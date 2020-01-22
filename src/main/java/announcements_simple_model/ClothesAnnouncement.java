package announcements_simple_model;

public class ClothesAnnouncement extends Announcement {
	// class representing clothes announcements

	private ClothType clothType;
	private String colour;
	private ClothesSize size;

	public ClothesAnnouncement(String title, String description, String price, Seller seller, ClothType clothType,
			ClothesSize size, String colour) {
		super(title, description, price, seller);
		this.clothType = clothType;
		this.size = size;
		this.colour = colour;
	}

	public ClothType getClothType() {
		return clothType;
	}

	public ClothesSize getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription() + ", tkanina: "
				+ clothType + ", kolor: " + colour + ", rozmiar: " + size + "], data wystawienia: " + getDayOfStart()
				+ ", data zakończenia: " + getDayOfEnd() + ", cena: " + getPrice() + " PLN, od sprzedawcy = "
				+ getSeller();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((clothType == null) ? 0 : clothType.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClothesAnnouncement other = (ClothesAnnouncement) obj;
		if (clothType != other.clothType)
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

}
