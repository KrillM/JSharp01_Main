package N08_Collection;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {
    public static void main(String[] args) {
        List<CrewInfo> crewInfos = new ArrayList<>();
        crewInfos.add(new CrewInfo("Krille", 28, "Male", "Brisbane"));
        crewInfos.add(new CrewInfo("Yena", 19, "Female", "Seoul"));
        crewInfos.add(new CrewInfo("Asahi", 27, "Male", "Tokyo"));

        crewInfos.get(0).print();
        crewInfos.get(1).print();
    }
}
