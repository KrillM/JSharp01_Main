package N08_Collection;

import java.util.HashMap;
import java.util.Map;

public class Ex03_Map {
    public static void main(String[] args) {
        Map<Integer, CrewInfo> crewInfoMap = new HashMap<>();
        crewInfoMap.put(1, new CrewInfo("Krille", 27, "Male", "Brisbane"));
        crewInfoMap.put(2, new CrewInfo("Sooah", 26, "Female", "Taipei"));
        crewInfoMap.put(3, new CrewInfo("Eden", 34, "Male", "Dubai"));

        for(int i=0;i<crewInfoMap.size();i++){
            System.out.println(i+1);
            System.out.println(crewInfoMap.get(i+1).getName());
            System.out.println(crewInfoMap.get(i+1).getAge());
            System.out.println(crewInfoMap.get(i+1).getGender());
            System.out.println(crewInfoMap.get(i+1).getAddress());
        }

        System.out.println(crewInfoMap.containsKey(1));
    }
}
