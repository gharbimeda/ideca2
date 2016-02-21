package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.AccountManagementDelegate;
import pdev.financialbrains.client.utils.UserTableModel;
import pdev.financialbrains.ejb.entities.User;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AccountManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	private JTextField userLG;
	private JTextField userPass;
	private List<User> users;
	private User user;

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
		setBounds(100, 100, 1243, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane accountsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		accountsTabbedPane.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		accountsTabbedPane.setBounds(300, 200, 800, 380);
		contentPane.add(accountsTabbedPane);
		table_1 = new JTable();
		table_1.setModel(new UserTableModel());

		accountsTabbedPane.addTab("Visualize Accounts",
				new ImageIcon(
						AccountManagement.class.getResource("/pdev/financialbrains/client/pictures/users-icon.png")),
				table_1, null);
		accountsTabbedPane.setEnabledAt(0, true);
		JLayeredPane panel = new JLayeredPane();
		accountsTabbedPane
				.addTab("Add Account",
						new ImageIcon(AccountManagement.class
								.getResource("/pdev/financialbrains/client/pictures/user-accept-icon.png")),
						panel, null);
		panel.setLayout(null);

		JLabel label = new JLabel("Login");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label.setBounds(107, 67, 78, 22);
		panel.add(label);

		userLG = new JTextField();
		userLG.setColumns(10);
		userLG.setBounds(271, 68, 148, 31);
		panel.add(userLG);

		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		label_1.setBounds(107, 167, 78, 22);
		panel.add(label_1);

		userPass = new JTextField();
		userPass.setColumns(10);
		userPass.setBounds(271, 163, 148, 31);
		panel.add(userPass);

		JLabel label_2 = new JLabel("\r\n");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				User user = new User();
				user.setLogin(userLG.getText());
				user.setPassword(userPass.getText());
				AccountManagementDelegate.getProxy().create(user);
				JOptionPane.showMessageDialog(null, "account has been added");
				table_1.setModel(new UserTableModel());

			}
		});
		label_2.setIcon(new ImageIcon(
				AccountManagement.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));
		label_2.setBounds(567, 205, 52, 56);
		panel.add(label_2);

		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table_1.getSelectedRow() == -1) {
					if (table_1.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "the table is empty");
					} else {
						JOptionPane.showMessageDialog(null, "choose a row");
					}
				} else {
					int i = Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0) + "");
					AccountManagementDelegate.doDelete(i);
					table_1.setModel(new UserTableModel());

				}

			}
		});
		btnDelete.setBounds(349, 599, 89, 23);
		contentPane.add(btnDelete);

		JLabel delete = new JLabel("\r\n");
		delete.setIcon(
				new ImageIcon(AccountManagement.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		delete.setBounds(271, 586, 68, 49);
		contentPane.add(delete);

		JLabel lbl_dash = new JLabel("\r\n");
		lbl_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new AdminHome().setVisible(true);
			}
		});
		lbl_dash.setBounds(20, 103, 197, 41);
		contentPane.add(lbl_dash);

		JLabel lbl_accounts = new JLabel((String) null);
		lbl_accounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new AccountManagement().setVisible(true);
			}
		});
		lbl_accounts.setBounds(20, 163, 183, 41);
		contentPane.add(lbl_accounts);

		JLabel lbl_complaints = new JLabel("");
		lbl_complaints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new ComplaintManagement().setVisible(true);
			}
		});
		lbl_complaints.setBounds(10, 231, 207, 58);
		contentPane.add(lbl_complaints);

		JLabel lbl_articles = new JLabel("");
		lbl_articles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new ArticlesManagement().setVisible(true);
			}
		});
		lbl_articles.setBounds(20, 300, 170, 76);
		contentPane.add(lbl_articles);

		JLabel lblNewLabel = new JLabel("Dashboard/Account Management");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblNewLabel.setBounds(316, 103, 331, 27);
		contentPane.add(lblNewLabel);

		JLabel sign_out = new JLabel("");
		sign_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new Authentification().setVisible(true);
			}
		});
		sign_out.setBounds(176, 643, 68, 41);
		contentPane.add(sign_out);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 1235, 705);
		backgroundLabel.setIcon(new ImageIcon(
				AccountManagement.class.getResource("/pdev/financialbrains/client/pictures/backAdminGrand2.PNG")));
		contentPane.add(backgroundLabel);

	}

	private void fermer() {
		this.setVisible(false);
	}
}
