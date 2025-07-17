package N01_DataType;

import java.util.Scanner;

public class Ex05_Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력해주세요.");
        String name = scanner.next();

        System.out.println("나이를 입력해주세요.");
        int age = scanner.nextInt();

        System.out.println("이름: "+ name +"\n나이: "+age);
    }
}
