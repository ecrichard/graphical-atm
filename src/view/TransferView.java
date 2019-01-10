package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
import model.BankAccount;
@SuppressWarnings("serial")
public class TransferView extends JPanel implements ActionListener{

	private ViewManager manager;
	private JLabel errorMessageLabel;
	private JButton homeButton;
	private JLabel amount;
	private JTextField damount;
	private JButton TransferButton;
	private JLabel label;
	private JTextField accountField;
	
	public TransferView(ViewManager manager) {
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
		
		inithomeButton();
		initgetAmount();
		initTransferButton();
		initAccount();
	}
	
	private void inithomeButton() {	
		homeButton = new JButton("Back to Home");
		homeButton.setBounds(205, 180, 200, 35);
		homeButton.addActionListener(this);
		
		this.add(homeButton);
	}
	
	private void initgetAmount() {
		amount = new JLabel("Amount: $");
		amount.setBounds(100, 100, 95, 35);
		amount.setLabelFor(damount);
		amount.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		damount = new JTextField(20);
		damount.setBounds(205, 100, 200, 35);
		
		this.add(amount);
		this.add(damount);
	}
	
	private void initAccount() {
		label = new JLabel("Account #:", SwingConstants.RIGHT);
		label.setBounds(100, 140, 95, 35);
		label.setLabelFor(accountField);
		label.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		accountField = new JTextField(20);
		accountField.setBounds(205, 140, 200, 35);
		
		this.add(label);
		this.add(accountField);
	}
	
	public void initTransferButton() {
		TransferButton = new JButton("Transfer");
		TransferButton.setBounds(126, 360, 248, 35);
		TransferButton.addActionListener(this);
		
		this.add(TransferButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source.equals(homeButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		} 
		else if (source.equals(TransferButton)) {
			double amount = Double.parseDouble(damount.getText());
			BankAccount destination = manager.db.getAccount(Integer.parseInt(accountField.getText()));
			manager.transfer(amount, destination);
		}
		
	}
	
	
}