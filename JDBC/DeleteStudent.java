import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "Satyam@2003";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "DELETE FROM students WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, "Alice");

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
