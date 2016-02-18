package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ArticleManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_title_add;
	private JTextField tf_author_add;
	private JTextField tf_date_add;
	private JTextField tf_text_add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleManagement frame = new ArticleManagement();
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
	public ArticleManagement() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		tabbedPane.setBounds(240, 145, 641, 341);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("All Articles", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("New Article\r\n", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(329, 21, 285, 265);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Photo");
		lblNewLabel_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 22, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel addphoto = new JLabel("");
		addphoto.setIcon(new ImageIcon("C:\\IDE\\images\\Upload Picture.png"));
		addphoto.setBounds(76, 11, 46, 32);
		panel_2.add(addphoto);
		
		JLabel lbl_photo_add = new JLabel("");
		lbl_photo_add.setForeground(Color.LIGHT_GRAY);
		lbl_photo_add.setBackground(Color.LIGHT_GRAY);
		lbl_photo_add.setBounds(91, 66, 151, 81);
		panel_2.add(lbl_photo_add);
		
		JLabel add = new JLabel("\r\n");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		add.setIcon(new ImageIcon("C:\\IDE\\images\\Download button.png"));
		add.setBounds(229, 211, 46, 43);
		panel_2.add(add);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(21, 21, 285, 265);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 25, 46, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblAut = new JLabel("Author");
		lblAut.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblAut.setBounds(26, 64, 46, 14);
		panel_3.add(lblAut);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblDate.setBounds(26, 105, 46, 14);
		panel_3.add(lblDate);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblText.setBounds(26, 150, 46, 14);
		panel_3.add(lblText);
		
		tf_title_add = new JTextField();
		tf_title_add.setBounds(102, 23, 86, 20);
		panel_3.add(tf_title_add);
		tf_title_add.setColumns(10);
		
		tf_author_add = new JTextField();
		tf_author_add.setBounds(102, 62, 86, 20);
		panel_3.add(tf_author_add);
		tf_author_add.setColumns(10);
		
		tf_date_add = new JTextField();
		tf_date_add.setBounds(102, 103, 86, 20);
		panel_3.add(tf_date_add);
		tf_date_add.setColumns(10);
		
		tf_text_add = new JTextField();
		tf_text_add.setBounds(102, 148, 162, 106);
		panel_3.add(tf_text_add);
		tf_text_add.setColumns(10);
		
		JLabel lblHomeArticle = new JLabel("Home \\ Article Management");
		lblHomeArticle.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblHomeArticle.setForeground(Color.LIGHT_GRAY);
		lblHomeArticle.setBounds(275, 86, 245, 35);
		contentPane.add(lblHomeArticle);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\IDE\\images\\backAdmin1.png"));
		label.setBounds(0, 0, 891, 498);
		contentPane.add(label);
	}
}
