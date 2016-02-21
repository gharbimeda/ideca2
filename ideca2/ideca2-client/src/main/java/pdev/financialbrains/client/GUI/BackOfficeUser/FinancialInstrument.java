package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.utils.Util;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinancialInstrument extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_cap;
	private JLabel lbl_equity;
	private JLabel lbl_fxOption ;
	private JLabel lbl_corporate;
	private JLabel lbl_treasury;
	private JLabel lbl_zerocoupon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialInstrument frame = new FinancialInstrument();
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
	public FinancialInstrument() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_zerocoupon = new JLabel("");
		lbl_zerocoupon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PricingZeroCouponBond().setVisible(true);
				fermer();
			}
		});
		lbl_zerocoupon.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/ZCO.PNG")));
		lbl_zerocoupon.setBounds(271, 288, 258, 92);
		contentPane.add(lbl_zerocoupon);
		
		lbl_treasury = new JLabel("");
		lbl_treasury.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TreasuryBondPricing().setVisible(true);
				fermer();
			}
		});
		lbl_treasury.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/treasury.PNG")));
		lbl_treasury.setBounds(271, 403, 258, 55);
		contentPane.add(lbl_treasury);
		
		lbl_corporate = new JLabel("");
		lbl_corporate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PricingCorporateBond().setVisible(true);
				fermer();
			}
		});
		lbl_corporate.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/corporate.PNG")));
		lbl_corporate.setBounds(271, 500, 258, 50);
		contentPane.add(lbl_corporate);
		
		lbl_fxOption = new JLabel("");
		lbl_fxOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FxoptionGUI().setVisible(true);
				fermer();
			}
		});
		lbl_fxOption.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/fxoption.PNG")));
		lbl_fxOption.setBounds(948, 391, 258, 52);
		contentPane.add(lbl_fxOption);
		
	    lbl_equity = new JLabel("");
	    lbl_equity.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		new EquityOptionPricing().setVisible(true);
	    		fermer();
	    	}
	    });
		lbl_equity.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/equity.PNG")));
		lbl_equity.setBounds(948, 310, 258, 50);
		contentPane.add(lbl_equity);
		
		lbl_cap = new JLabel("");
		lbl_cap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CapFloorPricing().setVisible(true);
				fermer();
			}
		});
		lbl_cap.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/cap.PNG")));
		lbl_cap.setBounds(948, 489, 258, 64);
		contentPane.add(lbl_cap);
		lbl_cap.setVisible(false);
		lbl_equity.setVisible(false);
		lbl_fxOption.setVisible(false) ;
		lbl_corporate.setVisible(false);
		lbl_treasury.setVisible(false);
		lbl_zerocoupon.setVisible(false);
		
		JLabel lblHomefinancialInstrument = new JLabel("Home/Financial instrument");
		lblHomefinancialInstrument.setForeground(Color.WHITE);
		lblHomefinancialInstrument.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblHomefinancialInstrument.setBounds(299, 113, 282, 21);
		contentPane.add(lblHomefinancialInstrument);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BackHome().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_1.setBounds(10, 117, 185, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FinancialInstrument().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_2.setBounds(10, 200, 185, 64);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MarketDataGUI().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_3.setBounds(10, 371, 203, 50);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SettlementGUI().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_4.setBounds(10, 458, 203, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.userConnect=null;
				new Authentification().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_5.setBounds(183, 630, 46, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MessageManagement().setVisible(true);
				fermer();
			}
		});
		lblNewLabel_6.setBounds(1075, 23, 46, 45);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_zerocoupon.setVisible(true);
				lbl_treasury.setVisible(true);
				lbl_corporate.setVisible(true);
			}
		});
		lblNewLabel_7.setBounds(282, 167, 243, 106);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_equity.setVisible(true);
				lbl_fxOption.setVisible(true);
				lbl_cap.setVisible(true);
			}
		});
		lblNewLabel_8.setBounds(930, 167, 294, 106);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				fermer();
			}
		});
		lblNewLabel_9.setBounds(592, 160, 294, 113);
		contentPane.add(lblNewLabel_9);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FinancialInstrument.class.getResource("/pdev/financialbrains/client/pictures/finanInstrument2.PNG")));
		lblNewLabel.setBounds(0, 0, 1234, 679);
		contentPane.add(lblNewLabel);
	}
	
	private void fermer(){
		this.setVisible(false);
	}
}
