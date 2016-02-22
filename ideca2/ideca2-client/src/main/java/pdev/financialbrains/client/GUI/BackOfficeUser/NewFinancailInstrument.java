package pdev.financialbrains.client.GUI.BackOfficeUser;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pdev.financialbrains.client.delegate.GenericManagementDelegate;
import pdev.financialbrains.ejb.entities.Generic;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class NewFinancailInstrument extends JFrame implements ActionListener {
	JPanel panel;
	Component[] components;
	JTextField field;
	JTextArea area;
	JComboBox box;
	Generic generic = new Generic();
	private JTable tableNewProduct;

	public NewFinancailInstrument() {
		getContentPane().setLayout(null);
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(
				NewFinancailInstrument.class.getResource("/pdev/financialbrains/client/pictures/addListIcon.png")));
		btnAdd.setBounds(902, 307, 73, 53);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// panel.add(new JButton("Button"));
				panel.add(new JTextField(10));
				panel.add(new JTextArea(1, 10));
				panel.add(new JComboBox<>(
						new DefaultComboBoxModel(new String[] { "Integer", "Float", "String", "Boolean" })));
				panel.revalidate();
				validate();
			}

		});

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblName.setBounds(542, 167, 58, 17);
		getContentPane().add(lblName);

		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblValue.setBounds(659, 167, 67, 17);
		getContentPane().add(lblValue);

		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Berlin Sans FB", Font.BOLD, 14));
		lblType.setBounds(769, 167, 73, 17);
		getContentPane().add(lblType);
		getContentPane().add(btnAdd);

		JButton button2 = new JButton("");
		button2.setIcon(new ImageIcon(
				NewFinancailInstrument.class.getResource("/pdev/financialbrains/client/pictures/saveIcon.png")));
		button2.setBounds(902, 398, 67, 53);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				components = panel.getComponents();

				for (Component c : components) {
					if (c instanceof JTextField) {
						field = (JTextField) c;
					} else if (c instanceof JTextArea) {
						area = (JTextArea) c;
					} else if (c instanceof JComboBox) {
						box = (JComboBox) c;
						if (box.getSelectedIndex() == 0)
							generic.setPropertyInteger(field.getText(), Integer.parseInt(area.getText()));
						else if (box.getSelectedIndex() == 1)
							generic.setPropertyFloat(field.getText(), Float.parseFloat(area.getText()));
						else if (box.getSelectedIndex() == 2)
							generic.setPropertyString(field.getText(), area.getText());
						else if (box.getSelectedIndex() == 3)
							generic.setPropertyBoolean(field.getText(), Boolean.parseBoolean(area.getText()));
					}
				}
				GenericManagementDelegate.getInstance().doCreate(generic);
				JOptionPane.showMessageDialog(null, "Ajout Réussi");
				MarketDataGUI frame = new MarketDataGUI();
				frame.setVisible(true);
				fermer();
				// System.out.println(GenericManagementDelegate.getInstance().doReadLastId());
				// String[] entete = { "Name", "Value", "Type" };
				// String[] s = GenericManagementDelegate.getInstance()
				// .doReadById(GenericManagementDelegate.getInstance().doReadLastId()).toString().split("
				// : ");
				// String[][] fill = {{""},{""}};
				// for (int j = 0; j < (s.length) / 3; j++) {
				// for (int i = 0; i < s.length; i = i + 3) {
				// fill[j][i] = s[i];
				// }
				// }
				// tableNewProduct = new JTable(fill, entete);
				// panel_1.add(tableNewProduct);
				// panel_1.revalidate();
				// validate();

			}
		});
		getContentPane().add(button2);

		panel = new JPanel();
		panel.setBounds(489, 183, 365, 382);
		panel.setBackground(new Color(211, 211, 211));
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				NewFinancailInstrument.class.getResource("/pdev/financialbrains/client/pictures/backBouGrand2.PNG")));
		lblNewLabel.setBounds(0, 0, 1208, 665);
		getContentPane().add(lblNewLabel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1220, 700);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		// panel.add(new JButton("Button"));
		panel.add(new JTextField());
		panel.add(new JButton("b"));
		// panel.add(new JComboBox<>(new DefaultComboBoxModel(new String[] {
		// "Integer", "Float", "String", "Boolean" })));

		panel.revalidate();
		validate();
	}

	public static void main(String[] args) {
		NewFinancailInstrument acojfar = new NewFinancailInstrument();
	}

	private void fermer() {
		this.setVisible(false);
	}
}