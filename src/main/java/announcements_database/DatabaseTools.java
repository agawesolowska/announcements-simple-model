package announcements_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class for database handling.
 * 
 * @author Aga
 *
 */
public class DatabaseTools {

	/**
	 * This method selects a maximum seller ID in the database and is used to create
	 * a new object of a seller.
	 * 
	 * @see Class 'Seller' in package announcements_simple_model.
	 * @return A maximum ID from sellers table.
	 */
	public static Integer getMaxIdOfSellers() {
		Connection connection;
		PreparedStatement pstmt;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:announcements-web-page.db");
			pstmt = connection.prepareStatement("SELECT max(seller_id) FROM sellers;");
			ResultSet rs = pstmt.executeQuery();
			Integer queryResult = rs.getInt(1);
			rs.close();
			pstmt.close();
			connection.close();
			return queryResult;
		} catch (SQLException e) {
			System.err.println("Błąd w odczycie danych.");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method selects a maximum announcement ID in the database and is used to
	 * create a new object of an announcement.
	 * 
	 * @see Class 'Announcement' in package announcements_simple_model.
	 * @return A maximum ID from announcements table.
	 */
	public static Integer getMaxIdOfAnnouncements() {
		Connection connection;
		PreparedStatement pstmt;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:announcements-web-page.db");
			pstmt = connection.prepareStatement("SELECT max(id) FROM announcements_ids;");
			ResultSet rs = pstmt.executeQuery();
			Integer queryResult = rs.getInt(1);
			rs.close();
			pstmt.close();
			connection.close();
			return queryResult;
		} catch (SQLException e) {
			System.err.println("Błąd w odczycie danych.");
			e.printStackTrace();
		}
		return null;
	}

}
