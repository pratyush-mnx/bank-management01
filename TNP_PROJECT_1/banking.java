package TNP_PROJECT_1;

import java.sql.*;
import java.util.Scanner;

public class banking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Connection connection = null;

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","12345");

            user u = new user(connection, sc);
            accounts acc = new accounts(connection, sc);

          
            while (true) {
                System.out.println("1. Register User");
                System.out.println("2. Login User");
                System.out.println("3. Open Account");
                System.out.println("4. Delete Account");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        u.register();
                        break;

                    case 2:
                        u.login();
                        break;

                    case 3:
                        acc.open_account();
                        break;

                    case 4:
                        acc.account_delete();
                        break;

                    case 5:
                        System.out.println("Thank you! Exiting...");
                        connection.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
