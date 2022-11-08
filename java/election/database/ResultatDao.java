package election.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import election.bean.ResultatBean;

public class ResultatDao {
	public int RegisterResultat(ResultatBean resultat) throws ClassNotFoundException {
        String INSERT_Resultat_SQL = "select * from Canditat where username = ? and numero = ?";
            
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/election?useSSL=false", "tech", "tech2021");
        		// Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Resultat_SQL)) {
                preparedStatement.setString(1, resultat.getCirconscription());
                preparedStatement.setInt(2, resultat.getNum_bureau());
                preparedStatement.setString(3, resultat.getJour());
                preparedStatement.setInt(4, resultat.getNbre_electeur_inscrite());
                preparedStatement.setInt(5, resultat.getNbre_votant());
                preparedStatement.setInt(6, resultat.getNbre_voi_valide());
                preparedStatement.setInt(7, resultat.getNbre_voi_nule());
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
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
