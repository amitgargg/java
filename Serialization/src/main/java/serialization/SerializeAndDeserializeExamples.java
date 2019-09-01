package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import serialization.model.CompleteUserSerializable;
import serialization.model.NonSerializeUserInheritSerializeAddress;
import serialization.model.NonSerializeUserThrowNotSerializableExceptionInheritSerializeAddress;
import serialization.model.SerializeUserInheritNotSerializeAddress;
import serialization.model.SerializeUserInheritSerializeAddress;
import serialization.model.SerializeUserWithReadAndWriteObjectAddressNotSerialize;
import serialization.model.SerializeUserWithReadAndWriteObjectAddressSerialize;
import serialization.model.SerializedUserArrayListofNonSerializedAddress;
import serialization.model.SerializedUserNonSerializeAddress;
import serialization.model.SerializedUserWithAddressTransient;
import serialization.model.SerializedUserWithoutAddress;
import serialization.model.SerializedUserWithoutAddressAddSerialVersionUID;
import singleton.serialization.SingletonImplementSerializationWithReadResolve;
import singleton.serialization.SingletonImplementSerializationWithReadResolveAndReadObject;
import singleton.serialization.SingletonImplementSerializationWithoutReadResolve;

public class SerializeAndDeserializeExamples {

	private static final String FILE = "C:\\Users\\egraiam\\Desktop\\serializeObject.txt";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		user_and_address_impl_serialize_NoError();
//		user_and_address_impl_deserialize_NoError();
//		
//		user_serialize_address_notSerialize_association_NotSerializableException();
//		
//		user_serialize_address_trainsent_serialization_NoError();
//		user_serialize_address_trainsent_deserialization_addess_null_NoError();
//		
//		serialize_user_inherit_serialize_address_serialization_NoError();
//		serialize_user_inherit_serialize_address_deserialization_success();
//		
//		serialize_user_inherit_non_serialize_address_serialization_NoError();
//		serialize_user_inherit_non_serialize_address_deserialization_super_class_default_construtor_called();
//
//		non_serialize_user_inherit_serialize_address_serialization_NoError();
//		non_serialize_user_inherit_serialize_address_deserialization_NoError();
//		
//		non_serialize_user_throw_NotSerializableException_inherit_serialize_address_serialization_Exception();
		
		
//		serialize_user_with_readObject_and_writeObject_serialize_address_custom_serializa_NoError();
//		serialize_user_with_readObject_and_writeObject_serialize_address_custom_deserializa_NoError();
		
//		serialize_user_with_readObject_and_writeObject_non_serialize_address_custom_serialization_NoError();
//		serialize_user_with_readObject_and_writeObject_non_serialize_address_custom_deserialization_NoError();
		
//		serialized_user_without_serialVersionUID_without_address_serialization_noError();
		// Add new Fields or Delete any field 		private String newField;
//		serialized_user_without_serialVersionUID_without_address_added_newField_deserialization_InvalidClassException();
		//Delete newly Added field
		
		
//		serialized_user_with_serialVersionUID_without_address_serialization_noError();
		// Add new Fields or Delete any field   	private String newField;
//		serialized_user_without_serialVersionUID_without_address_added_newField_deserialization_InvalidClassException();
		//Delete newly Added field
		
		
//		serialized_user_arrayListof_non_serialized_address_serialization();
		
//		serialized_singleton_implement_serializable_readResolve_not_defined_success();
//		serialized_singleton_implement_serializable_readResolve_not_defined_deserialize_return_duplicate_object_singleton_break();
		
//		serialized_singleton_defined_readResolve_success();
//		serialized_singleton_defined_readResolve_deserialize_return_same_object_lastest_value_of_userName_singleton_success();
		
		serialized_singleton_defined_readResolve_and_readObject_success();
		serialized_singleton_defined_readResolve_and_writeObject_deserialize_return_same_object_serialized_value_of_userName_singleton_success();
	}
	
	
	private static void serialized_singleton_defined_readResolve_and_readObject_success() throws IOException {
		SingletonImplementSerializationWithReadResolveAndReadObject obj = SingletonImplementSerializationWithReadResolveAndReadObject.getInstance();
		serialize(obj);
		System.out.println("serialized Hash Code:" + obj.hashCode());
		obj.setUserName("SUMIT");
	}
	
	private static void serialized_singleton_defined_readResolve_and_writeObject_deserialize_return_same_object_serialized_value_of_userName_singleton_success() throws IOException, ClassNotFoundException {
		Object obj = deserialize();
		System.out.println("Deserialized Hash Code:" + obj.hashCode());
	}
	

	private static void serialized_singleton_defined_readResolve_success() throws IOException {
		SingletonImplementSerializationWithReadResolve obj = SingletonImplementSerializationWithReadResolve.getInstance();
		serialize(obj);
		System.out.println("serialized Hash Code:" + obj.hashCode());
		obj.setUserName("SUMIT");
	}
	
	private static void serialized_singleton_defined_readResolve_deserialize_return_same_object_lastest_value_of_userName_singleton_success() throws IOException, ClassNotFoundException {
		Object obj = deserialize();
		System.out.println("Deserialized Hash Code:" + obj.hashCode());
	}
	
	
	private static void serialized_singleton_readResolve_not_defined_success() throws IOException {
		SingletonImplementSerializationWithoutReadResolve obj = SingletonImplementSerializationWithoutReadResolve.getInstance();
		serialize(obj);
		System.out.println("serialized Hash Code:" + obj.hashCode());
	}
	
	private static void serialized_singleton_readResolve_not_defined_deserialize_return_duplicate_object_singleton_break() throws IOException, ClassNotFoundException {
		Object obj = deserialize();
		System.out.println("Deserialized Hash Code:" + obj.hashCode());
	}
	
	
	private static void serialized_user_arrayListof_non_serialized_address_serialization() throws IOException {
		SerializedUserArrayListofNonSerializedAddress user = new SerializedUserArrayListofNonSerializedAddress();
		user.setValues();
		serialize(user);
	}
	
	private static void serialized_user_with_serialVersionUID_without_address_serialization_noError() throws IOException {
		SerializedUserWithoutAddressAddSerialVersionUID user = new SerializedUserWithoutAddressAddSerialVersionUID();
		user.setValues();
		serialize(user);
	}

	private static void serialized_user_with_serialVersionUID_without_address_added_newField_deserialization_noError() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	private static void serialized_user_without_serialVersionUID_without_address_serialization_noError() throws IOException {
		SerializedUserWithoutAddress user = new SerializedUserWithoutAddress();
		user.setValues();
		serialize(user);
	}

	private static void serialized_user_without_serialVersionUID_without_address_added_newField_deserialization_InvalidClassException() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	private static void serialize_user_with_readObject_and_writeObject_non_serialize_address_custom_serialization_NoError() throws IOException {
		SerializeUserWithReadAndWriteObjectAddressNotSerialize user = new SerializeUserWithReadAndWriteObjectAddressNotSerialize();
		user.setValues();
		serialize(user);
	}
	
	private static void serialize_user_with_readObject_and_writeObject_non_serialize_address_custom_deserialization_NoError() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	private static void serialize_user_with_readObject_and_writeObject_serialize_address_custom_serialization_NoError() throws IOException {
		SerializeUserWithReadAndWriteObjectAddressSerialize user = new SerializeUserWithReadAndWriteObjectAddressSerialize();
		user.setValues();
		serialize(user);
	}
	
	private static void serialize_user_with_readObject_and_writeObject_serialize_address_custom_deserialization_NoError() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	private static void non_serialize_user_throw_NotSerializableException_inherit_serialize_address_serialization_Exception() throws IOException {
		NonSerializeUserThrowNotSerializableExceptionInheritSerializeAddress user = new NonSerializeUserThrowNotSerializableExceptionInheritSerializeAddress();
		user.setValues();
		serialize(user);
	}
	
	private static void non_serialize_user_inherit_serialize_address_serialization_NoError() throws IOException {
		NonSerializeUserInheritSerializeAddress user = new NonSerializeUserInheritSerializeAddress();
		user.setValues();
		serialize(user);
	}
	
	private static void non_serialize_user_inherit_serialize_address_deserialization_NoError() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	
	private static void serialize_user_inherit_non_serialize_address_serialization_NoError() throws IOException {
		SerializeUserInheritNotSerializeAddress user = new SerializeUserInheritNotSerializeAddress();
		user.setValues();
		serialize(user);
	}
	
	private static void serialize_user_inherit_non_serialize_address_deserialization_super_class_default_construtor_called() throws ClassNotFoundException, IOException {
		deserialize();
	}
	
	private static void serialize_user_inherit_serialize_address_serialization_NoError() throws IOException {
		SerializeUserInheritSerializeAddress user = new SerializeUserInheritSerializeAddress();
		user.setValues();
		serialize(user);
	}
	
	private static void serialize_user_inherit_serialize_address_deserialization_success() throws ClassNotFoundException, IOException {
		deserialize();
	}
	
	
	private static void user_serialize_address_trainsent_serialization_NoError() throws IOException {
		SerializedUserWithAddressTransient user = new SerializedUserWithAddressTransient();
		user.setValues();
		serialize(user);
	}
	
	private static void user_serialize_address_trainsent_deserialization_addess_null_NoError() throws IOException, ClassNotFoundException {
		deserialize();
	}

	private static void user_serialize_address_notSerialize_association_NotSerializableException() throws IOException {
		SerializedUserNonSerializeAddress user = new SerializedUserNonSerializeAddress();
		user.setValues();
		serialize(user);
	}
	

	private static void user_and_address_impl_serialize_NoError() throws IOException {
		CompleteUserSerializable user = new CompleteUserSerializable();
		user.setValues();
		serialize(user);
	}

	private static void user_and_address_impl_deserialize_NoError() throws IOException, ClassNotFoundException {
		deserialize();
	}
	
	private static void serialize(Object object) throws IOException {
		System.out.println("========Serialization Start ==========");
		
		System.out.println("Serialize Object: "+ object);
		
		FileOutputStream fileOutputStream = new FileOutputStream(FILE);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(object);
		objectOutputStream.close();
		
		System.out.println("========Serialization Done ==========");
	}
	
	private static Object deserialize() throws IOException, ClassNotFoundException {
		System.out.println("========Deserialization Start ========");
		
		FileInputStream fileInputStream = new FileInputStream(FILE);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();

		System.out.println("deserialize Object: "+ object);
		
		System.out.println("========Deserialization Done ========");
		return object;
	}
}
