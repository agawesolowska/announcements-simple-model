package announcements_simple_model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode(callSuper=true)
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

	@Override
	public String toString() {
		return "Ogłoszenie nr: " + getAnnouncementId() + " [" + getTitle() + ", " + getDescription()
				+ ", typ planszówki: " + type + ", wiek graczy: " + minPlayerAge + "-" + maxPlayerAge
				+ ", liczba graczy: " + minNumberOfPlayers + "-" + maxNumberOfPlayers + "], data wystawienia: "
				+ getDayOfStart() + ", data zakończenia: " + getDayOfEnd() + ", cena: " + getPrice()
				+ " PLN, od sprzedawcy = " + getSeller();
	}

}
