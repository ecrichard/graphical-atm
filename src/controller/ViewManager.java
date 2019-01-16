package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.Database;
import model.BankAccount;
//import model.User;
import view.ATM;
import view.EditView;
import view.HomeView;
import view.InformationView;
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
				hv.initCloseAccountButton();
				hv.initEditAccountButton();
				
				EditView ev = ((EditView) views.getComponents()[ATM.EDIT_VIEW_INDEX]);
				ev.initaccountNumber();
				ev.initeditButton();
				ev.inithomeButton();
				
				InformationView iv = ((InformationView) views.getComponents()[ATM.INFORMATION_VIEW_INDEX]);
				iv.initallInfo();
				iv.initEditButton();
				iv.inithomeButton();
			}
		} catch (NumberFormatException e) {
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
	
	public String getStreetAddress() {
		String streetAddress = account.getUser().getStreetAddress();
		return streetAddress;
	}
	
	public String getCity() {
		String city = account.getUser().getCity();
		return city;
	}
	
	public String getState() {
		String state = account.getUser().getState();
		return state;
	}
	
	public String getPostal() {
		String postal = account.getUser().getZip();
		return postal;
	}
	
	public int getDOB() {
		int dob = account.getUser().getDob();
		return dob;
	}
	
	public long getPhone() {
		long phone = account.getUser().getPhone();
		return phone;
	}
	
	public int getPin() {
		int pin = account.getUser().getPin();
		return pin;
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
	
	public void closeAccount(long accountNumber) {
		BankAccount temp = db.getAccount(accountNumber);
		db.closeAccount(temp);
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
