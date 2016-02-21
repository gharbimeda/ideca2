package pdev.financialbrains.client.GUI.Administrator;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.GUI.BackOfficeUser.BackHome;
import pdev.financialbrains.client.delegate.UserManagementDelegate;
import pdev.financialbrains.client.utils.Util;
import pdev.financialbrains.ejb.entities.BackOfficeUser;
import pdev.financialbrains.ejb.entities.User;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField tf_login;
	private JPasswordField tf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
User user = UserManagementDelegate.doAuthentification(tf_login.getText(),new String(tf_password.getPassword()));
				
				
				//if (user  != null ){
					
					if (user  instanceof  BackOfficeUser ) {

						 
						new BackHome().setVisible(true);
						fermer();
						Util.userConnect= user;}

					
						
					 if ( tf_login.getText().equals("admin") && tf_password.getText().equals("admin")){
							new AdminHome().setVisible(true);
							fermer();
					 
					 
					 }
					
					else JOptionPane.showMessageDialog(null, " check your login or password");
						
					}
					
				
				
				
				
			
		});
		lblNewLabel.setBounds(264, 366, 134, 29);
		contentPane.add(lblNewLabel);
		
		tf_login = new JTextField();
		tf_login.setBounds(264, 202, 101, 20);
		contentPane.add(tf_login);
		tf_login.setColumns(10);
		
		tf_password = new JPasswordField();
		tf_password.setBounds(264, 283, 101, 20);
		contentPane.add(tf_password);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\IDE\\images\\12729239_1151112541565691_6708753397514368497_n (1).jpg"));
		label.setBounds(0, 0, 883, 476);
		contentPane.add(label);
	}
	private void fermer(){
		this.setVisible(false);
	}
}
