package controllers.changeAccount;

import accessDataBase.read.readAccount;
import accessDataBase.write.writeChangeAccount;

import javax.swing.*;

public class logicDebitAccount {
    public void logicDebitAccount(float changeAccount, String numberAccount) {
        JFrame frame = new JFrame("Ошибка операции");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        float nowCount = new readAccount().readAccount("moneyaccount_" + numberAccount);
        if (nowCount - changeAccount >= 0){
            float changeMoney = nowCount - changeAccount;
            new writeChangeAccount().writeChangeAccount(changeMoney, numberAccount, "-" + changeAccount);
            JOptionPane.showMessageDialog(frame, "Деньги успешно списаны.", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Ошибка: Недостаточно средств на счету");
            System.out.println("Недостаточно средств на счету");
        }
    }
}
