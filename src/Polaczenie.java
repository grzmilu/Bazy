
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Polaczenie {

    private static Polaczenie inst;
    private Connection connection;
    private Statement statement;

    public static Polaczenie inst() {
        if (inst == null) {
            inst = new Polaczenie();
        }
        return inst;
    }

    public boolean createConnection(String url) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Błąd sterownika: " + ex.getMessage());
            return false;
        }
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            return true;
        } catch (SQLException ex) {
            System.out.println("Błąd SQLa: " + ex.getMessage());
            return false;
        }
    }

    public ResultSet executeQuery(String query) {
        if (connection != null) {
            try {
                return statement.executeQuery(query);
            } catch (SQLException e) {
                System.out.println("Błąd w kwerendzie: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("Nie nawiązano połączenia");
            return null;
        }
    }

    public int executeUpdate(String query) {
        if (connection != null) {
            try {
                return statement.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("Błąd w kwerendzie: " + e.getMessage());
                return 0;
            }
        } else {
            System.out.println("Nie nawiązano połączenia");
            return 0;
        }
    }

    public boolean closeConnection() {
        if (connection == null) {
            System.out.println("Nie nawiązano połączenia");
            return false;
        } else {
            try {
                connection.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Błąd SQLa: " + ex.getMessage());
                return false;
            }
        }
    }

}
