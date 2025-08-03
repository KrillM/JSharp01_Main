package N09_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01_TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = 0.0;
        System.out.println("숫자를 입력하세요.");

        try{
            num = sc.nextDouble();
            System.out.println(num);
        }
        catch (InputMismatchException e){
            System.out.println("숫자가 아닙니다.");
        }
    }
}
