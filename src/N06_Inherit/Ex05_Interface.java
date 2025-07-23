package N06_Inherit;

interface IH{
    void hobby(String[]hobby);
}

interface INum{

    int favoriteNum();
}

abstract class H {
    abstract void printName(String name);
}

// 클래스와 추상화 클래스는 한 개가 최대이나 인터페이스는 무제한이다.
class Show extends H implements IH, INum{

    private int sootJa;

    public int getSootJa() {
        return sootJa;
    }

    public void setSootJa(int sootJa) {
        this.sootJa = sootJa;
    }

    Show(int x){
        this.sootJa = x;
    }

    @Override
    void printName(String name){
        System.out.println("Name : "+name);
    }

    // 인터페이스를 상속받으면 반드시 오버라이딩으로 재정의해야 하며 접근 제한자를 public으로 명시적으로 선언해야 한다.
    @Override
    public void hobby(String []hobby){
        for(String i : hobby) System.out.println(i);
    }

    @Override
    public int favoriteNum(){
        return sootJa;
    }
}

public class Ex05_Interface {
    public static void main(String[] args) {
        String[]x= {"축구", "게임"};
        String[]y={"독서", "요리"};

        Show messi = new Show(10);
        messi.printName("메시");
        System.out.println(messi.favoriteNum());
        messi.hobby(x);


        Show krille = new Show(16);
        krille.printName("크릴");
        System.out.println(krille.favoriteNum());
        krille.hobby(y);


    }
}
