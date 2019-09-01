package serialization.model;

import java.io.Serializable;

public class SerializeUserInheritSerializeAddress extends AddressSerializable implements Serializable {

	private int id;

	private String userName;

	private boolean active;

	public SerializeUserInheritSerializeAddress() {
		System.out.println("SerializeUserInheritSerializeAddress: Default Constructor");
	}
	
	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
		super.setValues();
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

	@Override
	public String toString() {
		return "SerializeUserInheritSerializeAddress [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", toString()=" + super.toString() + "]";
	}

	
	

}
