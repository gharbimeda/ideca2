package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.FixedIncomeSecurityManagementDelegate;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PricingCorporateBond extends JFrame {

	private JPanel contentPane;
	private JTextField tf_faceValue;
	//private JTextField tf_coupon;
	//private JTextField tf_freq;
	private JTextField tf_couponRate;
	private JTextField tf_yield;
	private JTextField tf_price;
	private JTextField tf_time;
	private JTextField tf_interest;
	private JTextField tf_months;
	private JTextField tf_frequency;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PricingCorporateBond frame = new PricingCorporateBond();
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
	public PricingCorporateBond() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel faceValue = new JLabel("Face Value");
		faceValue.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		faceValue.setForeground(Color.DARK_GRAY);
		faceValue.setBounds(243, 224, 130, 43);
		contentPane.add(faceValue);
		
		tf_faceValue = new JTextField();
		tf_faceValue.setBounds(421, 232, 239, 30);
		contentPane.add(tf_faceValue);
		tf_faceValue.setColumns(10);
		
		JLabel lblTimeToMaturity = new JLabel("Coupon Rate");
		lblTimeToMaturity.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblTimeToMaturity.setForeground(Color.DARK_GRAY);
		lblTimeToMaturity.setBounds(243, 301, 130, 43);
		contentPane.add(lblTimeToMaturity);
		
		tf_couponRate = new JTextField();
		tf_couponRate.setColumns(10);
		tf_couponRate.setBounds(421, 308, 239, 32);
		contentPane.add(tf_couponRate);
		
		JLabel lblInterestRateOn = new JLabel("Interest Rate On Bond");
		lblInterestRateOn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblInterestRateOn.setForeground(Color.DARK_GRAY);
		lblInterestRateOn.setBounds(724, 224, 158, 43);
		contentPane.add(lblInterestRateOn);
		

		
		JLabel lblPriceofTheBond = new JLabel("Price Of The Bond");
		lblPriceofTheBond.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblPriceofTheBond.setForeground(Color.DARK_GRAY);
		lblPriceofTheBond.setBounds(724, 575, 158, 43);
		contentPane.add(lblPriceofTheBond);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(923, 581, 239, 31);
		contentPane.add(tf_price);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PricingZeroCouponBond.class.getResource("")));
		lblNewLabel.setBounds(964, 538, 46, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnCalculate = new JButton("");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	FixedIncomeSecuritie f = new FixedIncomeSecuritie();
				Float FaceValue = Float.parseFloat(tf_faceValue.getText());
				Integer TimeToMaturity = Integer.parseInt(tf_time.getText());
				Float CouponRate = Float.parseFloat(tf_couponRate.getText());
				Float InterestRate = Float.parseFloat(tf_interest.getText());
				Integer Frequency = Integer.parseInt(tf_frequency.getText());

				Integer Months = Integer.parseInt(tf_months.getText());

				
				Double Price=FixedIncomeSecurityManagementDelegate.doPriceCorpBond(FaceValue, TimeToMaturity,InterestRate , Frequency, CouponRate, Months);

				tf_price.setText(Price.toString());
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PricingCorporateBond.class.getResource("/pdev/financialbrains/client/pictures/price.png")));
		lblNewLabel_1.setBounds(474, 560, 46, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPricingCorporateBonds = new JLabel("Home/Fixed Income Securities/Pricing Corporate Bonds");
		lblPricingCorporateBonds.setForeground(Color.WHITE);
		lblPricingCorporateBonds.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPricingCorporateBonds.setBounds(325, 109, 478, 41);
		contentPane.add(lblPricingCorporateBonds);
		btnCalculate.setBounds(452, 552, 80, 60);
		contentPane.add(btnCalculate);
		
		JLabel lblTimeToMaturity_1 = new JLabel("Time To Maturity ");
		lblTimeToMaturity_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblTimeToMaturity_1.setForeground(Color.DARK_GRAY);
		lblTimeToMaturity_1.setBounds(243, 412, 145, 43);
		contentPane.add(lblTimeToMaturity_1);
		
		tf_time = new JTextField();
		tf_time.setColumns(10);
		tf_time.setBounds(421, 419, 239, 32);
		contentPane.add(tf_time);
		
		tf_interest = new JTextField();
		tf_interest.setColumns(10);
		tf_interest.setBounds(923, 231, 239, 32);
		contentPane.add(tf_interest);
		
		JLabel lblMonthsUntilNext = new JLabel("Months Until Next Coupon");
		lblMonthsUntilNext.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblMonthsUntilNext.setForeground(Color.DARK_GRAY);
		lblMonthsUntilNext.setBounds(724, 308, 183, 43);
		contentPane.add(lblMonthsUntilNext);
		
		tf_months = new JTextField();
		tf_months.setColumns(10);
		tf_months.setBounds(923, 315, 239, 32);
		contentPane.add(tf_months);
		
		JLabel lblFrequence = new JLabel("Frequency");
		lblFrequence.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblFrequence.setForeground(Color.DARK_GRAY);
		lblFrequence.setBounds(724, 412, 158, 43);
		contentPane.add(lblFrequence);
		
		tf_frequency = new JTextField();
		tf_frequency.setColumns(10);
		tf_frequency.setBounds(923, 421, 239, 29);
		contentPane.add(tf_frequency);
		
		JLabel lb_home = new JLabel("");
		lb_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BackHome b = new BackHome();
				b.setVisible(true);
				fermer();
			}
		});
		lb_home.setBounds(0, 124, 166, 54);
		contentPane.add(lb_home);
		
		JLabel lb_financial = new JLabel("");
		lb_financial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FinancialInstrument f = new FinancialInstrument();
				f.setVisible(true);
				fermer();
			}
		});
		lb_financial.setBounds(0, 213, 183, 67);
		contentPane.add(lb_financial);
		
		JLabel lb_newproduct = new JLabel("");
		lb_newproduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewFinancailInstrument frame = new NewFinancailInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		lb_newproduct.setBounds(0, 308, 194, 54);
		contentPane.add(lb_newproduct);
		
		JLabel lb_marketdata = new JLabel("");
		lb_marketdata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MarketDataGUI m = new MarketDataGUI();
				m.setVisible(true);
				fermer();
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 470, 194, 54);
		contentPane.add(lblNewLabel_2);
		lb_marketdata.setBounds(0, 385, 208, 54);
		contentPane.add(lb_marketdata);
		
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SettlementGUI s = new SettlementGUI();
				s.setVisible(true);
				fermer();
			}
		});
		
		JLabel lb_exit = new JLabel("");
		lb_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authentification a = new Authentification();
				a.setVisible(true);
				fermer();
				
			}
		});
		lb_exit.setBounds(170, 645, 55, 43);
		contentPane.add(lb_exit);
		
		JLabel lb_msg = new JLabel("");
		lb_msg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageManagement m = new MessageManagement();
				m.setVisible(true);
				fermer();
			}
		});
		lb_msg.setBounds(1061, 42, 55, 30);
		contentPane.add(lb_msg);
		backgroundLabel.setIcon(new ImageIcon(PricingCorporateBond.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundLabel.setBounds(-8, 0, 1235, 705);
		contentPane.add(backgroundLabel, BorderLayout.CENTER);
		
	}private void fermer()
	{
		this.setVisible(false);
	}
	}
