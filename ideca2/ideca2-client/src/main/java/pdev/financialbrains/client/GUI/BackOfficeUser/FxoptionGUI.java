package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.FxManagementDelegate;
import pdev.financialbrains.ejb.entities.ForeignExchangeOption;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FxoptionGUI extends JFrame {
	private JTextField call_put;
	private JTextField current_spot_rate;
	private JTextField domestic_risk_free;
	private JTextField foreign_risk_free;
	private JTextField maturity_date;
	private JTextField strike_price;
	private JTextField volatilite;
	ForeignExchangeOption f;
	//private ForeignExchangeOption f;
	private String callPut;
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FxoptionGUI.class.getResource("/pdev/financialbrains/client/pictures/Forex-Tips.png")));
		label.setBounds(258, 188, 68, 69);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("call / put\r\n");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(414, 174, 73, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Current Spot Rate");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(414, 219, 128, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Domestic Risk Free");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel.setBounds(414, 264, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Foreign Risk Free");
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(414, 312, 90, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Maturity Date");
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(414, 358, 90, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Strike Price");
		lblNewLabel_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(414, 413, 73, 14);
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
		pricing.setBounds(557, 550, 86, 20);
		getContentPane().add(pricing);
		pricing.setColumns(10);
		
		JButton btnPrice = new JButton("price");
		btnPrice.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				f = new ForeignExchangeOption();
				callPut = call_put.getText();
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
		btnPrice.setBounds(374, 549, 89, 23);
		getContentPane().add(btnPrice);
		
		JLabel background = new JLabel("New label");
		background.setBounds(0, 0, 1235, 705);
		background.setIcon(new ImageIcon(FxoptionGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		getContentPane().add(background);
	}
}
