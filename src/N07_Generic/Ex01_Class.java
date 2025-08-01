package N07_Generic;

class SingleType<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class DoubleType<K, V>{
    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    DoubleType(K k, V v){
        this.k = k;
        this.v = v;
    }
}

public class Ex01_Class {
    public static void main(String[] args) {
        SingleType<String> name = new SingleType<>();
        name.setT("Krille");

        SingleType<Integer> age = new SingleType<>();
        age.setT(27);

        System.out.println(name.getT());
        System.out.println(age.getT());

        DoubleType<Integer, String> messi = new DoubleType<>(10, "Messi");
        System.out.println(messi.getK()+" "+messi.getV());

        DoubleType<String, String> yamal = new DoubleType<>("Spanish", "Yamal");
        System.out.println(yamal.getV()+" is "+yamal.getK());
    }
}
