package annotations.annotations;

@Service(name = "weaponsSystem")
public class SimpleService {
	@Init
	public void initService(){
		System.out.println("Weapons system activated.");
	}
	
	public void fire(){
		System.out.println("Fire!");
	}
}
