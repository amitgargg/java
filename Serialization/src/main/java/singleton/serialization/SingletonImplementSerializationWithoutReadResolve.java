package singleton.serialization;

import java.io.Serializable;

public class SingletonImplementSerializationWithoutReadResolve implements Serializable {

	private static Object lock = new Object();

	private static SingletonImplementSerializationWithoutReadResolve instance;

	private SingletonImplementSerializationWithoutReadResolve() {
	}

	public static SingletonImplementSerializationWithoutReadResolve getInstance() {
		if (instance != null) {
			return instance;
		}

		synchronized (lock) {
			if (instance == null) {
				instance = new SingletonImplementSerializationWithoutReadResolve();
			}
			return instance;
		}
	}

}
