package N07_Generic;

public class Ex02_Method {

    static <K> K getSingleParameter(K k){
        return k;
    }

    static <K, V> boolean getDoubleParameter(K k, V v){
        return k == v;
    }

    static <K> void setSingleParameter(K k){
        System.out.println(k);
    }

    static <K, V> void setDoubleParameter(K k, V v){
        System.out.println(k);
        System.out.println(v);
    }

    public static void main(String[] args) {
        String name = "Yena";
        String printName = Ex02_Method.getSingleParameter(name);
        System.out.println(printName);

        int age = 22;
        int printAge = Ex02_Method.getSingleParameter(age);
        System.out.println(printAge);

        String com1 = "Eden";
        String com2 = "Eden";
        String com3 = "Eren";

        boolean com1n2 = Ex02_Method.getDoubleParameter(com1, com2);
        System.out.println(com1n2);

        boolean com1n3 = Ex02_Method.getDoubleParameter(com1, com3);
        System.out.println(com1n3);

        Ex02_Method.setSingleParameter(name);
        Ex02_Method.setDoubleParameter(com2, age);
    }
}
