import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver
            String url = "jdbc:mysql://localhost:3306/hr"; // jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String login = "root";
            String password = "magina1701902";
            Connection connection = DriverManager.getConnection(url, login, password);

            PreparedStatement ps = connection.prepareStatement("update departments set location_id = ? where location_id = ?");
            ps.setInt(1, 1000);
            ps.setInt(2, 1700);
            ps.executeUpdate();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from departments");
            while (rs.next()) {
                String name = rs.getString("department_name");
                System.out.println(name);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
