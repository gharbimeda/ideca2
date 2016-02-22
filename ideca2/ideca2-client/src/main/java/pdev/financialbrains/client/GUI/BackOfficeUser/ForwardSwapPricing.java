package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.ForwardSwapManagementDelegate;
import pdev.financialbrains.client.utils.Util;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ForwardSwapPricing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStrikeRate;
	private JTextField textFieldRate;
	private JTextField textFieldNotional;
	private JTextField textFieldPeriodLength;
	private JTextField textFieldTimeToExpiry;
	private JTextField textFieldVolatility;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForwardSwapPricing frame = new ForwardSwapPricing();
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
	public ForwardSwapPricing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHomeFinancial = new JLabel("Home / Financial Instrument / Forward Swap ");
		lblHomeFinancial.setForeground(Color.WHITE);
		lblHomeFinancial.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblHomeFinancial.setBounds(318, 107, 363, 41);
		contentPane.add(lblHomeFinancial);
		
		JLabel labelSettlement = new JLabel("");
		labelSettlement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SettlementGUI frame = new SettlementGUI(); 
				frame.setVisible(true);
				fermer();
			}
		});
		
		JLabel labelMarketData = new JLabel("");
		labelMarketData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketDataGUI frame = new MarketDataGUI() ; 
				frame.setVisible(true);
				fermer();
			}
		});
		
		JLabel labelNewProduct = new JLabel("");
		labelNewProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewFinancailInstrument frame = new NewFinancailInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		labelNewProduct.setBounds(10, 300, 204, 61);
		contentPane.add(labelNewProduct);
		
		JLabel labelFinancialInstrument = new JLabel("");
		labelFinancialInstrument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinancialInstrument frame = new FinancialInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		
		JLabel labelHome = new JLabel("");
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BackHome frame = new BackHome();
				frame.setVisible(true);
				fermer();
			}
		});
		
		JLabel labelDisconnect = new JLabel("");
		labelDisconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.userConnect=null;
				new Authentification().setVisible(true);
				fermer();
			}
		});
		labelDisconnect.setBounds(184, 641, 46, 35);
		contentPane.add(labelDisconnect);
		labelHome.setBounds(10, 121, 204, 58);
		contentPane.add(labelHome);
		labelFinancialInstrument.setBounds(10, 209, 204, 63);
		contentPane.add(labelFinancialInstrument);
		labelMarketData.setBounds(10, 372, 204, 64);
		contentPane.add(labelMarketData);
		labelSettlement.setBounds(10, 460, 204, 58);
		contentPane.add(labelSettlement);

		JTextArea textAreaPrice = new JTextArea();
		textAreaPrice.setBounds(898, 380, 135, 50);
		contentPane.add(textAreaPrice);

		JLabel labelPrice = new JLabel("");
		labelPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Double a = ForwardSwapManagementDelegate.getInstance().dopriceForwardSwap(
						Float.parseFloat(textFieldStrikeRate.getText()), Float.parseFloat(textFieldRate.getText()),
						Float.parseFloat(textFieldNotional.getText()),
						Float.parseFloat(textFieldPeriodLength.getText()),
						Float.parseFloat(textFieldTimeToExpiry.getText()),
						Float.parseFloat(textFieldVolatility.getText()));
				textAreaPrice.setText(a.toString());
			}
		});

		labelPrice.setIcon(new ImageIcon(
				ForwardSwapPricing.class.getResource("/pdev/financialbrains/client/pictures/DollarIcon.png")));
		labelPrice.setBounds(791, 372, 55, 72);
		contentPane.add(labelPrice);

		textFieldVolatility = new JTextField();
		textFieldVolatility.setColumns(10);
		textFieldVolatility.setBounds(393, 591, 183, 41);
		contentPane.add(textFieldVolatility);

		JLabel lblVolatility = new JLabel("Volatility");
		lblVolatility.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblVolatility.setBounds(281, 591, 80, 41);
		contentPane.add(lblVolatility);

		textFieldTimeToExpiry = new JTextField();
		textFieldTimeToExpiry.setColumns(10);
		textFieldTimeToExpiry.setBounds(393, 520, 183, 41);
		contentPane.add(textFieldTimeToExpiry);

		JLabel lblTimeToExpiry = new JLabel("Time to expiry");
		lblTimeToExpiry.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblTimeToExpiry.setBounds(281, 520, 101, 41);
		contentPane.add(lblTimeToExpiry);

		textFieldPeriodLength = new JTextField();
		textFieldPeriodLength.setColumns(10);
		textFieldPeriodLength.setBounds(393, 444, 183, 41);
		contentPane.add(textFieldPeriodLength);

		JLabel lblPeriodLength = new JLabel("Period Length");
		lblPeriodLength.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPeriodLength.setBounds(281, 444, 101, 41);
		contentPane.add(lblPeriodLength);

		textFieldNotional = new JTextField();
		textFieldNotional.setColumns(10);
		textFieldNotional.setBounds(393, 372, 183, 41);
		contentPane.add(textFieldNotional);

		JLabel lblNotional = new JLabel("Notional");
		lblNotional.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNotional.setBounds(281, 372, 80, 41);
		contentPane.add(lblNotional);

		textFieldRate = new JTextField();
		textFieldRate.setColumns(10);
		textFieldRate.setBounds(393, 300, 183, 41);
		contentPane.add(textFieldRate);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblRate.setBounds(281, 300, 80, 41);
		contentPane.add(lblRate);

		textFieldStrikeRate = new JTextField();
		textFieldStrikeRate.setBounds(393, 231, 183, 41);
		contentPane.add(textFieldStrikeRate);
		textFieldStrikeRate.setColumns(10);

		JLabel lblStrikeRate = new JLabel("Strike Rate");
		lblStrikeRate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblStrikeRate.setBounds(281, 231, 80, 41);
		contentPane.add(lblStrikeRate);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(
				ForwardSwapPricing.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundLabel.setBounds(0, 0, 1235, 694);
		contentPane.add(backgroundLabel);
	}
	private void fermer() {
		this.setVisible(false);
	}
}
