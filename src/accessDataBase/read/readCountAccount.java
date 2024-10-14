package accessDataBase.read;

import accessDataBase.DatabaseConfig;
import accessDataBase.write.moneyAccountExist;

import java.sql.*;

public class readCountAccount extends DatabaseConfig {
    public StringBuilder readCountAccount(String tableName) throws RuntimeException {
        String columnName = "countaccount";
        String query = "SELECT " + columnName + " FROM " + tableName + " ORDER BY id DESC LIMIT 1";
        StringBuilder result = new StringBuilder();  // Для хранения результата

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)) {

            // Проверяем существование таблицы
            if (!moneyAccountExist.moneyAccountExist(conn, tableName)) {
                result.append("Таблица '").append(tableName).append("' не найдена.");
                return result; // Если таблица не найдена, возвращаем сообщение
            }

            try (PreparedStatement pstmt = conn.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                // Получаем последнюю строку из указанного столбца
                if (rs.next()) {
                    result.append("Последнее значение '").append(columnName).append("': ")
                            .append(rs.getFloat(columnName));  // Добавляем результат в StringBuilder
                } else {
                    result.append("Данных в таблице '").append(tableName).append("' не найдено.");
                }
            }

        } catch (SQLException e) {
            // В случае ошибки выводим её в StringBuilder и выбрасываем RuntimeException
            result.append("Ошибка при выполнении запроса: ").append(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }
}
