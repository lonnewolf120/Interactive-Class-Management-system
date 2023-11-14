package codenamex.smc.todo;

import codenamex.smc.Database.DatabaseManager;
import codenamex.smc.model.Task;
import codenamex.smc.Database.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class add_item_controller {

    public static void insert(Task task)
    {
        Connection connection = DatabaseManager.connectDB();
        String sql = "INSERT INTO `userdata`.`tasks` (`user_id`, `priority`, `headline`, `description`, `deadline`, `completed`) VALUES (?, ?, ?, ?, ?, ?);";
//        DatabaseManager.executeUpdate(sql, task.getTaskid(), task.getUser_id(), task.getPriority(), task.get
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
//            statement.setInt(1, task.getTaskid());
//            statement.setInt(2, task.getUser_id());
            statement.setInt(1, Login.getUserId());     //inserting the user_id from Login information to store data properly
            statement.setInt(2, task.getPriority());
            statement.setString(3, task.getHeadline());
            statement.setString(4, task.getDescription());
            statement.setDate(5, task.getDeadline());
            statement.setBoolean(6, task.getCompleted());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
