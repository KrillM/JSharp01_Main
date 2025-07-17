package N02_ControlStatement;

public class Ex02_Condition {
    public static void main(String[] args) {

        // if
        int x = 10;

        if(x==10) System.out.println("True");
        else System.out.println("False");

        x*=10;
        if(x==10) System.out.println("True");
        else System.out.println("False");

        x-=10;
        if(x==100) System.out.println("x1 is "+x);

        x+=10;
        if(x==100) System.out.println("x2 is "+x);

        x-=10;
        if(x==100) System.out.println("x3 is "+x);

        if(x == 100) System.out.println("x4 is "+x);
        else if (x == 90) System.out.println("x5 is "+x);
        else System.out.println("x6 is "+x);


        // switch
        String name = "sooah";

        switch (name){
            case "yena":
                System.out.println("This is "+ name);
                break;
            case "krille":
                System.out.println("This is "+ name);
                break;
            case "eden":
                System.out.println("This is "+ name);
                break;
            default:
                System.out.println("Who are you?");
                break;
        }
    }
}
