package N08_Collection;

import java.util.Hashtable;

public class Ex04_Hashtable {
    public static void main(String[] args) {
        Hashtable<Integer, String> crew = new Hashtable<>();
        crew.put(1, "Armin");
        crew.put(2, "Levi");
        crew.put(3, "Mikasa");
        crew.put(4, "Jean");
        crew.put(5, "Connie");
        crew.put(6, "Reiner");

        for(int i=0;i< crew.size();i++){
            System.out.println(crew.get(i+1));
        }

        System.out.println(crew.containsKey(2));
        System.out.println(crew.containsValue("Pieke"));

        // 특징
        // 1. null 허용 안 함
        // 2. 동기화(멀티 쓰레드 용 아닐 경우 추천 안 함)
        // 3. HashMap을 더 사용
    }
}
