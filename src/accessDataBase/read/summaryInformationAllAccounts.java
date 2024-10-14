package accessDataBase.read;


import accessDataBase.DatabaseConfig;

import java.sql.*;

public class summaryInformationAllAccounts extends DatabaseConfig {
    public StringBuilder summaryInformationAllAccounts(){

        StringBuilder result = new StringBuilder(); // Для накопления результатов
        String queryAccounts = "SELECT nameaccount, namebank, typeaccount, opendate, accountcurrency FROM accounts";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(queryAccounts)) {

            // Перебор всех счетов
            while (rs.next()) {
                String nameAccount = rs.getString("nameaccount");
                String nameBank = rs.getString("namebank");
                String typeAccount = rs.getString("typeaccount");
                String openDate = rs.getString("opendate");
                String accountCurrency = rs.getString("accountcurrency");

                // Динамическое имя таблицы истории операций для каждого счета
                String historyTable = "moneyaccount_" + nameAccount;
                String queryHistory = "SELECT countaccount FROM " + historyTable + " ORDER BY timechange DESC LIMIT 1";

                try (Statement historyStmt = conn.createStatement();
                     ResultSet historyRs = historyStmt.executeQuery(queryHistory)) {

                    if (historyRs.next()) {
                        float totalAmount = historyRs.getFloat("countaccount");

                        // Накопление данных по каждому счету вместе с суммой операций
                        result.append(String.format("Счет: %s | Банк: %s | Тип счета: %s | Дата открытия: %s | Валюта: %s | Общая сумма: %.2f\n",
                                nameAccount, nameBank, typeAccount, openDate, accountCurrency, totalAmount));
                    }
                } catch (SQLException e) {
                    result.append("Таблица ").append(historyTable).append(" не найдена. Пропускаем...\n");
                }
            }
        } catch (SQLException e) {
            result.append("Ошибка при выполнении запроса: ").append(e.getMessage()).append("\n");
            throw new RuntimeException(e);
        }

        // Возвращаем накопленный результат
        return result;
    }
}
