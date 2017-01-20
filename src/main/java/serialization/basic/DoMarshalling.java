package serialization.basic;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class DoMarshalling {
	
	// package which contains root element
	static final String PACKAGE = DataObject.class.getPackage().getName();

	public static void main(String[] args) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(PACKAGE);

		Marshaller m = jc.createMarshaller();      // for write
		Unmarshaller um = jc.createUnmarshaller(); // for read

		DataObject dataObj = new DataObject();
		dataObj.setMyData("haha");
		File file = new File("store.xml");

		m.marshal(dataObj, file);
		System.out.println("Marshalled");

		DataObject obj = (DataObject) um.unmarshal(file);
		
		System.out.println(obj);
		System.out.println(obj.getI());
		System.out.println(obj.getMyData());
		System.out.println(obj.customObject.isB());
				
	}

}
