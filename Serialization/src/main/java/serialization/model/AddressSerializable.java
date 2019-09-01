package serialization.model;

import java.io.Serializable;

public class AddressSerializable implements Serializable {

	private int houseNo;

	private String address;

	public AddressSerializable() {
		System.out.println("AddressSerializable: Default constructor");
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
		return "AddressSerializable [houseNo=" + houseNo + ", address=" + address + "]";
	}

	

}
