package annotations.reflection;

import annotations.annotations.SimpleService;

public class NewInstanceTest {

	public static void main(String[] args) {
		
		Class<?> c;
		try {
			c = Class.forName("annotations.annotations.SimpleService");
			Object obj = c.newInstance();
			SimpleService test = (SimpleService) obj;
			System.out.println(test.getClass().getSimpleName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
