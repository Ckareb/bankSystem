package accessDataBase.read;


import accessDataBase.DatabaseConfig;

import javax.swing.*;
import java.sql.*;

public class readBankAccount extends DatabaseConfig {
    public StringBuilder readBankAccount(String numberAccount) throws RuntimeException {
        StringBuilder result = new StringBuilder(); // Для накопления результатов
        // SQL-запрос для поиска
        String query = "SELECT * FROM accounts WHERE 1=1";

        if (numberAccount != null && !numberAccount.isEmpty()) {
            query += " AND nameaccount = ?";
        }

        try (Connection con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            // Устанавливаем параметры поиска в PreparedStatement
            int paramIndex = 1;

            if (numberAccount != null && !numberAccount.isEmpty()) {
                pstmt.setString(paramIndex++, numberAccount); // Устанавливаем как строку
            }

            // Выполняем запрос
            try (ResultSet rs = pstmt.executeQuery()) {
                // Проверяем, есть ли результаты
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Нет результатов для данного счета.", "Результаты", JOptionPane.INFORMATION_MESSAGE);
                    return null; // Завершаем метод, если нет результатов
                }

                // Выводим результаты поиска
                while (rs.next()) {
                    result.append("ID: ").append(rs.getInt("id"))
                            .append(", nameAccount: ").append(rs.getString("nameaccount")) // Используем getString
                            .append(", nameBank: ").append(rs.getString("namebank"))
                            .append(", typeAccount: ").append(rs.getString("typeaccount"))
                            .append(", openDate: ").append(rs.getString("opendate"))
                            .append(", accountCurrency: ").append(rs.getString("accountcurrency"))
                            .append(", customersId: ").append(rs.getInt("customer_id"))
                            .append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка при выполнении запроса: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return result;
    }
}
