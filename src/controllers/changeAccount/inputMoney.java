package controllers.changeAccount;

import java.util.Scanner;

public class inputMoney {
    public float inputMoney(){
        System.out.println("Введите сумму");
        Scanner scnNumberPassport = new Scanner(System.in);
        return scnNumberPassport.nextFloat();
    }
}
