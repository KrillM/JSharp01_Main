package N01_DataType;

public class Ex04_Calculate {
    public static void main(String[] args) {

        // 사칙 연산
        int x = 10;
        int y = 6;

        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x/y);
        System.out.println(x%y);
        System.out.println(x>y);
        System.out.println(x<y);

        x = y;

        System.out.println(x>=y);
        System.out.println(x<=y);
        System.out.println(x==y);
        System.out.println(x!=y);

        // 집합
        boolean a = true;
        boolean b = true;
        boolean c = false;

        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(a && c);
        System.out.println(a || c);
        System.out.println(c || b);


        int d = 10;
        int e = 6;
        int result = (d+=e);
        System.out.println(result);

        result = (d-=e);
        System.out.println(result);

        result = (d*=e);
        System.out.println(result);

        result = (d/=e);
        System.out.println(result);

        result = (d%=e);
        System.out.println(result);

        int f = 10;
        System.out.println(f++);
        System.out.println(++f);

        System.out.println(f--);
        System.out.println(--f);
    }
}
