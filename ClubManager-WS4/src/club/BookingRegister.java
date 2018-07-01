package club;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BookingRegister {

	private HashMap<Facility, ArrayList<Booking>> bookings;

	public BookingRegister() {
		bookings = new HashMap<Facility, ArrayList<Booking>>();
	}

	public void addBooking(Member member, Facility facility, LocalDateTime startDate, LocalDateTime endDate)
			throws BadBookingException {
		Booking b = new Booking(member, facility, startDate, endDate);
		ArrayList<Booking> bookingList = bookings.get(facility); // get facility from the HashMap

		if (bookingList == null) {
			bookingList = new ArrayList<Booking>();
			bookings.put(facility, bookingList); // a new empty ArrayList object must be created, and put into the
													// table, using the Facility object as the key
		} else {
			Iterator<Booking> i = bookingList.iterator();
			while (i.hasNext()) {
				Booking other = i.next();
				if (b.overlaps(other)) {
					throw new BadBookingException("New booking overlaps with existing one"); // existing Booking objects
																								// in the ArrayList, if
																								// there is an overlap,

					// the addBooking() must throw a BadBooking Exception
				}
			}
		}
		bookingList.add(b);

	}

	public void removeBooking(Booking booking) {
		ArrayList<Booking> bookingList = bookings.get(booking.getFacility());
		if (bookingList != null) {
			bookingList.remove(booking);
		}
	}

	public ArrayList<Booking> getBookings(Facility facility, LocalDateTime startDate, LocalDateTime endDate) {
		ArrayList<Booking> selected = new ArrayList<Booking>();
		ArrayList<Booking> bookingList = bookings.get(facility);

		if (bookingList != null) {
			Iterator<Booking> i = bookingList.iterator();
			while (i.hasNext()) {
				Booking b = i.next();
				boolean earlier = startDate.isAfter(b.getEndDate());
				boolean later = endDate.isBefore(b.getStartDate());
				if (!(earlier || later)) {
					selected.add(b);
				}
			}
		}
		return selected;
	}

}
