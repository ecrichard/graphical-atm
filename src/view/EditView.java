package view;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;
import model.User;
@SuppressWarnings("serial")
public class EditView extends JPanel implements ActionListener{

	private ViewManager manager;
	private JLabel errorMessageLabel;
	private JButton homeButton;
	private JLabel accountnumlabel;
	private JTextField accountnum;
	private JButton editButton;
	private JLabel fnamelabel;
	private JTextField fname;
	private JLabel lnamelabel;
	private JTextField lname;
	private JLabel streetaddlabel;
	private JTextField streetadd;
	private JLabel citylabel;
	private JTextField city;
	private JLabel statelabel;
	private JTextField state;
	private JLabel postallabel;
	private JTextField postal;
	private JLabel doblabel;
	private JTextField dob;
	private JLabel phonelabel;
	private JTextField phone;
	private JLabel pinlabel;
	private JPasswordField pin;
	
	
	public EditView(ViewManager manager) {
		super();
		
		this.manager = manager;
		this.errorMessageLabel = new JLabel("", SwingConstants.CENTER);
		initialize();
	}
	
	public void updateErrorMessage(String errorMessage) {
		errorMessageLabel.setText(errorMessage);
	}
	
	
	private void initialize() {
		this.setLayout(null);
		
	}
	
	
	public void inithomeButton() {	
		homeButton = new JButton("Cancel");
		homeButton.setBounds(35, 425, 125, 30);
		homeButton.addActionListener(this);
		
		this.add(homeButton);
	}
	
	public void initaccountNumber() {
		accountnumlabel = new JLabel("Account #:");
		accountnumlabel.setBounds(35, 25, 95, 30);
		accountnumlabel.setLabelFor(accountnum);
		
		accountnum = new JTextField(20);
		String text = String.valueOf(manager.getAccountNum());
		accountnum.setText(text);
		accountnum.setEditable(false);
		accountnum.setVisible(true);
		accountnum.setBounds(125, 25, 95, 30);
		
		fnamelabel = new JLabel("First name:");
		fnamelabel.setBounds(35, 50, 95, 30);
		fnamelabel.setLabelFor(fname);
		
		fname = new JTextField(20);
		String text1 = String.valueOf(manager.getFirst());
		fname.setText(text1);
		fname.setEditable(false);
		fname.setVisible(true);
		fname.setBounds(125, 50, 95, 30);
		
		lnamelabel = new JLabel("Last name:");
		lnamelabel.setBounds(35, 75, 95, 30);
		lnamelabel.setLabelFor(lname);
		
		lname = new JTextField(20);
		String text2 = String.valueOf(manager.getLast());
		lname.setText(text2);
		lname.setEditable(false);
		lname.setVisible(true);
		lname.setBounds(125, 75, 95, 30);
		
		streetaddlabel = new JLabel("Street Address:");
		streetaddlabel.setBounds(35, 100, 95, 30);
		streetaddlabel.setLabelFor(streetadd);
		
		streetadd = new JTextField(20);
		String text3 = String.valueOf(manager.getStreetAddress());
		streetadd.setText(text3);
		streetadd.setEditable(true);
		streetadd.setVisible(true);
		streetadd.setBounds(125, 100, 150, 30);
		
		citylabel = new JLabel("City:");
		citylabel.setBounds(35, 125, 95, 30);
		citylabel.setLabelFor(city);
		
		city = new JTextField(20);
		String text4 = String.valueOf(manager.getCity());
		city.setText(text4);
		city.setEditable(true);
		city.setVisible(true);
		city.setBounds(125, 125, 95, 30);
		
		statelabel = new JLabel("State:");
		statelabel.setBounds(35, 150, 95, 30);
		statelabel.setLabelFor(state);
		
		state = new JTextField(20);
		String text5 = String.valueOf(manager.getState());
		state.setText(text5);
		state.setEditable(true);
		state.setVisible(true);
		state.setBounds(125, 150, 95, 30);
		
		postallabel = new JLabel("postal:");
		postallabel.setBounds(35, 175, 95, 30);
		postallabel.setLabelFor(postal);
		
		postal = new JTextField(20);
		String text6 = String.valueOf(manager.getPostal());
		postal.setText(text6);
		postal.setEditable(true);
		postal.setVisible(true);
		postal.setBounds(125, 175, 95, 30);
		
		doblabel = new JLabel("dob:");
		doblabel.setBounds(35, 200, 95, 30);
		doblabel.setLabelFor(dob);
		
		dob = new JTextField(20);
		String text7 = String.valueOf(manager.getDOB());
		dob.setText(text7);
		dob.setEditable(false);
		dob.setVisible(true);
		dob.setBounds(125, 200, 95, 30);
		
		phonelabel = new JLabel("phone:");
		phonelabel.setBounds(35, 225, 95, 30);
		phonelabel.setLabelFor(phone);
		
		phone = new JTextField(20);
		String text8 = String.valueOf(manager.getPhone());
		phone.setText(text8);
		phone.setEditable(true);
		phone.setVisible(true);
		phone.setBounds(125, 225, 150, 30);
		
		pinlabel = new JLabel("pin:");
		pinlabel.setBounds(35, 250, 95, 30);
		pinlabel.setLabelFor(pin);
		
		pin = new JPasswordField(20);
		String text9 = String.valueOf(manager.getPin());
		pin.setText(text9);
		pin.setEditable(true);
		pin.setVisible(true);
		pin.setBounds(125, 250, 150, 30);
		
		
		this.add(accountnumlabel);
		this.add(accountnum);
		this.add(fnamelabel);
		this.add(fname);
		this.add(lnamelabel);
		this.add(lname);
		this.add(streetaddlabel);
		this.add(streetadd);
		this.add(citylabel);
		this.add(city);
		this.add(statelabel);
		this.add(state);
		this.add(postallabel);
		this.add(postal);
		this.add(doblabel);
		this.add(dob);
		this.add(phonelabel);
		this.add(phone);
		this.add(pinlabel);
		this.add(pin);
	}	
	
	public void initeditButton() {
		editButton = new JButton("Save");
		editButton.setBounds(35, 400, 95, 30);
		editButton.addActionListener(this);
		
		this.add(editButton);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source.equals(homeButton)) {
			manager.switchTo(ATM.INFORMATION_VIEW);
		} 
		else if (source.equals(editButton)) {
			int pinn = Integer.parseInt(pin.getText());
			long phonee = Long.parseLong(phone.getText());
			String street = streetadd.getText();
			String cityy = city.getText();
			String statee = state.getText();
			String postall = postal.getText();
			BankAccount account = new BankAccount('Y', manager.getAccountNum() ,manager.getBalance(), new User(pinn, manager.getDOB(),phonee, manager.getFirst(), manager.getLast(), street, cityy, statee, postall));
			manager.db.updateAccount(account);
			manager.switchTo(ATM.HOME_VIEW);
		}
		
	}
	
	
}