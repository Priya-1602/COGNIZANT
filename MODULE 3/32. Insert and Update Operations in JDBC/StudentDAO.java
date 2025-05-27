import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/schooldb";  
    private final String user = "root";         
    private final String password = "Priya@1602"; 
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    public boolean insertStudent(int id, String name, int age){
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateStudent(int id, String name, int age){
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

