package menu;
import menu.change.*;
import menu.fresh.menuNewBankAccount;
import menu.fresh.menuNewCustomers;
import menu.give.*;

import javax.swing.*;
import java.awt.*;


public class mainMenu {
    public void mainMenu(){
        // Создаем новое окно (JFrame)
        JFrame frame = new JFrame("Банковская ИС");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 900);

        // Устанавливаем менеджер компоновки (GridLayout с одной колонкой и 12 строками)
        frame.setLayout(new BorderLayout());
        frame.setLayout(new GridLayout(13, 1));

        // Добавляем метку (JLabel) с текстом "Доступны следующие операции:"
        JLabel label = new JLabel("Доступны следующие операции:");
        frame.add(label);

        Dimension buttonSize = new Dimension(50, 30);

        // Создаем кнопки
        //JButton backButton = new JButton("Вернуться на главную");
        JButton button1 = new JButton("Создать нового клиента");
        button1.setPreferredSize(buttonSize);
        JButton button2 = new JButton("Открыть новый счет");
        button2.setPreferredSize(buttonSize);
        JButton button3 = new JButton("Посмотреть клиента");
        button3.setPreferredSize(buttonSize);
        JButton button4 = new JButton("Посмотреть счет");
        button4.setPreferredSize(buttonSize);
        JButton button5 = new JButton("Пополнить счет");
        button5.setPreferredSize(buttonSize);
        JButton button6 = new JButton("Снять со счета");
        button6.setPreferredSize(buttonSize);
        JButton button7 = new JButton("Посмотреть историю операций");
        button7.setPreferredSize(buttonSize);
        JButton button8 = new JButton("Посмотреть баланс по счету");
        button8.setPreferredSize(buttonSize);
        JButton button9 = new JButton("Закрытие счета");
        button9.setPreferredSize(buttonSize);
        JButton button10 = new JButton("Перевод между счетами");
        button10.setPreferredSize(buttonSize);
        JButton button11 = new JButton("Формирование сводной информации по всем счетам");
        button11.setPreferredSize(buttonSize);
        JButton button12 = new JButton("Посмотреть закрытый счет");
        button12.setPreferredSize(buttonSize);

        // Добавляем кнопки в окно
        //frame.add(backButton, BorderLayout.NORTH);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);

        // Обработчики нажатий кнопок
        //backButton.addActionListener(e -> new mainMenu().mainMenu());
        button1.addActionListener(e -> new menuNewCustomers().menuNewCustomers());
        button2.addActionListener(e -> new menuNewBankAccount().menuNewBankAccount());
        button3.addActionListener(e -> new menuGiveCustomers().menuGiveCustomers());
        button4.addActionListener(e -> new menuGiveAccounts().menuGiveAccounts());
        button5.addActionListener(e -> new menuAddAccount().menuAddAccount());
        button6.addActionListener(e -> new menuDebitAccount().menuDebitAccount());
        button7.addActionListener(e -> new menuGiveHistoryOperation().menuGiveHistoryOperation());
        button8.addActionListener(e -> new menuGiveCountAccount().menuGiveCountAccount());
        button9.addActionListener(e -> new menuCloseBankAccount().menuDebitAccount());
        button10.addActionListener(e -> new menuFromOneAccountToAnother().menuFromOneAccountToAnother());
        button11.addActionListener(e -> new menuSummaryInformationAllAccounts().menuSummaryInformationAllAccounts());
        button12.addActionListener(e -> new menuShowsBlockAccount().menuShowsBlockAccount());


        // Делаем окно видимым pg_dump -U username -W -F t banksystem > db_dump.tar
        //docker exec -it my_postgres_db bash
        //
        frame.setVisible(true);


//        System.out.println("Доступны следующие операции\n" +
//                "1.Создать нового пользователя\n" +
//                "2.Открыть новый счет\n" +
//                "3.Посмотреть пользователя\n" +
//                "4.Посмотреть счет\n" +
//                "5.Пополнить счет\n" +
//                "6.Снять со счета\n" +
//                "7.Посмотреть исторю операций\n" +
//                "8.Посмотреть баланс по счету\n" +
//                "9.Закрытие счета\n" +
//                "10.Перевод между счетами\n" +
//                "11.Формирование сводной информации по всем счетам");
//        Scanner scn = new Scanner(System.in);
//        switch (scn.nextInt()){
//            case 1: new menuNewCustomers().menuNewCustomers();
//                break;
//            case 2: new menuNewBankAccount().menuNewBankAccount();
//                break;
//            case 3: new menuGiveCustomers().menuGiveCustomers();
//                break;
//            case 4: new menuGiveAccounts().menuGiveAccounts();
//                break;
//            case 5: new menuAddAccount().menuAddAccount();
//                break;
//            case 6: new menuDebitAccount().menuDebitAccount();
//                break;
//            case 7: new readHistoryOperation().readHistoryOperation("moneyaccount_" + new nameAccount().nameAccount());
//                break;
//            case 8: System.out.println("Баланс счета: " + new readAccount().readAccount("moneyaccount_" + new nameAccount().nameAccount()));
//                break;
//            case 9: new menuCloseBankAccount().menuDebitAccount();
//                break;
//            case 10: new menuFromOneAccountToAnother().menuFromOneAccountToAnother();
//                break;
//            case 11: new summaryInformationAllAccounts().summaryInformationAllAccounts();
//                break;
//            case 12: new showsBlockAccount().showsBlockAccount(new nameAccount().nameAccount());
//                break;
//        }
    }
}
