package annotations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented 			  			// class marked by @Service will go to JavaDoc
@Inherited  			  			// all children will also be marked by @Service
@Target(ElementType.TYPE) 			// scope of usage is on classes, IFs and ENUMs
@Retention(RetentionPolicy.RUNTIME) // time of life: always
public @interface Service {

	String name(); // mandatory property of annot @Service(name="Blah")
	
	/**
	 * default - is so-called predefined word
	 * false - is value by default	
	 * */	 
	boolean lazyLoad() default false; // @Service(name="Blah" lazyLoad=true)
}
