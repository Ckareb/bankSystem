package menu.give;

import accessDataBase.read.readAccount;
import accessDataBase.read.readCountAccount;
import accessDataBase.read.readHistoryOperation;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuGiveCountAccount {
    public void menuGiveCountAccount() {
        JFrame frame = new JFrame("Получение баланса по счету");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Создаем метки и текстовые поля
        JLabel nameLabel = new JLabel("номер счета");
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 25));

        // Добавляем метки и поля в окно
        frame.add(backButton);
        frame.add(nameLabel);
        frame.add(nameField);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Отправить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Создаем JTextArea для отображения результатов
        JTextArea textArea = new JTextArea(30, 80); // 30 строк, 80 столбцов
        textArea.setEditable(false); // Запрещаем редактирование
        JScrollPane scrollPane = new JScrollPane(textArea); // Добавляем прокрутку

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {
            String number = null;

            // Цикл для проверки номера паспорта
            while (number == null) {
                if (nameField.getText().matches("\\d{20}")) {
                    number = nameField.getText();
                } else {
                    JOptionPane.showMessageDialog(frame, "номер счета должн содержать 10 цифр.");
                    return; // Возвращаемся, чтобы пользователь ввел корректные данные
                }
            }

            // Передаем значение в метод для получения данных
            StringBuilder result = new readCountAccount().readCountAccount("moneyaccount_" + number);
            if (result == null) {
                JOptionPane.showMessageDialog(frame, "Ошибка при выполнении запроса: ", "Ошибка", JOptionPane.ERROR_MESSAGE);
            } else {
                // Обновляем текстовое поле с результатами
                textArea.setText(result.toString());
                if (!frame.isAncestorOf(scrollPane)) {
                    frame.add(scrollPane); // Добавляем прокручиваемую область, если ее еще нет
                    frame.revalidate(); // Перестраиваем контейнер
                    frame.repaint(); // Перерисовываем окно
                }
            }
        });

        // Делаем окно видимым
        frame.setVisible(true);
    }
}
