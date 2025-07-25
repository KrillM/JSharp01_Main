package N07_Generic;

public class Ex02_Method {

    static <T> T ReturnOneParameter(T t){
        return t;
    }

    static <T, V> boolean ReturnTwoParameters(T t, V v){
        return t.equals(v);
    }

    static <T> void VoidOneParameter(T t){
        System.out.println(t);
    }

    static <T, V> void VoidTwoParameters(T t, V v){
        System.out.println(t);
        System.out.println(v);
    }

    public static void main(String[] args) {

        // static을 선언해도 어떤 클래스에서 유래했는지 알 기 위해 앞에 클래스 이름은 필수이다.
        String yena = Ex02_Method.ReturnOneParameter("Yena");
        int age = Ex02_Method.ReturnOneParameter(19);
        System.out.println(yena);
        System.out.println(age);

        String Com1 = "HP";
        String Com2 = "HP";
        boolean Compare = Ex02_Method.ReturnTwoParameters(Com1, Com2);
        System.out.println(Compare);

        Ex02_Method.VoidOneParameter("Yummy");
        Ex02_Method.VoidTwoParameters("Messi", 10);

        Member member = Ex02_Method.ReturnOneParameter(new Member("Sooah", 26, "Female"));
        System.out.println(member.getName());
        System.out.println(member.getGender());
        System.out.println(member.getAge());
    }
}
