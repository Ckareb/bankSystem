package controllers.inputNewCustomers;

import java.util.Scanner;

public class birthday {
    public String birthday(){
        System.out.println("Дату рождения");
        Scanner scnBirthday = new Scanner(System.in);
        return scnBirthday.nextLine();
    }
}
