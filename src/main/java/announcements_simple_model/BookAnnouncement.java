package announcements_simple_model;

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

	public String getAuthor() {
		return author;
	}

	public BookCategory getCategory() {
		return category;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription()
				+ ", autor książki: " + author + ", gatunek: " + category + ", rok wydania: " + publicationYear
				+ "], data wystawienia: " + getDayOfStart() + ", data zakończenia: " + getDayOfEnd() + ", cena: "
				+ getPrice() + " PLN, od sprzedawcy = " + getSeller();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + publicationYear;
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
		BookAnnouncement other = (BookAnnouncement) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category != other.category)
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		return true;
	}

}
