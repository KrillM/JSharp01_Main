package N07_Generic;

class SingleParent<T>{
    private T t;
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}

class SingleChild<T> extends SingleParent<T>{

}

class DoubleParent<K, V>{
    private K k;
    public K getK() {
        return k;
    }
    DoubleParent(K k){
        this.k = k;
    }
}

class DoubleChild<K, V> extends DoubleParent<K, V>{
    private V v;

    public V getV(){
        return v;
    }

    DoubleChild(K k, V v){
        super(k);
        this.v = v;
    }
}

public class Ex03_Inherit {
    public static void main(String[] args) {
        SingleChild<String> str = new SingleChild<>();
        str.setT("Child");
        System.out.println(str.getT());

        DoubleChild<Integer, String> player = new DoubleChild<>(7, "Ronaldo");
        System.out.println(player.getV());
        System.out.println(player.getK());
    }
}
