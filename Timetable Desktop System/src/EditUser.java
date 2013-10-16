/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.SystemColor;

public class EditUser extends JPanel implements ActionListener {
	JComboBox cbType;
	JTextField txtUserName;
	JTextField txtPassword;
	JTextField txtEmail;
	JButton btnCreateAccount;
	JButton btnCancel;
	//JButton btnGetDetails;
	boolean sameID = false;
	boolean sameUsername = false;
	boolean sameEmail = false;

	CrossVariables x = new CrossVariables();

	public JPanel contentPane;
	private JTextField txtLecturer;
	String result = null;

	InputStream is = null;

	StringBuilder sb = null;

	String[][] courseNameID;
	String[][] moduleNameID;
	private JTextField txtFirst;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField txtLast;
	private JLabel lblEnterUsername;
	private JTextField txtUserFind;
	JButton btnGetDetails;
	String username;

	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the frame.
	 */
	public EditUser() {

		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 155, 75, 155, 155, 0 };
		gbl_contentPane.rowHeights = new int[] { 110, 0, 0, 20, 20, 20, 20, 20,
				20, 0, 0, 0, 110, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Account Type:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] { "",
				"Administrator", "Student" }));
		GridBagConstraints gbc_cbDept = new GridBagConstraints();
		gbc_cbDept.anchor = GridBagConstraints.SOUTH;
		gbc_cbDept.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDept.insets = new Insets(0, 0, 5, 5);
		gbc_cbDept.gridx = 2;
		gbc_cbDept.gridy = 1;
		contentPane.add(cbType, gbc_cbDept);
		cbType.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("User Name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtUserName = new JTextField();
		GridBagConstraints gbc_cbCourse = new GridBagConstraints();
		gbc_cbCourse.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCourse.insets = new Insets(0, 0, 5, 5);
		gbc_cbCourse.gridx = 2;
		gbc_cbCourse.gridy = 2;
		contentPane.add(txtUserName, gbc_cbCourse);
		txtUserName.addActionListener(this);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtPassword = new JTextField();

		GridBagConstraints gbc_cbModule = new GridBagConstraints();
		gbc_cbModule.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbModule.insets = new Insets(0, 0, 5, 5);
		gbc_cbModule.gridx = 2;
		gbc_cbModule.gridy = 3;
		contentPane.add(txtPassword, gbc_cbModule);

		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtEmail = new JTextField();
		GridBagConstraints gbc_cbRoom = new GridBagConstraints();
		gbc_cbRoom.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbRoom.insets = new Insets(0, 0, 5, 5);
		gbc_cbRoom.gridx = 2;
		gbc_cbRoom.gridy = 4;
		contentPane.add(txtEmail, gbc_cbRoom);

		lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 5;
		contentPane.add(lblFirstName, gbc_lblFirstName);

		txtFirst = new JTextField();
		GridBagConstraints gbc_txtFirst = new GridBagConstraints();
		gbc_txtFirst.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirst.gridx = 2;
		gbc_txtFirst.gridy = 5;
		contentPane.add(txtFirst, gbc_txtFirst);
		txtFirst.setColumns(10);

		lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 6;
		contentPane.add(lblLastName, gbc_lblLastName);

		txtLast = new JTextField();
		GridBagConstraints gbc_txtLast = new GridBagConstraints();
		gbc_txtLast.insets = new Insets(0, 0, 5, 5);
		gbc_txtLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLast.gridx = 2;
		gbc_txtLast.gridy = 6;
		contentPane.add(txtLast, gbc_txtLast);
		txtLast.setColumns(10);
		

		lblEnterUsername = new JLabel("Enter Username:");
		GridBagConstraints gbc_lblEnterUsername = new GridBagConstraints();
		gbc_lblEnterUsername.anchor = GridBagConstraints.WEST;
		gbc_lblEnterUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterUsername.gridx = 1;
		gbc_lblEnterUsername.gridy = 8;
		contentPane.add(lblEnterUsername, gbc_lblEnterUsername);

		txtUserFind = new JTextField();
		GridBagConstraints gbc_txtUserFind = new GridBagConstraints();
		gbc_txtUserFind.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserFind.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserFind.gridx = 2;
		gbc_txtUserFind.gridy = 8;
		contentPane.add(txtUserFind, gbc_txtUserFind);
		txtUserFind.setColumns(10);

		btnGetDetails = new JButton("Retrieve Details");
		GridBagConstraints gbc_btnGetDetails = new GridBagConstraints();
		gbc_btnGetDetails.gridwidth = 2;
		gbc_btnGetDetails.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetDetails.gridx = 1;
		gbc_btnGetDetails.gridy = 9;
		contentPane.add(btnGetDetails, gbc_btnGetDetails);
		btnGetDetails.addActionListener(this);


		btnCreateAccount = new JButton("Edit Account");
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.insets = new Insets(0, 0, 5, 5);
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 11;
		contentPane.add(btnCreateAccount, gbc_btnContinue);

		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 11;
		contentPane.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		btnCreateAccount.addActionListener(this);
		add(contentPane);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();

		if(src == btnGetDetails)
		{
			if(txtUserFind.getText().equals("") )
			{
				JOptionPane.showMessageDialog(this,"Please enter a username into the field provided."); 
				
			}
			else
			{






				try{
					DefaultHttpClient httpclient = new DefaultHttpClient();
					HttpGet httppost = new HttpGet("http://garageserver.herobo.com/selectUsers.php");
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					is = entity.getContent();

				}catch(Exception e){

				}
				try{

					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					sb = new StringBuilder();
					sb.append(reader.readLine() + "\n");
					String line="0";

					while ((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}

					is.close();
					result=sb.toString();

				}catch(Exception e){
				}
				//paring data

				try{
					JSONArray jArray = new JSONArray(result);
					JSONObject json_data=null;


					username = txtUserFind.getText();
					String userGotten = "";
					String password = "";
					String email = "";
					String first = "";
					String second = "";
					int type = 0;


					String usernameList = "";

					for(int i=0;i<jArray.length();i++){

						json_data = jArray.getJSONObject(i);
						usernameList = json_data.getString("username");


						if(username.equals(usernameList))
						{
							userGotten = usernameList;
							password = json_data.getString("password");
							email = json_data.getString("email");
							first = json_data.getString("fname");
							second = json_data.getString("lname");
							type = json_data.getInt("isAdmin");
							i = jArray.length();
						}

					}
					txtUserName.setText(userGotten);
					txtPassword.setText(password);
					txtEmail.setText(email);
					txtFirst.setText(first);
					txtLast.setText(second);
					if(type == 1)
						cbType.setSelectedIndex(1);
					else if(type == 0)
						cbType.setSelectedIndex(2);


				}catch(JSONException e1){

				}catch (ParseException e1){
					e1.printStackTrace();
				}
			}
		}



		else if(src == btnCreateAccount)	
		{ 
			String check = txtUserFind.getText();
			if(check != "")
			{
				
				if(cbType.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(this,"Please choose a valid account type."); 
					

				}
				else
				{
					boolean userFound = false;

					try{
						DefaultHttpClient httpclient = new DefaultHttpClient();
						HttpGet httppost = new HttpGet("http://garageserver.herobo.com/selectUsers.php");
						HttpResponse response = httpclient.execute(httppost);
						HttpEntity entity = response.getEntity();
						is = entity.getContent();

					}catch(Exception e){

					}
					try{

						BufferedReader reader = new BufferedReader(new InputStreamReader(is));
						sb = new StringBuilder();
						sb.append(reader.readLine() + "\n");
						String line="0";

						while ((line = reader.readLine()) != null) {
							sb.append(line + "\n");
						}

						is.close();
						result=sb.toString();

					}catch(Exception e){
					}
					//paring data

					try{
						JSONArray jArray = new JSONArray(result);
						JSONObject json_data=null;



						String usernameList;


						for(int i=0;i<jArray.length();i++){

							json_data = jArray.getJSONObject(i);
							usernameList = json_data.getString("username");

							if(txtUserFind.equals(usernameList))
							{
								userFound = true;
								i = jArray.length();
							}

						}

					}catch(JSONException e1){

					}catch (ParseException e1){
						e1.printStackTrace();
					}

					String newName = txtUserName.getText();
					String password = txtPassword.getText();
					String email = txtEmail.getText();
					String first = txtFirst.getText();
					String second = txtLast.getText();
					String type = "";
					boolean run = true;
					String oldUsername = username;
					if(cbType.getSelectedItem() == "Student")
					{
						type = "0";
					}
					else if(cbType.getSelectedItem() == "Administrator")
						type = "1";
					else
						run = false;

					if(run == true)
					{




						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("email", email));
						nameValuePairs.add(new BasicNameValuePair("fname", first));
						nameValuePairs.add(new BasicNameValuePair("lname", second));
						nameValuePairs.add(new BasicNameValuePair("newName", newName));
						nameValuePairs.add(new BasicNameValuePair("password", password));
						nameValuePairs.add(new BasicNameValuePair("type", type));
						nameValuePairs.add(new BasicNameValuePair("username", oldUsername));

						try {
							DefaultHttpClient httpclient1 = new DefaultHttpClient();
							HttpPost httppost = new HttpPost("http://garageserver.herobo.com/UpdateAccount.php");

							httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

							HttpResponse response = httpclient1.execute(httppost);

							txtUserName.setText("");
							txtPassword.setText("");
							txtEmail.setText("");
							txtFirst.setText("");
							txtLast.setText("");

							cbType.setSelectedIndex(0);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					else if(userFound == false)
					{

						JOptionPane.showMessageDialog(this,"Username not found."); 

					}
				}
			
			}
			else 
			{

				JOptionPane.showMessageDialog(this,"Please enter a username."); 

			}
		}



	}






}


