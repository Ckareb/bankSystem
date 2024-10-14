package menu.change;

import controllers.changeAccount.inputMoney;
import controllers.changeAccount.logicAddAccount;
import controllers.changeAccount.logicDebitAccount;
import controllers.inputNewBankAccount.nameAccount;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuFromOneAccountToAnother {
    public void menuFromOneAccountToAnother() {
        JFrame frame = new JFrame("Пополнение счета");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        JLabel nameDebitLabel = new JLabel("Номер счета:");
        JTextField nameDebitField = new JTextField();
        nameDebitField.setPreferredSize(new Dimension(200, 25));

        JLabel inputDebitLabel = new JLabel("Сумма на снятие со счета:");
        JTextField inputDebitField = new JTextField();
        inputDebitField.setPreferredSize(new Dimension(200, 25));

        JLabel nameAddLabel = new JLabel("Номер счета:");
        JTextField nameAddField = new JTextField();
        nameAddField.setPreferredSize(new Dimension(200, 25));

        JLabel inputAddLabel = new JLabel("Сумма на поплнение счета:");
        JTextField inputAddField = new JTextField();
        inputAddField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton, BorderLayout.NORTH);

        frame.add(nameDebitLabel);
        frame.add(nameDebitField);

        frame.add(inputDebitLabel);
        frame.add(inputDebitField);

        frame.add(nameAddLabel);
        frame.add(nameAddField);

        frame.add(inputAddLabel);
        frame.add(inputAddField);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Отправить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {
            String numberDebit = null;
            Float inputDebit = null;
            String numberAdd = null;
            Float inputAdd = null;

            // Цикл для проверки имени
            while (numberDebit == null) {
                if (nameDebitField.getText().matches("\\d{20}")) {
                    numberDebit = nameDebitField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Номер счета");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            // Цикл для проверки даты рождения
            while (inputDebit == null) {
                if (inputDebitField.getText().matches("\\d+")) {
                    inputDebit = Float.parseFloat(inputDebitField.getText());
                } else {
                    JOptionPane.showMessageDialog(frame, "Сумму");
                    return;
                }
            }

            // Передаем значения в метод
            new logicDebitAccount().logicDebitAccount(inputDebit, numberDebit);

            // Цикл для проверки имени
            while (numberAdd == null) {
                if (nameAddField.getText().matches("\\d{20}")) {
                    numberAdd = nameAddField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Номер счета");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            // Цикл для проверки даты рождения
            while (inputAdd == null) {
                if (inputAddField.getText().matches("\\d+")) {
                    inputAdd = Float.parseFloat(inputAddField.getText());
                } else {
                    JOptionPane.showMessageDialog(frame, "Сумму");
                    return;
                }
            }


            new logicAddAccount().logicAddAccount(inputAdd, numberAdd);
            JOptionPane.showMessageDialog(frame, "Запись успешно добавлена.", "Успех", JOptionPane.INFORMATION_MESSAGE);
            // Делаем окно видимым
        });
        frame.setVisible(true);

//        System.out.println("С какого аккауна списать");
//        int oneAccount = new nameAccount().nameAccount();
//        System.out.println("На какой аккаунт перевести");
//        int twoAccount = new nameAccount().nameAccount();
//        float fromOneToAnother = new inputMoney().inputMoney();
//        //new logicDebitAccount().logicDebitAccount(fromOneToAnother, oneAccount);
//        //new logicAddAccount().logicAddAccount(fromOneToAnother, twoAccount);
//        System.out.println("Транзакция прошла успешно");
    }
}
