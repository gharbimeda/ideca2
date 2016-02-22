package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pdev.financialbrains.client.GUI.Administrator.AdminHome;
import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.FxManagementDelegate;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FxoptionGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField call_put;
	private JTextField current_spot_rate;
	private JTextField domestic_risk_free;
	private JTextField foreign_risk_free;
	private JTextField maturity_date;
	private JTextField strike_price;
	private JTextField volatilite;
	ForeignExchangeOption f;
	//private ForeignExchangeOption f;
	private Integer callPut;
	private Integer dRisk;
	private Integer fRisk;
	private Integer currentSpotRate;
	private Integer time;
	private Float strikePrice;
	private Float volati;
	private JTextField pricing;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FxoptionGUI frame = new FxoptionGUI();
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
	public FxoptionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1242, 780);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Call  0 / Put 1\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(414, 174, 107, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Current Spot Rate");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(414, 219, 128, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Domestic Risk Free");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(414, 264, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Foreign Risk Free");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(414, 312, 107, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Maturity Date");
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(414, 358, 90, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Strike Price");
		lblNewLabel_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(414, 412, 73, 14);
		getContentPane().add(lblNewLabel_5);
		
		call_put = new JTextField();
		call_put.setBounds(582, 171, 86, 20);
		getContentPane().add(call_put);
		call_put.setColumns(10);
		
		domestic_risk_free = new JTextField();
		domestic_risk_free.setBounds(582, 261, 86, 20);
		getContentPane().add(domestic_risk_free);
		domestic_risk_free.setColumns(10);
		
		current_spot_rate = new JTextField();
		current_spot_rate.setBounds(582, 216, 86, 20);
		getContentPane().add(current_spot_rate);
		current_spot_rate.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Volatility");
		lblNewLabel_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(414, 474, 90, 14);
		getContentPane().add(lblNewLabel_6);
		
		foreign_risk_free = new JTextField();
		foreign_risk_free.setBounds(582, 309, 86, 20);
		getContentPane().add(foreign_risk_free);
		foreign_risk_free.setColumns(10);
		
		maturity_date = new JTextField();
		maturity_date.setBounds(582, 355, 86, 20);
		getContentPane().add(maturity_date);
		maturity_date.setColumns(10);
		
		strike_price = new JTextField();
		strike_price.setBounds(582, 410, 86, 20);
		getContentPane().add(strike_price);
		strike_price.setColumns(10);
		
		volatilite = new JTextField();
		volatilite.setBounds(582, 471, 86, 20);
		getContentPane().add(volatilite);
		volatilite.setColumns(10);
		
		pricing = new JTextField();
		pricing.setBounds(557, 550, 159, 20);
		getContentPane().add(pricing);
		pricing.setColumns(10);
		
		JButton btnPrice = new JButton("    price");
		
		btnPrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnPrice.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				f = new ForeignExchangeOption();
				callPut = Integer.parseInt(call_put.getText());
				dRisk = Integer.parseInt(domestic_risk_free.getText());
				fRisk = Integer.parseInt(foreign_risk_free.getText());
				currentSpotRate = Integer.parseInt(current_spot_rate.getText());
				time = Integer.parseInt(maturity_date.getText());
				strikePrice = Float.parseFloat(strike_price.getText());
				volati = Float.parseFloat(volatilite.getText());
				Double Pricing=FxManagementDelegate.getInstance().Price(callPut, currentSpotRate, dRisk, fRisk, time, strikePrice, volati);
				System.out.println(Pricing);
				pricing.setText(Pricing.toString());
				
				
				
				
				
			}
		});
		
		JLabel dollar = new JLabel("");
		dollar.setIcon(new ImageIcon(FxoptionGUI.class.getResource("/pdev/financialbrains/client/pictures/price-label1.png")));
		dollar.setBounds(355, 550, 32, 28);
		getContentPane().add(dollar);
		btnPrice.setBounds(355, 549, 108, 32);
		getContentPane().add(btnPrice);
		
		JLabel lblNewLabel_7 = new JLabel("Home / Financial instrument / FX Option");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblNewLabel_7.setBounds(297, 111, 384, 38);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lbl_home = new JLabel("");
		lbl_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new AdminHome().setVisible(true);
			}
		});
		lbl_home.setBounds(0, 124, 186, 64);
		getContentPane().add(lbl_home);
		
		JLabel lbl_financial = new JLabel("");
		lbl_financial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new FinancialInstrument().setVisible(true);
							}
		});
		lbl_financial.setBounds(0, 199, 186, 98);
		getContentPane().add(lbl_financial);
		
		JLabel lbl = new JLabel("");
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewFinancailInstrument frame = new NewFinancailInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		lbl.setBounds(0, 313, 211, 64);
		getContentPane().add(lbl);
		
		JLabel background = new JLabel("New label");
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		JLabel lbl_market = new JLabel("");
		lbl_market.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new MarketDataGUI().setVisible(true);
			}
			
		});
		lbl_market.setBounds(0, 388, 219, 54);
		getContentPane().add(lbl_market);
		
		JLabel lbl_settelement = new JLabel("");
		lbl_settelement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new SettlementGUI().setVisible(true);
			}
		});
		lbl_settelement.setBounds(10, 453, 186, 81);
		getContentPane().add(lbl_settelement);
		
		JLabel sign_out = new JLabel("\r\n");
		sign_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new Authentification().setVisible(true);
			}
		});
		sign_out.setBounds(175, 637, 56, 54);
		getContentPane().add(sign_out);
		
		JLabel lbl_message = new JLabel("");
		lbl_message.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fermer();
				new MessageManagement();
			}
		});
		lbl_message.setBounds(1069, 36, 61, 43);
		getContentPane().add(lbl_message);
		background.setBounds(0, 0, 1235, 705);
		background.setIcon(new ImageIcon(FxoptionGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		getContentPane().add(background);
	}
	private void fermer() {
		this.setVisible(false);
	}
}
