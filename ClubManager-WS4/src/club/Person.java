package club;

public class Person {
	private String firstName;
	private String surName;
	private String secoundName;

	public Person(String firstName, String surName, String secoundName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.surName = surName;
		this.secoundName = secoundName;
	}

	public Person(String firstName, String surName) {
		super();
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.surName = surName;
		this.secoundName = null;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setSecoundName(String secoundName) {
		this.secoundName = secoundName;
	}

	public void Show() {
		String fullname = firstName;
		if (secoundName != null) {
			fullname = fullname + " " + secoundName;
		}
		fullname = fullname + " " + surName;
		System.out.println("Full name: " + fullname);
	}
	
	//For WS 3
	public String toString() {
		String fullname = firstName;
		if (secoundName != null) {
			fullname = fullname + " " + secoundName;
		}
		fullname = fullname + " " + surName;
		return fullname;
		//System.out.println("Full name: " + fullname);
	}
	
	public String showinfo() {
		return this.toString() + "(Parent)";
	}

}
