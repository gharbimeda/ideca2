package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
<<<<<<< HEAD

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.boot.EmailSender;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_response;
	private JTextField tf_mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintManagement frame = new ComplaintManagement();
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
	public ComplaintManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_response = new JTextField();
		tf_response.setBounds(37, 174, 86, 20);
		contentPane.add(tf_response);
		tf_response.setColumns(10);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(37, 217, 86, 20);
		contentPane.add(tf_mail);
		tf_mail.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] to = {tf_mail.getText()};
	            System.out.println(to);
	            
	            String Email_Body = tf_response.getText();
	            System.out.println(Email_Body);          
	         if (EmailSender.sendEmail("create.money.differently@gmail.com", "98238622",Email_Body, to)) {
	                System.out.println("email sent successfully");
	               
	           JOptionPane.showMessageDialog(null, "Modification avec succes ", "Ok", 1);
	            } else {
	                System.out.println("some error occured");
	            }
			}
		});
		btnNewButton.setBounds(200, 194, 89, 23);
		contentPane.add(btnNewButton);
	}

=======
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import pdev.financialbrains.client.delegate.ComplaintManagementDelegate;
import pdev.financialbrains.ejb.entities.Complaint;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
     List <Complaint> complaint;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintManagement frame = new ComplaintManagement();
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
	public ComplaintManagement() {
		complaint = new ArrayList<Complaint>();
		complaint = ComplaintManagementDelegate.doReadAll();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		
			label.setBounds(0, 0, 908, 681);
			contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(373, 239, 488, 298);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(92, 92, 46, 14);
		contentPane.add(label_1);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Complaint, List<Complaint>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, complaint, table);
		//
		BeanProperty<Complaint, String> complaintBeanProperty = BeanProperty.create("object");
		jTableBinding.addColumnBinding(complaintBeanProperty).setColumnName("Object ");
		//
		BeanProperty<Complaint, String> complaintBeanProperty_1 = BeanProperty.create("text");
		jTableBinding.addColumnBinding(complaintBeanProperty_1).setColumnName("Text");
		//
		jTableBinding.bind();
	}

}
