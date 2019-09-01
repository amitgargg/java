package serialization.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeUserWithReadAndWriteObjectAddressSerialize implements Serializable{

	private int id;

	private String userName;

	private boolean active;
	
	private AddressSerializable address;

	public SerializeUserWithReadAndWriteObjectAddressSerialize() {
		System.out.println("SerializeUserWithReadAndWriteObjectAddressSerialize Default Constructor");
	}

	private void writeObject(ObjectOutputStream os) throws IOException {
		os.writeInt(id);
		os.writeUTF(userName);
		os.writeBoolean(active);
		os.writeObject(address);
	}

	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		this.id = is.readInt();
		this.userName = is.readUTF();
		this.active = is.readBoolean();
		this.address = (AddressSerializable) is.readObject();
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
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

	@Override
	public String toString() {
		return "SerializeUserWithReadAndWriteObjectAddressSerialize [id=" + id + ", userName=" + userName + ", active=" + active
				+ ", address=" + address + "]";
	}

	

}
