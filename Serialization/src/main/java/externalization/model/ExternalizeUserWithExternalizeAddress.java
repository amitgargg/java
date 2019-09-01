package externalization.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import serialization.model.AddressSerializable;

public class ExternalizeUserWithExternalizeAddress implements Externalizable {
	private int id;

	private String userName;

	private boolean active;

	private ExternalizeAddress address;

	public ExternalizeUserWithExternalizeAddress() {
		System.out.println("ExternalizeUserWithExternalizeAddress: Default Constructor");
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
		this.address = new ExternalizeAddress();
		this.address.setValues();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeUTF(userName);
		out.writeBoolean(active);
		out.writeObject(address);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.id = in.readInt();
		this.userName = in.readUTF();
		this.active = in.readBoolean();
		this.address = (ExternalizeAddress) in.readObject();
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
		return "ExternalizeUserWithExternalizeAddress [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", address=" + address + ", toString()=" + super.toString() + "]";
	}

	

}
