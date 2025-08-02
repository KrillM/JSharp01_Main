package N08_Collection;

import java.util.HashSet;
import java.util.Set;

public class Ex02_Set {
    public static void main(String[] args) {
        Set<String> crews = new HashSet<>();
        crews.add("Eren");
        crews.add("Mikasa");
        crews.add("Connie");
        crews.add("Sasha");
        crews.add("Levi");
        crews.add("Connie");

        for(String i : crews){
            System.out.println(i);
        }

        System.out.println(crews.contains("Levi"));

        crews.remove("Connie");

        for(String i : crews){
            System.out.println(i);
        }

        System.out.println(crews.contains("Connie"));

    }
}
