package org.example;
import java.util.Scanner;

public class words implements word {

    int num;
    String Eng;
    String Kor;

    words (){

    }

    words (String a, String b){
        String[] con = a.split(" ");
        this.num = Integer.parseInt(con[0]);
        this.Eng = con[1];
        this.Kor = b;
    }
    @Override
    public void word_update(String a,String b) {

    }

    @Override
    public void word_delete() {
        this.num = 0;
        this.Eng = "";
        this.Kor = "";
    }

    @Override
    public void word_list() {

    }

    public static void word_add(){
        String A,B;
        Scanner scan = new Scanner(System.in);
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        A = scan.nextLine();
        System.out.print("뜻 입력 : ");
        B = scan.nextLine();
        new words(A,B);
    }
}


