import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

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


public class DeleteAccount extends JPanel implements ActionListener{

	private JPanel contentPane;
	int id[];
	String firstName[];
	String lastName[];
	String userName[];
	String email[];
	DefaultTableModel model;
	JComboBox cbType;
	String result = null;
boolean delete = false;
	InputStream is = null;

	StringBuilder sb = null;
	
	private JTable table;

	private JLabel lblNewLabel_1;
	private JButton btnDeleteAccount;
	JButton btnCancel;
	/**
	 * Launch the application.
	 */
	
	public DeleteAccount() {
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 0, 125, 131, 0};
		gbl_contentPane.rowHeights = new int[]{71, 0, 164, 20, 20, 0, 42, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Account Type:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] {"", "Administrator", "Student"}));
		GridBagConstraints gbc_cbType = new GridBagConstraints();
		gbc_cbType.insets = new Insets(0, 0, 5, 5);
		gbc_cbType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbType.gridx = 2;
		gbc_cbType.gridy = 0;
		contentPane.add(cbType, gbc_cbType);
		cbType.addActionListener(this);
		
		model = new DefaultTableModel(){
			 @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};

		// Create a couple of columns
		model.addColumn("ID");
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("User Name");
		model.addColumn("E-mail");

		
		table = new JTable(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 3;
		gbc_table.gridwidth = 4;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		JScrollPane pane = new JScrollPane(table);  

		contentPane.add(pane, gbc_table);
		
		btnDeleteAccount = new JButton("Delete Account");
		GridBagConstraints gbc_btnDeleteAccount = new GridBagConstraints();
		gbc_btnDeleteAccount.anchor = GridBagConstraints.WEST;
		gbc_btnDeleteAccount.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteAccount.gridx = 1;
		gbc_btnDeleteAccount.gridy = 6;
		contentPane.add(btnDeleteAccount, gbc_btnDeleteAccount);
		btnDeleteAccount.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 6;
		contentPane.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		add(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		
		Object src = evt.getSource();
		
		if(src == cbType && cbType.getSelectedIndex() != 0)
		{
			int sizeRows = model.getRowCount();
			for(int x = 0;x < sizeRows;x++)
			{
				model.removeRow(0);
			}
			String isAdmin = null;
			if(cbType.getSelectedIndex() == 1)
			{
				isAdmin = "1";
			}
			else if(cbType.getSelectedIndex() == 2)
			{
				isAdmin = "0";
			}
				try {

					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("isAdmin", isAdmin));


					DefaultHttpClient httpclient = new DefaultHttpClient();

					HttpPost httppost = new HttpPost(
							"http://garageserver.herobo.com/selectUserType.php");

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

					id = new int[rowAmount];
					firstName = new String[rowAmount];
					lastName = new String[rowAmount];
					userName = new String[rowAmount];
					email = new String[rowAmount];

					
					for (int i = 0; i < jArray.length(); i++) {
						json_data = jArray.getJSONObject(i);

						id[i] = json_data.getInt("id");
						firstName[i] = json_data.getString("fname");
						lastName[i] = json_data.getString("lname");
						userName[i] = json_data.getString("username");
						email[i] = json_data.getString("email");

					}


					for (int z = 0; z < rowAmount; z++)
					{
						model.addRow(new Object[] { id[z], firstName[z], lastName[z], userName[z], email[z] });
				
					}

				} catch (JSONException e1) {
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			
			
		
		if(src == btnDeleteAccount)
		{
			String getUser = null;
			int selectedRow = table.getSelectedRow();
			if(selectedRow >= 0)
			 getUser = (String) model.getValueAt(selectedRow, 3); 
			
			
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

					


					String userList;
					
					
				boolean rowSelected = false;
					for(int i=0;i<jArray.length();i++){
						
						json_data = jArray.getJSONObject(i);
						userList = json_data.getString("username");
				

						if(table.getSelectedRow() >= 0)
						{
							
							rowSelected = true;
							
						}
					
						
		
					}
					if(rowSelected){
						int reply = JOptionPane.showConfirmDialog(
				                null,
				                "Delete Account?",
				                "",
				                JOptionPane.YES_NO_OPTION);

				    	if(reply == JOptionPane.YES_OPTION)
						delete = true;
						}
					else
					{
						
						JOptionPane.showMessageDialog(this, "No row selected.");
					}
					rowSelected = false;
					if(delete)
					{
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("username", getUser));
						

						try {
							DefaultHttpClient httpclient1 = new DefaultHttpClient();
							HttpPost httppost = new HttpPost("http://garageserver.herobo.com/deleteUser.php");

							httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

							HttpResponse response = httpclient1.execute(httppost);
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
				
					delete = false;
				}catch(JSONException e1){

				}catch (ParseException e1){
					e1.printStackTrace();
				}
				
				if(selectedRow >= 0)
				{
				int sizeRows = model.getRowCount();
				for(int x = 0;x < sizeRows;x++)
				{
					model.removeRow(0);
				}
				String isAdmin = null;
				if(cbType.getSelectedIndex() == 1)
				{
					isAdmin = "1";
				}
				else if(cbType.getSelectedIndex() == 2)
				{
					isAdmin = "0";
				}
					try {

						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("isAdmin", isAdmin));


						DefaultHttpClient httpclient = new DefaultHttpClient();

						HttpPost httppost = new HttpPost(
								"http://garageserver.herobo.com/selectUserType.php");

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

						id = new int[rowAmount];
						firstName = new String[rowAmount];
						lastName = new String[rowAmount];
						userName = new String[rowAmount];
						email = new String[rowAmount];

						
						for (int i = 0; i < jArray.length(); i++) {
							json_data = jArray.getJSONObject(i);

							id[i] = json_data.getInt("id");
							firstName[i] = json_data.getString("fname");
							lastName[i] = json_data.getString("lname");
							userName[i] = json_data.getString("username");
							email[i] = json_data.getString("email");

						}


						for (int z = 0; z < rowAmount; z++)
						{
							model.addRow(new Object[] { id[z], firstName[z], lastName[z], userName[z], email[z] });
					
						}

					} catch (JSONException e1) {
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		
		
	}}


