package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


import pdev.financialbrains.client.delegate.MessageManagementDelegate;
import pdev.financialbrains.client.utils.BondTableModel;
import pdev.financialbrains.client.utils.CurrencyTableModel;
import pdev.financialbrains.client.utils.MessageController;
import pdev.financialbrains.client.utils.StockTableModel;
import pdev.financialbrains.ejb.entities.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class MessageManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageManagement frame = new MessageManagement();
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
	public MessageManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel msgLabel = new JLabel("");
		msgLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MessageManagement frame = new MessageManagement();
				frame.repaint();

			}
		});
		msgLabel.setBounds(1077, 33, 42, 30);
		contentPane.add(msgLabel);

		JTabbedPane messageTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		messageTabbedPane.setBounds(233, 150, 994, 395);
		contentPane.add(messageTabbedPane);

		table_1 = new JTable();
		table_1.setModel(new MessageController());
		messageTabbedPane.addTab("All Messages",
				new ImageIcon(MarketDataGUI.class.getResource("")),
				table_1, null);
		messageTabbedPane.setEnabledAt(0, true);

		table_1 = new JTable();
		messageTabbedPane.addTab("Send Message", 
				new ImageIcon(MarketDataGUI.class.getResource("")),
				table_1, null);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(
				MarketDataGUI.class.getResource("")));
		backgroundLabel.setBounds(0, 0, 1227, 687);
		contentPane.add(backgroundLabel);
	}
}
