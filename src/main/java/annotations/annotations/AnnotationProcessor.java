package annotations.annotations;

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
		} else {
			System.out.println("Sorry! Annotation '"
		    + Service.class.getSimpleName()
		    + "' not found.");
		}
		
	}

}