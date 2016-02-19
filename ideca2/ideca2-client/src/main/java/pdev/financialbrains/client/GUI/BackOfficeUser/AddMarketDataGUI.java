package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.BondManagementDelegate;
import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
import pdev.financialbrains.ejb.entities.Bond;
import pdev.financialbrains.ejb.entities.Currency;
import pdev.financialbrains.ejb.entities.Stock;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMarketDataGUI extends JFrame {

	private JPanel contentPane;
	private JTextField stockCompanyName;
	private JTextField stockSymbol;
	private JTextField stockCurrentPrice;
	private JTextField stockOpeningPrice;
	private JTextField stockClosingPrice;
	private JTextField stockVolume;
	private JTextField stockVolatility;
	private JTextField currSymbol;
	private JTextField currCurrentPrice;
	private JTextField currVolatility;
	private JTextField currOpPrice;
	private JTextField currCloPrice;
	private JTextField currVolume;
	private JTextField bondVolatility;
	private JTextField bondCurrentPrice;
	private JTextField bondSymbol;
	private JTextField bondStartDate;
	private JTextField bondEndDate;
	private JTextField bondCouponFreq;
	private JTextField bondYield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarketDataGUI frame = new AddMarketDataGUI();
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
	public AddMarketDataGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane AddtabbedPane = new JTabbedPane(JTabbedPane.TOP);
		AddtabbedPane.setBounds(232, 158, 996, 399);
		contentPane.add(AddtabbedPane);

		JPanel Stockpanel = new JPanel();
		AddtabbedPane.addTab("Stock",
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/stock.png")),
				Stockpanel, null);
		Stockpanel.setLayout(null);

		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(307, 37, 122, 25);
		lblCompanyName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Stockpanel.add(lblCompanyName);

		stockCompanyName = new JTextField();
		stockCompanyName.setBounds(439, 37, 162, 25);
		Stockpanel.add(stockCompanyName);
		stockCompanyName.setColumns(10);

		JLabel lblSymbol = new JLabel("Symbol");
		lblSymbol.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblSymbol.setBounds(307, 84, 122, 25);
		Stockpanel.add(lblSymbol);

		stockSymbol = new JTextField();
		stockSymbol.setBounds(439, 84, 162, 25);
		Stockpanel.add(stockSymbol);
		stockSymbol.setColumns(10);

		JLabel lblCurrentPrice = new JLabel("Current Price");
		lblCurrentPrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblCurrentPrice.setBounds(307, 132, 122, 25);
		Stockpanel.add(lblCurrentPrice);

		stockCurrentPrice = new JTextField();
		stockCurrentPrice.setColumns(10);
		stockCurrentPrice.setBounds(439, 129, 162, 31);
		Stockpanel.add(stockCurrentPrice);

		JLabel lblOpeningPrice = new JLabel("Opening Price");
		lblOpeningPrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblOpeningPrice.setBounds(307, 179, 122, 25);
		Stockpanel.add(lblOpeningPrice);

		stockOpeningPrice = new JTextField();
		stockOpeningPrice.setColumns(10);
		stockOpeningPrice.setBounds(439, 179, 162, 25);
		Stockpanel.add(stockOpeningPrice);

		JLabel lblClosingPrice = new JLabel("Closing Price");
		lblClosingPrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblClosingPrice.setBounds(307, 223, 122, 25);
		Stockpanel.add(lblClosingPrice);

		stockClosingPrice = new JTextField();
		stockClosingPrice.setColumns(10);
		stockClosingPrice.setBounds(439, 223, 162, 25);
		Stockpanel.add(stockClosingPrice);

		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblVolume.setBounds(307, 259, 122, 25);
		Stockpanel.add(lblVolume);

		stockVolume = new JTextField();
		stockVolume.setColumns(10);
		stockVolume.setBounds(439, 259, 162, 25);
		Stockpanel.add(stockVolume);

		JLabel lblVolatility = new JLabel("Volatility");
		lblVolatility.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblVolatility.setBounds(307, 295, 120, 20);
		Stockpanel.add(lblVolatility);

		stockVolatility = new JTextField();
		stockVolatility.setColumns(10);
		stockVolatility.setBounds(439, 295, 162, 25);
		Stockpanel.add(stockVolatility);

		JLabel AddStock = new JLabel("");
		AddStock.setBounds(917, 263, 64, 63);
		Stockpanel.add(AddStock);
		AddStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock stock = new Stock();
				stock.setCompanyName(stockCompanyName.getText());
				stock.setSymbol(stockSymbol.getText());
				stock.setCurrentPrice(Float.parseFloat(stockCurrentPrice.getText()));
				stock.setOpeningPrice(Float.parseFloat(stockOpeningPrice.getText()));
				stock.setClosingPrice(Float.parseFloat(stockClosingPrice.getText()));
				stock.setVolume(Double.parseDouble(stockVolume.getText()));
				stock.setVolatility(Float.parseFloat(stockVolatility.getText()));
				try {
					StockManagementDelegate.getInstance().doCreate(stock);
					JOptionPane.showMessageDialog(null, "Ajout Réussi");
					MarketDataGUI frame = new MarketDataGUI();
					frame.setVisible(true);
				} catch (Exception erreur) {
					erreur.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ajout non effectué");
				}

			}
		});
		AddStock.setIcon(
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));

		JPanel Bondpanel = new JPanel();
		AddtabbedPane.addTab("Bond",
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/bond.png")),
				Bondpanel, null);
		Bondpanel.setLayout(null);
		
		JLabel label = new JLabel("Volatility");
		label.setBounds(30, 260, 120, 20);
		Bondpanel.add(label);
		
		bondVolatility = new JTextField();
		bondVolatility.setColumns(10);
		bondVolatility.setBounds(162, 255, 162, 25);
		Bondpanel.add(bondVolatility);
		
		JLabel label_1 = new JLabel("Current Price");
		label_1.setBounds(30, 69, 122, 25);
		Bondpanel.add(label_1);
		
		bondCurrentPrice = new JTextField();
		bondCurrentPrice.setColumns(10);
		bondCurrentPrice.setBounds(162, 66, 162, 28);
		Bondpanel.add(bondCurrentPrice);
		
		JLabel label_2 = new JLabel("Symbol");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		label_2.setBounds(30, 21, 122, 25);
		Bondpanel.add(label_2);
		
		bondSymbol = new JTextField();
		bondSymbol.setColumns(10);
		bondSymbol.setBounds(162, 21, 162, 25);
		Bondpanel.add(bondSymbol);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblStartDate.setBounds(30, 117, 64, 20);
		Bondpanel.add(lblStartDate);
		
		bondStartDate = new JTextField();
		bondStartDate.setColumns(10);
		bondStartDate.setBounds(162, 112, 162, 25);
		Bondpanel.add(bondStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblEndDate.setBounds(31, 162, 63, 20);
		Bondpanel.add(lblEndDate);
		
		bondEndDate = new JTextField();
		bondEndDate.setColumns(10);
		bondEndDate.setBounds(162, 162, 162, 25);
		Bondpanel.add(bondEndDate);
		
		JLabel lblCouponFreq = new JLabel("Coupon Freq");
		lblCouponFreq.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblCouponFreq.setBounds(30, 209, 64, 25);
		Bondpanel.add(lblCouponFreq);
		
		bondCouponFreq = new JTextField();
		bondCouponFreq.setColumns(10);
		bondCouponFreq.setBounds(162, 209, 162, 25);
		Bondpanel.add(bondCouponFreq);
		
		JLabel lblYield = new JLabel("Yield");
		lblYield.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblYield.setBounds(30, 312, 64, 14);
		Bondpanel.add(lblYield);
		
		bondYield = new JTextField();
		bondYield.setColumns(10);
		bondYield.setBounds(162, 307, 162, 25);
		Bondpanel.add(bondYield);
		
		JLabel addBond = new JLabel("");
		addBond.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Bond bond = new Bond();
				bond.setSymbol(bondSymbol.getText());
				bond.setCurrentPrice(Float.parseFloat(bondCurrentPrice.getText()));
				bond.setCouponFreq(Integer.parseInt(bondCouponFreq.getText()));
				bond.setVolatility(Float.parseFloat(bondVolatility.getText()));
				bond.setYield(Integer.parseInt(bondYield.getText()));
				try{
					BondManagementDelegate.getInstance().doCreate(bond);
					JOptionPane.showMessageDialog(null, "Ajout Réussi");
					MarketDataGUI frame = new MarketDataGUI();
					frame.setVisible(true);
				}catch(Exception erreur){
					erreur.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ajout non effectué");
				}
			}
		});
		addBond.setIcon(new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));
		addBond.setBounds(915, 260, 53, 63);
		Bondpanel.add(addBond);

		JPanel Currencypanel = new JPanel();
		AddtabbedPane.addTab("Currency",
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/currency.png")),
				Currencypanel, null);
		Currencypanel.setLayout(null);

		JLabel symbolLabel = new JLabel("Symbol");
		symbolLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		symbolLabel.setBounds(338, 26, 122, 25);
		Currencypanel.add(symbolLabel);

		currSymbol = new JTextField();
		currSymbol.setColumns(10);
		currSymbol.setBounds(470, 26, 162, 25);
		Currencypanel.add(currSymbol);

		JLabel curPriceLabel = new JLabel("Current Price");
		curPriceLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		curPriceLabel.setBounds(338, 65, 122, 25);
		Currencypanel.add(curPriceLabel);

		currCurrentPrice = new JTextField();
		currCurrentPrice.setColumns(10);
		currCurrentPrice.setBounds(470, 62, 162, 28);
		Currencypanel.add(currCurrentPrice);

		JLabel volatilityLabel = new JLabel("Volatility");
		volatilityLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		volatilityLabel.setBounds(338, 104, 120, 20);
		Currencypanel.add(volatilityLabel);

		currVolatility = new JTextField();
		currVolatility.setColumns(10);
		currVolatility.setBounds(470, 104, 162, 25);
		Currencypanel.add(currVolatility);

		JLabel opPriceLabel = new JLabel("Opening Price");
		opPriceLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		opPriceLabel.setBounds(338, 145, 122, 25);
		Currencypanel.add(opPriceLabel);

		currOpPrice = new JTextField();
		currOpPrice.setColumns(10);
		currOpPrice.setBounds(470, 145, 162, 25);
		Currencypanel.add(currOpPrice);

		JLabel cloPriceLabel = new JLabel("Closing Price");
		cloPriceLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		cloPriceLabel.setBounds(338, 189, 122, 25);
		Currencypanel.add(cloPriceLabel);

		currCloPrice = new JTextField();
		currCloPrice.setColumns(10);
		currCloPrice.setBounds(470, 189, 162, 25);
		Currencypanel.add(currCloPrice);

		JLabel volumeLabel = new JLabel("Volume");
		volumeLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		volumeLabel.setBounds(338, 225, 122, 25);
		Currencypanel.add(volumeLabel);

		currVolume = new JTextField();
		currVolume.setColumns(10);
		currVolume.setBounds(470, 225, 162, 25);
		Currencypanel.add(currVolume);

		JLabel AddCurrency = new JLabel("");
		AddCurrency.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Currency currency = new Currency();
				currency.setSymbol(currSymbol.getText());
				currency.setCurrentPrice(Float.parseFloat(currCurrentPrice.getText()));
				currency.setVolatility(Float.parseFloat(currVolatility.getText()));
				currency.setOpeningPrice(Float.parseFloat(stockOpeningPrice.getText()));
				currency.setClosingPrice(Float.parseFloat(currCloPrice.getText()));
				try {
					CurrencyManagementDelegate.getInstance().doCreate(currency);
					JOptionPane.showMessageDialog(null, "Ajout Réussi");
					MarketDataGUI frame = new MarketDataGUI();
					frame.setVisible(true);
				} catch (Exception erreur) {
					erreur.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ajout non effectué");
				}
			}
		});
		AddCurrency.setBounds(917, 263, 64, 63);
		Currencypanel.add(AddCurrency);
		AddCurrency.setIcon(
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));

		JLabel BackgroundLabel = new JLabel("");
		BackgroundLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MarketDataGUI frame = new MarketDataGUI();
				frame.setVisible(true);
			}
		});
		BackgroundLabel.setIcon(new ImageIcon(
				AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		BackgroundLabel.setBounds(0, 0, 1235, 699);
		contentPane.add(BackgroundLabel);

		JLabel MarketDataLabel = new JLabel("");
		MarketDataLabel.setBounds(10, 387, 202, 45);
		contentPane.add(MarketDataLabel);
	}
}
