package announcements_simple_model;

import announcements_database.DatabaseTools;

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

	public int getSellerId() {
		return sellerId;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "nick: " + nickname + ", dane kontaktowe: " + phoneNumber + ", " + emailAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + sellerId;
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
		Seller other = (Seller) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (sellerId != other.sellerId)
			return false;
		return true;
	}

}
