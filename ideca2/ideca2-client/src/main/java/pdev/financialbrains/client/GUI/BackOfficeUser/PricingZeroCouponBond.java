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

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.FixedIncomeSecurityManagementDelegate;
import pdev.financialbrains.ejb.entities.FixedIncomeSecuritie;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		faceValue.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		faceValue.setForeground(Color.DARK_GRAY);
		faceValue.setBounds(243, 213, 130, 43);
		contentPane.add(faceValue);
		
		tf_faceValue = new JTextField();
		tf_faceValue.setBounds(446, 220, 239, 33);
		contentPane.add(tf_faceValue);
		tf_faceValue.setColumns(10);
		
		JLabel lblTimeToMaturity = new JLabel("Time To Maturity");
		lblTimeToMaturity.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblTimeToMaturity.setForeground(Color.DARK_GRAY);
		lblTimeToMaturity.setBounds(243, 313, 130, 43);
		contentPane.add(lblTimeToMaturity);
		
		JLabel lblPricingZeroCoupon = new JLabel("Home/Fixed Income Securities/Pricing Zero Coupon  Bonds");
		lblPricingZeroCoupon.setForeground(Color.WHITE);
		lblPricingZeroCoupon.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblPricingZeroCoupon.setBounds(315, 114, 503, 41);
		contentPane.add(lblPricingZeroCoupon);
		
		tf_time = new JTextField();
		tf_time.setColumns(10);
		tf_time.setBounds(446, 317, 239, 34);
		contentPane.add(tf_time);
		
		JLabel lblInterestRateOn = new JLabel("Interest Rate On Bond");
		lblInterestRateOn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblInterestRateOn.setForeground(Color.DARK_GRAY);
		lblInterestRateOn.setBounds(243, 401, 176, 43);
		contentPane.add(lblInterestRateOn);
		
		JLabel lblInYears = new JLabel("(In years)");
		lblInYears.setForeground(Color.DARK_GRAY);
		lblInYears.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblInYears.setBounds(688, 315, 130, 43);
		contentPane.add(lblInYears);
		
		tf_rate = new JTextField();
		tf_rate.setColumns(10);
		tf_rate.setBounds(446, 407, 239, 31);
		contentPane.add(tf_rate);
		
		JLabel lblPriceofTheBond = new JLabel("Price Of The Bond");
		lblPriceofTheBond.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblPriceofTheBond.setForeground(Color.DARK_GRAY);
		lblPriceofTheBond.setBounds(843, 510, 153, 43);
		contentPane.add(lblPriceofTheBond);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(1039, 515, 160, 33);
		contentPane.add(tf_price);
		
		JLabel label = new JLabel("%");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
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
		
		JLabel lb_home = new JLabel("");
		lb_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BackHome b = new BackHome();
				b.setVisible(true);
				fermer();
			}
		});
		lb_home.setBounds(-8, 124, 176, 63);
		contentPane.add(lb_home);
		
		JLabel lb_financial = new JLabel("");
		lb_financial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinancialInstrument f = new FinancialInstrument();
				f.setVisible(true);
				fermer();
			}
		});
		lb_financial.setBounds(-8, 213, 204, 67);
		contentPane.add(lb_financial);
		
		JLabel lb_prod = new JLabel("");
		lb_prod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewFinancailInstrument frame = new NewFinancailInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		lb_prod.setBounds(-8, 305, 204, 58);
		contentPane.add(lb_prod);
		
		
		JLabel backgroundLabel = new JLabel("");
		
		
		JLabel lb_marketdata = new JLabel("");
		lb_marketdata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketDataGUI m = new MarketDataGUI();
				m.setVisible(true);
				fermer();
			}
		});
		lb_marketdata.setBounds(2, 383, 204, 63);
		contentPane.add(lb_marketdata);
		
		JLabel lb_set = new JLabel("");
		lb_set.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SettlementGUI s = new SettlementGUI();
				s.setVisible(true);
				fermer();
			}
		});
		lb_set.setBounds(2, 468, 194, 58);
		contentPane.add(lb_set);
		
		JLabel lb_exit = new JLabel("");
		lb_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Authentification a = new Authentification();
				a.setVisible(true);
				fermer();
			}
		});
		lb_exit.setBounds(175, 646, 46, 42);
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
		lb_msg.setBounds(1065, 38, 46, 43);
		contentPane.add(lb_msg);
		backgroundLabel.setIcon(new ImageIcon(PricingZeroCouponBond.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundLabel.setBounds(-8, 0, 1235, 705);
		contentPane.add(backgroundLabel, BorderLayout.CENTER);
		
	}
	public void fermer()
	{
		this.setVisible(false);
	}
}
