package org.example;
import java.util.Scanner;

public class menu {

    static int select;


    static void print_menu(){
        System.out.println("*** 영단어 마스터 ***");
        System.out.println("******************");
        System.out.println("1. 모든 단어 보기");
        System.out.println("2. 수준별 단어 보기");
        System.out.println("3. 단어 검색");
        System.out.println("4. 단어 추가");
        System.out.println("5. 단어 수정");
        System.out.println("6. 단어 삭제");
        System.out.println("7. 파일 저장");
        System.out.println("0. 나가기");
        System.out.println("******************");
    }

    static int selection(){
        Scanner scan = new Scanner(System.in);
        menu.print_menu();
        System.out.println("숫자를 입력하세요");
        select = scan.nextInt();
        scan.close();
        return select;
    }
}
