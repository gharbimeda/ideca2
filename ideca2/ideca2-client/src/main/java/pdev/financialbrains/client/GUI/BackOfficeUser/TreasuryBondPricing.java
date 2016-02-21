package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.FixedIncomeSecurityManagementDelegate;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TreasuryBondPricing extends JFrame {

	private JPanel contentPane;
	private JTextField tf_faceValue;
	private JTextField tf_coupon;
	private JTextField tf_freq;
	private JTextField tf_time;
	private JTextField tf_yield;
	private JTextField tf_price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreasuryBondPricing frame = new TreasuryBondPricing();
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
	public TreasuryBondPricing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_1 = new JLabel("Pricing Treasury Bonds");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setForeground(new Color(0, 102, 102));
		lblNewLabel_1.setBounds(320, 123, 345, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Face Value");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(241, 202, 164, 41);
		contentPane.add(lblNewLabel);
		
		tf_faceValue = new JTextField();
		tf_faceValue.setBounds(451, 207, 234, 30);
		contentPane.add(tf_faceValue);
		tf_faceValue.setColumns(10);
		
		JLabel lblCouponRateOn = new JLabel("Coupon rate on Bond");
		lblCouponRateOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCouponRateOn.setBounds(241, 272, 164, 41);
		contentPane.add(lblCouponRateOn);
		
		tf_coupon = new JTextField();
		tf_coupon.setColumns(10);
		tf_coupon.setBounds(451, 277, 234, 31);
		contentPane.add(tf_coupon);
		
		JLabel label = new JLabel("Frequency Of Coupon");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(241, 350, 164, 41);
		contentPane.add(label);
		
		tf_freq = new JTextField();
		tf_freq.setColumns(10);
		tf_freq.setBounds(451, 357, 234, 31);
		contentPane.add(tf_freq);
		
		JLabel lblTimeToMaturity = new JLabel("Time To Maturity");
		lblTimeToMaturity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimeToMaturity.setBounds(241, 422, 164, 41);
		contentPane.add(lblTimeToMaturity);
		
		tf_time = new JTextField();
		tf_time.setColumns(10);
		tf_time.setBounds(451, 429, 234, 31);
		contentPane.add(tf_time);
		
		JLabel lblCurrentYield = new JLabel("Current Yield");
		lblCurrentYield.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentYield.setBounds(241, 494, 140, 41);
		contentPane.add(lblCurrentYield);
		
		tf_yield = new JTextField();
		tf_yield.setColumns(10);
		tf_yield.setBounds(451, 499, 234, 31);
		contentPane.add(tf_yield);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float FaceValue = Float.parseFloat(tf_faceValue.getText());
				Integer TimeToMaturity = Integer.parseInt(tf_time.getText());
				Float CouponRate= Float.parseFloat(tf_coupon.getText());
				Float CurrentYield=Float.parseFloat(tf_yield.getText());
				Integer Frequency=Integer.parseInt(tf_freq.getText());
				
				//Double Price=FixedIncomeSecurityManagementDelegate.doPriceZeroCouponBond(FaceValue, TimeToMaturity, CurrentYield);

				
				
				Double Price=FixedIncomeSecurityManagementDelegate.doPriceTtreasuryBond(FaceValue, TimeToMaturity , CurrentYield, Frequency, CouponRate);
				 tf_price.setText(Price.toString());
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TreasuryBondPricing.class.getResource("/pdev/financialbrains/client/pictures/price.png")));
		label_1.setBounds(596, 566, 62, 41);
		contentPane.add(label_1);
		btnNewButton.setBounds(569, 566, 89, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblBondPrice = new JLabel("Bond Price");
		lblBondPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBondPrice.setBounds(771, 566, 164, 41);
		contentPane.add(lblBondPrice);
		
		JLabel label_2 = new JLabel("(In years)");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(695, 423, 130, 43);
		contentPane.add(label_2);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(945, 566, 234, 36);
		contentPane.add(tf_price);
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setForeground(Color.DARK_GRAY);
		backgroundLabel.setIcon(new ImageIcon("C:\\IDE\\images\\backBouGrand2.PNG"));
		backgroundLabel.setBounds(0, 11, 1235, 705);
		contentPane.add(backgroundLabel, BorderLayout.CENTER);
	}

}
