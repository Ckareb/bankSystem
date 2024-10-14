package menu.change;

import accessDataBase.closeBankAccount;
import accessDataBase.read.readAccount;
import controllers.changeAccount.logicAddAccount;
import controllers.changeAccount.logicCloseBankAccount;
import controllers.inputNewBankAccount.nameAccount;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuCloseBankAccount {
    public void menuDebitAccount(){
        JFrame frame = new JFrame("Закрытие счета");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Создаем метки и текстовые поля
        JLabel nameLabel = new JLabel("Номер счета:");
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton, BorderLayout.NORTH);

        frame.add(nameLabel);
        frame.add(nameField);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Отправить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {
            String number = null;

            // Цикл для проверки имени
            while (number == null) {
                if (nameField.getText().matches("\\d{20}")) {
                    number = nameField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Номер счета");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            float nowCount = new readAccount().readAccount("moneyaccount_" + number);

            while (nowCount != 0) {
                JOptionPane.showMessageDialog(frame, "Снимите все деньги со счета");
                return;
            }

            // Передаем значения в метод
            new closeBankAccount().closeBankAccount(number);
            JOptionPane.showMessageDialog(frame, "Счет закрыт", "Успех", JOptionPane.INFORMATION_MESSAGE);
            // Делаем окно видимым
        });
        frame.setVisible(true);
//        int numberAccount = new nameAccount().nameAccount();
//        new logicCloseBankAccount().logicCloseBankAccount(numberAccount);
    }
}
