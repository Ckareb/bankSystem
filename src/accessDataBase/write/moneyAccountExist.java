package accessDataBase.write;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class moneyAccountExist {
    public static boolean moneyAccountExist(Connection conn, String tableName) throws SQLException {
        String checkTableQuery = "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(checkTableQuery)) {
            pstmt.setString(1, tableName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }
}
