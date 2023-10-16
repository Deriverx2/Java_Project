import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use the new driver class
            c = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
