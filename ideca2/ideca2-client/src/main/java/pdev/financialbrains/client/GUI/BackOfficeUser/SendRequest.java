package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class SendRequest extends JFrame {

	private JPanel contentPane;
	private JTextField tf_email;
	private JTextField tf_company;
	private JTextField tf_job;
	private JTextField tf_account;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendRequest frame = new SendRequest();
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
	public SendRequest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_email = new JTextField();
		tf_email.setBounds(435, 184, 237, 37);
		contentPane.add(tf_email);
		tf_email.setColumns(10);
		
		tf_company = new JTextField();
		tf_company.setColumns(10);
		tf_company.setBounds(435, 244, 237, 37);
		contentPane.add(tf_company);
		
		tf_job = new JTextField();
		tf_job.setColumns(10);
		tf_job.setBounds(435, 307, 237, 37);
		contentPane.add(tf_job);
		
		tf_account = new JTextField();
		tf_account.setColumns(10);
		tf_account.setBounds(435, 365, 237, 37);
		contentPane.add(tf_account);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SendRequest.class.getResource("/pdev/financialbrains/client/pictures/Request.PNG")));
		lblNewLabel.setBounds(0, 0, 894, 509);
		contentPane.add(lblNewLabel);
	}

}
