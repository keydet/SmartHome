import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class DatabaseManager {

    private static final DatabaseManager instance = new DatabaseManager();
    private static final String url = "jdbc:mysql://localhost:3306/smarthome";
    private static final String user = "root";
    private static final String password = "128500";
    private static Connection connection = DatabaseManager.getConnection();
    private static Statement stmnt;
    private static ResultSet resultSet;


    public ArrayList<Thing> Things = new ArrayList<Thing>();

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {return instance;}

    public static Connection getConnection() {

        try {
            // Load the JDBC driver
            String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // Could not find the database driver
        } catch (SQLException e) {
            // Could not connect to the database
        }
        return connection;
    }

    public ArrayList<Thing> getThings() {


        String query = "select * from things";

        try {
            stmnt = connection.createStatement();
            resultSet = stmnt.executeQuery(query);

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmnt.execute(query)) {
                resultSet = stmnt.getResultSet();
            }

            // Now do something with the ResultSet ....

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int power = resultSet.getInt(3);
                Things.add(new Thing(id, name, power));
                System.out.println(id + "\t" + name + "\t" + power);
            }

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) { } // ignore

                resultSet = null;
            }

            if (stmnt != null) {
                try {
                    stmnt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmnt = null;
            }
        }

        return Things;
    }

}
