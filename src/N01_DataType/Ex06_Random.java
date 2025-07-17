package N01_DataType;

import java.util.Random;

public class Ex06_Random {
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt(10);
        double y = random.nextDouble();

        System.out.println(x);
        System.out.println(y);
    }
}
