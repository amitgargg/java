package singleton.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingletonImplementSerializationWithReadResolveAndReadObject implements Serializable {

	private static Object lock = new Object();

	private static SingletonImplementSerializationWithReadResolveAndReadObject instance;

	private String userName = null;

	private SingletonImplementSerializationWithReadResolveAndReadObject() {
		this.userName = "Default User";
	}

	public static SingletonImplementSerializationWithReadResolveAndReadObject getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (lock) {
			if (instance == null) {
				instance = new SingletonImplementSerializationWithReadResolveAndReadObject();
			}
			return instance;
		}
	}

	private Object readResolve() {
		System.out.println("Inside ReadResolve");
		return instance;
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		System.out.println("Inside ReadObject");
		ois.defaultReadObject();
		synchronized (lock) {
			instance = this;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "SingletonImplementSerializationWithReadResolve [userName=" + userName + "]";
	}

}
