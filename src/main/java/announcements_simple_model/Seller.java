package announcements_simple_model;

import announcements_database.DatabaseTools;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode
public class Seller {
	// class representing a user submitting the announcement

	private static int numberOfSellers = DatabaseTools.getMaxIdOfSellers();

	private int sellerId;
	private String nickname, phoneNumber, emailAddress;

	public Seller(String nickname, String phoneNumber, String emailAddress) {
		numberOfSellers++;
		this.sellerId = numberOfSellers;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "nick: " + nickname + ", dane kontaktowe: " + phoneNumber + ", " + emailAddress;
	}

}
