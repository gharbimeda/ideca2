package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NewProductGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	JPanel panel;
	Component[] components;
	JTextField field;
	JTextArea area;
	JComboBox box;

	public NewProductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1245, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();

		panel.setBackground(Color.GRAY);
		panel.setBounds(231, 152, 1007, 495);
		contentPane.add(panel);

		JLabel backgroundlabel = new JLabel("");
		backgroundlabel.setIcon(new ImageIcon(
				NewProductGUI.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		backgroundlabel.setBounds(0, 0, 1238, 694);
		contentPane.add(backgroundlabel);
		JButton btnChamps = new JButton("Nouveau Champ");
		btnChamps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.add(new JTextField(10));
				panel.add(new JTextArea(1, 10));
				panel.add(new JComboBox<>(
						new DefaultComboBoxModel(new String[] { "Integer", "Float", "String", "Boolean" })));
				panel.revalidate();
				validate();
			}
		});
		btnChamps.setBounds(1108, 587, 111, 49);
		contentPane.add(btnChamps);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		NewProductGUI acojfar = new NewProductGUI();
	}
}
