package pdev.financialbrains.client.GUI.Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import pdev.financialbrains.client.delegate.ArticleManagementDelegate;
import pdev.financialbrains.ejb.entities.Article;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;

public class ArticlesManagement extends JFrame {

	private JPanel contentPane;
	private JTextField tf_title;
	private JTextField tf_author;
	private Article article;
	private  File image;
	private JTable table;
	List<Article> articles = new ArrayList<Article>();
	private JTextField tf_title_update;
	private JTextField tf_author_update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticlesManagement frame = new ArticlesManagement();
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
	public ArticlesManagement() {
		setLocationRelativeTo(getParent());
		//setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//declaration de la liste des articles
		articles = ArticleManagementDelegate.doReadAll();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(268, 145, 942, 489);
		contentPane.add(tabbedPane);
		
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(UIManager.getColor("Button.highlight"));
				tabbedPane.addTab("All Articles", null, panel_1, null);
				panel_1.setLayout(null);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBackground(UIManager.getColor("Button.highlight"));
				panel_4.setBounds(10, 11, 920, 432);
				panel_1.add(panel_4);
				
				JScrollPane scrollPane = new JScrollPane();
				
				JPanel panel_5 = new JPanel();
				panel_5.setBackground(UIManager.getColor("Button.highlight"));
				panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GroupLayout gl_panel_4 = new GroupLayout(panel_4);
				gl_panel_4.setHorizontalGroup(
					gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(7)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(12, Short.MAX_VALUE))
				);
				gl_panel_4.setVerticalGroup(
					gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(22, Short.MAX_VALUE))
				);
				panel_5.setLayout(null);
				
				JLabel label = new JLabel("Title");
				label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
				label.setBounds(27, 25, 46, 14);
				panel_5.add(label);
				
				tf_title_update = new JTextField();
				tf_title_update.setColumns(10);
				tf_title_update.setBounds(83, 17, 217, 25);
				panel_5.add(tf_title_update);
				
				JLabel label_1 = new JLabel("Author");
				label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
				label_1.setBounds(27, 74, 46, 14);
				panel_5.add(label_1);
				
				tf_author_update = new JTextField();
				tf_author_update.setColumns(10);
				tf_author_update.setBounds(83, 71, 217, 22);
				panel_5.add(tf_author_update);
				
				JLabel label_2 = new JLabel("Text");
				label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
				label_2.setBounds(27, 123, 46, 14);
				panel_5.add(label_2);
				
				JTextArea tf_text_update = new JTextArea();
				tf_text_update.setBackground(SystemColor.menu);
				tf_text_update.setBounds(83, 119, 217, 196);
				panel_5.add(tf_text_update);
				
				JLabel delete = new JLabel("");
				delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						article = articles.get(table.getSelectedRow());
						ArticleManagementDelegate.doDelete(article);
						articles = ArticleManagementDelegate.doReadAll();
						initDataBindings();
						tf_text_update.setText("");
						tf_author_update.setText("");
						tf_title_update.setText("");
					}
				});
				delete.setIcon(new ImageIcon(ArticlesManagement.class.getResource("/pdev/financialbrains/client/pictures/delete.png")));
				delete.setBounds(268, 322, 64, 62);
				panel_5.add(delete);
				
				JLabel update = new JLabel("");
				update.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						article.setText(tf_text_update.getText());
						article.setAuthor(tf_author_update.getText());
						article.setTitle(tf_title_update.getText());
						ArticleManagementDelegate.doUpdate(article);
						articles = ArticleManagementDelegate.doReadAll();
						initDataBindings();
					}
				});
				update.setIcon(new ImageIcon(ArticlesManagement.class.getResource("/pdev/financialbrains/client/pictures/add.png")));
				update.setBounds(345, 309, 78, 80);
				panel_5.add(update);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						article = articles.get(table.getSelectedRow());
						tf_title_update.setText(article.getTitle());
						tf_author_update.setText(article.getAuthor());
						tf_text_update.setText(article.getText());
					}
				});
				scrollPane.setViewportView(table);
				panel_4.setLayout(gl_panel_4);
				
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(UIManager.getColor("Button.highlight"));
						tabbedPane.addTab("New Article", null, panel_2, null);
						panel_2.setLayout(null);
						
						JPanel panel = new JPanel();
						panel.setOpaque(false);
						panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel.setBounds(30, 22, 342, 363);
						panel_2.add(panel);
						panel.setLayout(null);
						
						JLabel lblTitle = new JLabel("Title");
						lblTitle.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						lblTitle.setBounds(38, 62, 46, 14);
						panel.add(lblTitle);
						
						JLabel lblAuthor = new JLabel("Author");
						lblAuthor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						lblAuthor.setBounds(38, 111, 46, 14);
						panel.add(lblAuthor);
						
						JLabel lblText = new JLabel("Text");
						lblText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						lblText.setBounds(38, 160, 46, 14);
						panel.add(lblText);
						
						tf_title = new JTextField();
						tf_title.setBounds(94, 54, 217, 25);
						panel.add(tf_title);
						tf_title.setColumns(10);
						
						tf_author = new JTextField();
						tf_author.setBounds(94, 108, 217, 22);
						panel.add(tf_author);
						tf_author.setColumns(10);
						
						JTextArea tf_text = new JTextArea();
						
						tf_text.setBackground(SystemColor.control);
						tf_text.setBounds(94, 156, 217, 196);
						panel.add(tf_text);
						
						JPanel panel_3 = new JPanel();
						panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel_3.setOpaque(false);
						panel_3.setBounds(395, 22, 380, 363);
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						
						JLabel lblNewLabel = new JLabel("Photo");
						lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 13));
						lblNewLabel.setBounds(32, 61, 46, 14);
						panel_3.add(lblNewLabel);
						
						JLabel lbl_photo = new JLabel("");
						lbl_photo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						lbl_photo.setBounds(136, 99, 179, 121);
						panel_3.add(lbl_photo);
						
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								JFileChooser fc = new JFileChooser();
						        int returnVal = fc.showDialog(null, "Ajouter");
						        image = fc.getSelectedFile();
						        if (image.isFile()) {
						            System.out.println(image.getAbsolutePath());
						            
						      
						           //***Mta3b  URL
						          // article.setUrl(url);
						        
						            BufferedImage myPicture2;
						            try {
						                myPicture2 = ImageIO.read(new File(image.getAbsolutePath()));
						                JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
						                lbl_photo.removeAll();
						                lbl_photo.add(picLabel2);
						                lbl_photo.repaint();
						                lbl_photo.revalidate();
						                lbl_photo.setIcon(new ImageIcon(myPicture2));
						            } catch (IOException ex) {
						                System.out.println(ex);
						            }
						        }
							}
						
						});
						lblNewLabel_1.setIcon(new ImageIcon(ArticlesManagement.class.getResource("/pdev/financialbrains/client/pictures/Upload Picture.png")));
						lblNewLabel_1.setBounds(88, 53, 46, 32);
						panel_3.add(lblNewLabel_1);
						
						
						
						JLabel lbl_add = new JLabel("");
						lbl_add.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								Article article1 = new Article();
								article1.setTitle(tf_title.getText());
								article1.setAuthor(tf_author.getText());
								article1.setText(tf_text.getText());
								//SimpleDateFormat d= new SimpleDateFormat("dd/MM/yyyy");
								Date date = new Date();
								article1.setDate(date);
								 
								
								
							//ArticleManagementDelegate.doCreate(article);
							}
						});
						lbl_add.setIcon(new ImageIcon(ArticlesManagement.class.getResource("/pdev/financialbrains/client/pictures/addIcon.png")));
						lbl_add.setBounds(297, 285, 58, 67);
						panel_3.add(lbl_add);
		
		JLabel dashbord = new JLabel("");
		dashbord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AdminHome().setVisible(true);
				fermer();
			}
		});
		dashbord.setBounds(20, 98, 225, 37);
		contentPane.add(dashbord);
		
		JLabel lbl_account = new JLabel("");
		lbl_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	new AccountManagement().setVisible(true);
				fermer();
			}
		});
		lbl_account.setBounds(20, 168, 225, 42);
		contentPane.add(lbl_account);
		
		JLabel lbl_complaint = new JLabel("");
		lbl_complaint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fermer();
				new ComplaintManagement().setVisible(true);
			}
		});
		lbl_complaint.setBounds(20, 233, 205, 47);
		contentPane.add(lbl_complaint);
		
		JLabel lbl_article = new JLabel("");
		lbl_article.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ArticlesManagement().setVisible(true);
				fermer();
			}
		});
		lbl_article.setBounds(20, 304, 205, 47);
		contentPane.add(lbl_article);
						
						
						
						

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(ArticlesManagement.class.getResource(
				"/pdev/financialbrains/client/pictures/backAdminGrand2.PNG")));
		background.setBounds(0, 0, 1230, 696);
		contentPane.add(background);
		initDataBindings();
	}

	private void fermer() {
		this.setVisible(false);
	}
	protected void initDataBindings() {
		JTableBinding<Article, List<Article>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, articles, table);
		//
		BeanProperty<Article, String> articleBeanProperty = BeanProperty.create("title");
		jTableBinding.addColumnBinding(articleBeanProperty).setColumnName("Title");
		//
		BeanProperty<Article, String> articleBeanProperty_1 = BeanProperty.create("author");
		jTableBinding.addColumnBinding(articleBeanProperty_1).setColumnName("Author");
		//
		BeanProperty<Article, String> articleBeanProperty_2 = BeanProperty.create("text");
		jTableBinding.addColumnBinding(articleBeanProperty_2).setColumnName("Text");
		//
		BeanProperty<Article, Date> articleBeanProperty_3 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(articleBeanProperty_3).setColumnName("Date");
		//
		jTableBinding.bind();
	}
}
