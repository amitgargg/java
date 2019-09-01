package serialization.model;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NonSerializeUserInheritSerializeAddress extends AddressSerializable {

	private int id;

	private String userName;

	private boolean active;

	public NonSerializeUserInheritSerializeAddress() {
		System.out.println("NonSerializeUserInheritSerializeAddress Default Constructor");
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
		return "NonSerializeUserInheritSerializeAddress [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", toString()=" + super.toString() + "]";
	}

}
