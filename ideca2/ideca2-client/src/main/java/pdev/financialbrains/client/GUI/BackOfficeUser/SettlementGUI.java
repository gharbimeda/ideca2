package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.TradeManagementDelegate;
import pdev.financialbrains.client.utils.TradePendTableModel;
import pdev.financialbrains.ejb.entities.Trade;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettlementGUI extends JFrame {

	private JPanel contentPane;
	private JTable allSettlement;
	private JTable settled;
	private JTable pending;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettlementGUI frame = new SettlementGUI();
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
	public SettlementGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel allLabel = new JLabel("All Settlement");
		allLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		allLabel.setBounds(406, 157, 163, 25);
		contentPane.add(allLabel);

		JPanel panelAllSett = new JPanel();
		panelAllSett.setBackground(Color.LIGHT_GRAY);
		panelAllSett.setBounds(241, 174, 469, 259);
		contentPane.add(panelAllSett);

		allSettlement = new JTable();
		allSettlement.setModel(new TradePendTableModel("ALL"));

		JScrollPane scrollPaneAllSett = new JScrollPane(allSettlement);
		panelAllSett.add(scrollPaneAllSett);

		JLabel managedLabel = new JLabel("Managed");
		managedLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		managedLabel.setBounds(953, 159, 99, 20);
		contentPane.add(managedLabel);

		JPanel panelSett = new JPanel();
		panelSett.setBackground(Color.LIGHT_GRAY);
		panelSett.setBounds(758, 176, 461, 257);
		contentPane.add(panelSett);

		settled = new JTable();
		settled.setModel(new TradePendTableModel("MANAGED"));

		JScrollPane scrollPaneSett = new JScrollPane(settled);
		panelSett.add(scrollPaneSett);

		JLabel pendingLabel = new JLabel("Pending");
		pendingLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		pendingLabel.setBounds(686, 439, 147, 20);
		contentPane.add(pendingLabel);

		JPanel panelNotSett = new JPanel();
		panelNotSett.setBackground(Color.LIGHT_GRAY);
		panelNotSett.setBounds(241, 458, 978, 171);
		contentPane.add(panelNotSett);
		panelNotSett.setLayout(null);

		pending = new JTable();
		pending.setModel(new TradePendTableModel("PENDING"));

		JScrollPane scrollPaneNotSett = new JScrollPane(pending);
		scrollPaneNotSett.setBounds(263, 5, 452, 402);
		panelNotSett.add(scrollPaneNotSett);

		JLabel accept = new JLabel("");
		accept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Trade trade = TradeManagementDelegate.getInstance()
							.doReadById((int) pending.getValueAt(pending.getSelectedRow(), 0));
					trade.setStatus(1);
					TradeManagementDelegate.getInstance().doUpdate(trade);
					JOptionPane.showMessageDialog(null, "Trade accepeté");
					pending.setModel(new TradePendTableModel("PENDING"));
					allSettlement.setModel(new TradePendTableModel("ALL"));
					settled.setModel(new TradePendTableModel("MANAGED"));
				} catch (Exception erreur) {
					JOptionPane.showMessageDialog(null, "Selectionnez un trade");
				}
			}
		});
		accept.setIcon(
				new ImageIcon(SettlementGUI.class.getResource("/pdev/financialbrains/client/pictures/accept.png")));
		accept.setBounds(725, 108, 54, 52);
		panelNotSett.add(accept);

		JLabel decline = new JLabel("");
		decline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Trade trade = TradeManagementDelegate.getInstance()
							.doReadById((int) pending.getValueAt(pending.getSelectedRow(), 0));
					trade.setStatus(0);
					TradeManagementDelegate.getInstance().doUpdate(trade);
					JOptionPane.showMessageDialog(null, "Trade refusé");
					pending.setModel(new TradePendTableModel("PENDING"));
					allSettlement.setModel(new TradePendTableModel("ALL"));
					settled.setModel(new TradePendTableModel("MANAGED"));
				} catch (Exception erreur) {
					JOptionPane.showMessageDialog(null, "Selectionnez un trade");
				}
			}
		});
		decline.setIcon(
				new ImageIcon(SettlementGUI.class.getResource("/pdev/financialbrains/client/pictures/decline.png")));
		decline.setBounds(205, 108, 48, 52);
		panelNotSett.add(decline);
		
		JLabel mdLabel = new JLabel("");
		mdLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MarketDataGUI frame = new MarketDataGUI(); 
				frame.setVisible(true);
				fermer();
			}
		});
		
		JLabel titreLabel = new JLabel("Home / Settlement");
		titreLabel.setForeground(Color.WHITE);
		titreLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
		titreLabel.setBounds(307, 114, 153, 22);
		contentPane.add(titreLabel);
		mdLabel.setBounds(10, 378, 204, 55);
		contentPane.add(mdLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				SettlementGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		label.setBounds(0, 0, 1235, 694);
		contentPane.add(label);
	}

	private void fermer() {
		this.setVisible(false);
	}
}
