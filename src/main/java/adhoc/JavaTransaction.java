package adhoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaTransaction {
    public static void main(String[] args) throws SQLException {
        String url = Config.getDbUrl();
        String user = Config.getDbUsername();
        String password = Config.getDbPassword();
        Connection connection = null;

        try{
            System.out.println("Connection object");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);
            // Equivalent of Begin Transaction
            connection.setAutoCommit(false);
            String updateEntityHeader = "update entity_header set title = ? where id = ?";
            String updateEntityBody = "update entity_body set contents = ? where headerid = ?";

            PreparedStatement updateEntityPreparedStatement = connection.prepareStatement(updateEntityHeader);
            PreparedStatement updateEnityBodyPreparedStatement = connection.prepareStatement(updateEntityBody);

            updateEntityPreparedStatement.setString(1, "Title One - Java");
            updateEntityPreparedStatement.setInt(2, 1);
            updateEnityBodyPreparedStatement.setString(1,"Body Contents One - Java");
            updateEnityBodyPreparedStatement.setInt(2,1);

            updateEntityPreparedStatement.executeUpdate();
            updateEnityBodyPreparedStatement.executeUpdate();

            // End of Transaction.
            connection.commit();
            System.out.println("Records updated successfully");

        }catch (SQLException exception){
            System.out.println("Failure while updating records");
            connection.rollback();
        }
    }
}
