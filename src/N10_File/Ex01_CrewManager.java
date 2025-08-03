package N10_File;

import java.io.*;
import java.util.Scanner;

public class Ex01_CrewManager {

    private static final String FILE_Name = "./src/N10_File/crew.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File file = new File(FILE_Name);

        try{
            if(file.createNewFile()) System.out.println("파일 생성 : "+FILE_Name);
        }
        catch (IOException e){
            System.out.println("파일 생성 중 오류 발생");
            e.printStackTrace();
            return;
        }

        while (true){
            System.out.println("\n1. 검색 2. 추가 3. 삭제 0. 종료");
            System.out.println("선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 클리어

            switch (choice){
                case 1:
                    searchCrew();
                    break;
                case 2:
                    addCrew();
                    break;
                case 3:
                    deleteCrew();
                    break;
                case 0:
                    System.out.println("시스템 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

    }

    private static void searchCrew() {
        System.out.println("크루 이름 : ");
        String name =scanner.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_Name))){
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null){
                if(line.startsWith(name+",")){
                    System.out.println("걸과: "+line);
                    found = true;
                    break;
                }
            }

            if(!found) System.out.println("해당 크루를 찾을 수 없습니다.");
        }
        catch (IOException e){
            System.out.println("검색 중 오류 발생");
            e.printStackTrace();
        }
    }

    private static void addCrew() {
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("나이: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("성별: ");
        String gender = scanner.nextLine();
        System.out.println("주소: ");
        String address = scanner.nextLine();

        String newCrew = name+","+age+","+gender+","+address;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_Name, true))){
            writer.write(newCrew);
            writer.newLine();
            System.out.println("신규 크루 등록");
        }
        catch (IOException e){
            System.out.println("추가 중 오류 발생");
            e.printStackTrace();
        }
    }

    private static void deleteCrew() {
        System.out.println("크루 삭제 : ");
        String name = scanner.nextLine();

        File tempFile = new File("temp.txt");

        try(
            BufferedReader reader = new BufferedReader(new FileReader(FILE_Name));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
            ){
            String line;
            boolean deleted = false;

            while ((line = reader.readLine())!=null){
                if(line.startsWith(name+",")){
                    deleted = true;
                    continue; // 이 줄은 건너뛴다.
                }
                writer.write(line);
                writer.newLine();
            }

            if(deleted){
                if(new File(FILE_Name).delete() && tempFile.renameTo(new File(FILE_Name))){
                    System.out.println("크루 삭제");
                }
                else{
                    System.out.println("삭제 실패");
                }
            }
            else{
                System.out.println("해당 크루는 존재하지 않습니다.");
                tempFile.delete();
            }
        }
        catch (IOException e){
            System.out.println("삭제 중 오류 발생");
            e.printStackTrace();
        }

    }
}
