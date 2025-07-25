package N07_Generic;

class Type<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class Identification<K, V>{
    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Identification(K k, V v){
        this.k = k;
        this.v = v;
    }
}

class Member{
    private String name;
    private int age;
    private String gender;

    public Member(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class Ex01_Class {

    static void OneParameter(){
        Type<String> name = new Type<String>();
        name.setT("Krille");
        System.out.println(name.getT());

        Type<Integer> age = new Type<Integer>();
        age.setT(28);
        System.out.println(age.getT());

        Type<Double> pi = new Type<>();
        pi.setT(Math.PI);
        System.out.println(pi.getT());
        System.out.printf("%.2f", pi.getT());
    }

    static void TwoParameters(){
        Identification<Integer, String> id1 = new Identification<>(10, "Messi");
        System.out.println(id1.getK() + "\t" +id1.getV());

        Identification<Integer, Double> id2 = new Identification<>(314, Math.PI);
        System.out.printf("%d\t%.2f", id2.getK(), id2.getV());
    }

    static void MemberGeneric(){
        Type<Member> member1 = new Type<>();
        member1.setT(new Member("Krille", 28, "Male"));
        System.out.println(member1.getT().getName());
        System.out.println(member1.getT().getAge());
        System.out.println(member1.getT().getGender());
    }

    public static void main(String[] args) {
//        OneParameter();
//        TwoParameters();
        MemberGeneric();
    }
}
