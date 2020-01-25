package announcements_database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import announcements_simple_model.AnnouncementType;
import announcements_simple_model.BoardGameAnnouncement;
import announcements_simple_model.BookAnnouncement;
import announcements_simple_model.ClothesAnnouncement;
import announcements_simple_model.Seller;

/**
 * Class representing an announcements database.
 * 
 * @author Aga
 *
 */
public class Database {

	private String url = "jdbc:sqlite:announcements-web-page.db";
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;

	public Database() {
		try {
			connection = DriverManager.getConnection(url);
			stmt = connection.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS sellers (seller_id INTEGER PRIMARY KEY, nickname TEXT, phone_number TEXT, email_address TEXT);");
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS board_games_announcements (announcement_id INTEGER PRIMARY KEY, title TEXT, description TEXT, day_of_start NUMERIC, day_of_end NUMERIC, price NUMERIC, commission NUMERIC, type TEXT, min_player_age INTEGER, max_player_age INTEGER, min_number_of_players INTEGER, max_number_of_players INTEGER);");
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS books_announcements (announcement_id INTEGER PRIMARY KEY, title TEXT, description TEXT, day_of_start NUMERIC, day_of_end NUMERIC, price NUMERIC, commission NUMERIC, author TEXT, category TEXT, publication_year INTEGER);");
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS clothes_announcements (announcement_id INTEGER PRIMARY KEY, title TEXT, description TEXT, day_of_start NUMERIC, day_of_end NUMERIC, price NUMERIC, commission NUMERIC, cloth_type TEXT, colour TEXT, size TEXT);");
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS announcements_ids (id INTEGER PRIMARY KEY);");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Nie udało sie stworzyć tabel.");
			e.printStackTrace();
		}
	}

	public void addSeller(Seller seller) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection.prepareStatement("INSERT INTO sellers VALUES (?, ?, ?, ?);");
			pstmt.setInt(1, seller.getSellerId());
			pstmt.setString(2, seller.getNickname());
			pstmt.setString(3, seller.getPhoneNumber());
			pstmt.setString(4, seller.getEmailAddress());
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Dodałeś do bazy dane sprzedawcy: " + seller.toString());
		} catch (SQLException e) {
			System.err.println("Nie udało sie dodać danych sprzedawcy.");
			e.printStackTrace();
		}
	}

	public void deleteSeller(String seller_id) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection.prepareStatement("DELETE FROM sellers WHERE seller_id = ?;");
			pstmt.setString(1, seller_id);
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Usunąłeś z bazy dane sprzedawcy.");
		} catch (SQLException e) {
			System.err.println("Nie udało sie usunąć danych sprzedawcy.");
			e.printStackTrace();
		}
	}
	
	public void findSeller(String nickname) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection.prepareStatement("SELECT * FROM sellers WHERE nickname = ?;");
			pstmt.setString(1, nickname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int sellerId = rs.getInt(1);
				String nickName = rs.getString("nickname");
				String phoneNumber = rs.getString("phone_number");
				String emailAddress = rs.getString("email_address");
				System.out.printf("Wyszukałeś użytkownika - id:%d %s %s %s", sellerId, nickName, phoneNumber, emailAddress);
			}
			rs.close();
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Nie udało sie wyszukać sprzedawcy.");
			e.printStackTrace();
		}
	}

	public void addBoardGameAnnouncement(BoardGameAnnouncement boardGameAnnouncement) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection.prepareStatement(
					"INSERT INTO board_games_announcements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setInt(1, boardGameAnnouncement.getAnnouncementId());
			pstmt.setString(2, boardGameAnnouncement.getTitle());
			pstmt.setString(3, boardGameAnnouncement.getDescription());
			pstmt.setObject(4, boardGameAnnouncement.getDayOfStart());
			pstmt.setObject(5, boardGameAnnouncement.getDayOfEnd());
			pstmt.setBigDecimal(6, boardGameAnnouncement.getPrice());
			pstmt.setBigDecimal(7, boardGameAnnouncement.getCommission());
			pstmt.setObject(8, boardGameAnnouncement.getType());
			pstmt.setInt(9, boardGameAnnouncement.getMinPlayerAge());
			pstmt.setInt(10, boardGameAnnouncement.getMaxPlayerAge());
			pstmt.setInt(11, boardGameAnnouncement.getMinNumberOfPlayers());
			pstmt.setInt(12, boardGameAnnouncement.getMaxNumberOfPlayers());
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("INSERT INTO announcements_ids VALUES (?);");
			pstmt.setInt(1, boardGameAnnouncement.getAnnouncementId());
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Dodałeś do bazy ogłoszenie gry planszowej:\n" + boardGameAnnouncement.toString());
		} catch (SQLException e) {
			System.err.println("Nie udało sie dodać ogłoszenia gry planszowej.");
			e.printStackTrace();
		}
	}

	public void addBookAnnouncement(BookAnnouncement bookAnnouncement) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection
					.prepareStatement("INSERT INTO books_announcements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setInt(1, bookAnnouncement.getAnnouncementId());
			pstmt.setString(2, bookAnnouncement.getTitle());
			pstmt.setString(3, bookAnnouncement.getDescription());
			pstmt.setObject(4, bookAnnouncement.getDayOfStart());
			pstmt.setObject(5, bookAnnouncement.getDayOfEnd());
			pstmt.setBigDecimal(6, bookAnnouncement.getPrice());
			pstmt.setBigDecimal(7, bookAnnouncement.getCommission());
			pstmt.setString(8, bookAnnouncement.getAuthor());
			pstmt.setObject(9, bookAnnouncement.getCategory());
			pstmt.setInt(10, bookAnnouncement.getPublicationYear());
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("INSERT INTO announcements_ids VALUES (?);");
			pstmt.setInt(1, bookAnnouncement.getAnnouncementId());
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Dodałeś do bazy ogłoszenie książki:\n" + bookAnnouncement.toString());
		} catch (SQLException e) {
			System.err.println("Nie udało sie dodać ogłoszenia książki.");
			e.printStackTrace();
		}
	}

	public void addClothesAnnouncement(ClothesAnnouncement clothesAnnouncement) {
		try {
			connection = DriverManager.getConnection(url);
			pstmt = connection
					.prepareStatement("INSERT INTO clothes_announcements VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setInt(1, clothesAnnouncement.getAnnouncementId());
			pstmt.setString(2, clothesAnnouncement.getTitle());
			pstmt.setString(3, clothesAnnouncement.getDescription());
			pstmt.setObject(4, clothesAnnouncement.getDayOfStart());
			pstmt.setObject(5, clothesAnnouncement.getDayOfEnd());
			pstmt.setBigDecimal(6, clothesAnnouncement.getPrice());
			pstmt.setBigDecimal(7, clothesAnnouncement.getCommission());
			pstmt.setObject(8, clothesAnnouncement.getClothType());
			pstmt.setString(9, clothesAnnouncement.getColour());
			pstmt.setObject(10, clothesAnnouncement.getSize());
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("INSERT INTO announcements_ids VALUES (?);");
			pstmt.setInt(1, clothesAnnouncement.getAnnouncementId());
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Dodałeś do bazy ogłoszenie ubrania:\n" + clothesAnnouncement.toString());
		} catch (SQLException e) {
			System.err.println("Nie udało sie dodać ogłoszenia ubrania.");
			e.printStackTrace();
		}
	}

	private String chooseTypeOfAnnouncement(AnnouncementType announcementType) {
		switch (announcementType) {
		case board_games:
			return "board_games_announcements";
		case books:
			return "books_announcements";
		case clothes:
			return "clothes_announcements";
		}
		return null;
	}

	public void deleteAnnouncement(AnnouncementType announcementType, String announcement_id) {
		try {
			connection = DriverManager.getConnection(url);
			String typeOfAnnouncement = chooseTypeOfAnnouncement(announcementType);
			pstmt = connection.prepareStatement("DELETE FROM " + typeOfAnnouncement + " WHERE announcement_id = ?;");
			pstmt.setString(1, announcement_id);
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("DELETE FROM announcements_ids WHERE id = ?;");
			pstmt.setString(1, announcement_id);
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			System.out.println("Usunąłeś ogłoszenie z bazy danych.");
		} catch (SQLException e) {
			System.err.println("Nie udało sie usunąć ogłoszenia.");
			e.printStackTrace();
		}
	}

	public void findAnnouncement(AnnouncementType announcementType, String lowerPrice, String higherPrice) {
		try {
			connection = DriverManager.getConnection(url);
			String typeOfAnnouncement = chooseTypeOfAnnouncement(announcementType);
			pstmt = connection.prepareStatement("SELECT * FROM " + typeOfAnnouncement + " WHERE price BETWEEN ? AND ? ORDER BY price DESC;");
			pstmt.setString(1, lowerPrice);
			pstmt.setString(2, higherPrice);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("Wyszukałeś nastepujące ogłoszenia:");
			while(rs.next()) {
				int announcementId = rs.getInt(1);
				String title = rs.getString("title");
				String description = rs.getString("description");
				BigDecimal price = rs.getBigDecimal("price");
				System.out.printf("> id:%d %s %s %.2f\n", announcementId, title, description, price);
			}
			rs.close();
			pstmt.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Nie udało sie wyszukać ogłoszeń.");
			e.printStackTrace();
		}
	}
}
