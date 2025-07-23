package N06_Inherit;

class D1{

    D1(){
        System.out.println("This is D1");
    }

    void print(){
        System.out.println("부모의 메서드");
    }
}

class D2 extends D1{

    String name = "D2";

    D2(){
        System.out.println("This is D2");
    }

    @Override
    void print(){
        System.out.println("자녀의 메서드");
    }

}

class D3 extends D2{

    String name = "D3";

    D3(){
        // 부모의 생성자를 볼 수 있다. 단 자식 생성자에서만 볼 수 있다.
        super();
    }

    @Override
    void print(){
        // super: 부모의 필드나 생성자를 볼 수 있다. 단 자식 클래스에서만 사용할 수 있다.
        super.print();
        System.out.println(super.name);
        System.out.println("손주의 메서드");
        System.out.println(name);
    }
}

class D4{}

public class Ex04_Override {
    public static void main(String[] args) {
        D1 d1 = new D1();
        d1.print();

        D2 d2 = new D2();
        d2.print();

        // 다운 캐스팅: 자녀의 데이터를 보기 위해 사용
        d1 = (D2)d2;
        d1.print();

        // 업캐스팅: 부모가 자녀로 인스턴스화
        D1 d3 = new D2();
        d3.print();

        D3 dd3 = new D3();
        dd3.print();

        // instance of
        if(dd3 instanceof D2) System.out.println("True");
        else System.out.println("False");

        if(dd3 instanceof D1) System.out.println("True");
        else System.out.println("False");

        if(d1 instanceof D1) System.out.println("True");
        else System.out.println("False");

        if(d1 instanceof D2) System.out.println("True");
        else System.out.println("False");

        D4 d4 = new D4();
        // instance of는 형 변환이 가능한 타입 관계에서만 사용이 가능하다.
//        if(d4 instanceof D1) System.out.println("True");
//        else System.out.println("False");

    }
}
