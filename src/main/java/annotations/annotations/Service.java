package annotations.annotations;



public @interface Service {

	String name(); // mandatory property of annot @Service(name="Blah")
	
	/**
	 * default - is so-called predefined word
	 * false - is value by default	
	 * */	 
	boolean lazyLoad() default false; // @Service(name="Blah" lazyLoad=true)
}
