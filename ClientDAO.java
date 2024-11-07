package learner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO {
    private static Connection con;

    public ClientDAO(){
        if(con == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TSM","root","Gargi@003");
            }catch(Exception e){
                System.out.println("This is not Connected");
            }
        }
    }
    public ArrayList<Client> searchClient(String key){
        ArrayList<Client> result = new ArrayList<Client>();
        String sql = "SELECT * FROM allotment WHERE employee_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Client client = new Client();
                client.setId(rs.getString("employee_id"));
                client.setName(rs.getString("employee_name"));
                client.setAddress(rs.getString("license_no"));
                client.setTel(rs.getString("contact_no"));
                client.setEmail(rs.getString("cr_no"));
                client.setNote(rs.getString("from_add"));
                client.setNote1(rs.getString("to_addr"));
                client.setNote2(rs.getString("Current_status"));
                result.add(client);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void editClient(Client client){
        String sql = "UPDATE allotment SET Current_status = ? WHERE cr_no=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, client.getNote2());
            ps.setString(2, client.getEmail());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteClient(String id){
        String sql = "DELETE FROM allotment WHERE cr_no = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

