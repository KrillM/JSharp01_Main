package N10_File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex03_Login {

    static final String FILE_NAME = "./src/N10_File/Account.txt";
    static Scanner sc = new Scanner(System.in);
    static File file = new File(FILE_NAME);

    public static void main(String[] args) {

        try{
            if(file.createNewFile()) System.out.println("파일 생성 성공 : "+FILE_NAME);
        } catch (IOException e) {
            System.out.println("파일 생성 실패");
            e.printStackTrace();
        }

        while (true){
            System.out.println("1. 로그인 2. 회원가입 3. 비밀번호 수정 4. 회원탈퇴 0. 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    loginAccount();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    updatePassword();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 0:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void loginAccount() {
        System.out.println("아이디 : ");
        String inputID = sc.nextLine();
        System.out.println("비밀번호 : ");
        String inputPW = sc.nextLine();

        boolean IsLogin = false;

        try(Scanner fileSC = new Scanner(file)){
            if(fileSC.hasNextLine()) fileSC.nextLine(); // 헤더 건너뛰기

            while (fileSC.hasNextLine()){
                String line = fileSC.nextLine();
                String[]separateLine = line.split("\t\t");

                if(separateLine.length >= 2){
                    String id = separateLine[0];
                    String pw = separateLine[1];

                    if(id.equals(inputID) && pw.equals(inputPW)){
                       IsLogin = true;
                       break;
                    }
                }
            }

            if(IsLogin) System.out.println("로그인 성공");
            else System.out.println("아이디나 비밀번호가 틀렸습니다.");
        }
        catch (IOException e){
            System.out.println("로그인 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    private static void createAccount() {
        System.out.println("신규 아이디 : ");
        String ID = sc.nextLine();
        System.out.println("신규 비밀번호 : ");
        String PW = sc.nextLine();

        String newAccount = ID+"\t\t"+PW;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            if(file.length() == 0){
                writer.write("ID\t\tPW");
                writer.newLine();
            }

            writer.write(newAccount);
            writer.newLine();
            System.out.println("회원가입 성공");
        }
        catch (IOException e){
            System.out.println("회원가입 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    private static void updatePassword() {
        System.out.println("아이디 : ");
        String inputID = sc.nextLine();
        System.out.println("현재 비밀번호 : ");
        String currentPW = sc.nextLine();
        System.out.println("새 비밀번호 : ");
        String newPW = sc.nextLine();

        boolean isUpdate = false;
        File tempFile = new File("temp.txt");

        try(
            Scanner fileSC = new Scanner(file);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ){
            if(fileSC.hasNextLine()){
                String header = fileSC.nextLine(); // 헤더 복사
                writer.write(header);
                writer.newLine();
            }

            while (fileSC.hasNextLine()){
                String line = fileSC.nextLine();
                String[]splitLine = line.split("\t\t");

                if(splitLine.length >= 2){
                    String id = splitLine[0];
                    String pw = splitLine[1];

                    if(id.equals(inputID) && pw.equals(currentPW)){
                        writer.write(id+"\t\t"+newPW); // 비밀번호 수정
                        isUpdate = true;
                    }
                    else {
                        writer.write(line); // 그대로 유지
                    }
                    writer.newLine(); //
                }
                else{
                    // 형식 이상한 줄도 유지
                    writer.write(line);
                    writer.newLine();
                }
            }

            writer.flush();

            if(isUpdate){
                if(file.delete() && tempFile.renameTo(file)) System.out.println("비밀번호가 성공적으로 변경되었습니다.");
                else System.out.println("비밀번호를 변경하지 못했습니다.");
            }
            else {
                System.out.println("아이디나 비밀번호가 틀렸습니다.");
            }
        }
        catch (IOException e){
            System.out.println("비밀번호 수정 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    private static void deleteAccount() {
        System.out.println("아이디 : ");
        String deleteID = sc.nextLine();
        System.out.println("비밀번호 : ");
        String deletePW = sc.nextLine();

        File tempFile = new File("temp.txt");
        boolean IsDelete = false;

        try(
           Scanner fileSC = new Scanner(file);
           BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ){
            if(fileSC.hasNextLine()){
                String header = fileSC.nextLine(); // 헤더
                writer.write(header);
                writer.newLine();
            }

            while (fileSC.hasNextLine()){
                String line = fileSC.nextLine();
                String []separateLine = line.split("\t\t");

                if(separateLine.length >= 2){
                    String id = separateLine[0];
                    String pw = separateLine[1];

                    if(id.equals(deleteID) && pw.equals(deletePW)){
                        IsDelete = true;
                        continue;
                    }
                }

                writer.write(line);
                writer.newLine();
            }

            writer.flush();

            if(IsDelete){
                if(file.delete() && tempFile.renameTo(file)) System.out.println("회원탈퇴하였습니다.");
                else System.out.println("회원 탈퇴를 할 수 없습니다.");
            }
            else {
                System.out.println("존재하지 않는 계정입니다.");
            }

        }
        catch (IOException e){
            System.out.println("회원탈퇴 중 오류가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}
