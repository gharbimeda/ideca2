package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import com.toedter.calendar.JDateChooser;

import pdev.financialbrains.ejb.entities.CapFloorTable;
import pdev.financialbrains.ejb.services.CalculCapFloor;

public class CapFloorPricing extends JFrame {

	private JPanel contentPane;
	private JDateChooser tf_startDate;
	private JDateChooser tf_EndDate;
	private JTextField tf_days;
	private JTextField tf_notionalAmount;
	private JTextField tf_FRate;
	private JTextField tf_rfr;
	private JTextField tf_Strike;
	private JTextField tf_volatility;
	private JComboBox<Integer> cb_Tenor;
	private JTable table;
	private List<CapFloorTable> list = new ArrayList <>();
	private JScrollPane scrollPane;
	private JDateChooser valDate;
	private Integer nd;

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
	
	private double nbPeriode(){
		
		Integer tenor = (Integer) cb_Tenor.getSelectedItem();
		 return nDays()/tenor;
	}
	
	private Integer nDays(){
		Date date1 = tf_startDate.getDate();
		Date date2 = tf_EndDate.getDate();
		Integer nbJour = Math.abs((date2.getYear() - date1.getYear())*12 + (date2.getMonth() - date1.getMonth())) ;
		return nbJour;
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
		panel_1.setBounds(661, 188, 546, 450);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		cb_Tenor = new JComboBox();
		cb_Tenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 nd = CalculCapFloor.nDays((Integer) cb_Tenor.getSelectedItem());
				tf_days.setText(nd+"");
			}
		});
		cb_Tenor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cb_Tenor.setBounds(258, 112, 73, 20);
		cb_Tenor.setModel(new DefaultComboBoxModel(new Integer[] {3, 6, 12}));
		
		JButton btnPricing = new JButton("Pricing");
		btnPricing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//tf_rfr.setText(tf_EndDate.getDate()+"");
				//tf_FRate.setText(nbPeriode()+"");
				SimpleDateFormat formater = null;
				formater = new SimpleDateFormat("dd/MM/yyyy");
				
				Calendar date1 = tf_startDate.getCalendar();
				Calendar date2 = valDate.getCalendar();
				Integer n = 0;
				List<CapFloorTable> capFloorTables = new ArrayList<>();
				for (int i=1 ; i<= nbPeriode(); i++){
					CapFloorTable capFloorTable = new CapFloorTable();
					capFloorTable.setStartDate(formater.format(date1.getTime()));
					date1.add(Calendar.DATE, nd);
					capFloorTable.setEndDate(formater.format(date1.getTime()));
					n = Math.abs((date2.getTime().getYear() - date1.getTime().getYear())*12 + (date2.getTime().getMonth() - date1.getTime().getMonth()));
					capFloorTable.setMaturity(n/365.0);
					capFloorTables.add(capFloorTable);
				}
				list = capFloorTables;
				initDataBindings();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
						.addComponent(btnPricing, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(btnPricing)
					.addGap(25))
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblHomeFianancial = new JLabel("Home / Fianancial Instrument / Cap and Floor");
		lblHomeFianancial.setForeground(Color.WHITE);
		lblHomeFianancial.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		lblHomeFianancial.setBounds(312, 112, 344, 22);
		contentPane.add(lblHomeFianancial);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(250, 188, 375, 450);
		contentPane.add(panel);
		
		JLabel lblInputs = new JLabel("INPUTS");
		lblInputs.setBounds(10, 11, 96, 18);
		lblInputs.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblStartDate.setBounds(26, 40, 68, 14);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblEndDate.setBounds(26, 80, 120, 14);
		
		JLabel lblNewLabel = new JLabel("Day Convention");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 115, 120, 14);
		
		JLabel lblTenor = new JLabel("Tenor");
		lblTenor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblTenor.setBounds(211, 115, 45, 14);
		
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
		
		tf_startDate = new JDateChooser();
		tf_startDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_startDate.setBounds(156, 40, 167, 20);
		
		
		tf_EndDate = new JDateChooser();
		tf_EndDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		tf_EndDate.setBounds(156, 80, 168, 20);
		
		//tf_EndDate.setColumns(10);
		
		JComboBox cb_dayConv = new JComboBox();
		cb_dayConv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cb_dayConv.setBounds(118, 112, 73, 20);
		cb_dayConv.setModel(new DefaultComboBoxModel(new String[] {"act/360", "act/365", "30/360"}));
		
	    
		
		tf_days = new JTextField();
		tf_days.setEnabled(false);
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
		
		JLabel lblValuationDate = new JLabel("Valuation Date");
		lblValuationDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblValuationDate.setBounds(26, 155, 120, 14);
		panel.add(lblValuationDate);
		
	    valDate = new JDateChooser();
		valDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		valDate.setBounds(156, 153, 167, 20);
		panel.add(valDate);
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon("C:\\IDE\\images\\backBouGrand2.PNG"));
		BackGround.setBounds(5, 0, 1235, 689);
		contentPane.add(BackGround);
		initDataBindings();
		
	}
	protected void initDataBindings() {
		ObjectProperty<JScrollPane> jScrollPaneObjectProperty = ObjectProperty.create();
		AutoBinding<List<CapFloorTable>, List<CapFloorTable>, JScrollPane, JScrollPane> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, list, scrollPane, jScrollPaneObjectProperty);
		autoBinding.bind();
		//
		JTableBinding<CapFloorTable, List<CapFloorTable>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, list, table);
		//
		BeanProperty<CapFloorTable, Calendar> capFloorTableBeanProperty = BeanProperty.create("startDate");
		jTableBinding.addColumnBinding(capFloorTableBeanProperty).setColumnName("Start Date");
		//
		BeanProperty<CapFloorTable, Calendar> capFloorTableBeanProperty_1 = BeanProperty.create("endDate");
		jTableBinding.addColumnBinding(capFloorTableBeanProperty_1).setColumnName("End Date");
		//
		BeanProperty<CapFloorTable, Double> capFloorTableBeanProperty_2 = BeanProperty.create("maturity");
		jTableBinding.addColumnBinding(capFloorTableBeanProperty_2).setColumnName("Maturity");
		//
		BeanProperty<CapFloorTable, Double> capFloorTableBeanProperty_3 = BeanProperty.create("d1");
		jTableBinding.addColumnBinding(capFloorTableBeanProperty_3).setColumnName("d 1");
		//
		BeanProperty<CapFloorTable, Double> capFloorTableBeanProperty_4 = BeanProperty.create("cap");
		jTableBinding.addColumnBinding(capFloorTableBeanProperty_4).setColumnName("Cap/Floor");
		//
		jTableBinding.bind();
	}
}
