package N03_Function;

public class Ex01_Method {

    static int giveNtake(int x) {
        return x;
    }

    static int getter(){
        return 10;
    }

    static void setter(int x) {
        System.out.println(x);
    }

    static void box(){
        System.out.println("Just Box Method");
    }

    void nonStatic(){
        System.out.println("Hard to Call");
    }

    public static void main(String[] args) {

        // static은 객체 없이 클래스 단위로 직접 접근 가능한 키워드로, 메모리에 한 번만 올라가지만 모든 인스턴스가 공유하므로 의도적으로 최소한으로 사용하는 것이 바람직하다.
        int x1 = giveNtake(5);
        System.out.println(x1);

        int x2 = getter();
        System.out.println(x2);

        setter(x1);
        setter(x2);
        box();

        // static이 없다면,,,
        Ex01_Method ex01Method = new Ex01_Method();
        ex01Method.nonStatic();
    }
}
