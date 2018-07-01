package club;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Club {

	
	
	private ArrayList<Member> members;
	private HashMap<String, Facility> facilities;
	
	public Club() {
		members = new ArrayList<Member>();
		facilities = new HashMap<String, Facility>();
	}
	
	public Member addMember (String surname, String firstName, String secondName) {
		
		Member m = new Member(members.size() +1,firstName, surname,secondName);
		
		members.add(m);
		return m;
	}
	
	public List<Member> getMembers(){
		ArrayList<Member> result;
		result = new ArrayList<Member>(members);
		Collections.sort(result);
		return (result);
	}
	
	public Member getMember(int numMembers) {
		Iterator<Member> i = members.iterator();
		while (i.hasNext()) {
			Member m = i.next();
			if (m.getMemberNumber() == numMembers) {
				return m;
			}
		}
		return null;
	}
	
	public void removeMember(int memberNum) {
		Member m = getMember(memberNum);
		if (m != null) {
			members.remove(m);
		}
	}
	
	public void showMembers() {
		Iterator<Member> i = members.iterator();
		while(i.hasNext()) {
			i.next().showinfo();
		}
	}
	
	public Facility getFacility(String name) {
		return facilities.get(name);
	}
	
	public List<Facility> getFacilities(){
		ArrayList<Facility> result;
		result = new ArrayList<Facility>(facilities.values());
		Collections.sort(result);
		return(result);
	}
	
	public void addFacility(String name, String description) {
		if (name == null) {
			return;
		}
		Facility f = new Facility(name,description);
		facilities.put(name, f);
	}
	
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	
	public void showFacilities() {
		Iterator<Facility> i = getFacilities().iterator();
		while (i.hasNext()) {
			i.next().Show();		
		}
	}
	
	public void show() {
		System.out.println("Current Members:");
		showMembers();
		System.out.println();
		System.out.println("Facilitires:");
		showFacilities();
	}

}
