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
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class NewFinancailInstrument extends JFrame implements ActionListener {
	JPanel panel;
	Component[] components;
	JTextField field;
	JTextArea area;
	JComboBox box;
	Generic generic = new Generic();

	public NewFinancailInstrument() {
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(489, 167, 365, 386);
		panel.setBackground(new Color(211, 211, 211));
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(1012, 574, 73, 53);
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
		getContentPane().add(btnAdd);

		JButton button2 = new JButton("Send");
		button2.setBounds(1101, 574, 57, 53);
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
				// System.out.println(generic);
				GenericManagementDelegate.getInstance().doCreate(generic);
				System.out.println(GenericManagementDelegate.getInstance().doReadById(2));
			}
		});
		getContentPane().add(button2);

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
}