package TNP_PROJECT_1;

import java.sql.*;
import java.util.Scanner;

public class user {
    private Connection connection;
    private Scanner sc;

    public user ( Connection connection, Scanner sc) {
        this.connection = connection;
        this.sc = sc;
    }

    public void register(){
        sc.nextLine();
        System.out.println("Full name");
        String Full_name = sc.nextLine();

        System.out.println("email");
        String email = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();

        String querry = "insert into user (full_name, email, password) values(?,?,?);";

        try{
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setString(1, Full_name); 
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();
            System.out.println("succsesfully");

        }catch( Exception e){
            System.out.println("email already exists");
        }

    }


    public void login(){
        sc.nextLine();

        System.out.println("email");
        String email = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();

        String querry = "select * from user  where email = ? AND password = ?;";

        try{
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==true){
                System.out.println("sucessful");
            }


        }catch(Exception e){
            System.out.println("login failed");
        }

    
    }

    
}
