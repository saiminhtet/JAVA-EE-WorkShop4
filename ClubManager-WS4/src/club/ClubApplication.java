package club;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClubApplication {
	public static void main(String[] args) {
		Person p1 = new Person("Alice", "May");
		Person p2 = new Person("Sai", "Min", "Htet");

		p1.Show();
		p2.Show();

		Facility f1 = new Facility("funtion rooms");
		Facility f2 = new Facility("conference rooms", "for meeting purpose");

		f1.Show();
		f2.Show();

		Person p3 = new Member(2211, "Min", "Sai", "Thet");
		System.out.println(p3.showinfo());

		Person p4 = new Member(2233, "Shenqi", "Tang");
		System.out.println(p4.showinfo());

		Person p5 = new Member(1122, "Happy", "Flying", "Sheep");
		System.out.println(p5.showinfo());

		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}

		
		Club club = new Club();
		
		Member member1,member2,member3,member4,member5;
		
		member1 = club.addMember("Min", "Sai", "Thet");
		member2 = club.addMember("Gao", "Yang", "Yang");
		member3 = club.addMember("Han", "Myint", "Tun");
		member4 = club.addMember("Aung", "Myo", null);
		member5 = club.addMember("Zin", "Min", "Htet");
		
		
		//Member Addition Testing
		System.out.println("Member Addition Testing");
		
		System.out.println("Current Members:");
		club.showMembers();
		
		System.out.println("Deleting " + member3);
		int id = member3.getMemberNumber();
		club.removeMember(id);
		
		System.out.println("Current Members:");
		club.showMembers();
		
		
		//Facility Testing
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
        System.out.println("Facility Testing");
		 
		club.addFacility("Lab", "Einstein's Experiment Area");
		club.addFacility("Studio", "Picasso's Work Place");
		club.addFacility("Room1", "Conference Room on Level 2");
		club.addFacility("Room2", "Meeting Room on Level 3");
		club.showFacilities();
		
		//Test Booking Class
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
        System.out.println("Booking Testing");
		System.out.println();
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("d-MMM-yyyy H:mm");
		
		try {
			Booking booking1 = new Booking(member1, club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
			booking1.show();
		}catch(Exception e) {
			System.out.println("Booking class error: " + e.getMessage());
		}
		
		//Test BadBookingException
		try {
			Booking booking2 = new Booking(member1, club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 15:00", df), LocalDateTime.parse("1-Aug-2007 14:00", df));
			booking2.show();
		}catch(BadBookingException be) {
			System.out.println("Bad Booking Exeption: " + be.getMessage());
		}
		
		//Test BookingRegister
		try {
			BookingRegister register = new BookingRegister();
			System.out.println("Adding bookings for Room1 2-Aug-2007 9:00 to 12:00");
			
			register.addBooking(member1, club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
			System.out.println("Attempting to add bookings for Room1");
			
			register.addBooking(member2, club.getFacility("Room1"), LocalDateTime.parse("1-Aug-2007 09:00", df), LocalDateTime.parse("1-Aug-2007 12:00", df));
			System.out.println("Attempting to add bookings for Room1");
		
		} catch (BadBookingException be) {
			System.out.println("Booking Error: " + be.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Booking class error: " + e.getMessage());
		}
	}
}
