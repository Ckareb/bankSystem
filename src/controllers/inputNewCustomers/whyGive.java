package controllers.inputNewCustomers;

import java.util.Scanner;

public class whyGive {
    public String whyGive(){
        System.out.println("Кем выдан");
        Scanner scnWhyGive = new Scanner(System.in);
        return scnWhyGive.nextLine();
    }
}
