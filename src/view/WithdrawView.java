package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ViewManager;
@SuppressWarnings("serial")
public class WithdrawView extends JPanel implements ActionListener{

	private ViewManager manager;
	private JLabel errorMessageLabel;
	private JButton homeButton;
	private JLabel amount;
	private JTextField damount;
	private JButton WithdrawButton;
	
	
	public WithdrawView(ViewManager manager) {
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
		initWithdrawButton();
		initErrorMessageLabel();
	}
	
	private void initErrorMessageLabel() {
		errorMessageLabel.setBounds(0, 240, 500, 35);
		errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		errorMessageLabel.setForeground(Color.RED);
		
		this.add(errorMessageLabel);
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
	
	public void initWithdrawButton() {
		WithdrawButton = new JButton("Withdraw");
		WithdrawButton.setBounds(126, 360, 248, 35);
		WithdrawButton.addActionListener(this);
		
		this.add(WithdrawButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source.equals(homeButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		} 
		else if (source.equals(WithdrawButton)) {
			double amount = Double.parseDouble(damount.getText());
			if(amount >= 0.01 && !Double.isNaN(amount)) {
				manager.withdraw(amount);
			}
			else {
				System.err.println("ERROR: input an amount that is greater than $0");
			}
		}
		
	}
	
	
}