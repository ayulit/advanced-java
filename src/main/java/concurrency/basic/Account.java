package concurrency.basic;

public class Account {
	
	private int balance;
	
	public Account(int initialBalance) {
		this.balance = initialBalance;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}

	public int getBalace() {
		return balance;
	}

}
