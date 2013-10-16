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


public class MenuStudent extends JPanel implements ActionListener {
	JButton btnSearch;
	JButton btnLogOut;
	 JPanel contentPane;
	  JButton btnAssignCourseId;
	   JButton btnAddCustomTime;
	   JButton btnDeleteCustomTime;

	
	public MenuStudent() {

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
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnAddCustomTime = new JButton("Custom Time");
		GridBagConstraints gbc_btnAddCustomTime = new GridBagConstraints();
		gbc_btnAddCustomTime.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddCustomTime.gridx = 1;
		gbc_btnAddCustomTime.gridy = 5;
		contentPane.add(btnAddCustomTime, gbc_btnAddCustomTime);

		btnSearch = new JButton("Course");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 3;
		gbc_btnSearch.gridy = 5;
		contentPane.add(btnSearch, gbc_btnSearch);
		btnSearch.addActionListener(this);

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
		add(contentPane);
				
				btnDeleteCustomTime = new JButton("Custom Time");
				GridBagConstraints gbc_btnDeleteCustomTime = new GridBagConstraints();
				gbc_btnDeleteCustomTime.insets = new Insets(0, 0, 5, 5);
				gbc_btnDeleteCustomTime.gridx = 5;
				gbc_btnDeleteCustomTime.gridy = 5;
				contentPane.add(btnDeleteCustomTime, gbc_btnDeleteCustomTime);
				
				btnAssignCourseId = new JButton("Assign Course ID");
				GridBagConstraints gbc_btnAssignCourseId = new GridBagConstraints();
				gbc_btnAssignCourseId.insets = new Insets(0, 0, 5, 5);
				gbc_btnAssignCourseId.gridx = 3;
				gbc_btnAssignCourseId.gridy = 9;
				contentPane.add(btnAssignCourseId, gbc_btnAssignCourseId);
		
				btnLogOut = new JButton("Log Out");
				GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
				gbc_btnLogOut.insets = new Insets(0, 0, 5, 5);
				gbc_btnLogOut.gridx = 3;
				gbc_btnLogOut.gridy = 10;
				contentPane.add(btnLogOut, gbc_btnLogOut);
		btnLogOut.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object src = evt.getSource();
		CrossVariables x = new CrossVariables();
}
	}
