package N13_Asynchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex02_CallableFutureBasic {
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "작업 완료";
        }; // 리턴 값이 있는 쓰레드 작업

        Future<String > future = service.submit(task); // 결과 대기 및 받아오는 도구

        System.out.println("작업 요청 완료. 결과 기다리는 중...");
        String result = future.get();
        System.out.println("결과 " + result);

        service.shutdown();
    }
}
