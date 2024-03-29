/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nierema_sd2081
 */
public class CRUD {
    private ResultSet conn;
    public boolean addData() {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/niere";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Statement st = conn.createStatement();
            
            String query = " insert into userlist (firstname, lastname, middlename, email, password, repassword)" + "values ('?,?,?,?,?,?')"; 

            // note that i'm leaving "date_created" out of this insert statement
            st.executeUpdate(query);
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return false;
        }

    }

    public ResultSet getData() {
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/niere";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            
            Statement st = conn.createStatement();
            String getData = "select * from userlist";

            ResultSet rs = st.executeQuery(getData);
            while(rs.next()){
                System.out.println(rs.getString("firstname") + rs.getString("lastname")+rs.getString("middlename")
                +rs.getString("email") + rs.getString("password")+ rs.getString("repassword"));
            }    
            conn.close();
            return rs;
           
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            return conn;
        }
       
    }
}
