package election.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import election.bean.UserBean;

public class UserDao {
	public int registerUser(UserBean user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (prenom, nom,civilite, date_naiss, cni, adresse, dept, commune, bureauvote, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/election?useSSL=false", "tech", "tech2021");
        		// Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
                preparedStatement.setString(1, user.getPrenom());
                preparedStatement.setString(2, user.getNom());
                preparedStatement.setString(3, user.getCivilite());
                preparedStatement.setString(4, user.getDate_naiss());
                preparedStatement.setString(5, user.getCni());
                preparedStatement.setString(6, user.getAdresse());
                preparedStatement.setString(7, user.getDept());
                preparedStatement.setString(8, user.getCommune());
                preparedStatement.setString(9, user.getBureauvote());
                preparedStatement.setString(10, user.getPassword());
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();
                
                }catch (SQLException e) {
                    // process sql exception
                    printSQLException(e);
                }
                return result;
        		
        }
	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }

}
