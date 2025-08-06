package N12_Thread;

class WithoutSync{
    static int cnt = 0;

    public static void main() throws InterruptedException {
        Runnable task = () -> {
            for(int i=0;i<10000;i++) cnt++;
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("최종 count (동기화 X) : " + cnt);
    }
}

class WithSync {
    static int cnt = 0;
    public static synchronized void increment(){
        cnt++;
    }

    public static void main() throws InterruptedException {
        Runnable task = () -> {
            for(int i=0;i<10000;i++) increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("최종 count (동기화 O) : " + cnt);
    }
}

class WithSyncBlock{
    static int cnt = 0;
    static final Object lock = new Object();

    static void main()throws InterruptedException{
        Runnable task = () -> {
            for(int i=0;i<10000;i++){
                synchronized (lock) {
                    cnt++;
                };
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("최종 count (동기화 블록) : " + cnt);
    }
}

public class Ex04_Synchronized {
    public static void main(String[] args) throws InterruptedException{
        WithoutSync.main();
        WithSync.main();
        WithSyncBlock.main();
    }
}
