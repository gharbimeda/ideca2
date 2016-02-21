package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.client.utils.BondTableModel;
import pdev.financialbrains.client.utils.CurrencyTableModel;
import pdev.financialbrains.client.utils.StockTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class MarketDataGUI extends JFrame {

	private JPanel contentPane;
	private JTable stockTable;
	private JTable bondTable;
	private JTable currencyTable;
	private JLabel deleteLabel;
	private JScrollPane CurrencyScrollPane;
	private JScrollPane BondScrollPane;
	private JScrollPane StockScrollPane;
	private JLabel titreLabel;

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
//		setLocationRelativeTo(null);
//		setUndecorated(true);
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
				recharger();

			}
		});
		marketDataLabel.setBounds(10, 377, 207, 45);
		contentPane.add(marketDataLabel);

		JLabel addMDLabel = new JLabel("");
		addMDLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddMarketDataGUI frame = new AddMarketDataGUI(); 
				frame.setVisible(true);
				fermer();
			}
		});
		addMDLabel.setIcon(
				new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/add.png")));
		addMDLabel.setBounds(1122, 556, 72, 82);
		contentPane.add(addMDLabel);

		deleteLabel = new JLabel("");
		deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (stockTable.getSelectedRow() != -1) {
					try {
						StockManagementDelegate.getInstance().doDelete(StockManagementDelegate.getInstance()
								.doReadById((int) stockTable.getValueAt(stockTable.getSelectedRow(), 0)));
						JOptionPane.showMessageDialog(null, "Suppression effectué !");
						stockTable.setModel(new StockTableModel());
						
					} catch (Exception erreur) {
						JOptionPane.showMessageDialog(null, "Suppression non effectué !");
					}
				} else if (bondTable.getSelectedRow() != -1) {
					try {
						BondManagementDelegate.getInstance().doDelete(BondManagementDelegate.getInstance()
								.doReadById((int) bondTable.getValueAt(bondTable.getSelectedRow(), 0)));
						JOptionPane.showMessageDialog(null, "Suppression éffectué !");
						bondTable.setModel(new BondTableModel());
					} catch (Exception erreur) {
						JOptionPane.showMessageDialog(null, "Suppression non effectué !");
					}
				} else if (currencyTable.getSelectedRow() != -1) {
					try {
						CurrencyManagementDelegate.getInstance().doDelete(CurrencyManagementDelegate.getInstance()
								.doReadById((int) currencyTable.getValueAt(currencyTable.getSelectedRow(), 0)));
						JOptionPane.showMessageDialog(null, "Suppression effectué !");
						currencyTable.setModel(new CurrencyTableModel());
					} catch (Exception erreur) {
						JOptionPane.showMessageDialog(null, "Suppression non effectué !");
					}
				}
			}
		});
		deleteLabel.setIcon(
				new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		deleteLabel.setBounds(1048, 573, 64, 53);
		contentPane.add(deleteLabel);

		JTabbedPane marketTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		marketTabbedPane.setBounds(233, 150, 994, 395);
		contentPane.add(marketTabbedPane);

		stockTable = new JTable();
		stockTable.setModel(new StockTableModel());

		StockScrollPane = new JScrollPane(stockTable);
		marketTabbedPane.addTab("Stock",
				new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/stock.png")),
				StockScrollPane, null);

		bondTable = new JTable();
		bondTable.setModel(new BondTableModel());

		BondScrollPane = new JScrollPane(bondTable);
		marketTabbedPane.addTab("Bond",
				new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/bond.png")),
				BondScrollPane, null);

		currencyTable = new JTable();
		currencyTable.setModel(new CurrencyTableModel());

		CurrencyScrollPane = new JScrollPane(currencyTable);
		marketTabbedPane.addTab("Currency",
				new ImageIcon(MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/currency.png")),
				CurrencyScrollPane, null);
		
		JLabel settlementLabel = new JLabel("");
		settlementLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SettlementGUI frame = new SettlementGUI();
				frame.setVisible(true);
				fermer();
			}
		});
		settlementLabel.setBounds(10, 466, 207, 45);
		contentPane.add(settlementLabel);
		
		titreLabel = new JLabel("Home / Market Data");
		titreLabel.setForeground(Color.WHITE);
		titreLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		titreLabel.setBounds(298, 117, 344, 22);
		contentPane.add(titreLabel);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(
				MarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundLabel.setBounds(0, 0, 1227, 687);
		contentPane.add(backgroundLabel);
	}
	
	private void fermer(){
		this.setVisible(false);
	}
	private void recharger(){
		this.repaint();
	}
}
