package org.example;
import java.util.Scanner;
public class Main {
    static int flag = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        do {
            flag = menu.selection();
        }while(flag != 0);
    }
}