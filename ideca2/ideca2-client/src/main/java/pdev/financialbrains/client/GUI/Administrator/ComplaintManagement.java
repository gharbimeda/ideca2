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
import java.util.Date;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_response;
	private JTextField tf_mail;
	private JTextField tf_object;
	private JTextField tf_text;
	List<Complaint> complaints;
	Complaint complaint;
	private JTable table1;

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
		setBounds(100, 100, 1235, 738);
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
		btnNewButton.setIcon(new ImageIcon(
				ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/response.png")));
		btnNewButton.setBounds(520, 543, 136, 76);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] to = { tf_mail.getText() };
				System.out.println(to);

				String Email_Body = tf_response.getText();
				System.out.println(Email_Body);
				if (EmailSender.sendEmail("create.money.differently@gmail.com", "98238622", Email_Body, to)) {
					System.out.println("email sent successfully");

					JOptionPane.showMessageDialog(null, "Complaint was sent with success ", "Ok", 1);
				} else {
					System.out.println("some error occured");
				}
			}
		});

		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				new AdminHome().setVisible(true);

				fermer();

			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new AccountManagement().setVisible(true);

				fermer();

			}
		});

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ArticlesManagement().setVisible(true);
				fermer();

			}
		});

		JLabel lb_deconnect = new JLabel("");
		lb_deconnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new Authentification().setVisible(true);
				fermer();

			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(316, 194, 543, 144);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(19)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(111, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
								.addContainerGap()));

		table1 = new JTable();
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				complaint = complaints.get(table1.getSelectedRow());
				tf_object.setText(complaint.getObject());
				tf_text.setText(complaint.getText());
			}
		});
		scrollPane.setViewportView(table1);
		panel.setLayout(gl_panel);
		lb_deconnect.setBounds(170, 641, 58, 47);
		contentPane.add(lb_deconnect);
		lblNewLabel_3.setBounds(10, 304, 218, 47);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_2.setBounds(10, 163, 193, 47);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_1.setBounds(10, 90, 224, 62);
		contentPane.add(lblNewLabel_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblEmail.setBounds(526, 488, 63, 24);
		contentPane.add(lblEmail);

		JLabel lblNewLabel = new JLabel("Response");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(268, 493, 79, 14);
		contentPane.add(lblNewLabel);

		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblText.setBounds(526, 403, 58, 24);
		contentPane.add(lblText);

		JLabel lblObject = new JLabel("Object");
		lblObject.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblObject.setBounds(280, 408, 63, 14);
		contentPane.add(lblObject);

		JLabel lblComplaintManagement = new JLabel("Dashbord/Complaint Management");
		lblComplaintManagement.setForeground(Color.WHITE);
		lblComplaintManagement.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		lblComplaintManagement.setBounds(302, 103, 394, 24);
		contentPane.add(lblComplaintManagement);
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
				complaint = complaints.get(table1.getSelectedRow());
				tf_object.setText(complaint.getObject());
				tf_text.setText(complaint.getText());

				ComplaintManagementDelegate.doDelete(complaint);
				JOptionPane.showMessageDialog(null, "success");
				tf_object.setText("");
				tf_text.setText("");

				complaints = ComplaintManagementDelegate.doReadAll();
				initDataBindings();

			}
		});
		label_1.setIcon(new ImageIcon(
				ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
		label_1.setBounds(791, 385, 96, 55);
		contentPane.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				ComplaintManagement.class.getResource("/pdev/financialbrains/client/pictures/backAdminGrand2.PNG")));
		label.setBounds(-10, 0, 1241, 699);
		contentPane.add(label);
		initDataBindings();
	}

	private void fermer() {
		this.setVisible(false);
	}

	protected void initDataBindings() {
		JTableBinding<Complaint, List<Complaint>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, complaints, table1);
		//
		BeanProperty<Complaint, String> complaintBeanProperty = BeanProperty.create("object");
		jTableBinding.addColumnBinding(complaintBeanProperty).setColumnName("Object");
		//
		BeanProperty<Complaint, String> complaintBeanProperty_1 = BeanProperty.create("text");
		jTableBinding.addColumnBinding(complaintBeanProperty_1).setColumnName("Text");
		//
		BeanProperty<Complaint, Date> complaintBeanProperty_2 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(complaintBeanProperty_2).setColumnName("Date");
		//
		jTableBinding.bind();
	}
}
