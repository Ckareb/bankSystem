package accessDataBase.read;

import accessDataBase.DatabaseConfig;

import javax.swing.*;
import java.sql.*;

public class showsBlockAccount extends DatabaseConfig {
    public StringBuilder showsBlockAccount(String nameAccountToView) {
        // SQL-запрос для получения записи по номеру счёта из таблицы archived_account
        String queryArchivedAccount = "SELECT * FROM archived_account WHERE nameaccount = ?";

        // Для хранения результата
        StringBuilder result = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(queryArchivedAccount)) {

            // Устанавливаем значение параметра запроса
            pstmt.setString(1, nameAccountToView);

            // Выполняем запрос для получения записей
            try (ResultSet rs = pstmt.executeQuery()) {
                int count = 0;

                // Получение данных из результата запроса
                while (rs.next()) {
                    count++;
                    int id = rs.getInt("id");
                    String nameAccount = rs.getString("nameaccount");
                    String nameBank = rs.getString("namebank");
                    String typeAccount = rs.getString("typeaccount");
                    String openDate = rs.getString("opendate");
                    String accountCurrency = rs.getString("accountcurrency");
                    int customerId = rs.getInt("customer_id");

                    result.append(count).append(". ID: ").append(id)
                            .append(" | Name Account: ").append(nameAccount)
                            .append(" | Name Bank: ").append(nameBank)
                            .append(" | Type Account: ").append(typeAccount)
                            .append(" | Open Date: ").append(openDate)
                            .append(" | Account Currency: ").append(accountCurrency)
                            .append(" | Customer ID: ").append(customerId)
                            .append("\n");
                }

                // Если запись не найдена
                if (count == 0) {
                    result.append("Запись для аккаунта '").append(nameAccountToView).append("' не найдена.\n");
                }
            }

        } catch (SQLException e) {
            // Обработка ошибки и запись её в результат
            result.append("Ошибка при выполнении запроса: ").append(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }

}
