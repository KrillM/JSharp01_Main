package N12_Thread;

public class Ex01_ThreadBeginning {
    public static void main(String[] args) {
        BasicThread1 basicThread1 = new BasicThread1();
        Thread thread1 = new Thread(basicThread1);
        thread1.start();

        Thread thread2 = new Thread(new BasicThread2());
        thread2.start();

        Thread thread3 = new Thread(()->{
            System.out.println("쓰레드 3 : Lambda 사용");
        });

        thread3.start();
    }
}
