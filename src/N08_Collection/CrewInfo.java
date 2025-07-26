package N08_Collection;

public class CrewInfo {
    private String name;
    private int age;
    private String gender;
    private String address;

    public CrewInfo(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void print() {
        System.out.println("이름 : " + getName());
        System.out.println("나이 : " + getAge());
        System.out.println("성별 : " + getGender());
        System.out.println("주소 : " + getAddress());
    }
}