package controllers.inputNewBankAccount;

import java.util.Scanner;

public class nameBank {
    public String nameBank(){
        System.out.println("Введите название банка");
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }
}
