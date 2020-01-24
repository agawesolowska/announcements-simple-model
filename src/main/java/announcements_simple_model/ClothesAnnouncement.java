package announcements_simple_model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class representing clothes announcements.
 * 
 * @author Aga
 *
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class ClothesAnnouncement extends Announcement {

	private ClothType clothType;
	private String colour;
	private ClothesSize size;

	/**
	 * This constructor creates an object based on parameters given by user.
	 */
	public ClothesAnnouncement(String title, String description, String price, Seller seller, ClothType clothType,
			ClothesSize size, String colour) {
		super(title, description, price, seller);
		this.clothType = clothType;
		this.size = size;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription() + ", tkanina: "
				+ clothType + ", kolor: " + colour + ", rozmiar: " + size + "], data wystawienia: " + getDayOfStart()
				+ ", data zakończenia: " + getDayOfEnd() + ", cena: " + getPrice() + " PLN, od sprzedawcy = "
				+ getSeller();
	}

}
