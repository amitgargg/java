package externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import externalization.model.ExternalizeUserWithExternalizeAddress;

public class ExternalizationExample {

	private static final String FILE = "C:\\Users\\egraiam\\Desktop\\externalizeObject.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExternalizeUserWithExternalizeAddress user = new ExternalizeUserWithExternalizeAddress();
		user.setValues();
		externalize(user);
		deserialize();
	}

	private static void externalize(Object object) throws IOException {
		
		System.out.println("Externalize object: "+ object);

		FileOutputStream fileOutputStream = new FileOutputStream(FILE);

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(object);
		
		objectOutputStream.close();
		fileOutputStream.close();
		
	}

	private static void deserialize() throws ClassNotFoundException, IOException {
		FileInputStream fileInputStream = new FileInputStream(FILE);
		
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Object object  = objectInputStream.readObject();
		
		System.out.println("Deserialize object: "+ object);
		
		objectInputStream.close();
		fileInputStream.close();
		
	}

}
