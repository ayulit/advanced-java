package annotations.reflection;



import annotations.annotations.SimpleService;


/**
 * Playing with reflections
 *   
 * */
public class ReflectionsTest {

	public static void main(String[] args) {
		
		SimpleService weaponsSystem = new SimpleService();
		
		Class<SimpleService> aclass = (Class<SimpleService>) weaponsSystem.getClass();
		System.out.println(aclass.getSimpleName());
		
		aclass = SimpleService.class;
		System.out.println(aclass.getSimpleName());
		
		// Spring works like this
		try {
			Class<?> c = Class.forName("annotations.reflection.AmmoLoaderService");
			System.out.println(c.getSimpleName());
			System.out.println(c.getSuperclass());
			
			for (Class<?> object: c.getInterfaces()) {
				System.out.println(object.getName());
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		

		
	}

}
