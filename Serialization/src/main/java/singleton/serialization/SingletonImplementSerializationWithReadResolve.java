package singleton.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingletonImplementSerializationWithReadResolve implements Serializable {

	private static Object lock = new Object();

	private static SingletonImplementSerializationWithReadResolve instance;

	private String userName = null;

	private SingletonImplementSerializationWithReadResolve() {
		this.userName = "Default User";
	}

	public static SingletonImplementSerializationWithReadResolve getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (lock) {
			if (instance == null) {
				instance = new SingletonImplementSerializationWithReadResolve();
			}
			return instance;
		}
	}

	private Object readResolve() {
		System.out.println("Inside ReadResolve");
		return instance;
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
