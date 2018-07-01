package club;

public class Member extends Person implements Comparable<Member>{
		int memberNumber;

		public Member(int memberNo, String firstName, String surName, String secoundName) {
			super(firstName, surName, secoundName);
			// TODO Auto-generated constructor stub
			memberNumber = memberNo;
		}

		public Member(int memberNo, String firstName, String surName) {
			super(firstName, surName);
			// TODO Auto-generated constructor stub
			memberNumber = memberNo;
		}

		public int getMemberNumber() {
			return memberNumber;
		}

		public void setMemberNumber(int memberNumber) {
			this.memberNumber = memberNumber;
		}
		
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString() + memberNumber + "(Child)";
		}
		
		public String showinfo() {
			return super.toString() + memberNumber + "(ShowChild)";
		}
	
		// Added so that Members can be sorted by membership member
		public int compareTo (Member other) {
			return (getMemberNumber() - other.getMemberNumber());
		}

}
