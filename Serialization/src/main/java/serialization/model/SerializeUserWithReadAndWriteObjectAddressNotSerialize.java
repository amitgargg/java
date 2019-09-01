package serialization.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeUserWithReadAndWriteObjectAddressNotSerialize implements Serializable {

	private int id;

	private String userName;

	private boolean active;

	private AddressNoSerializable address;

	public SerializeUserWithReadAndWriteObjectAddressNotSerialize() {
		System.out.println("SerializeUserWithReadAndWriteObjectAddressNotSerialize Default Constructor");
	}

	private void writeObject(ObjectOutputStream os) throws IOException {
		os.writeInt(id);
		os.writeUTF(userName);
		os.writeBoolean(active);
	}

	private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
		this.id = is.readInt();
		this.userName = is.readUTF();
		this.active = is.readBoolean();
	}

	public void setValues() {
		this.id = 1;
		this.userName = "amitGarg";
		this.active = true;
		this.address = new AddressNoSerializable();
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
		return "SerializeUserWithReadAndWriteObjectAddressNotSerialize [id=" + id + ", userName=" + userName
				+ ", active=" + active + ", address=" + address + "]";
	}

}
