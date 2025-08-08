package N13_Asynchronization;

import java.util.concurrent.*;

public class Ex03_AsyncProducerConsumer {

    private static final int CAPACITY = 5;
    private static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(CAPACITY);
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    // 비동기 생산지
    static class Producer implements Callable<Integer>{
        private final int value;

        public Producer(int value){
            this.value = value;
        }

        @Override
        public Integer call()throws Exception{
            buffer.put(value); // 가득 차면 블로킹
            System.out.println("생산됨 "+value);
            return value;
        }
    }

    // 비동기 소비자
    static class Consumer implements Callable<Integer>{
        @Override
        public Integer call()throws Exception{
            int consumed = buffer.take(); // 비어 있으면 블로킹
            System.out.println("소비됨 "+consumed);
            return consumed;
        }
    }

    public static void main(String[] args) throws Exception{
        for(int i = 1; i < 11; i++){
            // 생산
            Future<Integer> produced = executor.submit(new Producer(i));

            // 소비
            Future<Integer> consumed = executor.submit(new Consumer());

            // 필요시 결과 확인 (여기서는 동기적으로 get해서 확인한다.)
            produced.get();
            consumed.get();

            Thread.sleep(300);// 시뮬레이션용 지연
        }

        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("모든 생산/소비 완료");
    }
}
