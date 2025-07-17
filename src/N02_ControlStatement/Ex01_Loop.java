package N02_ControlStatement;

public class Ex01_Loop {
    public static void main(String[] args) {

        // while
        int x = 10;
        while (x > 0){
            System.out.println(x);
            x--;
        }

        boolean isFunction = true;
        while (isFunction){
            System.out.println("This is While Loop");
            isFunction = false;
        }

        // do-while
        x = 5;
        do{
            System.out.println(x);
        }
        while (x > 10);

        // for
        for(int i=0;i<10;i++){
            System.out.print(i+1+" ");
        }

    }
}
