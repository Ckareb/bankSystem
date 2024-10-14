package accessDataBase.read;

import accessDataBase.DatabaseConfig;
import accessDataBase.write.moneyAccountExist;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class readHistoryOperation extends DatabaseConfig {
    public StringBuilder readHistoryOperation(String tableName) throws RuntimeException {
        String columnName = "historyaccount";
        String query = "SELECT " + columnName + ", timechange FROM " + tableName;
        StringBuilder result = new StringBuilder(); // Для накопления истории операций

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            // Проверяем, существует ли таблица
            if (moneyAccountExist.moneyAccountExist(conn, tableName)) {
                int count = 0;

                // Получаем данные из указанных столбцов
                while (rs.next()) {
                    count++;
                    result.append(count)
                            .append(". ")
                            .append(rs.getString(columnName)) // Получаем историю операций
                            .append(" Время: ")
                            .append(rs.getTimestamp("timechange")) // Получаем время изменения
                            .append("\n"); // Добавляем новую строку для каждого результата
                }

                // Проверка, если не было данных
                if (count == 0) {
                    result.append("История операций пуста.\n");
                }
            } else {
                result.append("Таблица '").append(tableName).append("' не найдена.\n");
            }
        } catch (SQLException e) {
            // Обрабатываем ошибки, возвращая их как часть результата
            result.append("Ошибка при выполнении запроса: ").append(e.getMessage()).append("\n");
            throw new RuntimeException(e);
        }
        return result; // Возвращаем накопленный результат
    }
}
