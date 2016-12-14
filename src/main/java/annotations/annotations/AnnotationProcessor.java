package annotations.annotations;

import java.lang.reflect.InvocationTargetException;
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
	
		initService(servicesMap.get("weaponsSystem"));
		initService(servicesMap.get("heatingSystem"));
		initService(servicesMap.get("coolingSystem"));
		
	}
	
	private static void initService(Object serviceObj) {
		if (serviceObj == null) {
			System.out.println("Service NOT found");
		} else {
			System.out.println("Service " + serviceObj.getClass().getSimpleName() + " found");
			
			for (Method method: serviceObj.getClass().getDeclaredMethods()) {
				
				if(method.isAnnotationPresent(Init.class)) {
					System.out.println("Method " + method.getName() + 
										" is annotated by @" + Init.class.getSimpleName());
					
					try {
						// TODO check lazyLoad 25:00
						method.invoke(serviceObj); // calling method
						
					} catch (Exception e) {
					
						Init ann = method.getAnnotation(Init.class);
						if(ann.suppressException()) {
							System.err.println(e.getMessage());
						} else {
							throw new RuntimeException(e);
						}
						
					}
					
				} else {
					System.out.println("Method " + method.getName() + 
							" is NOT annotated");
				}
			}
			
			
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
