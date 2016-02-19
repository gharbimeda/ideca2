package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.boot.EmailSender;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_response;
	private JTextField tf_mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintManagement frame = new ComplaintManagement();
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
	public ComplaintManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_response = new JTextField();
		tf_response.setBounds(37, 174, 86, 20);
		contentPane.add(tf_response);
		tf_response.setColumns(10);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(37, 217, 86, 20);
		contentPane.add(tf_mail);
		tf_mail.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] to = {tf_mail.getText()};
	            System.out.println(to);
	            
	            String Email_Body = tf_response.getText();
	            System.out.println(Email_Body);          
	         if (EmailSender.sendEmail("create.money.differently@gmail.com", "98238622",Email_Body, to)) {
	                System.out.println("email sent successfully");
	               
	           JOptionPane.showMessageDialog(null, "Modification avec succes ", "Ok", 1);
	            } else {
	                System.out.println("some error occured");
	            }
			}
		});
		btnNewButton.setBounds(200, 194, 89, 23);
		contentPane.add(btnNewButton);
	}

}
