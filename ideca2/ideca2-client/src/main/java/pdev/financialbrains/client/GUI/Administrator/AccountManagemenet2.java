package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.delegate.AccountManagementDelegate;
import pdev.financialbrains.client.utils.UserTableModel;
import pdev.financialbrains.ejb.entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class AccountManagemenet2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField userLG;
	private JTextField userPass;
	private JTextField textField_Id;
	private JTextField textField_Login;
	private JTextField textField_Password;
	private Integer Iduser;
	List<User> users ;
	private User user;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagemenet2 frame = new AccountManagemenet2();
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
	public AccountManagemenet2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		users =new ArrayList<User>();
		users=AccountManagementDelegate.doRead();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(300, 200, 800, 423);
		contentPane.add(tabbedPane);
		
		JPanel VisualizeAccounts = new JPanel();
		tabbedPane.addTab("Visualize Accounts ", new ImageIcon(AccountManagemenet2.class.getResource("/pdev/financialbrains/client/pictures/users-icon.png")), VisualizeAccounts, null);
		VisualizeAccounts.setLayout(null);
		table = new JTable();
		table.setBounds(54, 305, 525, -254);
		VisualizeAccounts.add(table);
		System.out.println(AccountManagementDelegate.doRead());
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if (table.getSelectedRow() == -1) {
			            if (table.getRowCount() == 0) {
			                JOptionPane.showMessageDialog(null, "le tableau est vide");
			            } else {
			                JOptionPane.showMessageDialog(null, "il faut selectionner une ligne");
			            }
			        } else {
			            int i = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");
			            AccountManagementDelegate.doDelete(i);
			            table.setModel(new UserTableModel());
			          

			            
			        }
			        
				
			}
		});
		
	
		Delete.setIcon(new ImageIcon(AccountManagemenet2.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		Delete.setBounds(638, 191, 131, 65);
		VisualizeAccounts.add(Delete);
		
		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new UserTableModel());
			}
		});
		btnList.setBounds(638, 75, 89, 23);
		VisualizeAccounts.add(btnList);
		
		
		JPanel AddAccount = new JPanel();
		tabbedPane.addTab("Add Account",  new ImageIcon(AccountManagemenet2.class.getResource("/pdev/financialbrains/client/pictures/user-accept-icon.png")), AddAccount, null);
		AddAccount.setLayout(null);
		
		JLabel Login = new JLabel("Login");
		Login.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		Login.setBounds(105, 66, 78, 22);
		AddAccount.add(Login);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
		lblPassword.setBounds(105, 166, 78, 22);
		AddAccount.add(lblPassword);
		
		userLG = new JTextField();
		userLG.setBounds(269, 67, 148, 31);
		AddAccount.add(userLG);
		userLG.setColumns(10);
		
		userPass = new JTextField();
		userPass.setBounds(269, 167, 148, 31);
		AddAccount.add(userPass);
		userPass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ghada\\git\\ideca2\\ideca2\\ideca2-client\\src\\main\\java\\pdev\\financialbrains\\client\\pictures\\addIcon.png"));
		lblNewLabel_1.setBounds(565, 204, 52, 56);
		AddAccount.add(lblNewLabel_1);
		
		JButton Add = new JButton("Add Account");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User() ;
				user.setLogin(userLG.getText());
				user.setPassword(userPass.getText());
				AccountManagementDelegate.getProxy().create(user);
				
				users = AccountManagementDelegate.getProxy().readAll();
				initDataBindings();
				
			}
		});
		Add.setBounds(530, 271, 134, 23);
		AddAccount.add(Add);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -11, 1230, 707);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ghada\\git\\ideca2\\ideca2\\ideca2-client\\src\\main\\java\\pdev\\financialbrains\\client\\pictures\\backAdminGrand2.PNG"));
		contentPane.add(lblNewLabel);
		initDataBindings();
	}
	protected void initDataBindings() {
	}
}
