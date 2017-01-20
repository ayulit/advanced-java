package serialization.basic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement // this class will be root
@XmlAccessorType(XmlAccessType.NONE) // do not use what hasn't annot
@XmlType(name = "dataObj") // tag dataObj will be created in xml
public class DataObject extends NonSerializable implements Serializable {
	
	@XmlElement(required=true, name="i") // will be tag with name "i"
	private int i = 5;
	@XmlElement(required=true, name="s")
	private String s = "aaa";
	 
	private transient String[] def;
	CustomObject customObject = new CustomObject(); // will be Exception w/o imp Serializible or Externializible on it
	
	@XmlAttribute // will be attribute
	private int id;
	
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
