package org.example;

public class Main {
    static int flag = 0;

    public static void main(String[] args) {

        do {
            flag = menu.selection();
        }while(flag != 0);
    }
}