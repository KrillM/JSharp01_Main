package N07_Generic;

class GetString<K, V>{

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

    @Override
    public String toString(){
        return getK() + " " + getV();
    }
}

public class Ex06_ToString {
    public static void main(String[] args) {
        GetString<String, String> crew1 = new GetString<>();
        crew1.setK("Yena");
        crew1.setV("Backend Developer");
        System.out.println(crew1.toString());
        System.out.println(crew1);

        GetString<String, Integer> crew2 = new GetString<>();
        crew2.setK("Eden");
        crew2.setV(7);
        System.out.println(crew2);

        // 이 외에도
        // 1. 제네릭 클래스, 함수에는 데이터 타입 필수
        // 2. 배역은 제네릭에 사용 불가 (단 C#에서는 가능)
    }
}
