package controllers.changeAccount;

import accessDataBase.read.readAccount;
import accessDataBase.write.writeChangeAccount;

public class logicAddAccount {
    public void logicAddAccount(float changeAccount, String numberAccount){
        float nowCount = new readAccount().readAccount("moneyaccount_" + numberAccount);
        float changeMoney = nowCount + changeAccount;
        new writeChangeAccount().writeChangeAccount(changeMoney, numberAccount, "+" + changeAccount);
    }
}
