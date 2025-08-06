package N12_Thread;

class SharedBuffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException{
        while (hasData) wait(); // 소비될 때 까지 기다린다.

        data = value;
        hasData = true;
        System.out.println("생산 "+ data);
        notify(); // 소비자 깨움
    }

    public synchronized void consume() throws InterruptedException{
        while (!hasData) wait(); // 생산될 때 까지 기다린다.

        System.out.println("소비 "+data);
        hasData = false;
        notify(); // 생산자 깨움
    }
}

public class Ex05_WaitNotify {
    public static void main(String[] args){
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(()->{
           try{
               for(int i=1;i<6;i++){
                   buffer.produce(i);
                   Thread.sleep(500);
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        Thread consumer = new Thread(()->{
            try{
                for(int i=1;i<6;i++){
                    buffer.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
