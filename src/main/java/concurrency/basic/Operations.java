package concurrency.basic;

public class Operations {

	public static void main(String[] args) throws InsufficentFundsException, InterruptedException {
		
		final Account vasya   = new Account(1000);
		final Account george  = new Account(2000);
		
		new Thread(new Runnable() {
						public void run() {
							try {
								
								transfer(vasya, george, 500);
								
							} catch (InsufficentFundsException | InterruptedException e) {
								e.printStackTrace();
							} 
						 }  
						}).start();
		
		transfer(george, vasya, 200);
		
		System.out.println("vasya="  +  vasya.getBalace());
		System.out.println("george=" + george.getBalace());
	}

	private static void transfer(Account acc1, Account acc2, int amount) throws InsufficentFundsException, InterruptedException {
		
		if(acc1.getBalace() < amount) {
			throw new InsufficentFundsException();
		}
		
		// doing thread-safety
		synchronized (acc1) {
			
			System.out.println("acc1 locked");
			Thread.sleep(1000); // doing deadlock
			
			synchronized (acc2) {
				
				System.out.println("acc2 locked");
				
				acc1.withdraw(amount);
				acc2.deposit(amount);
			
			}
			
		}
		
		
		System.out.println("Transfer successful.");
				
	}

}
