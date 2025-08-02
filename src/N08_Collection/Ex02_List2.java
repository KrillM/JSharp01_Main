package N08_Collection;

import java.util.ArrayList;
import java.util.List;

public class Ex02_List2 {
    public static void main(String[] args) {
        List<Member> members = new ArrayList<>();
//        members.add(new Member());

        Member member1 = new Member();
        member1.setName("Krille");
        member1.setJob("Developer");
        members.add(member1);

        Member member2 = new Member();
        member2.setName("Sooah");
        member2.setJob("Developer");
        members.add(member2);

        for(Member m : members){
            System.out.println(m.getName());
            System.out.println(m.getJob());
        }

    }
}
