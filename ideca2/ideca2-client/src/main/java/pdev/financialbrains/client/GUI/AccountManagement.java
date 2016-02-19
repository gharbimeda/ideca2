package pdev.financialbrains.client.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement frame = new AccountManagement();
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
	public AccountManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	/*	JLabel deleteAccount = new JLabel("Delete Account\r\n");
		deleteAccount.setBounds(694, 403, 177, 42);
		deleteAccount.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		deleteAccount.setForeground(Color.black);
		contentPane.add(deleteAccount);*/
		
		JButton btnDeleteUser = new JButton("Delete Account");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteAccount frame = new DeleteAccount();
				frame.setVisible(true);
			}
		});
		btnDeleteUser.setBounds(683, 305, 177, 42);
		btnDeleteUser.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		btnDeleteUser.setForeground(Color.black);
		contentPane.add(btnDeleteUser);
		
		JLabel deleteIcon = new JLabel("");
		deleteIcon.setIcon(new ImageIcon("C:\\IDE\\images\\user-delete-icon.png"));
		deleteIcon.setBounds(706, 157, 123, 128);
		contentPane.add(deleteIcon);
		
		/*JLabel addAccount = new JLabel("Add Account");
		addAccount.setBounds(499, 380, 177, 42);
		addAccount.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		addAccount.setForeground(Color.black);
		contentPane.add(addAccount);*/
		
		JButton btnAddUser = new JButton("Add Account\r\n");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccount frame = new AddAccount();
				frame.setVisible(true);
			}
		});
		btnAddUser.setBounds(475, 305, 177, 42);
		btnAddUser.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		btnAddUser.setForeground(Color.black);
		contentPane.add(btnAddUser);
		
		JLabel lbadduser = new JLabel("\r\n");
		lbadduser.setIcon(new ImageIcon("C:\\IDE\\images\\user-accept-icon.png"));
		lbadduser.setBounds(499, 157, 140, 128);
		contentPane.add(lbadduser);
		
		JLabel allusersicon = new JLabel("");
		allusersicon.setForeground(Color.LIGHT_GRAY);
		allusersicon.setIcon(new ImageIcon("C:\\IDE\\images\\users-icon.png"));
		allusersicon.setBounds(279, 157, 140, 128);
		contentPane.add(allusersicon);
		
		/*JLabel lblVisualizeAccount = new JLabel("Visualize Accounts\r\n");
		lblVisualizeAccount.setBounds(278, 293, 177, 42);
		lblVisualizeAccount.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblVisualizeAccount.setForeground(Color.black);
		contentPane.add(lblVisualizeAccount);*/
		
		
		//button Visualize Accounts : //
		JButton Visualize = new JButton("Visualize Accounts");
		Visualize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisualizeAccounts frame = new VisualizeAccounts();
				frame.setVisible(true);
			}
		});
		Visualize.setBounds(246, 305, 199, 42);
		Visualize.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		Visualize.setForeground(Color.black);
		contentPane.add(Visualize);
		
		JLabel lblHomeAccount = new JLabel("Home \t\t\t\t    Account Management\r\n");
		lblHomeAccount.setBounds(268, 93, 400, 35);
		lblHomeAccount.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblHomeAccount.setForeground(Color.LIGHT_GRAY);
		contentPane.add(lblHomeAccount);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 881, 504);
		background.setIcon(new ImageIcon("C:\\IDE\\images\\backAdmin.jpg"));
		contentPane.add(background);
	}
}
