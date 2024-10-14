package accessDataBase.read;

import accessDataBase.DatabaseConfig;

import javax.swing.*;
import java.sql.*;

public class readCustomersDB extends DatabaseConfig {
    public StringBuilder readCustomersDB(String seriesNumberPassport) throws RuntimeException {
        StringBuilder result = new StringBuilder(); // Для накопления результатов
        // SQL-запрос для поиска
        String query = "SELECT * FROM customers WHERE seriesnumberpassport = ?";

        try (Connection con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, seriesNumberPassport);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Проверяем, есть ли результаты
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Нет результатов для данного паспорта.", "Результаты", JOptionPane.INFORMATION_MESSAGE);
                    return null; // Завершаем метод, если нет результатов
                }

                // Выводим результаты поиска
                while (rs.next()) {
                    result.append("ID: ").append(rs.getInt("id"))
                            .append(", Name: ").append(rs.getString("name"))
                            .append(", Birthday: ").append(rs.getString("birthday"))
                            .append(", City of Birth: ").append(rs.getString("citybirths"))
                            .append(", Series Number Passport: ").append(rs.getInt("seriesnumberpassport"))
                            .append(", Issued By: ").append(rs.getString("whygive"))
                            .append(", Issue Date: ").append(rs.getString("giveday"))
                            .append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка при выполнении запроса: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Показываем результаты в диалоговом окне
        //JOptionPane.showMessageDialog(null, result.toString(), "Результаты поиска", JOptionPane.INFORMATION_MESSAGE);
        return result;
    }
}

