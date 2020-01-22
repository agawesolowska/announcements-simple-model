package announcements_simple_model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import announcements_database.DatabaseTools;

public class Announcement {
	// class representing a simple model of announcements

	private static int numberOfAnnouncements = DatabaseTools.getMaxIdOfAnnouncements();

	private int announcementId;
	private String title, description;
	private LocalDate dayOfStart;
	private BigDecimal price;
	private Seller seller;

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

	public int getTimeSinceStartInDays() {
		return Period.between(dayOfStart, LocalDate.now()).getDays();
	}

	public LocalDate getDayOfEnd() {
		return dayOfStart.plusDays(14);
	}

	public BigDecimal getCommission() {
		return price.multiply(BigDecimal.valueOf(0.05)).setScale(2, RoundingMode.HALF_UP);
	}

	public int getAnnouncementId() {
		return announcementId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDayOfStart() {
		return dayOfStart;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Seller getSeller() {
		return seller;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + announcementId + " [" + title + ", " + description + "], data wystawienia: "
				+ dayOfStart + ", data zakończenia: " + getDayOfEnd() + ", cena: " + price + " PLN, " + seller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayOfStart == null) ? 0 : dayOfStart.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + announcementId;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Announcement other = (Announcement) obj;
		if (dayOfStart == null) {
			if (other.dayOfStart != null)
				return false;
		} else if (!dayOfStart.equals(other.dayOfStart))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (announcementId != other.announcementId)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
