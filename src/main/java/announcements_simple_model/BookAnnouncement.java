package announcements_simple_model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode(callSuper=true)
public class BookAnnouncement extends Announcement {
	// class representing books announcements

	private String author;
	private BookCategory category;
	private int publicationYear;

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
