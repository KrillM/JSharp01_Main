package N12_Thread;

public class BasicYieldThread implements Runnable{
    private String name;
    public String getName() {
        return name;
    }

    public BasicYieldThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=1;i<6;i++){
            System.out.println(getName()+" "+i);
            if(i==3) Thread.yield();
        }
    }
}
