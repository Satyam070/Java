import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Satyam@2003";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE students SET age = ? WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, 21);
            stmt.setString(2, "Alice");

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
