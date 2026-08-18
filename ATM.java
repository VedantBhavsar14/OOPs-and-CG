package Javaproject;
import java.util.Scanner;

class ATM {
	private double balance;
	public ATM(double initialBalance) {
		this.balance=initialBalance;
	}
	public void checkBalance() {
		System.out.println("Current Balance:Rs"+balance);
	}
	public void deposit(double amount) {
		if(amount<=0) {
			throw new IllegalArgumentException("Deposit must be positive");
		}
		balance+=amount;
		System.out.println("Amount Deposited Successfully"+amount);
	}
	public void withdraw(double amount) {
		if(amount<=0) {
			throw new IllegalArgumentException("Withdraw should be positive");
		}
		if(amount>balance) {
			throw new ArithmeticException("Insufficient balance");
		}
		balance-=amount;
		System.out.println("Amount Withdraw Successfully"+amount);
	}
}

class ATMSimulation{
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		ATM atm=new ATM(100000);
		boolean running=true;
	while (running) {
		try {
			System.out.println("1.Check balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		
		}
			}
		}
	}
}