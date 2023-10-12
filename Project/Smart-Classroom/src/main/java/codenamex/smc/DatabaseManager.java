package codenamex.smc;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    public static Connection connectDB()
    {
        try
        {
            Class.forName("com.sql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost")
        }
        catch(Exception e){e.printStackTrace();}
    }

}
