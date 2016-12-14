package concurrency.basic;

public class Operations {

	public static void main(String[] args) throws InsufficentFundsException {
		
		final Account vasya   = new Account(1000);
		final Account george  = new Account(2000);
		
		new Thread(new Runnable() {
						public void run() {
							try {
								
								transfer(vasya, george, 500);
								
							} catch (InsufficentFundsException e) {
								e.printStackTrace();
							} 
						 }  
						}).start();
		
		transfer(george, vasya, 200);
		
		System.out.println("vasya="  +  vasya.getBalace());
		System.out.println("george=" + george.getBalace());
	}

	private static void transfer(Account acc1, Account acc2, int amount) throws InsufficentFundsException {
		
		if(acc1.getBalace() < amount) {
			throw new InsufficentFundsException();
		}
		
		// doing thread-safety
		synchronized (acc1) {
			synchronized (acc2) {

				acc1.withdraw(amount);
				acc2.deposit(amount);
			
			}
			
		}
		
		
		System.out.println("Transfer successful.");
				
	}

}
