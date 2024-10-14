package menu.change;

import controllers.changeAccount.logicAddAccount;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuAddAccount {
    public void menuAddAccount(){
        JFrame frame = new JFrame("Пополнение счета");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Создаем метки и текстовые поля
        JLabel nameLabel = new JLabel("Номер счета:");
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));

        JLabel inputLabel = new JLabel("Сумма на поплнение счета:");
        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton, BorderLayout.NORTH);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(inputLabel);
        frame.add(inputField);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Отправить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {
            String number = null;
            Float input = null;


            // Цикл для проверки имени
            while (number == null) {
                if (nameField.getText().matches("\\d{20}")) {
                    number = nameField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Номер счета");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            // Цикл для проверки даты рождения
            while (input == null) {
                if (inputField.getText().matches("\\d+")) {
                    input = Float.parseFloat(inputField.getText());
                } else {
                    JOptionPane.showMessageDialog(frame, "Сумму");
                    return;
                }
            }

            // Передаем значения в метод
            new logicAddAccount().logicAddAccount(input, number);
            JOptionPane.showMessageDialog(frame, "Запись успешно добавлена.", "Успех", JOptionPane.INFORMATION_MESSAGE);
            // Делаем окно видимым
        });
        frame.setVisible(true);


//        int numberAccount = new nameAccount().nameAccount();
//        float addAccount = new inputMoney().inputMoney();
//        new logicAddAccount().logicAddAccount(addAccount,numberAccount);
    }
}
