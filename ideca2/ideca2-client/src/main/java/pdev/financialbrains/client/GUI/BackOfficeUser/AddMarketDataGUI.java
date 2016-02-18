package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.CurrencyManagementDelegate;
import pdev.financialbrains.client.delegate.StockManagementDelegate;
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
	private JTextField tfCompanyName;
	private JTextField tfSymbol;
	private JTextField tfCurrentPrice;
	private JTextField tfOpeningPrice;
	private JTextField tfClosingPrice;
	private JTextField tfVolume;
	private JTextField tfVolatility;
	private JTextField textFSymbol;
	private JTextField textFCurrentPrice;
	private JTextField textFVolatility;
	private JTextField textFOpPrice;
	private JTextField textFCloPrice;
	private JTextField textFVolume;

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
		Stockpanel.add(lblCompanyName);

		tfCompanyName = new JTextField();
		tfCompanyName.setBounds(439, 37, 162, 25);
		Stockpanel.add(tfCompanyName);
		tfCompanyName.setColumns(10);

		JLabel lblSymbol = new JLabel("Symbol");
		lblSymbol.setBounds(307, 84, 122, 25);
		Stockpanel.add(lblSymbol);

		tfSymbol = new JTextField();
		tfSymbol.setBounds(439, 84, 162, 25);
		Stockpanel.add(tfSymbol);
		tfSymbol.setColumns(10);

		JLabel lblCurrentPrice = new JLabel("Current Price");
		lblCurrentPrice.setBounds(307, 132, 122, 25);
		Stockpanel.add(lblCurrentPrice);

		tfCurrentPrice = new JTextField();
		tfCurrentPrice.setColumns(10);
		tfCurrentPrice.setBounds(439, 129, 162, 31);
		Stockpanel.add(tfCurrentPrice);

		JLabel lblOpeningPrice = new JLabel("Opening Price");
		lblOpeningPrice.setBounds(307, 179, 122, 25);
		Stockpanel.add(lblOpeningPrice);

		tfOpeningPrice = new JTextField();
		tfOpeningPrice.setColumns(10);
		tfOpeningPrice.setBounds(439, 179, 162, 25);
		Stockpanel.add(tfOpeningPrice);

		JLabel lblClosingPrice = new JLabel("Closing Price");
		lblClosingPrice.setBounds(307, 223, 122, 25);
		Stockpanel.add(lblClosingPrice);

		tfClosingPrice = new JTextField();
		tfClosingPrice.setColumns(10);
		tfClosingPrice.setBounds(439, 223, 162, 25);
		Stockpanel.add(tfClosingPrice);

		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setBounds(307, 259, 122, 25);
		Stockpanel.add(lblVolume);

		tfVolume = new JTextField();
		tfVolume.setColumns(10);
		tfVolume.setBounds(439, 259, 162, 25);
		Stockpanel.add(tfVolume);

		JLabel lblVolatility = new JLabel("Volatility");
		lblVolatility.setBounds(307, 295, 120, 20);
		Stockpanel.add(lblVolatility);

		tfVolatility = new JTextField();
		tfVolatility.setColumns(10);
		tfVolatility.setBounds(439, 295, 162, 25);
		Stockpanel.add(tfVolatility);

		JLabel AddStock = new JLabel("");
		AddStock.setBounds(917, 263, 64, 63);
		Stockpanel.add(AddStock);
		AddStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock stock = new Stock();
				stock.setCompanyName(tfCompanyName.getText());
				stock.setSymbol(tfSymbol.getText());
				stock.setCurrentPrice(Float.parseFloat(tfCurrentPrice.getText()));
				stock.setOpeningPrice(Float.parseFloat(tfOpeningPrice.getText()));
				stock.setClosingPrice(Float.parseFloat(tfClosingPrice.getText()));
				stock.setVolume(Double.parseDouble(tfVolume.getText()));
				stock.setVolatility(Float.parseFloat(tfVolatility.getText()));
				try {
					StockManagementDelegate.getInstance().doCreate(stock);
					JOptionPane.showMessageDialog(null, "Ajout Réussi");
					MarketDataGUI frame = new MarketDataGUI();
					frame.setVisible(true);
				} catch (Exception erreur) {
					erreur.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ajout non éffectué");
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

		JPanel Currencypanel = new JPanel();
		AddtabbedPane.addTab("Currency",
				new ImageIcon(AddMarketDataGUI.class.getResource("/pdev/financialbrains/client/pictures/currency.png")),
				Currencypanel, null);
		Currencypanel.setLayout(null);

		JLabel symbolLabel = new JLabel("Symbol");
		symbolLabel.setBounds(338, 26, 122, 25);
		Currencypanel.add(symbolLabel);

		textFSymbol = new JTextField();
		textFSymbol.setColumns(10);
		textFSymbol.setBounds(470, 26, 162, 25);
		Currencypanel.add(textFSymbol);

		JLabel curPriceLabel = new JLabel("Current Price");
		curPriceLabel.setBounds(338, 65, 122, 25);
		Currencypanel.add(curPriceLabel);

		textFCurrentPrice = new JTextField();
		textFCurrentPrice.setColumns(10);
		textFCurrentPrice.setBounds(470, 62, 162, 28);
		Currencypanel.add(textFCurrentPrice);

		JLabel volatilityLabel = new JLabel("Volatility");
		volatilityLabel.setBounds(338, 104, 120, 20);
		Currencypanel.add(volatilityLabel);

		textFVolatility = new JTextField();
		textFVolatility.setColumns(10);
		textFVolatility.setBounds(470, 104, 162, 25);
		Currencypanel.add(textFVolatility);

		JLabel opPriceLabel = new JLabel("Opening Price");
		opPriceLabel.setBounds(338, 145, 122, 25);
		Currencypanel.add(opPriceLabel);

		textFOpPrice = new JTextField();
		textFOpPrice.setColumns(10);
		textFOpPrice.setBounds(470, 145, 162, 25);
		Currencypanel.add(textFOpPrice);

		JLabel cloPriceLabel = new JLabel("Closing Price");
		cloPriceLabel.setBounds(338, 189, 122, 25);
		Currencypanel.add(cloPriceLabel);

		textFCloPrice = new JTextField();
		textFCloPrice.setColumns(10);
		textFCloPrice.setBounds(470, 189, 162, 25);
		Currencypanel.add(textFCloPrice);

		JLabel volumeLabel = new JLabel("Volume");
		volumeLabel.setBounds(338, 225, 122, 25);
		Currencypanel.add(volumeLabel);

		textFVolume = new JTextField();
		textFVolume.setColumns(10);
		textFVolume.setBounds(470, 225, 162, 25);
		Currencypanel.add(textFVolume);

		JLabel AddCurrency = new JLabel("");
		AddCurrency.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Currency currency = new Currency();
				currency.setSymbol(textFSymbol.getText());
				currency.setCurrentPrice(Float.parseFloat(textFCurrentPrice.getText()));
				currency.setVolatility(Float.parseFloat(textFVolatility.getText()));
				currency.setOpeningPrice(Float.parseFloat(tfOpeningPrice.getText()));
				currency.setClosingPrice(Float.parseFloat(textFCloPrice.getText()));
				try {
					CurrencyManagementDelegate.getInstance().doCreate(currency);
					JOptionPane.showMessageDialog(null, "Ajout Réussi");
					MarketDataGUI frame = new MarketDataGUI();
					frame.setVisible(true);
				} catch (Exception erreur) {
					erreur.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ajout non éffectué");
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
