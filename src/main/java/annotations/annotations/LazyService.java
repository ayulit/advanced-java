package annotations.annotations;

@Service(name = "heatingSystem")
public class LazyService {
	@Init
	public void lazyInit() throws Exception {
		System.out.println("Heating system activated.");
	}

}
