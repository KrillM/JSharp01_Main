package N10_File;

import java.io.*;
import java.util.Scanner;

public class Ex02_CrewManagerThrows {

    static final String FILE_NAME = "./src/N10_File/CrewList.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException{

        File file = new File(FILE_NAME);

        try{
            if(file.createNewFile()) System.out.println("파일 생성 성공 : "+FILE_NAME);
        }
        catch (IOException e){
            System.out.println("파일 생성 실패");
            e.printStackTrace();
        }

        while (true){
            System.out.println("1. 검색 2. 전체 3. 추가 4. 삭제 0. 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    searchCrew();
                    break;
                case 2:
                    showCrewAll();
                    break;
                case 3:
                    addCrew();
                    break;
                case 4:
                    deleteCrew();
                    break;
                case 0:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void searchCrew(){
        System.out.println("크루 검색 : ");
        String name = sc.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            boolean search = false;

            while ((line = reader.readLine())!=null){
                if(line.startsWith(name+"\t")){
                    System.out.println(line);
                    search = true;
                    break;
                }
            }

            if(!search) System.out.println("해당 크루를 찾을 수 없습니다.");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("검색 실패");
        }
    }

    private static void showCrewAll() throws IOException {
        System.out.println("전체 크루 목록");

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            boolean isEmpty = true;

            while ((line = reader.readLine())!=null){
                System.out.println(line);
                isEmpty = false;
            }

            if(isEmpty) System.out.println("등록된 크루가 없습니다.");
        }
    }

    private static void addCrew() throws IOException {
        System.out.println("이름 입력 : ");
        String name = sc.nextLine();
        System.out.println("나이 입력 : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("성별 입력 : ");
        String gender = sc.nextLine();
        System.out.println("주소 입력 : ");
        String address = sc.nextLine();

        String newCrew = name+"\t"+age+"\t"+gender+"\t"+address;
        File file = new File(FILE_NAME);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            if(file.length() == 0){
                writer.write("Name\tAge\tGender\tAddress");
                writer.newLine();
            }

            writer.write(newCrew);
            writer.newLine();
            System.out.println("크루 추가 성공");
        }
    }

    private static void deleteCrew() {
        System.out.println("삭제할 크루 : ");
        String name = sc.nextLine();

        File tempFile = new File("temp.txt");

        try(
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
            ){
            String line;
            boolean isDelete = false;

            while ((line = reader.readLine()) != null){
                if(line.startsWith(name+"\t")){
                    isDelete = true;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            if(isDelete) {
                if(new File(FILE_NAME).delete() && tempFile.renameTo(new File(FILE_NAME))){
                    System.out.println("크루가 삭제되었습니다.");
                }
                else{
                    System.out.println("크루를 삭제할 수 없습니다.");
                }
            }
            else{
                System.out.println("해당 크루는 존재하지 않습니다.");
                tempFile.delete();
            }
        }
        catch (IOException e){
            System.out.println("삭제 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}
