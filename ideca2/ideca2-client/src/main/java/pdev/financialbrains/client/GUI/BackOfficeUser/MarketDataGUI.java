package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.utils.BondTableModel;
import pdev.financialbrains.client.utils.CurrencyTableModel;
import pdev.financialbrains.client.utils.StockTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarketDataGUI extends JFrame {

	private JPanel contentPane;
	private JTable stockTable;
	private JTable bondTable;
	private JTable currencyTable;
	private JLabel deleteLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketDataGUI frame = new MarketDataGUI();
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
	public MarketDataGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel marketDataLabel = new JLabel("");
		marketDataLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MarketDataGUI frame = new MarketDataGUI();
				frame.repaint();
				
			}
		});
		marketDataLabel.setBounds(10, 377, 207, 45);
		contentPane.add(marketDataLabel);
		
		JLabel addMDLabel = new JLabel("");
		addMDLabel.setIcon(new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/add.png")));
		addMDLabel.setBounds(1122, 556, 72, 82);
		contentPane.add(addMDLabel);
		
		deleteLabel = new JLabel("");
		deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		deleteLabel.setIcon(new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		deleteLabel.setBounds(1048, 573, 64, 53);
		contentPane.add(deleteLabel);
		
		JTabbedPane marketTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		marketTabbedPane.setBounds(233, 150, 994, 395);
		contentPane.add(marketTabbedPane);
		
		stockTable = new JTable();
		stockTable.setModel(new StockTableModel());
		marketTabbedPane.addTab("Stock", new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/stock.png")), stockTable, null);
		marketTabbedPane.setEnabledAt(0, true);
		
		bondTable = new JTable();
		bondTable.setModel(new BondTableModel());
		marketTabbedPane.addTab("Bond", new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/bond.png")), bondTable, null);
		
		currencyTable = new JTable();
		currencyTable.setModel(new CurrencyTableModel());
		marketTabbedPane.addTab("Currency", new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/currency.png")), currencyTable, null);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundLabel.setBounds(0, 0, 1227, 687);
		contentPane.add(backgroundLabel);
	}
}
