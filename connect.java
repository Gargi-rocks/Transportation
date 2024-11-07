package learner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class connect {
    Connection con1 = null;
    PreparedStatement ps = null;
    bridge newt;
    String first_name,last_name,city,email;
    void connected(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "Gargi@003");
            System.out.println("This is Connected");
            String sql = "insert into contact values ('"+first_name+"', '"+last_name+"', '"+city+"', '"+email+"')";
            ps = con1.prepareStatement(sql);
            ps.execute();
        }catch(Exception e){
            System.out.println("This is not Connected");
        }
    }

    public static  void main(String[] args){
        connect obj = new connect();
        obj.connected();
    }
}
