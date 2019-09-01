package serialization.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializedUserArrayListofNonSerializedAddress implements Serializable {
	private int id;

	private String userName;

	private boolean active;

	private List<AddressNoSerializable> addresses;

	public SerializedUserArrayListofNonSerializedAddress() {
		System.out.println("SerializedUserArrayListofNonSerializedAddress: Default Constructor");
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
		AddressNoSerializable address = new AddressNoSerializable();
		address.setValues();
		addresses = new ArrayList<AddressNoSerializable>();
		addresses.add(address);
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

	public List<AddressNoSerializable> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressNoSerializable> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "SerializedUserArrayListofNonSerializedAddress [id=" + id + ", userName=" + userName + ", active="
				+ active + ", addresses=" + addresses + "]";
	}

}
