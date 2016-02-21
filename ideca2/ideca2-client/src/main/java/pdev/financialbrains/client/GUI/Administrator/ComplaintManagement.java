package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pdev.financialbrains.client.boot.EmailSender;
import pdev.financialbrains.client.delegate.ComplaintManagementDelegate;
import pdev.financialbrains.ejb.entities.Complaint;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_response;
	private JTextField tf_mail;
	private JTable table;
	private JTextField tf_object;
	private JTextField tf_text;
	List <Complaint> complaints;
     Complaint complaint;
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
		
		complaints = new ArrayList<Complaint>();
		complaints = ComplaintManagementDelegate.doReadAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tf_response = new JTextField();
		tf_response.setBounds(357, 478, 159, 47);
		tf_response.setColumns(10);
		
		tf_mail = new JTextField();
		tf_mail.setBounds(593, 478, 188, 46);
		tf_mail.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setIcon(new ImageIcon(ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/response.png")));
		btnNewButton.setBounds(520, 543, 136, 76);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] to = {tf_mail.getText()};
	            System.out.println(to);
	            
	            String Email_Body = tf_response.getText();
	            System.out.println(Email_Body);          
	         if (EmailSender.sendEmail("create.money.differently@gmail.com", "98238622",Email_Body, to)) {
	                System.out.println("email sent successfully");
	               
	           JOptionPane.showMessageDialog(null, "Complaint was sent with success ", "Ok", 1);
	            } else {
	                System.out.println("some error occured");
	            }
			}
		});

		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Algerian", Font.BOLD, 15));
		lblEmail.setBounds(526, 488, 63, 24);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Response");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 15));
		lblNewLabel.setBounds(248, 494, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Algerian", Font.BOLD, 15));
		lblText.setBounds(526, 403, 58, 24);
		contentPane.add(lblText);
		
		JLabel lblObject = new JLabel("Object");
		lblObject.setFont(new Font("Algerian", Font.BOLD, 15));
		lblObject.setBounds(258, 408, 63, 14);
		contentPane.add(lblObject);
		
		JLabel lblComplaintManagement = new JLabel("Complaint Management");
		lblComplaintManagement.setForeground(new Color(72, 61, 139));
		lblComplaintManagement.setFont(new Font("Algerian", Font.BOLD, 18));
		lblComplaintManagement.setBounds(387, 104, 324, 24);
		contentPane.add(lblComplaintManagement);
		
		JPanel panel = new JPanel();
		panel.setBounds(316, 194, 543, 144);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				complaint = complaints.get(table.getSelectedRow());
				tf_object.setText(complaint.getObject());
				tf_text.setText(complaint.getText());
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(270)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(tf_response);
		contentPane.add(tf_mail);
		contentPane.add(btnNewButton);
		
		tf_object = new JTextField();
		tf_object.setBounds(353, 393, 163, 47);
		contentPane.add(tf_object);
		tf_object.setColumns(10);
		
		tf_text = new JTextField();
		tf_text.setBounds(593, 393, 188, 47);
		contentPane.add(tf_text);
		tf_text.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				complaint = complaints.get(table.getSelectedRow());
				tf_object.setText(complaint.getObject());
				tf_text.setText(complaint.getText());
				ComplaintManagementDelegate.doDelete(complaint);
				JOptionPane.showMessageDialog(null, "success" );
				tf_object.setText("");
				tf_text.setText("");
				
				complaints= ComplaintManagementDelegate.doReadAll();
				initDataBindings();
				
				
			}
		});
		label_1.setIcon(new ImageIcon(ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		label_1.setBounds(791, 385, 96, 55);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/backAdminGrand2.PNG")));
		label.setBounds(-10, 0, 897, 699);
		contentPane.add(label);
		initDataBindings();
	}	
	protected void initDataBindings() {
		JTableBinding<Complaint, List<Complaint>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, complaints, table);
		//
		BeanProperty<Complaint, String> complaintBeanProperty = BeanProperty.create("object");
		jTableBinding.addColumnBinding(complaintBeanProperty).setColumnName("Object");
		//
		BeanProperty<Complaint, String> complaintBeanProperty_1 = BeanProperty.create("text");
		jTableBinding.addColumnBinding(complaintBeanProperty_1).setColumnName("Text");
		//
		jTableBinding.bind();
	}
	}


