package controllers.inputNewBankAccount;

import java.util.Scanner;

public class accountCurrency {
    public String accountCurrency(){
        System.out.println("Введите валюту счета");
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }
}
