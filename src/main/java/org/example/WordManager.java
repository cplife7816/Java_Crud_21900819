package org.example;
import java.util.Scanner;

public class WordManager {
    Scanner scan = new Scanner(System.in);

    WordCRUD wordCRUD;
    WordManager(){
        wordCRUD = new WordCRUD(scan);
    }
    public int selectMenu(){
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
        System.out.println("=> 원하는 메뉴는?");

        return scan.nextInt();
    }

    public void start(){
        wordCRUD.load();
        while(true) {
            int menu = selectMenu();
            if (menu == 0) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            switch(menu){
                case 1:
                {
                    wordCRUD.listAll();
                    break;
                }
                case 2:
                {
                    wordCRUD.selectLevel();
                    break;
                }
                case 3:
                {
                    wordCRUD.search();
                    break;
                }
                case 4:
                {
                    wordCRUD.addWord();
                    break;
                }
                case 5:
                {
                    wordCRUD.update();
                    break;
                }
                case 6:
                {
                    wordCRUD.delete();
                    break;
                }
                case 7:
                {
                    wordCRUD.save();
                }
            }
        }
    }
}
