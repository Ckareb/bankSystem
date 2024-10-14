package menu.change;

import accessDataBase.read.showsBlockAccount;
import accessDataBase.read.summaryInformationAllAccounts;
import menu.mainMenu;

import javax.swing.*;
import java.awt.*;

public class menuSummaryInformationAllAccounts {
    public void menuSummaryInformationAllAccounts() {
        JFrame frame = new JFrame("Сводная информаци по всем счетам");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.setLayout(new FlowLayout());

        JButton backButton = new JButton("Вернуться на главную");

        // Добавляем метки и поля в окно
        frame.add(backButton);

        // Создаем кнопку "Отправить"
        JButton submitButton = new JButton("Получить");
        frame.add(submitButton);

        backButton.addActionListener(e -> new mainMenu().mainMenu());

        // Создаем JTextArea для отображения результатов
        JTextArea textArea = new JTextArea(30, 80); // 30 строк, 80 столбцов
        textArea.setEditable(false); // Запрещаем редактирование
        JScrollPane scrollPane = new JScrollPane(textArea); // Добавляем прокрутку

        // Обработчик нажатия кнопки с передачей данных в метод
        submitButton.addActionListener(e -> {

            StringBuilder result = new summaryInformationAllAccounts().summaryInformationAllAccounts();
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
