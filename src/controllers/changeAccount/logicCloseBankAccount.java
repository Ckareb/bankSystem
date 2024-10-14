package controllers.changeAccount;

import accessDataBase.closeBankAccount;
import accessDataBase.read.readAccount;
import accessDataBase.write.writeChangeAccount;

public class logicCloseBankAccount {
    public void logicCloseBankAccount(String numberAccount) {
    float nowCount = new readAccount().readAccount("moneyaccount_" + numberAccount);
    if (nowCount == 0){
        new closeBankAccount().closeBankAccount(numberAccount);
    } else System.out.println("Снемите все деньги со счета прежде чем закрыть его");
}
}
