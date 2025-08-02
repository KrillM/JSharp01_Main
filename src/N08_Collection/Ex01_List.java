package N08_Collection;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {
    public static void main(String[] args) {
        List<CrewInfo> crew = new ArrayList<>();
        crew.add(new CrewInfo("Krille", 27, "Male", "Brisbane"));
        crew.add(new CrewInfo("Yena", 22, "Feale", "Seoul"));
        crew.add(new CrewInfo("Jisu", 18, "Male", "Sydney"));
        crew.add(new CrewInfo("Asahi", 25, "Male", "Tokyo"));

        for(int i=0;i<crew.size();i++){
            System.out.println("Crew "+(i+1));
            System.out.println("Name \t"+crew.get(i).getName());
            System.out.println("Age \t"+crew.get(i).getAge());
            System.out.println("Gender \t"+crew.get(i).getGender());
            System.out.println("Home \t"+crew.get(i).getAddress());
        }

        System.out.println("\r\n"+crew.size());
    }
}
