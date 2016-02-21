package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.EquityOptionManagementDelegate;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquityOptionPricing extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cp;
	private JTextField tf_stock;
	private JTextField tf_date;
	private JTextField tf_rate;
	private JTextField tf_volatility;

	
	private JTextField tf_resultat;
	private JTextField tf_strike;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquityOptionPricing frame = new EquityOptionPricing();
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
	public EquityOptionPricing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1226, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalculate = new JButton("");
		btnCalculate.setBackground(Color.WHITE);
		btnCalculate.setIcon(new ImageIcon(EquityOptionPricing.class.getResource("/pdev/financialbrains/client/pictures/privsign.png")));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String	type =(tf_cp.getText());
			Double	 s = Double.parseDouble(tf_stock.getText());
			Double x= Double.parseDouble(tf_strike.getText());
			Double t= Double.parseDouble(tf_date.getText());
			Double r= Double.parseDouble(tf_rate.getText());
			Double	 v= Double.parseDouble(tf_volatility.getText());
				
			Double	 option = EquityOptionManagementDelegate.doBlackScholes("type", s, x, t, r, v);
				
					tf_resultat.setText(option.toString());
				
				
				
				
			}
		});
		
		JLabel lb_home = new JLabel("");
		lb_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new BackHome().setVisible(true);
				fermer();
			}
		});
		
		JLabel lb_fininst = new JLabel("");
		lb_fininst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JLabel lb_sett = new JLabel("");
		lb_sett.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SettlementGUI().setVisible(true);
				fermer();
			}
		});
		lb_sett.setBounds(0, 464, 217, 57);
		contentPane.add(lb_sett);
		
		JLabel lb_marketdata = new JLabel("");
		lb_marketdata.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new MarketDataGUI().setVisible(true);
				fermer();
			}
		});
		lb_marketdata.setBounds(10, 378, 215, 57);
		contentPane.add(lb_marketdata);
		lb_fininst.setBounds(10, 216, 215, 66);
		contentPane.add(lb_fininst);
		
		JLabel lb_newproduct = new JLabel("");
		lb_newproduct.setBounds(10, 299, 215, 57);
		contentPane.add(lb_newproduct);
		lb_home.setBounds(10, 118, 207, 57);
		contentPane.add(lb_home);
		
		JLabel lblEquityOption = new JLabel("Equity option ");
		lblEquityOption.setFont(new Font("Algerian", Font.BOLD, 17));
		lblEquityOption.setForeground(new Color(95, 158, 160));
		lblEquityOption.setBounds(425, 109, 285, 29);
		contentPane.add(lblEquityOption);
		
		JLabel lblOptionPrice = new JLabel("Option Price");
		lblOptionPrice.setFont(new Font("Algerian", Font.BOLD, 16));
		lblOptionPrice.setBounds(624, 573, 159, 29);
		contentPane.add(lblOptionPrice);
		
		JLabel lblStockReturnVolatility = new JLabel("Stock Return Volatility");
		lblStockReturnVolatility.setFont(new Font("Algerian", Font.BOLD, 15));
		lblStockReturnVolatility.setBounds(645, 406, 215, 29);
		contentPane.add(lblStockReturnVolatility);
		
		JLabel lblNewLabel_1 = new JLabel("Risk Free Rate");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 15));
		lblNewLabel_1.setBounds(684, 296, 166, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Remaining Time to expiry");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 15));
		lblNewLabel.setBounds(268, 454, 245, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblStrikzPrice = new JLabel("Strike Price");
		lblStrikzPrice.setFont(new Font("Algerian", Font.BOLD, 15));
		lblStrikzPrice.setBounds(348, 378, 121, 21);
		contentPane.add(lblStrikzPrice);
		
		tf_strike = new JTextField();
		tf_strike.setBounds(512, 378, 123, 29);
		contentPane.add(tf_strike);
		tf_strike.setColumns(10);
		
		tf_resultat = new JTextField();
		tf_resultat.setBounds(793, 573, 109, 29);
		contentPane.add(tf_resultat);
		tf_resultat.setColumns(10);
		btnCalculate.setBounds(482, 558, 109, 66);
		contentPane.add(btnCalculate);
		
		tf_volatility = new JTextField();
		tf_volatility.setBounds(860, 407, 112, 29);
		contentPane.add(tf_volatility);
		tf_volatility.setColumns(10);
		
		tf_rate = new JTextField();
		tf_rate.setBounds(860, 303, 112, 29);
		contentPane.add(tf_rate);
		tf_rate.setColumns(10);
		
		tf_date = new JTextField();
		tf_date.setBounds(512, 464, 123, 29);
		contentPane.add(tf_date);
		tf_date.setColumns(10);
		
		JLabel lblStockPrice = new JLabel("Stock Price ");
		lblStockPrice.setFont(new Font("Algerian", Font.BOLD, 15));
		lblStockPrice.setBounds(348, 316, 135, 29);
		contentPane.add(lblStockPrice);
		
		tf_stock = new JTextField();
		tf_stock.setBounds(512, 312, 123, 29);
		contentPane.add(tf_stock);
		tf_stock.setColumns(10);
		
		tf_cp = new JTextField();
		tf_cp.setBounds(512, 251, 123, 29);
		contentPane.add(tf_cp);
		tf_cp.setColumns(10);
		
		JLabel lb_call = new JLabel("Call  / Put ");
		lb_call.setFont(new Font("Algerian", Font.BOLD, 16));
		lb_call.setBounds(346, 245, 123, 39);
		contentPane.add(lb_call);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\IDE\\images\\backBouGrand2.PNG"));
		
		label.setBounds(0, 0, 1210, 695);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(90, 97, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(EquityOptionPricing.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		label_2.setBounds(171, 283, 98, 121);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(171, 390, 46, 14);
		contentPane.add(label_3);
	}
	
	private void fermer(){
		this.setVisible(false);
	}
}
