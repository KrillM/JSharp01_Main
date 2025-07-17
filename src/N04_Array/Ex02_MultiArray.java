package N04_Array;

public class Ex02_MultiArray {
    public static void main(String[] args) {
        int[][]x=new int[2][3];

        int result = 1;

        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i].length;j++){
                x[i][j] = result;
                System.out.print(x[i][j]+" ");
                result++;
            }
            System.out.println();
        }

        // 배열의 단점 - 1. 갯수 제한 2. 하나의 타입만 가능 3. 삽입, 삭제가 불편함
    }
}
