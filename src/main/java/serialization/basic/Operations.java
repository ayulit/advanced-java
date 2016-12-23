package serialization.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Operations {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		DataObject obj = new DataObject();
		obj.setMyData("haha");
	
		
		File file = new File("store.bin");
		
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream so = new ObjectOutputStream(fo);
		
		so.writeObject(obj);
		so.flush();
		so.close();
		
		System.out.println("Serialized");
		
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream si = new ObjectInputStream(fi);
		DataObject objNew = (DataObject) si.readObject();
		si.close();
		
		System.out.println(objNew);
		System.out.println(objNew.getI());
		System.out.println(objNew.getMyData()); // nothing
		System.out.println(objNew.customObject.isB());

	}

}
