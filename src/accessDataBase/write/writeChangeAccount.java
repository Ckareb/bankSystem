package accessDataBase.write;

import accessDataBase.DatabaseConfig;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class writeChangeAccount extends DatabaseConfig {
    public void writeChangeAccount(float changeMoney, String nameAccount, String changeAccount){
        JFrame frame = new JFrame("Ошибка операции");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        String tableName = "moneyaccount_" + nameAccount;  // Имя таблицы, которую ищем
        String insertDataSQL = "INSERT INTO %s (nameaccount, historyaccount, countaccount) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)) {

            // Проверяем наличие таблицы в базе данных
            if (moneyAccountExist.moneyAccountExist(conn, tableName)) {

                // Подготавливаем SQL для вставки данных
                String sql = String.format(insertDataSQL, tableName);

                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, String.valueOf(nameAccount));
                    pstmt.setString(2, changeAccount);
                    pstmt.setFloat(3, changeMoney );

                    // Выполняем вставку данных
                    int affectedRows = pstmt.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Данные успешно вставлены в таблицу " + tableName);
                    }
                }
            } else {
                System.out.println("Счет " + nameAccount + " не найден/закрыт");
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Access to this table is blocked")) {
                System.out.println("Ошибка: Счет закрыт и недоступен для операций.");
                JOptionPane.showMessageDialog(frame, "Ошибка: Счет закрыт и недоступен для операций.");
            } else {
                e.printStackTrace(); // Выводим остальные ошибки
            }
            throw new RuntimeException(e);
            // Выводим остальные ошибки
            //32132132132132132121
        }
    }
}

