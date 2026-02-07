package TNP_PROJECT_1;

import java.sql.*;
import java.util.Scanner;

public class accounts {

    private Connection connection;
    private Scanner sc;

    public accounts(Connection connection, Scanner sc) {
        this.connection = connection;
        this.sc = sc;
    }

    public void open_account() {
        sc.nextLine();

        System.out.println("Full Name:");
        String full_name = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();

        System.out.println("Deposit money:");
        double balance = sc.nextDouble();

        System.out.println("Password:");
        String password = sc.next();   

        String query = "INSERT INTO accounts (full_name, email, balance, password) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, full_name);
            ps.setString(2, email);
            ps.setDouble(3, balance);   
            ps.setString(4, password);

            int rows = ps.executeUpdate();  

            if (rows > 0) {
                System.out.println("Account opened successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void account_delete(){
        sc.nextLine();

        System.out.println("email");
        String email = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();

        System.out.println("confirm your decision Y/N");
        String decision = sc.nextLine();

        String query = "DELETE FROM accounts WHERE email = ? AND password = ?";



        if(decision.equalsIgnoreCase("Y")){
            try{

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            ps.executeUpdate();
            System.out.println("sucessful");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("failed");
        }


    }

    public void generate_pin(){
        sc.nextLine();

        System.out.println("pin generate");
    }

}
