package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.AccountManagementDelegate;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1226, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashoard = new JLabel("Dashoard");
		lblDashoard.setForeground(Color.WHITE);
		lblDashoard.setFont(new Font("Berlin Sans FB", Font.BOLD, 17));
		lblDashoard.setBounds(320, 98, 139, 22);
		contentPane.add(lblDashoard);
		
		JLabel lbl_dash = new JLabel("");
		lbl_dash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				new AdminHome().setVisible(true);
			}
		});
		lbl_dash.setBounds(10, 98, 211, 37);
		contentPane.add(lbl_dash);
		
		JLabel lbl_account = new JLabel("");
		lbl_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				//new AccountManagement().setVisible(true);
			}
		});
		lbl_account.setBounds(10, 162, 211, 37);
		contentPane.add(lbl_account);
		
		JLabel lblcomplaint = new JLabel("");
		lblcomplaint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				new ComplaintManagement().setVisible(true);
			}
		});
		lblcomplaint.setBounds(10, 228, 211, 47);
		contentPane.add(lblcomplaint);
		
		JLabel lbl_article = new JLabel("");
		lbl_article.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				new ArticlesManagement().setVisible(true);
			}
		});
		lbl_article.setBounds(10, 297, 211, 47);
		contentPane.add(lbl_article);
		
		JLabel signout = new JLabel("");
		signout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				new Authentification().setVisible(true);
			}
		});
		signout.setBounds(182, 645, 46, 26);
		contentPane.add(signout);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(AdminHome.class.getResource("/pdev/financialbrains/client/pictures/backAdminGrand2.PNG")));
		background.setBounds(0, 0, 1216, 688);
		contentPane.add(background);
	}
	private void fermer(){
		this.setVisible(false);
	}

}
