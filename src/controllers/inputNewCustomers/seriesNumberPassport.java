package controllers.inputNewCustomers;

import java.util.Scanner;

public class seriesNumberPassport {
    public String seriesNumberPassport(){
        System.out.println("Введите серию номер паспорта клиента");
        Scanner scnSeriesPassport = new Scanner(System.in);
        return scnSeriesPassport.nextLine();
    }
}
