package hidden_specs_assignment;

public class Student {
	private int roll_number;
	private String name;
	private String address;
	
	Student (int roll_number, String name, String address) {
		this.roll_number = roll_number;
		this.name = name;
		this.address = address;
	}
	
	int getRollno () {
		return roll_number;
	}
	
	@Override
	public String toString() {
		return String.format("%-22d%-22s%-22s", this.roll_number, this.name, this.address);
	}
}
