package concurrency.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	private int balance;
	private Lock lock;
	
	public Account(int initialBalance) {
		this.balance = initialBalance;
		this.lock = new	ReentrantLock();
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

	public Lock getLock() {
		return lock;
	}
	
	

}
