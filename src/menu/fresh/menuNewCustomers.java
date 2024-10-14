package menu.fresh;

import accessDataBase.write.writeNewCustomersDB;
import controllers.inputNewCustomers.*;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuNewCustomers {
    public void menuNewCustomers() {
        JFrame frame = new JFrame("Ввод данных клиента");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Создаем метки и текстовые поля
        JLabel nameLabel = new JLabel("Имя:");
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));

        JLabel birthdayLabel = new JLabel("Дата рождения:");
        JTextField birthdayField = new JTextField();
        birthdayField.setPreferredSize(new Dimension(200, 25));

        JLabel cityBirthLabel = new JLabel("Город рождения:");
        JTextField cityBirthField = new JTextField();
        cityBirthField.setPreferredSize(new Dimension(200, 25));

        JLabel seriesPassportLabel = new JLabel("Серия паспорта:");
        JTextField seriesPassportField = new JTextField();
        seriesPassportField.setPreferredSize(new Dimension(200, 25));

        JLabel whyGiveLabel = new JLabel("Кем выдан:");
        JTextField whyGiveField = new JTextField();
        whyGiveField.setPreferredSize(new Dimension(200, 25));

        JLabel giveDayLabel = new JLabel("Дата выдачи:");
        JTextField giveDayField = new JTextField();
        giveDayField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton, BorderLayout.NORTH);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(birthdayLabel);
        frame.add(birthdayField);

        frame.add(cityBirthLabel);
        frame.add(cityBirthField);

        frame.add(seriesPassportLabel);
        frame.add(seriesPassportField);

        frame.add(whyGiveLabel);
        frame.add(whyGiveField);

        frame.add(giveDayLabel);
        frame.add(giveDayField);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Отправить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {
            String name = null;
            String birthday = null;
            String cityBirths = null;
            String seriesPassport = null;
            String whyGive = null;
            String giveDay = null;



            // Цикл для проверки имени
            while (name == null) {
                if (nameField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    name = nameField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Имя должно содержать только буквы.");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            // Цикл для проверки даты рождения
            while (birthday == null) {
                if (birthdayField.getText().matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    birthday = birthdayField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Введите дату рождения в формате ДД.ММ.ГГГГ.");
                    return;
                }
            }

            // Цикл для проверки города рождения
            while (cityBirths == null) {
                if (cityBirthField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    cityBirths = cityBirthField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Город должен содержать только буквы.");
                    return;
                }
            }

            // Цикл для проверки серии паспорта
            while (seriesPassport == null) {
                if (seriesPassportField.getText().matches("\\d{10}")) {
                    seriesPassport = seriesPassportField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Введите серию паспорта, состоящую из 10 цифр.");
                    return;
                }
            }

            // Цикл для проверки поля "кем выдан"
            while (whyGive == null) {
                if (whyGiveField.getText().matches("[a-zA-ZА-Яа-я]+")) {
                    whyGive = whyGiveField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Поле 'кем выдан' должно содержать только буквы.");
                    return;
                }
            }

            // Цикл для проверки даты выдачи
            while (giveDay == null) {
                if (giveDayField.getText().matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    giveDay = giveDayField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "Введите дату выдачи в формате ДД.ММ.ГГГГ.");
                    return;
                }
            }

            // Передаем значения в метод
                new writeNewCustomersDB().writeNewCustomersDB(name, birthday, cityBirths, String.valueOf(seriesPassport), whyGive, giveDay);
                JOptionPane.showMessageDialog(frame, "Запись успешно добавлена.", "Успех", JOptionPane.INFORMATION_MESSAGE);
                // Делаем окно видимым
        });
            frame.setVisible(true);



//        String name = new name().name();
//        String birthday = new birthday().birthday();
//        String cityBirths = new cityBirths().cityBirths();
//        String seriesPassport =  new seriesNumberPassport().seriesNumberPassport();
//        String whyGive = new whyGive().whyGive();
//        String giveDay = new giveDay().giveDay();
//
//        new writeNewCustomersDB().writeNewCustomersDB(name, birthday, cityBirths, seriesPassport, whyGive, giveDay);

    }
}
/*CREATE TABLE customers
(
    Id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(30),
    birthday DATE,
	cityBiths CHARACTER VARYING(100),
	seriesPassport INTEGER,
	numberPassport INTEGER,
	whyGive CHARACTER VARYING(100),
	giveDay DATE
);*/