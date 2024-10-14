package menu.fresh;

import accessDataBase.write.openNewBankAccount;
import controllers.inputNewBankAccount.*;
import controllers.inputNewCustomers.seriesNumberPassport;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuNewBankAccount {
    public void menuNewBankAccount() {
        // Создание окна
        JFrame frame = new JFrame("Открытие нового банковского счета");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Создание меток и текстовых полей
        JLabel nameAccountLabel = new JLabel("Номер счета:");
        JTextField nameAccountField = new JTextField();
        nameAccountField.setPreferredSize(new Dimension(200, 25));

        JLabel nameBankLabel = new JLabel("Название банка:");
        JTextField nameBankField = new JTextField();
        nameBankField.setPreferredSize(new Dimension(200, 25));

        JLabel typeAccountLabel = new JLabel("Тип счета:");
        JTextField typeAccountField = new JTextField();
        typeAccountField.setPreferredSize(new Dimension(200, 25));

        JLabel openDateLabel = new JLabel("Дата открытия:");
        JTextField openDateField = new JTextField();
        openDateField.setPreferredSize(new Dimension(200, 25));

        JLabel accountCurrencyLabel = new JLabel("Валюта счета:");
        JTextField accountCurrencyField = new JTextField();
        accountCurrencyField.setPreferredSize(new Dimension(200, 25));

        JLabel seriesNumberLabel = new JLabel("Серия паспорта:");
        JTextField seriesNumberField = new JTextField();
        seriesNumberField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton);
        frame.add(nameAccountLabel);
        frame.add(nameAccountField);

        frame.add(nameBankLabel);
        frame.add(nameBankField);

        frame.add(typeAccountLabel);
        frame.add(typeAccountField);

        frame.add(openDateLabel);
        frame.add(openDateField);

        frame.add(accountCurrencyLabel);
        frame.add(accountCurrencyField);

        frame.add(seriesNumberLabel);
        frame.add(seriesNumberField);

        // Кнопка "Отправить"
        JButton submitButton = new JButton("Открыть счет");
        frame.add(submitButton);

        // Обработчик кнопки "Назад"
        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Обработчик нажатия кнопки "Отправить"
        submitButton.addActionListener(e -> {
            String nameAccount = null;
            String nameBank = null;
            String typeAccount = null;
            String openDate = null;
            String accountCurrency = null;
            String seriesNumber = null;

            // Цикл проверки номера счета
            while (nameAccount == null) {
                if (nameAccountField.getText().matches("\\d{20}")) {
                    nameAccount = nameAccountField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Номер счета должен содержать только цифры и не меньше и не больше 20 цифр.");
                    return;
                }
            }

            // Цикл проверки названия банка
            while (nameBank == null) {
                if (nameBankField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    nameBank = nameBankField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Название банка должно содержать только буквы.");
                    return;
                }
            }

            // Цикл проверки типа счета
            while (typeAccount == null) {
                if (typeAccountField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    typeAccount = typeAccountField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Тип счета должен содержать только буквы.");
                    return;
                }
            }

            // Цикл проверки даты открытия
            while (openDate == null) {
                if (openDateField.getText().matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    openDate = openDateField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Введите дату открытия в формате ДД.ММ.ГГГГ.");
                    return;
                }
            }

            // Цикл проверки валюты счета
            while (accountCurrency == null) {
                if (accountCurrencyField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    accountCurrency = accountCurrencyField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Валюта счета должна содержать только буквы.");
                    return;
                }
            }

            // Цикл проверки серии паспорта
            while (seriesNumber == null) {
                if (seriesNumberField.getText().matches("\\d{10}")) {
                    seriesNumber = seriesNumberField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Введите серию паспорта, состоящую из 10 цифр.");
                    return;
                }
            }

            // Передаем значения в метод для записи нового счета
            new openNewBankAccount().writeNewBankAccount(nameAccount, nameBank, typeAccount, openDate, accountCurrency, seriesNumber);
            JOptionPane.showMessageDialog(frame, "Новый счет успешно открыт.", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);


//        int nameAccount = new nameAccount().nameAccount();
//        String nameBank = new nameBank().nameBank();
//        String typeAccount = new typeAccount().typeAccount();
//        String openDate = new openDate().openDate();
//        String accountCurrency = new accountCurrency().accountCurrency();
//        String seriesNumber = new seriesNumberPassport().seriesNumberPassport();
//
//        new openNewBankAccount().writeNewBankAccount(nameAccount, nameBank, typeAccount, openDate, accountCurrency, seriesNumber);
    }
}
