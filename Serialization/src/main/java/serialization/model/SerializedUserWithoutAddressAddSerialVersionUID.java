package serialization.model;

import java.io.Serializable;

public class SerializedUserWithoutAddressAddSerialVersionUID implements Serializable {

	private static final long serialVersionUID = -7179226809880851908L;

	private int id;

	private String userName;

	private boolean active;
	
	private String newField;
	
	public SerializedUserWithoutAddressAddSerialVersionUID() {
		System.out.println("SerializedUserWithoutAddressAddSerialVersionUID: Default Constructor");
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
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
		return "SerializedUserWithoutAddress [id=" + id + ", userName=" + userName + ", active=" + active + "]";
	}

}
