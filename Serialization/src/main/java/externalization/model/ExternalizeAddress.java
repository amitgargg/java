package externalization.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizeAddress implements Externalizable {

	private int houseNo;

	private String address;

	public ExternalizeAddress() {
		System.out.println("ExternalizeAddress: Default constructor");
	}

	public void setValues() {
		this.houseNo = 193;
		this.address = "Sector 15 GGN";
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(address);
		out.writeInt(houseNo);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.address = in.readUTF();
		this.houseNo = in.readInt();

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
		return "ExternalizeAddress [houseNo=" + houseNo + ", address=" + address + "]";
	}

}
