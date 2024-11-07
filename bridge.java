package learner;
import java.sql.*;
public class bridge {
    Connection con=null, con1 = null,con2 = null,con3=null,con4=null,con5=null,con6= null;
    Statement stmt=null, stmt1 = null;
    String yourDatabaseName="tsm";
    void connected(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "Gargi@003");
            stmt1 = con1.createStatement();
            int status = stmt1.executeUpdate("CREATE DATABASE if not exists " + yourDatabaseName);
            if (status > 0) {
                System.out.println("Database is created successfully !!!");
            }
        }
        catch(Exception e) {
            System.out.println("This is not Connected");
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS sign_up (Name VARCHAR(50) NOT NULL, contact_no VARCHAR(12) NOT NULL, state VARCHAR(12), email_id VARCHAR(100), password VARCHAR(20) NOT NULL, tou VARCHAR(12) NOT NULL, gender VARCHAR(12), dob VARCHAR(12) NOT NULL, fathers_name VARCHAR(20) NOT NULL, image_path VARCHAR(700) NOT NULL, USER_ID VARCHAR(700) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("Sign_up Table Created");
        }
        catch(Exception e) {
            System.out.println("Sign_up table not created");
                    }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con2.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS employee_1 (Name VARCHAR(100) NOT NULL,Age VARCHAR(200) NOT NULL,Blood_group VARCHAR(10) , contact_no VARCHAR(20) NOT NULL, License_no VARCHAR(50) NOT NULL, permanent_add VARCHAR(100), Aadhar_no VARCHAR(20) NOT NULL, user_id VARCHAR(700) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("employee Table Created");
        }
        catch(Exception e) {
            System.out.println("employee table not created");
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con3.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS bilty (customer_name VARCHAR(100) NOT NULL,sender_no VARCHAR(20) NOT NULL,receiver_name VARCHAR(10) , receiver_no VARCHAR(20) NOT NULL, sender_aadhar_no VARCHAR(50) NOT NULL, total_dis VARCHAR(100), total_cost VARCHAR(20) NOT NULL,cr_no VARCHAR(20) NOT NULL,from_add VARCHAR(20) NOT NULL,to_add VARCHAR(20) NOT NULL, user_id VARCHAR(700) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("customer_1 Table Created");
        }
        catch(Exception e) {
            System.out.println("customer_1 table not created");
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con4.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS vehicle_1 (date_of_pur VARCHAR(100) NOT NULL,seller_name VARCHAR(200) NOT NULL,type_of_vehicle VARCHAR(20) , model_name VARCHAR(20) NOT NULL, engine_no VARCHAR(50) NOT NULL,chassis_no VARCHAR(100) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("vehicle Table Created");
        }
        catch(Exception e) {
            System.out.println("vehicle table not created");
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con5.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS vehicle_2 ( Date_of_service VARCHAR(100) NOT NULL,brakes VARCHAR(200) NOT NULL,spark_plugs VARCHAR(100) , oil_filter VARCHAR(200) NOT NULL, Battery VARCHAR(200) NOT NULL, radiator VARCHAR(100), air_filter VARCHAR(200) NOT NULL,chassis_no VARCHAR(100) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("manage_vehicle Table Created");
        }
        catch(Exception e) {
            System.out.println("manage_vehicle table not created");
        }
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsm", "root", "Gargi@003");
            stmt = con6.createStatement();
            String mytable_name = "CREATE TABLE IF NOT EXISTS allotment( employee_id VARCHAR(100) NOT NULL,employee_name VARCHAR(200) NOT NULL,license_no VARCHAR(100) , contact_no VARCHAR(20) NOT NULL, from_add VARCHAR(300) NOT NULL, to_addr VARCHAR(300),Current_status Varchar(20),cr_no VARCHAR(100) NOT NULL Primary Key);";
            stmt.executeUpdate(mytable_name);
            System.out.println("Allotment Table Created");
        }
        catch(Exception e) {
            System.out.println("Allotment table not created");
        }
                }
    public static  void main(String[] args){
        bridge obj = new bridge();
        obj.connected();
    }
}

