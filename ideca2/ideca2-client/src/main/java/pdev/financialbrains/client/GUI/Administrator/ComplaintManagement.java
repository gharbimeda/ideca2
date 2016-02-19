package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ComplaintManagement extends JFrame {

	private JPanel contentPane;
	private JTable table;
     List <Complaint> complaint;
     Complaint complaints;
     private JTextField tf_text;
     private JTextField tf_object;
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
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				complaints = complaint.get(table.getSelectedRow());
				tf_object.setText(complaints.getObject());
				tf_text.setText(complaints.getText());
				
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(67)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tf_text = new JTextField();
		tf_text.setColumns(10);
		
		tf_object = new JTextField();
		tf_object.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JLabel deletea = new JLabel("");
		deletea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				complaints.setObject(tf_object.getText());
				complaints.setText(tf_text.getText());
				ComplaintManagementDelegate.doDelete(complaints);
				
				tf_object.setText("");
				tf_text.setText("");
				complaint = ComplaintManagementDelegate.doReadAll();
				
				
				initDataBindings();
				
				
			}
		});
		deletea.setIcon(new ImageIcon("C:\\IDE\\images\\Delete_Icopn.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(280)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(256)
									.addComponent(tf_text, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
								.addComponent(tf_object, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(394)
									.addComponent(label)
									.addGap(26)
									.addComponent(deletea))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(334)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)))
					.addGap(720))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(308)
									.addComponent(tf_text, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(deletea, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(308)
									.addComponent(tf_object, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(440)
									.addComponent(label))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
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
