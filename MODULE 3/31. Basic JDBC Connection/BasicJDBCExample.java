import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BasicJDBCExample {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "Priya@1602";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("ID\tName\tAge");
            while (rs.next()){
                int id = rs.getInt("id");           
                String name = rs.getString("name"); 
                int age = rs.getInt("age");         
                System.out.printf("%d\t%s\t%d%n", id, name, age);
            }
        }catch(Exception e){
            e.printStackTrace(); 
        } finally{
            try { if (rs != null) rs.close(); } catch(Exception e){ }
            try { if (stmt != null) stmt.close(); } catch(Exception e){ }
            try { if (con != null) con.close(); } catch(Exception e){ }
        }
    }
}
