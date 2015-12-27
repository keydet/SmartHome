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
    private static Connection connection;
    private static Statement stmnt;
    private static ResultSet resultSet;

    public ArrayList<Thing> Things = new ArrayList<Thing>();

    private DatabaseManager() {

    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    public ArrayList<Thing> getThings() {


        String query = "select * from things";

        try {
            Class.forName("org.mariadb.jdbc.Driver");


            // opening database connection to MySQL server
            connection = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmnt = connection.createStatement();

            // executing SELECT query
            resultSet = stmnt.executeQuery(query);
            ArrayList<Thing> results = new ArrayList<Thing>();
            while (resultSet.next()) {
                results.add(new Thing(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
            }
            return results;

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { connection.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmnt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /*can't do anything */ }
        }

        return Things;
    }

}
