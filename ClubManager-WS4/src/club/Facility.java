package club;

public class Facility implements Comparable<Facility> {
	private String facilityname;
	private String description;
	
	public Facility(String facilityname, String description) {
//		super();
		this.facilityname = facilityname;
		this.description = description;
	}
	
	public Facility(String facilityname) {
		super();
		this.facilityname = facilityname;
	
	}
	

	public String getFacilityname() {
		return facilityname;
	}

	public String getDescription() {
		return description;
	}
	
	public void Show() {
		String FacilityInfo = facilityname;
		if (description != null) {
			FacilityInfo = facilityname + "-" + description;			
		}
		System.out.println(FacilityInfo);
	}
	
	// Added so that Facilities can be sorted alphabetically
	
	public int compareTo(Facility other) {
		return (getFacilityname().compareTo(other.getFacilityname()));
	}
	
}
