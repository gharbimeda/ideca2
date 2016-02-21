package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import pdev.financialbrains.client.GUI.Administrator.Authentification;
import pdev.financialbrains.client.delegate.MessageManagementDelegate;
import pdev.financialbrains.client.delegate.UserManagementDelegate;
import pdev.financialbrains.client.utils.BondTableModel;
import pdev.financialbrains.client.utils.CurrencyTableModel;
import pdev.financialbrains.client.utils.MessageController;
import pdev.financialbrains.client.utils.StockTableModel;
import pdev.financialbrains.ejb.contracts.IMessageCrudServicesRemote;
import pdev.financialbrains.ejb.entities.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.ejb.EJB;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;
import pdev.financialbrains.ejb.entities.User;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

public class MessageManagement extends JFrame {
	private JComboBoxBinding<User, List<User>, JComboBox> login;

	List<Message> messages;
	private Message message;
	List<User> users;
	private User user;


	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JTextField tf_content;
	private JComboBox comboBox;
	

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
		users = UserManagementDelegate.doReadAll();
		System.out.println(users);
		messages = new ArrayList<Message>();
		messages = MessageManagementDelegate.doRead();
		//users = UserManagementDelegate.doRead(1);
		//List<User> list = UserManagementDelegate.doRead(1);
      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1243, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane messageTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		messageTabbedPane.setBounds(233, 200, 994, 395);
		contentPane.add(messageTabbedPane);table_1 = new JTable();
table_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		table_1.setModel(new MessageController());
		//MessageManagementDelegate.doRead();
		messageTabbedPane.addTab("All Messages",
				new ImageIcon(MessageManagement.class.getResource("/pdev/financialbrains/client/pictures/menu-button.png")),
				table_1, null);
	
		messageTabbedPane.setEnabledAt(0, true);
		
		JLayeredPane panel = new JLayeredPane();
		messageTabbedPane.addTab("Send", new ImageIcon(MessageManagement.class.getResource("/pdev/financialbrains/client/pictures/msg.png")), panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Content");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 104, 129, 54);
		panel.add(lblNewLabel);
		
		tf_content = new JTextField();
		tf_content.setBounds(203, 87, 330, 93);
		panel.add(tf_content);
		tf_content.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		lblDestination.setBounds(31, 234, 129, 54);
		panel.add(lblDestination);
				
				JButton btnSendMessage = new JButton("");
				btnSendMessage.setIcon(new ImageIcon(MessageManagement.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));
				btnSendMessage.setBounds(762, 187, 89, 54);
				panel.add(btnSendMessage);
				
				comboBox = new JComboBox();
				comboBox.setBounds(203, 243, 330, 37);
				panel.add(comboBox);
				btnSendMessage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Message m = new Message(); 
						//User u = new User();
						
						m.setTexte(tf_content.getText());
						m.setDate(new Date());
						User user = (User) comboBox.getSelectedItem();
					     
						m.setUserDest(user);
						m.setUserSource(user); // Source avec authentification
						MessageManagementDelegate.doCreate(m);
						JOptionPane.showMessageDialog(null, "Your message has been sent");
						table_1.setModel(new MessageController());
						
					}
				});
				
				JButton btnDelete = new JButton("");
				btnDelete.setIcon(new ImageIcon(MessageManagement.class.getResource("/pdev/financialbrains/client/pictures/cross.png")));
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						message = messages.get(table_1.getSelectedRow());
						
						messages= MessageManagementDelegate.doRead();
						MessageManagementDelegate.doDelete(message);
						
					}
				});
				btnDelete.setBounds(406, 606, 79, 39);
				contentPane.add(btnDelete);
				
				JLabel lblHomemanageMessages = new JLabel("Home/Manage Messages");
				lblHomemanageMessages.setForeground(Color.WHITE);
				lblHomemanageMessages.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
				lblHomemanageMessages.setBounds(323, 102, 267, 54);
				contentPane.add(lblHomemanageMessages);
				
				JLabel lb_homeback = new JLabel("");
				lb_homeback.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						BackHome b = new BackHome();
						b.setVisible(true);
						fermer();
					}
				});
				lb_homeback.setBounds(-8, 129, 153, 54);
				contentPane.add(lb_homeback);
				
				JLabel lb_financialinstrument = new JLabel("");
				lb_financialinstrument.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						FinancialInstrument f = new FinancialInstrument();
						f.setVisible(false);
						fermer();
					}
				});
				lb_financialinstrument.setBounds(-8, 210, 192, 70);
				contentPane.add(lb_financialinstrument);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					}
				});
				lblNewLabel_1.setBounds(-8, 306, 205, 54);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						MarketDataGUI m = new MarketDataGUI();
						m.setVisible(true);
						fermer();
					}
				});
				lblNewLabel_2.setBounds(2, 376, 205, 60);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						SettlementGUI s = new SettlementGUI();
						s.setVisible(true);
						fermer();
					}
				});
				lblNewLabel_3.setBounds(2, 460, 182, 70);
				contentPane.add(lblNewLabel_3);
				
				JLabel lb_msg = new JLabel("");
				lb_msg.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						MessageManagement m = new MessageManagement();
						m.setVisible(true);
						fermer();
					}
				});
				lb_msg.setBounds(1066, 36, 46, 39);
				contentPane.add(lb_msg);
				
				JLabel lb_exit = new JLabel("");
				lb_exit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Authentification a = new Authentification();
						a.setVisible(true);
						fermer();
					}
				});
				lb_exit.setBounds(175, 647, 52, 41);
				contentPane.add(lb_exit);
		
				JLabel backgroundLabel = new JLabel("");
				backgroundLabel.setIcon(new ImageIcon(MessageManagement.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
				backgroundLabel.setBounds(-8, 0, 1235, 705);
				contentPane.add(backgroundLabel);
				initDataBindings();
	}
	protected void initDataBindings() {
		login = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, users, comboBox);
		login.bind();
	}
	private void fermer()
	{
		this.setVisible(false);
	}
}
