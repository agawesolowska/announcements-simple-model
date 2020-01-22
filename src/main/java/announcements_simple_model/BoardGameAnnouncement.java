package announcements_simple_model;

public class BoardGameAnnouncement extends Announcement {
	// class representing board games announcements

	private BoardGameType type;
	private int minPlayerAge, maxPlayerAge, minNumberOfPlayers, maxNumberOfPlayers;

	public BoardGameAnnouncement(String title, String description, String price, Seller seller, BoardGameType type,
			int minPlayerAge, int maxPlayerAge, int minNumberOfPlayers, int maxNumberOfPlayers) {
		super(title, description, price, seller);
		this.type = type;
		this.minPlayerAge = minPlayerAge;
		this.maxPlayerAge = maxPlayerAge;
		this.minNumberOfPlayers = minNumberOfPlayers;
		this.maxNumberOfPlayers = maxNumberOfPlayers;
	}

	public BoardGameType getType() {
		return type;
	}

	public int getMinPlayerAge() {
		return minPlayerAge;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public int getMinNumberOfPlayers() {
		return minNumberOfPlayers;
	}

	public int getMaxNumberOfPlayers() {
		return maxNumberOfPlayers;
	}

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription()
				+ ", typ planszówki: " + type + ", wiek graczy: " + minPlayerAge + "-" + maxPlayerAge
				+ ", liczba graczy: " + minNumberOfPlayers + "-" + maxNumberOfPlayers + "], data wystawienia: "
				+ getDayOfStart() + ", data zakończenia: " + getDayOfEnd() + ", cena: " + getPrice()
				+ " PLN, od sprzedawcy = " + getSeller();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + maxNumberOfPlayers;
		result = prime * result + maxPlayerAge;
		result = prime * result + minNumberOfPlayers;
		result = prime * result + minPlayerAge;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BoardGameAnnouncement other = (BoardGameAnnouncement) obj;
		if (maxNumberOfPlayers != other.maxNumberOfPlayers)
			return false;
		if (maxPlayerAge != other.maxPlayerAge)
			return false;
		if (minNumberOfPlayers != other.minNumberOfPlayers)
			return false;
		if (minPlayerAge != other.minPlayerAge)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
