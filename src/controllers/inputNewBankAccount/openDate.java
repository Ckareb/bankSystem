package controllers.inputNewBankAccount;

import java.util.Scanner;

public class openDate {
    public String openDate(){
        System.out.println("Введите дату открытия");
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }
}
