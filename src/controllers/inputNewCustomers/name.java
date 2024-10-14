package controllers.inputNewCustomers;

import java.util.Scanner;

public class name {
    public String name(){
        System.out.println("Введите Имя, Фамилию, Отчество (при наличии)");
        Scanner scnName = new Scanner(System.in);
        return scnName.nextLine();
    }
}
