package view;

//import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;
import model.User;

@SuppressWarnings("serial")
public class CreateView extends JPanel implements ActionListener {
	
	private ViewManager manager;		// manages interactions between the views, model, and database
	private JTextField firstName;
	private JTextField lastName;
	private String dateOB;
	private JComboBox<String> month;
	private JComboBox<String> day;
	private JComboBox<String> year;
	private JTextField phone;
	private JPasswordField pin;
	private JTextField streetAddress;
	private JTextField city;
	private JComboBox<String> state;
	private JTextField zip;
	private JButton createAccount;
	private JButton cancelButton;
	private JLabel errorMessageLabel;
	//private char status;
	//private long accountNumber;
	//private double balance;
	private User user;
	private BankAccount account;
	private String states;
	/**
	 * Constructs an instance (or object) of the CreateView class.
	 * 
	 * @param manager
	 */
	
	public CreateView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	///////////////////// PRIVATE METHODS /////////////////////////////////////////////
	
	/*
	 * Initializes the CreateView components.
	 */
	public void updateErrorMessage(String errorMessage) {
		errorMessageLabel.setText(errorMessage);
	}
	
	private void initialize() {
		
		// TODO
		//
		// this is a placeholder for this view and should be removed once you start
		// building the CreateView.
		this.setLayout(null);
		this.add(new javax.swing.JLabel("CreateView", javax.swing.SwingConstants.CENTER));
		initFirstName();
		initLastName();
		initDateOB();
		initPhone();
		initPin();
		initStreetAddress();
		initCity();
		initState();
		initZip();
		initCreateAccount();
		initCancelButton();
		// TODO
		//
		// this is where you should build the CreateView (i.e., all the components that
		// allow the user to enter his or her information and create a new account).
		//
		// feel free to use my layout in LoginView as an example for laying out and
		// positioning your components.
	}
	private void initFirstName() {
		JLabel label = new JLabel("First name:", SwingConstants.RIGHT);
		label.setBounds(35, 50, 95, 30);
		label.setLabelFor(firstName);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		firstName = new JTextField(20);
		firstName.setBounds(125, 50, 200, 30);
		firstName.addActionListener(this);
		
		this.add(label);
		this.add(firstName);
	}
	
	private void initLastName() {
		JLabel label = new JLabel("Last name:", SwingConstants.RIGHT);
		label.setBounds(35, 90, 95, 30);
		label.setLabelFor(lastName);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		lastName = new JTextField(20);
		lastName.setBounds(125, 90, 200, 30);
		lastName.addActionListener(this);
		
		this.add(label);
		this.add(lastName);
	}
	
	private void initDateOB() {
		JLabel label = new JLabel("Date OB:", SwingConstants.RIGHT);
		label.setBounds(35, 130, 95, 30);
		label.setLabelFor(year);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));

		
		year = new JComboBox<String>();
		month = new JComboBox<String>();
		day = new JComboBox<String>();
		
		year.addItem("1980");
		year.addItem("1981");
		year.addItem("1982");
		year.addItem("1983");
		year.addItem("1984");
		year.addItem("1985");
		
		
		year.setBounds(125, 130, 100, 30);
		year.addActionListener(this);
		
		month.addItem("01");
		month.addItem("02");
		month.addItem("03");
		month.addItem("04");
		month.addItem("05");
		month.addItem("06");
		month.addItem("07");
		month.addItem("08");
		month.addItem("09");
		month.addItem("10");
		month.addItem("11");
		month.addItem("12");
		
		month.setBounds(225, 130, 70, 30);
		month.addActionListener(this);
		
		day.addItem("01");
		day.addItem("02");
		day.addItem("03");
		day.addItem("04");
		day.addItem("05");
		day.addItem("06");
		day.addItem("07");
		day.addItem("08");
		day.addItem("09");
		day.addItem("10");
		day.addItem("11");
		day.addItem("12");
		day.addItem("13");
		day.addItem("14");
		day.addItem("15");
		day.addItem("16");
		day.addItem("17");
		day.addItem("18");
		day.addItem("19");
		day.addItem("20");
		day.addItem("21");
		day.addItem("22");
		day.addItem("23");
		day.addItem("24");
		day.addItem("25");
		day.addItem("26");
		day.addItem("27");
		day.addItem("28");
		day.addItem("29");
		day.addItem("30");
		day.addItem("31");

		day.setBounds(285, 130, 70, 30);
		day.addActionListener(this);
		//dateOB = new JTextField(20);
		//dateOB.setBounds(125, 130, 200, 30);
		//dateOB.addActionListener(this);
		
		dateOB = (String) year.getSelectedItem() + (String) month.getSelectedItem() + (String) day.getSelectedItem();
		//dateOB = Integer.parseInt(dateOB);
		this.add(label);
		this.add(year);
		this.add(month);
		this.add(day);
		//this.add(dateOB);
	}
	
	private void initPhone() {
		JLabel label = new JLabel("Phone:", SwingConstants.RIGHT);
		label.setBounds(35, 170, 95, 30);
		label.setLabelFor(phone);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		phone = new JTextField(20);
		phone.setBounds(125, 170, 200, 30);
		phone.addActionListener(this);
		
		this.add(label);
		this.add(phone);
	}
	
	private void initPin() {
		JLabel label = new JLabel("Pin:", SwingConstants.RIGHT);
		label.setBounds(35, 210, 95, 30);
		label.setLabelFor(pin);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		pin = new JPasswordField(20);
		pin.setBounds(125, 210, 200, 30);
		pin.addActionListener(this);
		
		this.add(label);
		this.add(pin);
	}
	
	private void initStreetAddress() {
		JLabel label = new JLabel("Address:", SwingConstants.RIGHT);
		label.setBounds(35, 250, 95, 30);
		label.setLabelFor(streetAddress);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		streetAddress = new JTextField(20);
		streetAddress.setBounds(125, 250, 200, 30);
		streetAddress.addActionListener(this);
		
		this.add(label);
		this.add(streetAddress);
	}
	
	private void initCity() {
		JLabel label = new JLabel("City:", SwingConstants.RIGHT);
		label.setBounds(35, 290, 95, 30);
		label.setLabelFor(city);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		city = new JTextField(20);
		city.setBounds(125, 290, 200, 30);
		city.addActionListener(this);
		
		this.add(label);
		this.add(city);
	}
	
	private void initState() {
		
		
		state = new JComboBox<String>();
		 
		// add items to the combo box
		state.addItem("AL");
		state.addItem("AK");
		state.addItem("AZ");
		state.addItem("AR");
		state.addItem("CA");
		state.addItem("CO");
		state.addItem("CT");
		state.addItem("DE");
		state.addItem("DC");
		state.addItem("FL");
		state.addItem("GA");
		state.addItem("HI");
		state.addItem("ID");
		state.addItem("IL");
		state.addItem("IN");
		state.addItem("IA");
		state.addItem("KS");
		state.addItem("KY");
		state.addItem("LA");
		state.addItem("MA");
		state.addItem("ME");
		state.addItem("MD");
		state.addItem("MI");
		state.addItem("MN");
		state.addItem("MO");
		state.addItem("MS");
		state.addItem("MT");
		state.addItem("NE");
		state.addItem("NV");
		state.addItem("NH");
		state.addItem("NJ");
		state.addItem("NM");
		state.addItem("NY");
		state.addItem("NC");
		state.addItem("ND");
		state.addItem("OH");
		state.addItem("OK");
		state.addItem("OR");
		state.addItem("PA");
		state.addItem("RI");
		state.addItem("SC");
		state.addItem("SD");
		state.addItem("TN");
		state.addItem("TX");
		state.addItem("UT");
		state.addItem("VT");
		state.addItem("VA");
		state.addItem("WA");
		state.addItem("WV");
		state.addItem("WI");
		state.addItem("WY");

		JLabel label = new JLabel("State:", SwingConstants.RIGHT);
		label.setBounds(35, 330, 95, 30);
		label.setLabelFor(state);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		//state = new JComboBox<String>();
		state.setBounds(125, 330, 200, 30);
		state.addActionListener(this);
		
		states = (String) state.getSelectedItem();
		
		this.add(label);
		this.add(state);
	}
	
	private void initZip() {
		JLabel label = new JLabel("Zip:", SwingConstants.RIGHT);
		label.setBounds(35, 370, 95, 30);
		label.setLabelFor(zip);
		label.setFont(new Font("DialogInput", Font.BOLD, 12));
		
		zip = new JTextField(20);
		zip.setBounds(125, 370, 200, 30);
		zip.addActionListener(this);
		
		this.add(label);
		this.add(zip);
	}
	
	private void initCreateAccount() {	
		createAccount = new JButton("Create Account");
		createAccount.setBounds(125, 410, 200, 30);
		createAccount.addActionListener(this);
		
		this.add(createAccount);
	}
	
	private void initCancelButton() {	
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(125, 450, 200, 30);
		cancelButton.addActionListener(this);
		
		this.add(cancelButton);
	}
	
	public User newUser(int pin, int dob, long phone, String firstName, String lastName, String streetAddress, String city, String state, String zip) {
		user = new User(pin, dob, phone, firstName, lastName, streetAddress, city, state, zip);
		return user; 
	}
	
	public BankAccount accessBankaccount() throws SQLException {
		String s = new String(pin.getPassword());
		int pin = Integer.parseInt(s);
		//String stated = (String) state.getSelectedItem();
		int ddateOB = Integer.parseInt(dateOB);
		long accountnum = manager.newAccountNumber();
		account = new BankAccount('Y', accountnum, 0.00, newUser(pin, ddateOB, Integer.parseInt(phone.getText()), firstName.getText(), lastName.getText(), streetAddress.getText(), city.getText(), states, zip.getText()));
		return account;
	}
	
	/*
	 * CreateView is not designed to be serialized, and attempts to serialize will throw an IOException.
	 * 
	 * @param oos
	 * @throws IOException
	 */
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		throw new IOException("ERROR: The CreateView class is not serializable.");
	}
	
	///////////////////// OVERRIDDEN METHODS //////////////////////////////////////////
	
	/*
	 * Responds to button clicks and other actions performed in the CreateView.
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(cancelButton)) {
			manager.switchTo(ATM.LOGIN_VIEW);
		}
		else if(source.equals(createAccount)) {
			try {
				manager.newAccount(accessBankaccount());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			manager.switchTo(ATM.HOME_VIEW);
		}
		else {
			System.err.println("ERROR: Action command not found (" + e.getActionCommand() + ")");
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