package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.*;
import java.util.Random;

public class CapFloorPricing extends JFrame {

	private JPanel contentPane;
	private JTextField tf_startDate;
	private JTextField tf_EndDate;
	private JTextField tf_days;
	private JTextField tf_notionalAmount;
	private JTextField tf_FRate;
	private JTextField tf_rfr;
	private JTextField tf_Strike;
	private JTextField tf_volatility;
	private JTextField tf_cap;
	private JTextField tf_floor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapFloorPricing frame = new CapFloorPricing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private double N(){
		Random random = new Random();
		random.nextGaussian();
		return 0.0;
	}

	/**
	 * Create the frame.
	 */
	public CapFloorPricing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(661, 188, 546, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		tf_cap = new JTextField();
		tf_cap.setBounds(99, 22, 86, 20);
		panel_1.add(tf_cap);
		tf_cap.setColumns(10);
		
		tf_floor = new JTextField();
		tf_floor.setBounds(99, 72, 86, 20);
		panel_1.add(tf_floor);
		tf_floor.setColumns(10);
		
		JButton btnPricing = new JButton("Pricing");
		btnPricing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPricing.setBounds(34, 397, 89, 23);
		panel_1.add(btnPricing);
		
		JLabel lblHomeFianancial = new JLabel("Home / Fianancial Instrument / Cap and Floor");
		lblHomeFianancial.setForeground(Color.WHITE);
		lblHomeFianancial.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblHomeFianancial.setBounds(312, 112, 344, 22);
		contentPane.add(lblHomeFianancial);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(250, 188, 375, 431);
		contentPane.add(panel);
		
		JLabel lblInputs = new JLabel("INPUTS");
		lblInputs.setBounds(10, 11, 96, 18);
		lblInputs.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblStartDate.setBounds(20, 43, 68, 14);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblEndDate.setBounds(26, 80, 120, 14);
		
		JLabel lblNewLabel = new JLabel("Day Convention");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 115, 120, 14);
		
		JLabel lblTenor = new JLabel("Tenor");
		lblTenor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblTenor.setBounds(26, 153, 120, 14);
		
		JLabel lblNumberOfDays = new JLabel("Number of days");
		lblNumberOfDays.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNumberOfDays.setBounds(26, 188, 120, 14);
		
		JLabel lblNotionalAmount = new JLabel("Notional amount");
		lblNotionalAmount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNotionalAmount.setBounds(26, 229, 120, 14);
		
		JLabel lblReferenceIndex = new JLabel("Reference index");
		lblReferenceIndex.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblReferenceIndex.setBounds(26, 264, 120, 14);
		
		JLabel lblRiskFreeRate = new JLabel("Risk Free Rate");
		lblRiskFreeRate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblRiskFreeRate.setBounds(26, 299, 120, 14);
		
		JLabel lblYearForward = new JLabel("1.0 Year forward Rate");
		lblYearForward.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblYearForward.setBounds(26, 337, 120, 14);
		
		JLabel lblStrikePrice = new JLabel("Strike Price");
		lblStrikePrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblStrikePrice.setBounds(26, 372, 120, 14);
		
		JLabel lblVolatility = new JLabel("Volatility");
		lblVolatility.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblVolatility.setBounds(26, 404, 120, 14);
		
		JLabel lblCapFloor = new JLabel("Cap / Floor");
		lblCapFloor.setBounds(169, 11, 74, 18);
		lblCapFloor.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		
		JComboBox cb_capFloor = new JComboBox();
		cb_capFloor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cb_capFloor.setBounds(261, 10, 70, 20);
		cb_capFloor.setModel(new DefaultComboBoxModel(new String[] {"Choice", "Cap", "Floor"}));
		cb_capFloor.setToolTipText("");
		
		tf_startDate = new JTextField();
		tf_startDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_startDate.setBounds(156, 40, 167, 20);
		tf_startDate.setColumns(10);
		
		tf_EndDate = new JTextField();
		tf_EndDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_EndDate.setBounds(156, 80, 168, 20);
		tf_EndDate.setText("");
		tf_EndDate.setColumns(10);
		
		JComboBox cb_dayConv = new JComboBox();
		cb_dayConv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cb_dayConv.setBounds(157, 111, 73, 20);
		cb_dayConv.setModel(new DefaultComboBoxModel(new String[] {"act/360", "act/365", "30/360"}));
		
		JComboBox cb_Tenor = new JComboBox();
		cb_Tenor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cb_Tenor.setBounds(157, 149, 73, 20);
		cb_Tenor.setModel(new DefaultComboBoxModel(new String[] {"3", "6", "12"}));
		
		tf_days = new JTextField();
		tf_days.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_days.setBounds(156, 184, 74, 20);
		tf_days.setColumns(10);
		
		tf_notionalAmount = new JTextField();
		tf_notionalAmount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_notionalAmount.setBounds(156, 225, 167, 20);
		tf_notionalAmount.setColumns(10);
		
		tf_FRate = new JTextField();
		tf_FRate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_FRate.setBounds(156, 333, 86, 20);
		tf_FRate.setColumns(10);
		
		JLabel lblLibor = new JLabel("LIBOR");
		lblLibor.setFont(new Font("Berlin Sans FB", Font.BOLD, 13));
		lblLibor.setBounds(156, 263, 52, 14);
		
		tf_rfr = new JTextField();
		tf_rfr.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_rfr.setBounds(156, 295, 86, 20);
		tf_rfr.setColumns(10);
		panel.setLayout(null);
		panel.add(lblInputs);
		panel.add(lblCapFloor);
		panel.add(cb_capFloor);
		panel.add(lblStrikePrice);
		panel.add(lblVolatility);
		panel.add(lblNumberOfDays);
		panel.add(tf_days);
		panel.add(lblNewLabel);
		panel.add(lblTenor);
		panel.add(cb_Tenor);
		panel.add(cb_dayConv);
		panel.add(lblNotionalAmount);
		panel.add(tf_notionalAmount);
		panel.add(lblEndDate);
		panel.add(tf_EndDate);
		panel.add(lblStartDate);
		panel.add(tf_startDate);
		panel.add(lblYearForward);
		panel.add(lblReferenceIndex);
		panel.add(lblRiskFreeRate);
		panel.add(lblLibor);
		panel.add(tf_rfr);
		panel.add(tf_FRate);
		
		tf_Strike = new JTextField();
		tf_Strike.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_Strike.setBounds(157, 368, 86, 20);
		panel.add(tf_Strike);
		tf_Strike.setColumns(10);
		
		tf_volatility = new JTextField();
		tf_volatility.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_volatility.setBounds(157, 400, 86, 20);
		panel.add(tf_volatility);
		tf_volatility.setColumns(10);
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon("C:\\IDE\\images\\backBouGrand2.PNG"));
		BackGround.setBounds(5, 0, 1235, 689);
		contentPane.add(BackGround);
	}
}
