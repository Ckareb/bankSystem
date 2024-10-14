package controllers.inputNewBankAccount;

import java.util.Scanner;

public class nameAccount {
    public int nameAccount(){
        System.out.println("Введите номер счета");
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }
}
