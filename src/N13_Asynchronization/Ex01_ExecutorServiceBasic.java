package N13_Asynchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex01_ExecutorServiceBasic {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3); // 고정 개수의 쓰레드 풀 생성

        for(int i=1;i<11;i++){
            int taskID = i;
            service.submit(()->{ // 작업 제출
                System.out.println("Task " + taskID + " 실행 - " + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        service.shutdown(); // 현재 작업 마무리
    }
}
