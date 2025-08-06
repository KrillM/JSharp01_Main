package N12_Thread;

public class Ex03_ThreadMethods {

    static BasicThread1 basicThread1 = new BasicThread1();
    static BasicThread3 basicThread3 = new BasicThread3();
    static Thread thread1 = new Thread(basicThread1);
    static Thread thread2 = new Thread(new BasicThread2());
    static Thread thread3 = new Thread(basicThread3);

    static void sleep() throws InterruptedException{
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

    static void join() throws InterruptedException {
        thread3.start();
        thread3.join();
        thread1.start();
    }

    static void priority() throws InterruptedException{
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        System.out.println(thread1.getPriority());
        System.out.println(thread2.getPriority());
        System.out.println(thread3.getPriority());

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }

    static void yieldThread(){
        Thread yena = new Thread(new BasicYieldThread("Yena"));
        Thread eden = new Thread(new BasicYieldThread("Eden"));

        yena.start();
        eden.start();
    }

    static void interruptedThread() throws InterruptedException{
        BasicInterruptedThread basicInterruptedThread = new BasicInterruptedThread();
        Thread thread = new Thread(basicInterruptedThread);

        thread.start();
        thread.sleep(2000);
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException{
//        sleep();
//        join();
//        priority();
//        yieldThread();
        interruptedThread();
    }
}
