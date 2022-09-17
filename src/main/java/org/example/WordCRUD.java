package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner scan;

    WordCRUD(Scanner scan){
        list = new ArrayList<>();
        this.scan = scan;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = scan.nextInt();
        String word = scan.nextLine();
        word = word.substring(1);
        System.out.print("뜻 입력 : ");
        String meaning = scan.nextLine();
        return new Word(0, level, word, meaning);
    }

    public void addWord() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.\n");
    }
    @Override
    public void update() {
        scan.nextLine();
        System.out.println("=>수정할 단어 검색:");
        String upword = scan.nextLine();
        System.out.println("---------------------------------------");
        int check = 0;
        int [] checkList = new int[100];
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).getWord().contains(upword))
            {
                check+=1;
                System.out.print((check) + " ");
                System.out.println(list.get(i).toString());
                checkList[check] = list.get(i).getId();
            }
        }
        System.out.println("---------------------------------------");
        if (check == 0) System.out.println("검색 결과가 없습니다.\n");
        else {
            System.out.println("=>수정할 번호 선택:");
            int choose = scan.nextInt();
            scan.nextLine();
            System.out.println("=>뜻 입력:");
            String meaning = scan.nextLine();
            list.get(checkList[choose]).setMeaning(meaning);
            System.out.println("단어 수정이 성공적으로 되었습니다.\n");

        }


    }

    @Override
    public void search() {
        scan.nextLine();
        System.out.println("=>검색할 단어 입력:");
        String word = scan.nextLine();
        System.out.println("---------------------------------------");
        int check = 0;
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).getWord().contains(word))
            {
                check+=1;
                System.out.print((check) + " ");
                System.out.println(list.get(i).toString());
            }
        }
        System.out.println("---------------------------------------");
        if (check == 0) System.out.println("검색 결과가 없습니다.\n");
    }

    @Override
    public void delete() {
        scan.nextLine();
        System.out.println("=>삭제할 단어 검색:");
        String delword = scan.nextLine();
        System.out.println("---------------------------------------");
        int check = 0;
        int [] delList = new int[100];
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).getWord().contains(delword))
            {
                check+=1;
                System.out.print((check) + " ");
                System.out.println(list.get(i).toString());
                delList[check] = list.get(i).getId();
            }
        }
        System.out.println("---------------------------------------");
        if (check == 0) System.out.println("검색 결과가 없습니다.\n");
        else{
            System.out.println("=>삭제할 번호 선택:");
            int choose = scan.nextInt();
            System.out.println("정말로 삭제하실래요?(Y/n)");
            char sel = scan.next().charAt(0);
            if (sel == 'Y') {
                list.remove(delList[choose]);
                System.out.println("\n선택한 단어 삭제 완료!!!\n");
            }
            else System.out.println("\n삭제가 취소 되었습니다.\n");
        }
    }

    @Override
    public void selectLevel() {
        scan.nextLine();
        System.out.println("=>레벨(1:초급, 2:중급, 3:고급)선택:");
        int levword = scan.nextInt();
        System.out.println("---------------------------------------");
        int check = 0;
        int [] levList = new int[100];
        for (int i = 0 ; i < list.size() ; i++){
            if (list.get(i).getLevel() == levword)
            {
                check+=1;
                System.out.print((check) + " ");
                System.out.println(list.get(i).toString());
                levList[check] = list.get(i).getId();
            }
        }
        System.out.println("---------------------------------------");
        if (check == 0) System.out.println("검색 결과가 없습니다.\n");

    }

    @Override
    public void save() {
        try {
            FileOutputStream save = new FileOutputStream("src/main/java/org/example/word.txt");
            for (int i = 0; i < list.size(); i++) {
                String text = list.get(i).getLevel() + "-" + list.get(i).getWord() + "-" + list.get(i).getMeaning() + "\n";
                save.write(text.getBytes());
            }
            save.close();
        }catch (IOException e){
            System.out.println("오류! 저장에 실패했습니다.");
        }
        System.out.println("저장완료!\n");
    }

    @Override
    public void load() {
        File T = new File("src/main/java/org/example/word.txt");
        if (T.exists()) {
            try {
                BufferedReader txt = new BufferedReader(new FileReader("src/main/java/org/example/word.txt"));
                String stream;
                while ((stream = txt.readLine()) != null) {
                    String text = stream;
                    String[] cont = text.split("-");
                    int level = Integer.parseInt(cont[0]);
                    String word = cont[1];
                    String meaning = cont[2];
                    Word one = new Word(0, level, word, meaning);
                    list.add(one);
                }
            } catch (IOException e) {
                System.out.println("오류! 파일 손상되었습니다.");
            }
            System.out.println("파일을 불러왔습니다.");
        }else System.out.println("오류! 해당 파일을 찾을 수 없습니다.");


    }






    public void listAll(){
        System.out.println("---------------------------------------");
        for (int i = 0; i < list.size() ; i++){
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("---------------------------------------");
    }
}




