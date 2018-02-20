package practice.boot.transaction;

public class Address {

	private String state;
	private String country;

	public Address(String state, String country) {
		this.state = state;
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", country=" + country + "]";
	}

}
