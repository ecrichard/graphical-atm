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
@SuppressWarnings("serial")
public class DepositView extends JPanel implements ActionListener{

	private ViewManager manager;
	private JLabel errorMessageLabel;
	private JButton homeButton;
	private JLabel amount;
	private JTextField damount;
	private JButton depositButton;
	
	public DepositView(ViewManager manager) {
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
		initdepositButton();
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
	
	public void initdepositButton() {
		depositButton = new JButton("deposit");
		depositButton.setBounds(126, 360, 248, 35);
		depositButton.addActionListener(this);
		
		this.add(depositButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source.equals(homeButton)) {
			manager.switchTo(ATM.HOME_VIEW);
		} 
		else if (source.equals(depositButton)) {
			double amount = Double.parseDouble(damount.getText());
			manager.deposit(amount);
		}
		
	}
	
	
}