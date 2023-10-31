package codenamex.smc.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection connectDB()
    {
        Connection connect = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","smc_1234");
//            return connect;
        }
        catch(ClassNotFoundException | SQLException e){e.printStackTrace();}
        return connect;
    }

}
