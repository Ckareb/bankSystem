package accessDataBase;

import java.sql.*;

public class searchCustomersID {
    public int searchCustomersID(String seriesNumberPassport) throws RuntimeException {

        int id =0;
        // Формируем SQL-запрос с параметрами для поиска
        String query = "SELECT * FROM customers WHERE 1=1";

        if (!seriesNumberPassport.isEmpty()) {
            query += " AND seriesnumberpassport = ?";
        }

        try (Connection con = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            // Устанавливаем параметры поиска в PreparedStatement
            int paramIndex = 1;


            if (!seriesNumberPassport.isEmpty()) {
                pstmt.setString(paramIndex++, seriesNumberPassport);
            }


            // Выполняем запрос
            try (ResultSet rs = pstmt.executeQuery()) {
                // Выводим результаты поиска
                while (rs.next()) {
                    id = rs.getInt("id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}