package concurrency.basic;

import java.util.concurrent.TimeUnit;

public class Operations {
	
	final static int WAIT_MSEC = 1500;

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
		if(acc1.getLock().tryLock(WAIT_MSEC, TimeUnit.MILLISECONDS)) {
			try {
				if(acc2.getLock().tryLock(WAIT_MSEC, TimeUnit.MILLISECONDS)) {
					try {
					
						// do transfer
						
						acc1.withdraw(amount);
						acc2.deposit(amount);

						System.out.println("Transfer successful.");
									
						
					} finally {
						acc2.getLock().unlock();
					}
				}
				
			} finally {
				acc1.getLock().unlock();
			}
		} else {
			// Error waiting lock
			System.out.println("Can't lock");
		}
				
	}

}
