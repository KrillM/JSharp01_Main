package N12_Thread;

import java.util.LinkedList;

class CommonBuffer{
    private final LinkedList<Integer> buffer =new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException{
        while (buffer.size() == CAPACITY){
            System.out.println("버퍼 가득참. 생산자 대기.");
            wait();
        }

        buffer.add(value);
        System.out.println("생산 "+ value);
        notify(); // 소비자에게 알림
    }

    public synchronized int consume()throws InterruptedException{
        while (buffer.isEmpty()){
            System.out.println("비어 있음. 소비자 대기.");
            wait();
        }

        int value = buffer.removeFirst();
        System.out.println("소비 "+ value);
        notify(); // 생산자에게 알림
        return value;
    }
}

class Producer implements Runnable{
    private final CommonBuffer buffer;

    public Producer(CommonBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int value = 0;
        try {
            for(int i =0 ;i<10;i++) {
                buffer.produce(value++);
                Thread.sleep(500); // 생산
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private final CommonBuffer buffer;

    public Consumer(CommonBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        try{
            while (true){
                buffer.consume();
                Thread.sleep(1000); // 소비
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Ex06_WaitNotifyHard {
    public static void main(String[] args) throws InterruptedException {
        CommonBuffer buffer = new CommonBuffer();

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("작업 완료");
    }
}
