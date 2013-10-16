/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;


public class Menu extends JPanel implements ActionListener {
	
	
	
	JButton btnDeleteCourse;
	JButton btnAddModule;
	JButton btnSearch;
	JButton btnDeleteModule;
	JButton btnAddTime;
	JButton btnLogOut;
	JButton btnDeleteTime;
	JButton btnAddCourse;
	 JPanel contentPane;
	 JButton btnAddAccount;
	 JButton btnDeleteAccount;
	  JLabel lblEdit;
	  JButton btnEditAccount;

	 /*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Menu frame = new Menu();
						 frame.setLocationRelativeTo(null);

						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}*/
	public Menu() {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e1) {
		    // handle exception
		} catch (ClassNotFoundException e1) {
		    // handle exception
		} catch (InstantiationException e1) {
		    // handle exception
		} catch (IllegalAccessException e1) {
		    // handle exception
		}
		
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{85, 67, 65, 119, 65, 67, 86, 0};
		gbl_contentPane.rowHeights = new int[]{101, 24, 35, 14, 23, 23, 23, 0, 0, 0, 0, 104, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Tempus Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Addition");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Deletion");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		btnAddCourse = new JButton("Course");
		GridBagConstraints gbc_btnAddCourse = new GridBagConstraints();
		gbc_btnAddCourse.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddCourse.gridx = 1;
		gbc_btnAddCourse.gridy = 4;
		contentPane.add(btnAddCourse, gbc_btnAddCourse);
		btnAddCourse.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		btnDeleteCourse = new JButton("Course");
		GridBagConstraints gbc_btnDeleteCourse = new GridBagConstraints();
		gbc_btnDeleteCourse.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteCourse.gridx = 5;
		gbc_btnDeleteCourse.gridy = 4;
		contentPane.add(btnDeleteCourse, gbc_btnDeleteCourse);
		btnDeleteCourse.addActionListener(this);

		btnAddModule = new JButton("Module");
		GridBagConstraints gbc_btnAddModule = new GridBagConstraints();
		gbc_btnAddModule.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddModule.gridx = 1;
		gbc_btnAddModule.gridy = 5;
		contentPane.add(btnAddModule, gbc_btnAddModule);
		btnAddModule.addActionListener(this);

		btnSearch = new JButton("Course");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 5;
		contentPane.add(btnSearch, gbc_btnSearch);
		btnSearch.addActionListener(this);
		
				btnDeleteModule = new JButton("Module");
				GridBagConstraints gbc_btnDeleteModule = new GridBagConstraints();
				gbc_btnDeleteModule.insets = new Insets(0, 0, 5, 5);
				gbc_btnDeleteModule.gridx = 5;
				gbc_btnDeleteModule.gridy = 5;
				contentPane.add(btnDeleteModule, gbc_btnDeleteModule);
				btnDeleteModule.addActionListener(this);

		btnAddTime = new JButton("Time");
		GridBagConstraints gbc_btnAddTime = new GridBagConstraints();
		gbc_btnAddTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddTime.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddTime.gridx = 1;
		gbc_btnAddTime.gridy = 6;
		contentPane.add(btnAddTime, gbc_btnAddTime);
		btnAddTime.addActionListener(this);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.gridheight = 5;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 3;
		contentPane.add(separator, gbc_separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.VERTICAL;
		gbc_separator_1.gridheight = 5;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 4;
		gbc_separator_1.gridy = 3;
		contentPane.add(separator_1, gbc_separator_1);
		
		btnDeleteTime = new JButton("Time");
		GridBagConstraints gbc_btnDeleteTime = new GridBagConstraints();
		gbc_btnDeleteTime.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteTime.gridx = 5;
		gbc_btnDeleteTime.gridy = 6;
		contentPane.add(btnDeleteTime, gbc_btnDeleteTime);
		btnDeleteTime.addActionListener(this);
								
		btnAddAccount = new JButton("Account");
		GridBagConstraints gbc_btnAddAccount = new GridBagConstraints();
		gbc_btnAddAccount.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAccount.gridx = 1;
		gbc_btnAddAccount.gridy = 7;
		contentPane.add(btnAddAccount, gbc_btnAddAccount);
		
		lblEdit = new JLabel("Edit");
		GridBagConstraints gbc_lblEdit = new GridBagConstraints();
		gbc_lblEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdit.gridx = 3;
		gbc_lblEdit.gridy = 7;
		contentPane.add(lblEdit, gbc_lblEdit);

		btnDeleteAccount = new JButton("Account");
		GridBagConstraints gbc_btnDeleteAccount = new GridBagConstraints();
		gbc_btnDeleteAccount.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteAccount.gridx = 5;
		gbc_btnDeleteAccount.gridy = 7;
		contentPane.add(btnDeleteAccount, gbc_btnDeleteAccount);
				
				btnEditAccount = new JButton("Account");
				GridBagConstraints gbc_btnEditAccount = new GridBagConstraints();
				gbc_btnEditAccount.anchor = GridBagConstraints.NORTH;
				gbc_btnEditAccount.insets = new Insets(0, 0, 5, 5);
				gbc_btnEditAccount.gridx = 3;
				gbc_btnEditAccount.gridy = 8;
				contentPane.add(btnEditAccount, gbc_btnEditAccount);
		
				btnLogOut = new JButton("Log Out");
				GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
				gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
				gbc_btnLogOut.gridx = 3;
				gbc_btnLogOut.gridy = 10;
				contentPane.add(btnLogOut, gbc_btnLogOut);
		btnLogOut.addActionListener(this);
		add(contentPane);
		//setContentPane(contentPane);

	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object src = evt.getSource();
		CrossVariables x = new CrossVariables();
		if(src == btnAddModule)
		{
		
}
}
	}
