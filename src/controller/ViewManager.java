package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.Database;
import model.BankAccount;
//import model.User;
import view.ATM;
import view.HomeView;
import view.LoginView;

public class ViewManager {
	
	private Container views;				// the collection of all views in the application
	public Database db;					// a reference to the database
	private BankAccount account;			// the user's bank account
	//private BankAccount destination;		// an account to which the user can transfer funds
	//private User user;
	/**
	 * Constructs an instance (or object) of the ViewManager class.
	 * 
	 * @param layout
	 * @param container
	 */
	
	public ViewManager(Container views) {
		this.views = views;
		this.db = new Database();
	}
	
	///////////////////// INSTANCE METHODS ////////////////////////////////////////////
	
	/**
	 * Routes a login request from the LoginView to the Database.
	 * 
	 * @param accountNumber
	 * @param pin
	 */
	
	public void login(String accountNumber, char[] pin) {
		try {
			account = db.getAccount(Long.valueOf(accountNumber), Integer.valueOf(new String(pin)));
			
			if (account == null) {
				LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
				lv.updateErrorMessage("Invalid account number and/or PIN.");
			} else {
				switchTo(ATM.HOME_VIEW);
				
				LoginView lv = ((LoginView) views.getComponents()[ATM.LOGIN_VIEW_INDEX]);
				lv.updateErrorMessage("");
				
				HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
				hv.initDisplayInfo();
				hv.initDepositButton();
				hv.initWithdrawButton();
				hv.initTransferButton();
			}
		} catch (NumberFormatException e) {
			// ignore
		}
	}
	
	public void create() {
		try {
			switchTo(ATM.HOME_VIEW);
			HomeView hv = ((HomeView) views.getComponents()[ATM.HOME_VIEW_INDEX]);
			hv.initDisplayInfo();
			hv.initDepositButton();
			hv.initWithdrawButton();
			hv.initTransferButton();
		}
		catch (NumberFormatException e) {
			// ignore
		}

	}
	
	public long newAccountNumber() throws SQLException {
		long accountNum =  1 + db.getMaxAccountNumber();
		return accountNum;
	}
	
	public void newAccount(BankAccount account) {
		db.insertAccount(account);
	}
	
	public long getAccountNum() {
		long accountnum = account.getAccountNumber();
		return accountnum;
	}
	
	public String getLast() {
		String lastname = account.getUser().getLastName();
		return lastname;
	}
	
	public String getFirst() {
		String firstname = account.getUser().getFirstName();
		return firstname;
	}
	
	public double getBalance() {
		double balance = account.getBalance();
		return balance;
	}
	
	public void deposit(double amount) {
		account.deposit(amount);
		db.updateAccount(account);
	}
	
	public void withdraw(double amount) {
		account.withdraw(amount);
		db.updateAccount(account);
	}
	
	public void transfer(double amount, BankAccount destination) {
		account.transfer(destination, amount);
		db.updateAccount(destination);
		db.updateAccount(account);
	}
	
	/**
	 * Switches the active (or visible) view upon request.
	 * 
	 * @param view
	 */
	
	public void switchTo(String view) {
		((CardLayout) views.getLayout()).show(views, view);
	}
	
	/**
	 * Routes a shutdown request to the database before exiting the application. This
	 * allows the database to clean up any open resources it used.
	 */
	
	public void shutdown() {
		try {			
			int choice = JOptionPane.showConfirmDialog(
				views,
				"Are you sure?",
				"Shutdown ATM",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE
			);
			
			if (choice == 0) {
				db.shutdown();
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
