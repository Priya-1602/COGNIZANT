import java.sql.*;
public class Transaction{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/schooldb";
        String user = "root";
        String password = "Priya@1602";
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            double transferAmount = 100;
            PreparedStatement debitStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
            );
            debitStmt.setDouble(1, transferAmount);
            debitStmt.setInt(2, 1); 
            PreparedStatement creditStmt = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
            );
            creditStmt.setDouble(1, transferAmount);
            creditStmt.setInt(2, 2); 
            int debitResult = debitStmt.executeUpdate();
            int creditResult = creditStmt.executeUpdate();
            if (debitResult == 1 && creditResult == 1) {
                con.commit();
                System.out.println("✅ Transfer successful.");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");
                System.out.println("\nUpdated Account Balances:");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("account_id") +
                                       ", Holder: " + rs.getString("account_holder") +
                                       ", Balance: " + rs.getBigDecimal("balance"));
                }
                rs.close();
                stmt.close();
            } else {
                con.rollback();
                System.out.println("Transfer failed. Rolled back.");
            }
            debitStmt.close();
            creditStmt.close();
        } catch (Exception e){
            try {
                if (con != null) con.rollback(); 
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();
        } finally{
            try{
                if (con != null) con.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

