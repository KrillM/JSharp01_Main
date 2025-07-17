package N02_ControlStatement;

public class Ex03_Control {
    public static void main(String[] args) {

        // break
        for(int i=1;i<11;i++){
            System.out.print(i+" ");
            if(i == 5) break;
        }

        System.out.println();

        for(int i=1;i<11;i++){
            if(i == 5) break;
            System.out.print(i+" ");
        }

        System.out.println();

        // continue
        for(int i=1;i<11;i++){
            System.out.print(i+" ");
            if(i == 5) continue;
        }

        System.out.println();

        for(int i=1;i<11;i++){
            if(i == 5) continue;
            System.out.print(i+" ");
        }

        System.out.println();

        // return
        for(int i=1;i<11;i++){
            System.out.print(i+" ");
            if(i == 5) return;
        }

        System.out.println();

        for(int i=1;i<11;i++){
            if(i == 5) return;
            System.out.print(i+" ");
        }
    }
}
