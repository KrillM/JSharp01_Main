package N04_Array;

public class Ex01_SingleArray {

    static int[]returnInt (int[]x){
        return x;
    }

    public static void main(String[] args) {
        // 기존 변수의 단점
        int x1 = 1;
        int x2 = 2;
        int x3 = 3;

        // 한 번에 여러 번 선언이 가능한 배열
        int[]y1= new int[3];
        y1[0] = 10;
        y1[1] = 20;
        y1[2] = 30;

        for(int i=0;i<y1.length;i++){
            System.out.print(y1[i]+" ");
        }

        System.out.println();

        int[]y2 = {1,2,3};

        for(int i : y2){
            System.out.print(i+" ");
        }

        System.out.println();

        int[]y3 = returnInt(y1);

        for(int i : y3){
            System.out.print(i+" ");
        }
    }
}
