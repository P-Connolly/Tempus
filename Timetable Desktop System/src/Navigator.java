import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Navigator extends JFrame  implements ActionListener{

	private JPanel contentPane;
    private CardLayout cardLayout = new CardLayout();
	CrossVariables x = new CrossVariables();
	DeleteTimeGUI deleteTimeGui;
	SetTimeGUI setTimeGUI;
	boolean deleteGUIentered = false;
	boolean addGUIentered = false;
	boolean searchGUIentered = false;
	boolean addCustomEntered = false;
	boolean deleteCustomEntered = false;

	LogIn login = new LogIn();
	
	 Menu menu = new Menu();
	 MenuStudent menuStudent = new MenuStudent();

	 AssignUserCourse assignUserCourse = new AssignUserCourse();
	 ViewUserCourse viewUserCourse;
	 RemoveUserCourse removeUserCourse;

	 
	 AddCourse addCourse = new AddCourse();
	 AddModule addModule = new AddModule();
	 AddTime addTime = new AddTime();
	 AddAccount addAccount = new AddAccount();

	
	 DeleteCourse deleteCourse = new DeleteCourse();
	 DeleteModule deleteModule = new DeleteModule();
	 DeleteTime deleteTime = new DeleteTime();
	 DeleteAccount deleteAccount = new DeleteAccount();

	 SearchCourse searchCourse = new SearchCourse();
	 SearchResult searchResult;

	
	 EditUser editUser = new EditUser();

	
	JPanel mainPanel = new JPanel();


	/**
	 * Launch the application.
	 */
	
	
	    //listen to the actions made by the Frame class

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigator frame = new Navigator();
					 frame.setLocationRelativeTo(null);

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
	public Navigator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 500);
		
		
		login.setLayout(new CardLayout(0,0));
		login.btnLogIn.addActionListener(this);
		login.btnExit.addActionListener(this);
		
		menu.setLayout(new CardLayout(0,0));

		menu.btnAddCourse.addActionListener(this);
		menu.btnAddModule.addActionListener(this);
		menu.btnAddTime.addActionListener(this);
		menu.btnDeleteCourse.addActionListener(this);
		menu.btnDeleteModule.addActionListener(this);
		menu.btnDeleteTime.addActionListener(this);
		menu.btnSearch.addActionListener(this);
		menu.btnAddAccount.addActionListener(this);
		menu.btnDeleteAccount.addActionListener(this);
		menu.btnLogOut.addActionListener(this);
		menu.btnEditAccount.addActionListener(this);


		menuStudent.setLayout(new CardLayout(0,0));
		menuStudent.btnSearch.addActionListener(this);
		menuStudent.btnAssignCourseId.addActionListener(this);
		menuStudent.btnAddCustomTime.addActionListener(this);
		menuStudent.btnDeleteCustomTime.addActionListener(this);
		menuStudent.btnLogOut.addActionListener(this);
		menuStudent.btnLogOut.addActionListener(this);

		
		addCourse.setLayout(new CardLayout(0,0));
		addCourse.btnCancel.addActionListener(this);
		
		addModule.setLayout(new CardLayout(0,0));
		addModule.btnCancel.addActionListener(this);
		
		addTime.setLayout(new CardLayout(0,0));
		addTime.btnCancel.addActionListener(this);
		addTime.btnContinue.addActionListener(this);
		
		addAccount.setLayout(new CardLayout(0,0));
		addAccount.btnCancel.addActionListener(this);
		
		deleteCourse.setLayout(new CardLayout(0,0));
		deleteCourse.btnCancel.addActionListener(this);
		
		deleteModule.setLayout(new CardLayout(0,0));
		deleteModule.btnCancel.addActionListener(this);
		
		editUser.setLayout(new CardLayout(0,0));
		editUser.btnCancel.addActionListener(this);
		
		deleteTime.setLayout(new CardLayout(0,0));
		deleteTime.btnCancel.addActionListener(this);
		deleteTime.btnContinue.addActionListener(this);
		
		deleteAccount.setLayout(new CardLayout(0,0));
		deleteAccount.btnCancel.addActionListener(this);
		
		searchCourse.setLayout(new CardLayout(0,0));
		searchCourse.btnCancel.addActionListener(this);
		searchCourse.btnContinue.addActionListener(this);

		assignUserCourse.setLayout(new CardLayout(0,0));
		assignUserCourse.btnAssignCourse.addActionListener(this);
		assignUserCourse.btnCancel.addActionListener(this);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add(login, "login");
		mainPanel.add(menu, "menu");
		mainPanel.add(menuStudent, "menuStudent");
		mainPanel.add(addCourse, "addCourse");
		mainPanel.add(addModule, "addModule");
		mainPanel.add(addTime, "addTime");
		mainPanel.add(addAccount, "addAccount");
		mainPanel.add(deleteCourse, "deleteCourse");
		mainPanel.add(deleteAccount, "deleteAccount");
		mainPanel.add(deleteModule, "deleteModule");
		mainPanel.add(deleteTime, "deleteTime");
		mainPanel.add(searchCourse, "searchCourse");
		mainPanel.add(assignUserCourse, "assignUserCourse");
		mainPanel.add(editUser, "editUser");

		
		add(mainPanel);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object src = evt.getSource();
		
	

		if(src == menu.btnAddCourse)
		{
			 CardLayout cl = (CardLayout)(mainPanel.getLayout());
		        cl.show(mainPanel, "addCourse");
				this.setLocationRelativeTo(null);

		}
		else if(src == menu.btnEditAccount)
		{
			 CardLayout cl = (CardLayout)(mainPanel.getLayout());
		        cl.show(mainPanel, "editUser");
				this.setLocationRelativeTo(null);
		}
		else if(src == menuStudent.btnAddCustomTime)
		{
			if(x.userCourseID.equals("0"))
			{

				JOptionPane.showMessageDialog(this, "You must first assign a course to this account.");

			}
			else
			{
			viewUserCourse = new ViewUserCourse();
			this.setBounds(100, 100, 679, 731);
			this.setLocationRelativeTo(null);
			mainPanel.add(viewUserCourse, "viewUserCourse");
			CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			c2.show(mainPanel, "viewUserCourse");
			viewUserCourse.setLayout(new CardLayout(0,0));
			viewUserCourse.btnBack.addActionListener(this);
			addCustomEntered = true;
			}
		
		}
		else if(src == menuStudent.btnDeleteCustomTime)
		{

			if(x.userCourseID.equals("0"))
			{

				JOptionPane.showMessageDialog(this, "You must first assign a course to this account.");

			}
			else
			{
			removeUserCourse = new RemoveUserCourse();
			this.setBounds(100, 100, 679, 731);
			this.setLocationRelativeTo(null);
			mainPanel.add(removeUserCourse, "removeUserCourse");
			CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			c2.show(mainPanel, "removeUserCourse");
			removeUserCourse.setLayout(new CardLayout(0,0));
			removeUserCourse.btnBack.addActionListener(this);
			deleteCustomEntered = true;
			}

		}
		else if(src == menu.btnAddModule)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "addModule");
				this.setLocationRelativeTo(null);

		}
		else if(src == login.btnLogIn)
		{
			if(login.txtPassword.getText().equals("") || login.txtUsername.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please fill in the appropriate details.");

			}
			else if(login.login() == true)
			{
				if(x.userType.equals("1"))
				{
				CardLayout c2 = (CardLayout)(mainPanel.getLayout());
				 c2.show(mainPanel, "menu");
					this.setLocationRelativeTo(null);
				}
				else if(x.userType.equals("0"))
				{
					CardLayout c2 = (CardLayout)(mainPanel.getLayout());
					 c2.show(mainPanel, "menuStudent");
						this.setLocationRelativeTo(null);

				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Incorrect login details, you have " + login.loginRemaining + " attempts remaining.");

			}
			 
		}
		else if(src == menu.btnAddTime)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "addTime");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnLogOut || src == menuStudent.btnLogOut)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "login");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnDeleteCourse)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "deleteCourse");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnDeleteModule)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "deleteModule");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnDeleteTime)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "deleteTime");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnSearch)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "searchCourse");
				this.setLocationRelativeTo(null);
		}
		else if(src == login.btnExit)
		{
			dispose();
		}
		else if(src == menuStudent.btnSearch)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "searchCourse");
				this.setLocationRelativeTo(null);
		}
		else if(src == menuStudent.btnAssignCourseId)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "assignUserCourse");
				this.setLocationRelativeTo(null);
		}
		else if(src == addCourse.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);

		}
		else if(src == addModule.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);

		}
		else if(src == addTime.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == deleteCourse.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == deleteModule.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == deleteTime.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}

		else if(src == searchCourse.btnCancel)
		{
			if(x.userType.equals("1"))
			{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
			}
			else
			{
				 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
				 c2.show(mainPanel, "menuStudent");
					this.setLocationRelativeTo(null);
			}
			
		}
		else if(src == menu.btnAddAccount)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "addAccount");
				this.setLocationRelativeTo(null);
		}
		else if(src == editUser.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == menu.btnDeleteAccount)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "deleteAccount");
				this.setLocationRelativeTo(null);
		}
		else if(src == addAccount.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == deleteAccount.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menu");
				this.setLocationRelativeTo(null);
		}
		else if(src == assignUserCourse.btnCancel)
		{
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menuStudent");
				this.setLocationRelativeTo(null);
		}
		else if(src == addTime.btnContinue)
		{

			if(addTime.cbCourse.getSelectedIndex() == 0 || addTime.cbDept.getSelectedIndex() == 0 || addTime.cbFloor.getSelectedIndex() == 0 || addTime.cbModule.getSelectedIndex() == 0 || addTime.cbRoom.getSelectedIndex() == 0 || addTime.txtLecturer.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please ensure you have filled in the fields correctly.");

			}
			else{
				x.courseID = addTime.courseNameID[0][addTime.cbCourse.getSelectedIndex() - 1];
				x.ModuleName = (String) addTime.cbModule.getSelectedItem();
				x.ModuleID = addTime.moduleNameID[0][addTime.cbModule.getSelectedIndex() - 1];
				x.Lecturer = addTime.txtLecturer.getText();
				x.roomNo = (String) addTime.cbRoom.getSelectedItem();
				setTimeGUI = new SetTimeGUI();
				setTimeGUI.model.setValueAt(x.ModuleName + "\n" + x.roomNo + "\n"+ x.Lecturer, 0, 0);

				setTimeGUI.setLayout(new CardLayout(0,0));
				setTimeGUI.btnBack.addActionListener(this);
				 this.setBounds(100, 100, 679, 731);
					this.setLocationRelativeTo(null);
					mainPanel.add(setTimeGUI, "setTimeGUI");

			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "setTimeGUI");
			 addTime.cbCourse.setSelectedIndex(0);
			 addTime.cbDept.setSelectedIndex(0);
			 addTime.cbFloor.setSelectedIndex(0);
			 addTime.cbModule.setSelectedIndex(0);
			 addTime.cbRoom.setSelectedIndex(0);
			 addTime.txtLecturer.setText("");
			addGUIentered = true;
			 
			}
		}
		if(addGUIentered)
		{
		 if(src == setTimeGUI.btnBack)
		{
			 this.setBounds(100, 100, 588, 500);
			 this.setLocationRelativeTo(null);
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "addTime");
		}
		}
		if (src == deleteTime.btnContinue)
		{

			if(deleteTime.cbCourse.getSelectedIndex() == 0 || deleteTime.cbDept.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(this, "Please ensure you have filled in the fields correctly.");

			}
			else
			{
			x.courseID = deleteTime.courseNameID[0][deleteTime.cbCourse.getSelectedIndex() - 1];
			deleteTimeGui = new DeleteTimeGUI();
			this.setBounds(100, 100, 679, 731);
			this.setLocationRelativeTo(null);
			mainPanel.add(deleteTimeGui, "deleteTimeGui");
			CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			c2.show(mainPanel, "deleteTimeGui");
			deleteTimeGui.setLayout(new CardLayout(0,0));
			deleteTimeGui.btnBack.addActionListener(this);
			deleteGUIentered = true;
			deleteTime.cbCourse.setSelectedIndex(0);
			deleteTime.cbDept.setSelectedIndex(0);
			 }
			
			
		}
		if(deleteGUIentered == true)
		{
			if (src == deleteTimeGui.btnBack)
			{
				
			 this.setBounds(100, 100, 588, 500);
			 this.setLocationRelativeTo(null);
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "deleteTime");
			 
			}
		}
		if (src == searchCourse.btnContinue)
		{
			if(searchCourse.cbCourse.getSelectedIndex() == 0 || searchCourse.cbDept.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(this, "Please ensure you have filled in the fields correctly.");

			}
			else
			{
				
			x.courseID = searchCourse.courseNameID[0][searchCourse.cbCourse.getSelectedIndex() - 1];
			searchResult = new SearchResult();
			this.setBounds(100, 100, 679, 731);
			this.setLocationRelativeTo(null);
			mainPanel.add(searchResult, "searchResult");
			CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			c2.show(mainPanel, "searchResult");
			searchResult.setLayout(new CardLayout(0,0));
			searchResult.btnBack.addActionListener(this);
			searchGUIentered = true;
			searchCourse.cbCourse.setSelectedIndex(0);
			searchCourse.cbDept.setSelectedIndex(0);
			 }
			
			
		}
		if(searchGUIentered)
		{
		if (src == searchResult.btnBack)
		{
			 this.setBounds(100, 100, 588, 500);
			 this.setLocationRelativeTo(null);
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "searchCourse");
		}
		}
		if(addCustomEntered)
		{
		if (src == viewUserCourse.btnBack)
		{
			 this.setBounds(100, 100, 588, 500);
			 this.setLocationRelativeTo(null);
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menuStudent");
		}
		}
		if(deleteCustomEntered)
		{
		if (src == removeUserCourse.btnBack)
		{
			 this.setBounds(100, 100, 588, 500);
			 this.setLocationRelativeTo(null);
			 CardLayout c2 = (CardLayout)(mainPanel.getLayout());
			 c2.show(mainPanel, "menuStudent");
		}
		}
}
}
