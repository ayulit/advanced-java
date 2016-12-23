package serialization.basic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
