package announcements_simple_model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import announcements_database.DatabaseTools;

/**
 * Unit tests of class representing a simple model of announcements.
 * 
 * @author Aga
 *
 */
public class AnnouncementTest {

	private static Seller seller;
	private static Announcement announcement;

	@BeforeClass
	public static void setUpBeforeClass() {
		seller = new Seller("Rick Dalton", "365554771", "rickdalton@la.com");
		announcement = new Announcement("Rower", "Stan powypadkowy", "49.99", seller);
	}

	@Test
	public void testConstructor() {
		assertEquals(DatabaseTools.getMaxIdOfAnnouncements() + 1, announcement.getAnnouncementId());
		assertEquals("Rower", announcement.getTitle());
		assertEquals("Stan powypadkowy", announcement.getDescription());
		assertEquals(LocalDate.now(), announcement.getDayOfStart());
		assertEquals(new BigDecimal("49.99"), announcement.getPrice());
		assertEquals(seller, announcement.getSeller());
	}

	@Test
	public void testGetTimeSinceStartInDays() {
		assertEquals(0, announcement.getTimeSinceStartInDays());
	}

	@Test
	public void testGetDayOfEnd() {
		assertEquals(LocalDate.now().plusDays(14), announcement.getDayOfEnd());
	}

	@Test
	public void testGetCommission() {
		assertEquals(new BigDecimal("2.50"), announcement.getCommission());
	}

}
