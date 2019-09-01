package serialization.model;

public class AddressNoSerializable {

	private int houseNo;

	private String address;

	public AddressNoSerializable() {
		System.out.println("AddressNoSerializable: Default constructor");
	}

	public void setValues() {
		this.houseNo = 193;
		this.address = "Sector 15 GGN";
	}
	
	public int getHouseNo() {
		return houseNo;
	}

	public String getAddress() {
		return address;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AddressNoSerializable [houseNo=" + houseNo + ", address=" + address + "]";
	}
	
	

}
