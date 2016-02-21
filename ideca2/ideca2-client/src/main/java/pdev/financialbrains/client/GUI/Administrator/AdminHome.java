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
		setBounds(100, 100, 1226, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashoard = new JLabel("Dashoard");
		lblDashoard.setForeground(Color.WHITE);
		lblDashoard.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblDashoard.setBounds(95, 115, 139, 22);
		contentPane.add(lblDashoard);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AccountManagement().setVisible(true);
				fermer();
			}
		});
		lblNewLabel.setBounds(22, 279, 336, 142);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ArticlesManagement().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_1.setBounds(408, 273, 336, 147);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ComplaintManagement().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_2.setBounds(829, 279, 342, 142);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Authentification().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_3.setBounds(0, 651, 46, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(AdminHome.class.getResource("/pdev/financialbrains/client/pictures/backAdminHome.PNG")));
		background.setBounds(-13, -11, 1229, 710);
		contentPane.add(background);
	}
	private void fermer(){
		this.setVisible(false);
	}

}
