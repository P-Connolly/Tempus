import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class LogIn extends JPanel implements ActionListener {

	private JPanel contentPane;
	JTextField txtUsername;
	JPasswordField txtPassword;
	JButton btnLogIn;
	String result = null;
	InputStream is = null;
	StringBuilder sb = null;
	int loginAttempt = 0;
	int loginRemaining = 3;
	 JButton btnExit;

	
	
	
	
	public boolean login()
	{
		String getUser = txtUsername.getText();
		String getPassword = txtPassword.getText();
		
		try {

			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("username", getUser));
			nameValuePairs.add(new BasicNameValuePair("password", getPassword));

			DefaultHttpClient httpclient = new DefaultHttpClient();

			HttpPost httppost = new HttpPost(
					"http://garageserver.herobo.com/login.php");

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost);

			HttpEntity entity = response.getEntity();

			is = entity.getContent();

		} catch (Exception e) {
		}
		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");
			String line = "0";

			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			is.close();
			result = sb.toString();

		} catch (Exception e) {
		}
		// paring data

		try {
			JSONArray jArray = new JSONArray(result);

			JSONObject json_data = null;
			
			int rowAmount = 0;
			for (int i = 0; i < jArray.length(); i++) {
				
				
				rowAmount++;
			}


			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				txtPassword.setText("");
				txtUsername.setText("");
				loginAttempt = 0;
				loginRemaining = 3;
				CrossVariables x = new CrossVariables();
				x.username = getUser;
				x.userCourseID = json_data.getString("courseID");
				x.userType = json_data.getString("isAdmin");

				return true;

			
			}
			
			
		} catch (Exception e)
		{}
		loginAttempt++;
		loginRemaining--;
		if(loginAttempt == 3)
		{
			System.exit(1);
		}
		return false;
		}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{84, 388, 90, 0};
		gbl_contentPane.rowHeights = new int[]{84, 227, 28, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tempus", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{85, 0, 152, 74, 0};
		gbl_panel.rowHeights = new int[]{51, 0, 0, 20, 0, 49, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblLogInTo = new JLabel("Log In To Proceed");
		lblLogInTo.setForeground(SystemColor.text);
		lblLogInTo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblLogInTo = new GridBagConstraints();
		gbc_lblLogInTo.gridwidth = 2;
		gbc_lblLogInTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogInTo.gridx = 0;
		gbc_lblLogInTo.gridy = 0;
		panel.add(lblLogInTo, gbc_lblLogInTo);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 1;
		panel.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		((JPasswordField) txtPassword).setEchoChar('*');
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 2;
		panel.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		btnLogIn = new JButton("Log In");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnLogIn, gbc_btnNewButton);
		
		btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.EAST;
		gbc_btnExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnExit.gridx = 2;
		gbc_btnExit.gridy = 4;
		panel.add(btnExit, gbc_btnExit);
		btnLogIn.addActionListener(this);
		add(contentPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
