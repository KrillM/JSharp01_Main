package N01_DataType;

public class Ex03_PrintNEscape {
    public static void main(String[] args) {
        System.out.println("Hello PrintLine");
        System.out.print("Hello Print");

        System.out.print(".");
        System.out.print("\n"); // 탈출 문자

        System.out.println("Line Changed");

        String java = "Java";
        int ver = 11;
        System.out.printf("This is %s version %d", java, ver);

        double pi = 3.141592;
        System.out.printf("%f\r\n", pi);
        System.out.printf("%.2f", pi);
    }
}
