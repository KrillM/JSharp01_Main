package N06_Inherit;

class A{
    public String print(){
        return "This is A";
    }
}

class B extends A{

}

public class Ex01_Has2Is {

    protected static String x3 = "Protected";

    public static void main(String[] args) {

        // has 관계는 클래스를 인스턴스화하는 것이다.
        A a = new A();
        System.out.println(a.print());

        // is 관계는 클래스를 상속받아 사용한다.
        B b = new B();
        System.out.println(b.print());
    }
}
