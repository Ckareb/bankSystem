package accessDataBase.write;

import accessDataBase.DatabaseConfig;
import accessDataBase.searchCustomersID;

import java.sql.*;

public class openNewBankAccount extends DatabaseConfig {
    public void writeNewBankAccount(String nameAccount, String nameBank, String typeAccount, String openDate, String accountCurrency, String seriesNumber){
        int customersId = new searchCustomersID().searchCustomersID(seriesNumber);
        String dropPolicyQuery = "ALTER TABLE accounts DISABLE ROW LEVEL SECURITY;";
        String sql = "INSERT INTO accounts (nameaccount, namebank, typeaccount, opendate, accountcurrency, customer_id) VALUES (?, ?, ?, ?, ?, ?)";
        String createTableMoney = "CREATE TABLE IF NOT EXISTS moneyAccount_" + nameAccount + " ("
                + "id SERIAL PRIMARY KEY, "
                + "nameaccount VARCHAR(20) NOT NULL, "
                + "historyaccount VARCHAR(256) NOT NULL,"
                + "timechange TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "countaccount FLOAT NOT NULL,"
                + "FOREIGN KEY (nameaccount) REFERENCES accounts(nameaccount)"
                + "ON DELETE RESTRICT )";
        String addTableMoney = "INSERT INTO moneyAccount_" + nameAccount + " (nameaccount, historyAccount, countAccount) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement crtableMoney = conn.prepareStatement(createTableMoney);
             PreparedStatement adTableMoney = conn.prepareStatement(addTableMoney);
             Statement stmt = conn.createStatement()) {

            // Устанавливаем значения для параметров SQL-запроса
            pstmt.setString(1, nameAccount);
            pstmt.setString(2, nameBank);
            pstmt.setString(3, typeAccount);
            pstmt.setString(4, openDate);
            pstmt.setString(5, accountCurrency);
            pstmt.setInt(6, customersId);

            adTableMoney.setString(1, nameAccount);
            adTableMoney.setString(2, "0");
            adTableMoney.setFloat(3, 0);


            // Выполняем запрос
            stmt.executeUpdate(dropPolicyQuery);
            int affectedRows = pstmt.executeUpdate();
            int affectedTableMoney = crtableMoney.executeUpdate();
            int affectedTableMoney1 = adTableMoney.executeUpdate();


            if (affectedRows > 0 && affectedTableMoney > 0 && affectedTableMoney1 > 0) {
                System.out.println("Запись успешно добавлена!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
