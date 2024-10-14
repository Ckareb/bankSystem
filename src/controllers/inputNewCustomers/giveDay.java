package controllers.inputNewCustomers;

import java.util.Scanner;

public class giveDay {
    public String giveDay(){
        System.out.println("Дату выдачи");
        Scanner scnGiveDay = new Scanner(System.in);
        return scnGiveDay.nextLine();
    }
}
