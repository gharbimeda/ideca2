package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.FixedIncomeSecurityManagementDelegate;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import java.awt.Font;

public class PricingZeroCouponBond extends JFrame {

	private JPanel contentPane;
	private JTextField tf_faceValue;
	private JTextField tf_time;
	private JTextField tf_rate;
	private JTextField tf_price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PricingZeroCouponBond frame = new PricingZeroCouponBond();
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
	public PricingZeroCouponBond() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel faceValue = new JLabel("Face Value");
		faceValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		faceValue.setForeground(Color.DARK_GRAY);
		faceValue.setBounds(243, 213, 130, 43);
		contentPane.add(faceValue);
		
		tf_faceValue = new JTextField();
		tf_faceValue.setBounds(446, 220, 239, 33);
		contentPane.add(tf_faceValue);
		tf_faceValue.setColumns(10);
		
		JLabel lblTimeToMaturity = new JLabel("Time To Maturity");
		lblTimeToMaturity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimeToMaturity.setForeground(Color.DARK_GRAY);
		lblTimeToMaturity.setBounds(243, 313, 130, 43);
		contentPane.add(lblTimeToMaturity);
		
		JLabel lblPricingZeroCoupon = new JLabel("Pricing Zero Coupon  Bonds");
		lblPricingZeroCoupon.setForeground(new Color(0, 102, 102));
		lblPricingZeroCoupon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblPricingZeroCoupon.setBounds(346, 113, 365, 41);
		contentPane.add(lblPricingZeroCoupon);
		
		tf_time = new JTextField();
		tf_time.setColumns(10);
		tf_time.setBounds(446, 317, 239, 34);
		contentPane.add(tf_time);
		
		JLabel lblInterestRateOn = new JLabel("Interest Rate On Bond");
		lblInterestRateOn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInterestRateOn.setForeground(Color.DARK_GRAY);
		lblInterestRateOn.setBounds(243, 401, 176, 43);
		contentPane.add(lblInterestRateOn);
		
		JLabel lblInYears = new JLabel("(In years)");
		lblInYears.setForeground(Color.DARK_GRAY);
		lblInYears.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInYears.setBounds(688, 315, 130, 43);
		contentPane.add(lblInYears);
		
		tf_rate = new JTextField();
		tf_rate.setColumns(10);
		tf_rate.setBounds(446, 407, 239, 31);
		contentPane.add(tf_rate);
		
		JLabel lblPriceofTheBond = new JLabel("Price Of The Bond");
		lblPriceofTheBond.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPriceofTheBond.setForeground(Color.DARK_GRAY);
		lblPriceofTheBond.setBounds(843, 510, 153, 43);
		contentPane.add(lblPriceofTheBond);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(1039, 515, 160, 33);
		contentPane.add(tf_price);
		
		JLabel label = new JLabel("%");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(693, 401, 46, 43);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PricingZeroCouponBond.class.getResource("")));
		lblNewLabel.setBounds(964, 538, 46, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnCalculate = new JButton("");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FixedIncomeSecuritie f = new FixedIncomeSecuritie();
				Float FaceValue=Float.parseFloat(tf_faceValue.getText());
				Integer TimeToMaturity=Integer.parseInt(tf_time.getText());
				Float CurrentYield=Float.parseFloat(tf_rate.getText());
				Double Price=FixedIncomeSecurityManagementDelegate.doPriceZeroCouponBond(FaceValue, TimeToMaturity, CurrentYield);

				//Double Price=Fixe.getInstance().priceZeroCouponBond(FaceValue, TimeToMaturity, CurrentYield);

				tf_price.setText(Price.toString());
				//f.setTimeMaturity(Date.parse(s)(tf_time.getText()));
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PricingZeroCouponBond.class.getResource("/pdev/financialbrains/client/pictures/price.png")));
		lblNewLabel_1.setBounds(741, 507, 57, 58);
		contentPane.add(lblNewLabel_1);
		btnCalculate.setBounds(725, 507, 68, 58);
		contentPane.add(btnCalculate);
		
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon("C:\\IDE\\images\\backBouGrand2.PNG"));
		backgroundLabel.setBounds(-8, 0, 1235, 705);
		contentPane.add(backgroundLabel, BorderLayout.CENTER);
		
	}
}
