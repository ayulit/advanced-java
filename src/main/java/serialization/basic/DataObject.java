package serialization.basic;

import java.io.Serializable;

public class DataObject extends NonSerializable implements Serializable {
	
	private int i = 5;
	private String s = "aaa";
	private transient String[] def;
	CustomObject customObject;
	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	

}
