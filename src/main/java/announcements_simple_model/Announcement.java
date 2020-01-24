package announcements_simple_model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import announcements_database.DatabaseTools;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class representing a simple model of announcements.
 * 
 * @author Aga
 *
 */
@Getter
@EqualsAndHashCode
public class Announcement {

	/**
	 * Static variable helpful in creating a new object.
	 * 
	 * @see Class 'DatabaseTools' in package announcements_database.
	 */
	private static int numberOfAnnouncements = DatabaseTools.getMaxIdOfAnnouncements();

	private int announcementId;
	private String title, description;
	private LocalDate dayOfStart;
	private BigDecimal price;
	private Seller seller;

	/**
	 * This constructor creates an object based on parameters given by user.
	 */
	public Announcement(String title, String description, String price, Seller seller) {
		numberOfAnnouncements++;
		this.announcementId = numberOfAnnouncements;
		this.title = title;
		this.description = description;
		this.dayOfStart = LocalDate.now();
		this.price = new BigDecimal(price);
		if (this.price.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Cena nie może być ujemna.");
		}
		this.seller = seller;
	}

	/**
	 * This method returns time in days from adding an announcement.
	 */
	public int getTimeSinceStartInDays() {
		return Period.between(dayOfStart, LocalDate.now()).getDays();
	}

	/**
	 * This method returns a day of an announcement ending.
	 */
	public LocalDate getDayOfEnd() {
		return dayOfStart.plusDays(14);
	}

	/**
	 * This method returns a commission, which depends on selling price.
	 */
	public BigDecimal getCommission() {
		return price.multiply(BigDecimal.valueOf(0.05)).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + announcementId + " [" + title + ", " + description + "], data wystawienia: "
				+ dayOfStart + ", data zakończenia: " + getDayOfEnd() + ", cena: " + price + " PLN, " + seller;
	}

}
