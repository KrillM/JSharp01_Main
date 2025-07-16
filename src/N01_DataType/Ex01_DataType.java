package N01_DataType;

public class Ex01_DataType {
    public static void main(String[] args) {

        // int x 까지는 선언 = 10은 초기화라고 부른다.
        int x = 10;

        // 상수는 절대로 변하여서는 안 되는 값을 뜻한다.
        final int ConstructedVariable = 20;
//        ConstructedVariable = 30; 상수의 값을 변경하려 시도하였으므로 에러 처리

        // 숫자형
        // 정수형
        byte x1 = 10;
        short x2 = 30000;
        int x3 =  1324123;
        long x4 = 132412380912l;

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);

        // 실수형
        double x5 = 3.14;
        float x6 = 3.561f;

        System.out.println(x5);
        System.out.println(x6);

        // 문자형
        char c1 = 't';
        System.out.println(c1);

        c1 = 'v';
        System.out.println(c1);

        String word = "Hello World";
        System.out.println(word);

        // 논리형
        boolean isTrue = true;
        System.out.println(isTrue);
        System.out.println(!isTrue);
    }
}
