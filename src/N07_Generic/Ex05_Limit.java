package N07_Generic;

class LimitType<K extends Number, V>{
    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    LimitType(K k ,V v){
        this.k = k;
        this.v = v;
    }
}

public class Ex05_Limit {
    public static void main(String[] args) {
        LimitType<Integer, String> name1 = new LimitType<>(1, "Krille");
        System.out.println(name1.getK() + " " + name1.getV());

        LimitType<Double, String> math = new LimitType<>(Math.PI, "Math");
        System.out.printf("%.2f", math.getK());
        System.out.println(math.getV());

//        LimitType<String, Integer> error = new LimitType<>();
        // 타입 제한으로 인한 에러 발생

    }
}
