package announcements_simple_model;

import announcements_database.DatabaseTools;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Class representing a user submitting the announcement.
 * 
 * @author Aga
 *
 */
@Getter
@EqualsAndHashCode
public class Seller {

	/**
	 * Static variable helpful in creating a new object.
	 * 
	 * @see Class 'DatabaseTools' in package announcements_database.
	 */
	private static int numberOfSellers = DatabaseTools.getMaxIdOfSellers();

	private int sellerId;
	private String nickname, phoneNumber, emailAddress;

	/**
	 * This constructor creates an object based on parameters given by user.
	 */
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
