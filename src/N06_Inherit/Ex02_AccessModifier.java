package N06_Inherit;

class C{

    // 모든 클래스에서 사용 가능
    public static String x1 = "Public";

    // 동일한 패키지에서 사용 가능
    static String x2 = "Default";

    // 상속 받아야만 사용 가능
    protected static String x3 = "Protected";

    // 다른 클래스에서 사용 불개
    private static String x4 = "Private";

    public static String getX4() {
        return x4;
    }

    public static void setX4(String x4) {
        C.x4 = x4;
    }
}

class C2 extends C{

    static void print(){
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
//        System.out.println(x4);
    }

}

public class Ex02_AccessModifier {
    public static void main(String[] args) {
        C c1 = new C();
        System.out.println(c1.x1);
        System.out.println(c1.x2);

        // 동일한 패키지에서만 사용이 가능하나 다른 패키지에서 상속받은 클래스가 있다면 사용이 가능하다.
        System.out.println(c1.x3);
//        System.out.println(c1.x4);

        C2 c2 = new C2();
        c2.print();

        // private 필드를 사용하는 법
        c2.setX4("Private");
        System.out.println(c2.getX4());
    }
}
