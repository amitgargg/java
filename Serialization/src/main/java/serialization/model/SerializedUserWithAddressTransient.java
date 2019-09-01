package serialization.model;

import java.io.Serializable;

public class SerializedUserWithAddressTransient implements Serializable{
	private int id;

	private String userName;

	private boolean active;

	private transient AddressSerializable address;

	public SerializedUserWithAddressTransient() {
		System.out.println("SerializedUserWithAddressTransient: Default Constructor");
	}
	
	public void setValues() {
		this.id=1;
		this.userName="amitGarg";
		this.active = true;
		this.address = new AddressSerializable();
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

	public AddressSerializable getAddress() {
		return address;
	}

	public void setAddress(AddressSerializable address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SerializedUserWithAddressTransient [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", address=" + address + "]";
	}

	
	
}
