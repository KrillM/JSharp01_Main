package N07_Generic;

interface ISingleParent<T>{
    void print(T t);
}

class ISingleChild<T> implements ISingleParent<T>{

    @Override
    public void print(T t){
        System.out.println(t);
    }
}

interface IDoubleParent<K, V>{
    <K> K getK(K k);
    void setV(V v);
}

class IDoubleChild<K, V> implements IDoubleParent<K, V>{

    @Override
    public <K> K getK(K k){
        return k;
    }

    @Override
    public void setV(V v){
        System.out.println(v);
    }
}

public class Ex04_Interface {
    public static void main(String[] args) {
        ISingleChild<String> name = new ISingleChild<>();
        name.print("Yena");

        IDoubleChild<String, String> capital = new IDoubleChild<>();
        capital.setV("Korea");
        System.out.println(capital.getK("Seoul"));
    }
}
