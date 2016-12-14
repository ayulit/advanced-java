package annotations.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
	
	// <name of annotation of the service, object of service>
	private static Map<String, Object> servicesMap = new HashMap<>();

	public static void main(String[] args) {
		inspectService(SimpleService.class);
		inspectService(LazyService.class);
		inspectService(String.class);
		
		// creating services dynamically by the name of the class
		loadService("annotations.annotations.SimpleService");
		loadService("annotations.annotations.LazyService");
		loadService("java.lang.String");
	
		checkObject(servicesMap.get("weaponsSystem"));
		checkObject(servicesMap.get("heatingSystem"));
		checkObject(servicesMap.get("coolingSystem"));
		
	}
	
	private static void checkObject(Object serviceObj) {
		if (serviceObj == null) {
			System.out.println("Object NOT found");
		} else {
			System.out.println("Object " + serviceObj.getClass().getSimpleName() + " found");
		}		
	}

	private static void loadService(String className) {
		try {
			// reflection
			Class<?> clazz = Class.forName(className);
						
			// if class of the service has annotation @Service
			if(clazz.isAnnotationPresent(Service.class)) {
			
				Service ann = clazz.getAnnotation(Service.class);
				
				// creating new object of service class
				Object serviceObj = clazz.newInstance();
				
				// add to map by name from annotation <name,Object>						
				servicesMap.put(ann.name(), serviceObj);		
			}
			
		} catch (ClassNotFoundException  | InstantiationException | IllegalAccessException e) {
			// Java 7 feature
			e.printStackTrace();
		}
		
		
	}

	static void inspectService(Class<?> service) {
		if(service.isAnnotationPresent(Service.class)) {
			Service ann = service.getAnnotation(Service.class);
			System.out.println(ann.name());
			
			for (Method method: service.getDeclaredMethods()) {
				if(method.isAnnotationPresent(Init.class)) {
					System.out.println("Method " + method.getName() + 
										" is annotated by @" + Init.class.getSimpleName());
				} else {
					System.out.println("Method " + method.getName() + 
							" is NOT annotated");
				}
			}			
			
		} else {
			System.out.println("Sorry! Annotation '"
		    + Service.class.getSimpleName()
		    + "' not found.");
		}
		
		System.out.println("\n");
		
	}


}
