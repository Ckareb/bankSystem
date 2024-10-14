package accessDataBase.read;

import accessDataBase.DatabaseConfig;
import accessDataBase.write.moneyAccountExist;

import java.sql.*;


public class readAccount extends DatabaseConfig {
    public float readAccount(String tableName) throws RuntimeException {
        String columnName = "countaccount";
        String query = "SELECT " + columnName + " FROM " + tableName + " ORDER BY id DESC LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            // Поиск таблицы
            if (moneyAccountExist.moneyAccountExist(conn, tableName)) {
                // Получение последней строки указанного столбца
                if (rs.next()) {
                    return rs.getFloat(columnName); // Возвращаем значение последней строки указанного столбца
                }
            } else {
                System.out.println("Таблица '" + tableName + "' не найдена.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return 0;
    }
}
