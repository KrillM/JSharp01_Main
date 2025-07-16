package N01_DataType;

public class Ex02_ChangeType {
    public static void main(String[] args) {

        // 암시적 형 변환
        short x1 = 10;
        int x2 = x1;

        System.out.println(x1);
        System.out.println(x2);

        // 암시적 형 변환은 큰 -> 작은 단 역은 X
        int x3 = 10000000;
//        short x4 = x3;
//        System.out.println(x4);

        // 명시적 형 변환
        int x5 = 100000;
        short x6 = (short) x5;
        System.out.println(x6);
    }
}
