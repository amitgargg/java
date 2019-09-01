package serialization.model;

import java.io.Serializable;

public class SerializedUserNonSerializeAddress implements Serializable {

	private int id;

	private String userName;

	private boolean active;

	private AddressNoSerializable address;

	public SerializedUserNonSerializeAddress() {
		System.out.println("UserSerializeAddressNoSerialize: Default Constructor");
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
		this.address = new AddressNoSerializable();
		this.address.setValues();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AddressNoSerializable getAddress() {
		return address;
	}

	public void setAddress(AddressNoSerializable address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserSerializeAddressNoSerialize [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", address=" + address + "]";
	}

}
