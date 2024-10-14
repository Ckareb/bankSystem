package accessDataBase;
import java.sql.*;

public class closeBankAccount extends DatabaseConfig {
    public void closeBankAccount(String nameAccount){
        // Создаем имена таблиц
        String sourceTableName = "moneyaccount_" + nameAccount;
        String targetTableName = "archive_moneyaccount_" + nameAccount;

// SQL-запрос для создания таблицы archive_moneyaccount_<nameAccount>
        String createMoneyAccountTableQuery = "CREATE TABLE IF NOT EXISTS " + targetTableName + " (" +
                "id SERIAL PRIMARY KEY, " +
                "nameaccount VARCHAR(20) NOT NULL, " +
                "historyaccount VARCHAR(256) NOT NULL, " +
                "timechange TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "countaccount FLOAT NOT NULL" +
                ")";

// SQL-запрос для архивирования аккаунта
        String archiveQuery = "INSERT INTO archived_account (nameaccount, namebank, typeaccount, opendate, accountcurrency, customer_id) " +
                "SELECT nameaccount, namebank, typeaccount, opendate, accountcurrency, customer_id FROM accounts " +
                "WHERE nameaccount = ?";

// SQL-запрос для удаления аккаунта из таблицы accounts
        String deleteQuery = "DELETE FROM accounts WHERE nameaccount = ?";

// SQL-запрос для переноса данных из moneyaccount_<nameAccount> в archive_moneyaccount_<nameAccount>
        String transferQuery = "INSERT INTO " + targetTableName + " (nameaccount, historyaccount, timechange, countaccount) " +
                "SELECT nameaccount, historyaccount, timechange, countaccount FROM " + sourceTableName;

// SQL-запрос для удаления данных из исходной таблицы moneyaccount_<nameAccount>
        String deleteSourceTableQuery = "DROP TABLE IF EXISTS " + sourceTableName;

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Шаг 1: Создаем таблицу archive_moneyaccount_<nameAccount>, если она не существует
            stmt.executeUpdate(createMoneyAccountTableQuery);
            System.out.println("Таблица " + targetTableName + " создана или уже существует.");

            // Шаг 2: Переносим данные из таблицы accounts в archived_account
            try (PreparedStatement archiveStmt = conn.prepareStatement(archiveQuery)) {
                archiveStmt.setString(1, nameAccount);
                int rowsArchived = archiveStmt.executeUpdate();

                if (rowsArchived > 0) {
                    System.out.println("Аккаунт '" + nameAccount + "' успешно заархивирован.");

                    // Шаг 3: Переносим данные из moneyaccount_<nameAccount> в archive_moneyaccount_<nameAccount>
                    int rowsTransferred = stmt.executeUpdate(transferQuery);
                    System.out.println(rowsTransferred + " записей перенесено из " + sourceTableName + " в " + targetTableName + ".");

                    // Шаг 4: Удаляем исходную таблицу moneyaccount_<nameAccount>
                    stmt.executeUpdate(deleteSourceTableQuery);
                    System.out.println("Таблица " + sourceTableName + " успешно удалена.");

                    // Шаг 5: Удаляем аккаунт из таблицы accounts
                    try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                        deleteStmt.setString(1, nameAccount);
                        int rowsDeleted = deleteStmt.executeUpdate();

                        if (rowsDeleted > 0) {
                            System.out.println("Аккаунт '" + nameAccount + "' был успешно удален из таблицы accounts.");
                        } else {
                            System.out.println("Ошибка: не удалось удалить аккаунт '" + nameAccount + "' из таблицы accounts.");
                        }
                    }
                } else {
                    System.out.println("Ошибка: не удалось заархивировать аккаунт '" + nameAccount + "'.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
