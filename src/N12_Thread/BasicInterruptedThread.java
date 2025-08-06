package N12_Thread;

public class BasicInterruptedThread extends Thread{

    public void run(){
        while (!isInterrupted()){
            System.out.println("Working...");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Interrupted!");
                break;
            }
        }

        System.out.println("Finished");
    }

}
