package logic;

public class Station {
	private String name;
	private int number;
	
	public Station(String name, int number) {
		this.name = name;
		if (number >= 0) {
			this.number = number;
		} else {
			this.number = 0;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if (number < 0) {
			this.number = 0;
		} else {
			this.number = number;
		}
	}

}
