package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		if (type == 0) { //Student
			this.type = 0;
			this.priceperstation = 30;
		} else if (type == 1) { //Adult
			this.type = 1;
			this.priceperstation = 30;
		} else if (type == 2) { //Elderly
			this.type = 2;
			this.priceperstation = 25;
		} else {
			this.type = 1;
			this.priceperstation = 30;
		}	
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		int distance = getStationDistance(start, end);

		
		if (!isStationValid(start, end)) {
			System.out.println("B1");
			return -1;
		}
		
		if (type == 0) { //Student
			System.out.println("B2");
			if (distance > 4) {
				return priceperstation*distance*0.8;
			}
			return priceperstation*distance;
		} else if (type == 1) { //Adult
			System.out.println("B3");
			return priceperstation*distance;
		} else if (type == 2) { //Elderly
			System.out.println("B4");
			return priceperstation*distance*0.6;
		} else {
			System.out.println("B5");
			return -1;
		}
		
	}
	
	public String getDescription() {
		String typename;


		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			typename = "Elderly";
			if (getStationDistance(start,end) > 6) {
				typename = "Invalid";
			}
			break;
		default:
			typename = "Invalid";
		}
		return typename+" Ticket, from "+ getStart().getName() +" to "+ getEnd().getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		
		// Elderly more than 6 stations
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}
		
		// Same start & end
		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
