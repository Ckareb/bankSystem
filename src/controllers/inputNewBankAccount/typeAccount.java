package controllers.inputNewBankAccount;

import java.util.Scanner;

public class typeAccount {
    public String typeAccount(){
        System.out.println("Вид счета");
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }
}
