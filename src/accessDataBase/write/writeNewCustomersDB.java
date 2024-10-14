package accessDataBase.write;

import accessDataBase.DatabaseConfig;

import java.sql.*;


public class writeNewCustomersDB extends DatabaseConfig {

    public void writeNewCustomersDB(String name, String birthday, String cityBirths, String seriesNumberPassport, String whyGive, String giveDay){
        String sql = "INSERT INTO customers (name, birthday, citybirths, seriesnumberpassport, whygive, giveday) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Устанавливаем значения для параметров SQL-запроса
            pstmt.setString(1, name);
            pstmt.setString(2, birthday);
            pstmt.setString(3, cityBirths);
            pstmt.setInt(4, Integer.parseInt(seriesNumberPassport));
            pstmt.setString(5, whyGive);
            pstmt.setString(6, giveDay);

            // Выполняем запрос
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Запись успешно добавлена!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



//        File file = new File("src", "customers.txt");
//        try (FileWriter fw = new FileWriter(file, true);
//                 BufferedWriter bw = new BufferedWriter(fw)){
//            bw.write("Введите Имя, Фамилию, Отчество (при наличии) " + name + "\n");
//            bw.write("Дату рождения " + birthday + "\n");
//            bw.write("Место рождения " + cityBirths + "\n");
//            bw.write("Введите серию паспорта " + seriesPassport + "\n");
//            bw.write("Введите номер паспорта " + numberPassport + "\n");
//            bw.write("Кем выдан " + whyGive + "\n");
//            bw.write("Дату выдачи " + giveDay + "\n");
//        } catch (IOException e) {
//            System.out.println("Ошибка при записи в файл");
//            e.printStackTrace();
//        }
    }
}
