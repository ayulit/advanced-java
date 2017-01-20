package serialization.basic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataObj") // tag dataObj will be created in xml
public class CustomObject implements Externalizable {
	
	private transient boolean b = true;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeBoolean(b);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		boolean b = in.readBoolean();
		setB(b);
		
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

}
