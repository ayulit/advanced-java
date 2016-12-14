package annotations.annotations;

import java.lang.reflect.Method;

public class AnnotationProcessor {

	public static void main(String[] args) {
		inspectService(SimpleService.class);
		inspectService(LazyService.class);
		inspectService(String.class);
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
