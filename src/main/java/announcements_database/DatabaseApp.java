package announcements_database;

import announcements_simple_model.AnnouncementType;
import announcements_simple_model.BookAnnouncement;
import announcements_simple_model.BookCategory;
import announcements_simple_model.Seller;

/**
 * Using this simple app you can add/remove/search users 
 * or add/remove/search announcements - let me show you how...
 * 
 * @author Aga
 *
 */
public class DatabaseApp {

	public static void main(String[] args) {

		Database db = new Database();
		
		// adding a nickname, phone number and user's email address to the database
		Seller seller = new Seller("Biały pies", "223554878", "whitedog@animals.com");
		db.addSeller(seller);

		// removing user data based on id number
		db.deleteSeller("16");

		// searching user data based on nickname
		db.findSeller("BrudnyHarry");

		// adding book's announcement data to the database
		BookAnnouncement book = new BookAnnouncement("Thinking in Java", "Stan niezbyt idealny", "45.99", seller,
				"Bruce Eckel", BookCategory.popularnonakowa, 2006);
		db.addBookAnnouncement(book);
		
		// removing announcement data based on its type and id number
		db.deleteAnnouncement(AnnouncementType.clothes, "35");

		// searching announcements based on its type, price range
		db.findAnnouncement(AnnouncementType.board_games, "30", "70");		

	}

}
