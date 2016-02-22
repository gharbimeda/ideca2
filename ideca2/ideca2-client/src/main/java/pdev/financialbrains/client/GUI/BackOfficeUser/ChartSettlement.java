package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.TradeManagementDelegate;
import pdev.financialbrains.client.utils.Util;
import pdev.financialbrains.ejb.entities.Generic;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChartSettlement extends JFrame {
	JPanel panel;
	Component[] components;
	JTextField field;
	JTextArea area;
	JComboBox box;
	Generic generic = new Generic();
	private JTable tableNewProduct;

	public ChartSettlement() {
		getContentPane().setLayout(null);

		JPanel panelChart = new JPanel();
		JFreeChart chart = createChart(createDataset());
		panelChart = new ChartPanel(chart);
		panelChart.setBounds(341, 173, 775, 406);
		getContentPane().add(panelChart);

		JLabel labelHome = new JLabel("");
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BackHome frame = new BackHome();
				frame.setVisible(true);
				fermer();
			}
		});
		labelHome.setBounds(10, 111, 207, 51);
		getContentPane().add(labelHome);

		JLabel labelFinancialInstrument = new JLabel("");
		labelFinancialInstrument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinancialInstrument frame = new FinancialInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		labelFinancialInstrument.setBounds(10, 197, 207, 63);
		getContentPane().add(labelFinancialInstrument);

		JLabel labelNewProduct = new JLabel("");
		labelNewProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewFinancailInstrument frame = new NewFinancailInstrument();
				frame.setVisible(true);
				fermer();
			}
		});
		labelNewProduct.setBounds(10, 288, 207, 51);
		getContentPane().add(labelNewProduct);

		JLabel labelMarketData = new JLabel("");
		labelMarketData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketDataGUI frame = new MarketDataGUI();
				frame.setVisible(true);
				fermer();
			}
		});
		labelMarketData.setBounds(10, 360, 207, 57);
		getContentPane().add(labelMarketData);

		JLabel labelSettlement = new JLabel("");
		labelSettlement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SettlementGUI frame = new SettlementGUI();
				frame.setVisible(true);
				fermer();
			}
		});
		labelSettlement.setBounds(10, 446, 207, 57);
		getContentPane().add(labelSettlement);

		JLabel labelDisconnect = new JLabel("");
		labelDisconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.userConnect = null;
				new Authentification().setVisible(true);
				fermer();
			}
		});
		labelDisconnect.setBounds(185, 622, 46, 43);
		getContentPane().add(labelDisconnect);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				NewFinancailInstrument.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		lblNewLabel.setBounds(0, 0, 1208, 665);
		getContentPane().add(lblNewLabel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1220, 700);
		setVisible(true);
	}

	private static PieDataset createDataset() {
		// List<Claim>claims;
		Integer nbAccpeted;
		Integer nbRefused;

		nbAccpeted = TradeManagementDelegate.getInstance().doReadAccepted();
		nbRefused = TradeManagementDelegate.getInstance().doReadRefused();

		System.out.println(nbAccpeted);
		System.out.println(nbRefused);

		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("Settlement accepted", nbAccpeted);
		dataset.setValue("Settlement refused", nbRefused);

		return dataset;

	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Settlement Statistic", // chart
				// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		ChartSettlement acojfar = new ChartSettlement();

	}

	private void fermer() {
		this.setVisible(false);
	}
}