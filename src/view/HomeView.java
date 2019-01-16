package view;

//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;

import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.SwingConstants;

import controller.ViewManager;
//import model.BankAccount;

@SuppressWarnings("serial")
public class HomeView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JButton loginButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JButton closeButton;
	private JButton editButton;
	private long number;
	private String first;
	private String last;
	public double balance;
	//private BankAccount account;
	/**
	 * Constructs an instance (or objects) of the HomeView class.
	 * 
	 * @param manager
	 */
	
	public HomeView(ViewManager manager) {
		super();
		
		this.manager = manager;
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the HomeView components.
	 */
	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the HomeView.
		
		this.add(new javax.swing.JLabel("HomeView", javax.swing.SwingConstants.CENTER));
		initLoginButton();
		
		//initDisplayInfo();
		// TODO
		//
		// this is where you should build the HomeView (i.e., all the components that
		// allow the user to interact with the ATM - deposit, withdraw, transfer, etc.).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	
	
	
	void initLoginButton() {	
		loginButton = new JButton("Logout");
		loginButton.setBounds(205, 180, 200, 35);
		loginButton.addActionListener(this);
		
		this.add(loginButton);
	}
	
	
	public void initDisplayInfo() {
		//System.out.println(helpaccount.accountNum);
		number = manager.getAccountNum();
		first = manager.getFirst();
		last = manager.getLast();
		balance = manager.getBalance();
		
		
		
		DecimalFormat df2 = new DecimalFormat( "###,##0.00" );
	
		
		this.add(new javax.swing.JLabel("\nFirst name: " + first, javax.swing.SwingConstants.CENTER));
		this.add(new javax.swing.JLabel("\nLast name: " + last, javax.swing.SwingConstants.CENTER));
		this.add(new javax.swing.JLabel("\nAccount Number: " + number, javax.swing.SwingConstants.CENTER));
		this.add(new javax.swing.JLabel("\nBalance: $" + df2.format(balance), javax.swing.SwingConstants.CENTER));
	}
	
	public void initDepositButton() {
		depositButton = new JButton("Deposit");
		//depositButton.setBounds(205, 180, 200, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	public void initWithdrawButton() {
		withdrawButton = new JButton("Withdraw");
		//depositButton.setBounds(205, 180, 200, 35);
		withdrawButton.addActionListener(this);
		
		this.add(withdrawButton);
	}
	
	public void initTransferButton() {
		transferButton = new JButton("Transfer");
		//depositButton.setBounds(205, 180, 200, 35);
		transferButton.addActionListener(this);
		
		this.add(transferButton);
	}
	
	public void initCloseAccountButton() {
		closeButton = new JButton("Close Account");
		closeButton.addActionListener(this);
		
		this.add(closeButton);
	}
	
	public void initEditAccountButton() {
		editButton = new JButton("Edit Account Information");
		editButton.addActionListener(this);
		
		this.add(editButton);
	}
	
	/*
	 * HomeView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The HomeView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the HomeView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(loginButton)) {
			manager.switchTo(ATM.LOGIN_VIEW);
			this.setLayout(null);
		}
		else if (source.equals(depositButton)) {
			manager.switchTo(ATM.DEPOSIT_VIEW);
		}
		else if(source.equals(withdrawButton)) {
			manager.switchTo(ATM.WITHDRAW_VIEW);
		}
		else if(source.equals(transferButton)) {
			manager.switchTo(ATM.TRANSFER_VIEW);
		}
		else if(source.equals(editButton)) {
			manager.switchTo(ATM.INFORMATION_VIEW);
		}
		else if(source.equals(closeButton)) {
			manager.closeAccount(manager.getAccountNum());
			manager.switchTo(ATM.LOGIN_VIEW);
		}
		// TODO
		//
		// this is where you'll setup your action listener, which is responsible for
		// responding to actions the user might take in this view (an action can be a
		// user clicking a button, typing in a textfield, etc.).
		//
		// feel free to use my action listener in LoginView.java as an example.
	}
}