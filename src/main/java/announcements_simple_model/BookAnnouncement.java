package announcements_simple_model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class representing books announcements.
 * 
 * @author Aga
 *
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BookAnnouncement extends Announcement {

	private String author;
	private BookCategory category;
	private int publicationYear;

	/**
	 * This constructor creates an object based on parameters given by user.
	 */
	public BookAnnouncement(String title, String description, String price, Seller seller, String author,
			BookCategory category, int publicationYear) {
		super(title, description, price, seller);
		this.author = author;
		this.category = category;
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription()
				+ ", autor książki: " + author + ", gatunek: " + category + ", rok wydania: " + publicationYear
				+ "], data wystawienia: " + getDayOfStart() + ", data zakończenia: " + getDayOfEnd() + ", cena: "
				+ getPrice() + " PLN, od sprzedawcy = " + getSeller();
	}

}
