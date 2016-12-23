package serialization.basic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataObject extends NonSerializable implements Serializable {
	
	private int i = 5;
	private String s = "aaa";
	private transient String[] def;
	CustomObject customObject = new CustomObject(); // will be Exception w/o imp Serializible or Externializible on it
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();     // standart serialization
		out.writeObject(getMyData()); // serialization of NonSerializable
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// visa-versa
		
		in.defaultReadObject(); // standart deserialization
		
		String myData = (String) in.readObject();
		
		setMyData(myData);
		
	}
	
	

}
