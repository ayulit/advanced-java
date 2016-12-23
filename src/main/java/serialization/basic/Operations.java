package serialization.basic;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Operations {

	public static void main(String[] args) throws IOException {
		
		DataObject obj = new DataObject();
		obj.setMyData("haha");
	
		
		File file = new File("store.bin");
		
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutputStream so = new ObjectOutputStream(fo);
		
		so.writeObject(obj);
		so.flush();
		so.close();
		
		System.out.println("Serialized");

	}

}