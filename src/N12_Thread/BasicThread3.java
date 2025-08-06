package N12_Thread;

public class BasicThread3 extends Thread{
    public void run(){
        for(int i=1;i<11;i++){
            System.out.println(i);
        }
    }
}
