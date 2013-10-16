/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridBagLayout;
import javax.swing.JTable;

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

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class SetTimeGUI extends JPanel implements ActionListener {

	boolean outOfBounds = false;
	DefaultTableModel model;
	private JPanel contentPane;
	String[][] data = new String[10][5];
	CrossVariables x = new CrossVariables();
	InputStream is = null;
	StringBuilder sb = null;
	String result = null;
	String courseID = "13";
	int rowAmount = 0;
	String lecturer = "";
	String room = "";
	String time = "";
	int dayCheck = 0;
	int timeCheck = 0;
	String day = "";
	int colChosen;
	int rowChosen;
	int dayCount;
	int timeCount;
	int timeChosen;
	int dayChosen;
	String timeInserted;
	String dayInserted;
	JButton btnBack;
	boolean usedCell = false;
	boolean roomUsed = false;
	
	public SetTimeGUI() {
		setBounds(100, 100, 679, 731);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// SETTING
		// DATA..........................................................................................................................
		try {
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

			nameValuePairs.add(new BasicNameValuePair("courseID", x.courseID));

			DefaultHttpClient httpclient = new DefaultHttpClient();

			HttpPost httppost = new HttpPost(
					"http://garageserver.herobo.com/selectCourseTime.php");

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
			 dayCount = 0;
			 timeCount = 0;

			String name;
			for (int i = 0; i < jArray.length(); i++) {

				json_data = jArray.getJSONObject(i);

				name = json_data.getString("moduleName");
				lecturer = json_data.getString("lecturer");
				room = json_data.getString("room");
				time = json_data.getString("time");
				day = json_data.getString("day");

				switch (day) {
				case "Monday":
					dayCount = 0;
					break;
				case "Tuesday":
					dayCount = 1;
					break;
				case "Wednesday":
					dayCount = 2;
					break;
				case "Thursday":
					dayCount = 3;
					break;
				case "Friday":
					dayCount = 4;
					break;
				}

				switch (time) {
				case "09:00:00":
					timeCount = 0;
					break;
				case "10:00:00":
					timeCount = 1;
					break;
				case "11:00:00":
					timeCount = 2;
					break;
				case "12:00:00":
					timeCount = 3;
					break;
				case "13:00:00":
					timeCount = 4;
					break;
				case "14:00:00":
					timeCount = 5;
					break;
				case "15:00:00":
					timeCount = 6;
					break;
				case "16:00:00":
					timeCount = 7;
					break;
				case "17:00:00":
					timeCount = 8;
					break;
				case "18:00:00":
					timeCount = 9;
					break;
				}
				data[timeCount][dayCount] = name + "\n" + room + "\n"
						+ lecturer;
			}

		} catch (JSONException e1) {

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// END SET
		// DATA....................................................................................................................................


		model = new DefaultTableModel(){
			 @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};

		// Create a couple of columns
		model.addColumn("Time");
		model.addColumn("Monday");
		model.addColumn("Tuesday");
		model.addColumn("Wednesday");
		model.addColumn("Thursday");
		model.addColumn("Friday");

		
		model.addRow(new Object[] { x.ModuleName + "\n" + x.roomNo + "\n"
				+ x.Lecturer, "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday" });
		model.addRow(new Object[] { "09:00", data[0][0], data[0][1],
				data[0][2], data[0][3], data[0][4] });
		model.addRow(new Object[] { "10:00", data[1][0], data[1][1],
				data[1][2], data[1][3], data[1][4] });
		model.addRow(new Object[] { "11:00", data[2][0], data[2][1],
				data[2][2], data[2][3], data[2][4] });
		model.addRow(new Object[] { "12:00", data[3][0], data[3][1],
				data[3][2], data[3][3], data[3][4] });
		model.addRow(new Object[] { "13:00", data[4][0], data[4][1],
				data[4][2], data[4][3], data[4][4] });
		model.addRow(new Object[] { "14:00", data[5][0], data[5][1],
				data[5][2], data[5][3], data[5][4] });
		model.addRow(new Object[] { "15:00", data[6][0], data[6][1],
				data[6][2], data[6][3], data[6][4] });
		model.addRow(new Object[] { "16:00", data[7][0], data[7][1],
				data[7][2], data[7][3], data[7][4] });
		model.addRow(new Object[] { "17:00", data[8][0], data[8][1],
				data[8][2], data[8][3], data[8][4] });
		model.addRow(new Object[] { "18:00", data[9][0], data[9][1],
				data[9][2], data[9][3], data[9][4] });

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		
		JTable table_1 = new JTable(model);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Enables Word Wrap.
		table_1.getColumnModel().getColumn(0)
				.setCellRenderer(new TableCellLongTextRenderer());
		table_1.getColumnModel().getColumn(1)
				.setCellRenderer(new TableCellLongTextRenderer());
		table_1.getColumnModel().getColumn(2)
				.setCellRenderer(new TableCellLongTextRenderer());
		table_1.getColumnModel().getColumn(3)
				.setCellRenderer(new TableCellLongTextRenderer());
		table_1.getColumnModel().getColumn(4)
				.setCellRenderer(new TableCellLongTextRenderer());
		table_1.getColumnModel().getColumn(5)
				.setCellRenderer(new TableCellLongTextRenderer());

		table_1.setDragEnabled(true);
		table_1.setDropMode(DropMode.USE_SELECTION);
		table_1.setTransferHandler(new TransferHandler() {

			public int getSourceActions(JComponent c) {
				return DnDConstants.ACTION_COPY_OR_MOVE;
			}

			public Transferable createTransferable(JComponent comp) {
				JTable table_1 = (JTable) comp;
				int row = table_1.getSelectedRow();
				int col = table_1.getSelectedColumn();

				String value = (String) table_1.getModel().getValueAt(row, col);
				if (col == 0 || row == 0) {
					outOfBounds = true;
				} else
					outOfBounds = false;
				if(col == 0 && row ==0)
					outOfBounds = false;
				if (outOfBounds == false) {
					StringSelection transferable = new StringSelection(value);
					return transferable;
				}
				return null;
			}

			public boolean canImport(TransferHandler.TransferSupport info) {
				if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
					return false;
				}

				return true;
			}

			public boolean importData(TransferSupport support) {
				if (outOfBounds == false) {
					
					if (!support.isDrop()) 
					{
						
						return false;
					}

					if (!canImport(support)) {
						return false;
					}

					JTable table_1 = (JTable) support.getComponent();
					DefaultTableModel tableModel = (DefaultTableModel) table_1
							.getModel();

					JTable.DropLocation dl = (JTable.DropLocation) support
							.getDropLocation();
					if(data[dl.getRow() - 1][dl.getColumn() - 1] == null || data[dl.getRow() - 1][dl.getColumn() - 1] == "" ||data[dl.getRow() - 1][dl.getColumn() - 1] == "null")
					{
						
						usedCell = false;

					}
					else
					{
						  JOptionPane.showMessageDialog(contentPane,"There is already time set in this cell, remove it first to proceed."); 

						usedCell = true;
					}
					if(usedCell == false)
					{
						roomUsed = false;
						try {
							
							dayCheck = dl.getColumn() - 1;
							timeCheck = dl.getRow() - 1;
							
							switch (dayCheck) {
							case 0:
								dayInserted = "Monday";
								break;
							case 1:
								dayInserted = "Tuesday";
								break;
							case 2:
								dayInserted = "Wednesday";
								break;
							case 3:
								dayInserted = "Thursday";
								break;
							case 4:
								dayInserted = "Friday";
								break;
							}

							switch (timeCheck) {
							case 0:
								timeInserted = "09:00:00";
								break;
							case 1:
								timeInserted =  "10:00:00";
								break;
							case 2:
								timeInserted =  "11:00:00";
								break;
							case 3:
								timeInserted =  "12:00:00";
								break;
							case 4:
								timeInserted =  "13:00:00";
								break;
							case 5:
								timeInserted =  "14:00:00";
								break;
							case 6:
								timeInserted =  "15:00:00";
								break;
							case 7:
								timeInserted =  "16:00:00";
								break;
							case 8:
								timeInserted =  "17:00:00";
								break;
							case 9:
								timeInserted =  "18:00:00";
								break;
							}
							
							ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
							nameValuePairs.add(new BasicNameValuePair("room", x.roomNo));
							nameValuePairs.add(new BasicNameValuePair("time", timeInserted));
							nameValuePairs.add(new BasicNameValuePair("day", dayInserted));
							nameValuePairs.add(new BasicNameValuePair("lecturer", x.Lecturer));

							
							DefaultHttpClient httpclient = new DefaultHttpClient();

							HttpPost httppost = new HttpPost(
									"http://garageserver.herobo.com/selectClassUsed.php");

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
						String moduleNamePop = "";
						String lecturerName = "";
						String roomNoChosen = "";
						boolean roomDouble = false;
						boolean lecturerDouble = false;
						try {
							JSONArray jArray = new JSONArray(result);

							JSONObject json_data = null;

							int rowAmount = 0;
							for (int i = 0; i < jArray.length(); i++) {

								rowAmount++;
								json_data = jArray.getJSONObject(i);
								
								moduleNamePop = json_data.getString("moduleName");
								lecturerName = json_data.getString("lecturer");
								roomNoChosen = json_data.getString("room");
								if(roomNoChosen.equals(x.roomNo))
								{
								roomDouble = true;	
								}
								if(lecturerName.equals(x.Lecturer))
								{
								lecturerDouble = true;
								}
							}

						if (rowAmount > 0)
						{
							
							roomUsed = true;
							if(roomDouble)
							{
							  JOptionPane.showMessageDialog(contentPane,"This room is already allocated to module " + moduleNamePop + ", remove it first to proceed."); 
							}
							else if(lecturerDouble)
							{
								  JOptionPane.showMessageDialog(contentPane,x.Lecturer + " is already rostered to be in another room at this time and day."); 
								  		

							}
						}

						} catch (JSONException e1) {
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						
						
					}
					// TIME+DAY+ROOM CHECKER..........................................................................................................

					int row = dl.getRow();
					int col = dl.getColumn();
					dayChosen = dl.getColumn() - 1;
					timeChosen = dl.getRow() - 1;
					rowChosen = dl.getRow();
					colChosen = dl.getColumn();
					if (dl.getRow() == 0 || dl.getColumn() == 0) 
					{
						outOfBounds = true;
					}  
					if (dl.getRow() == 0 && dl.getColumn() == 0) 
					{
						outOfBounds = false;
					}  
						if(outOfBounds == false && usedCell == false && roomUsed == false)
						{
						String data1;
						try {
							data1 = (String) support.getTransferable()
									.getTransferData(DataFlavor.stringFlavor);
						} catch (UnsupportedFlavorException e) {
							return false;
						} catch (IOException e) {
							return false;
						}

						tableModel.setValueAt(data1, row, col);
						data[row - 1][col - 1] = data1;
					
				}
				}

				if(outOfBounds == false && usedCell == false && roomUsed == false)
				{
				
				switch (dayChosen) {
				case 0:
					dayInserted = "Monday";
					break;
				case 1:
					dayInserted = "Tuesday";
					break;
				case 2:
					dayInserted = "Wednesday";
					break;
				case 3:
					dayInserted = "Thursday";
					break;
				case 4:
					dayInserted = "Friday";
					break;
				}

				switch (timeChosen) {
				case 0:
					timeInserted = "09:00:00";
					break;
				case 1:
					timeInserted =  "10:00:00";
					break;
				case 2:
					timeInserted =  "11:00:00";
					break;
				case 3:
					timeInserted =  "12:00:00";
					break;
				case 4:
					timeInserted =  "13:00:00";
					break;
				case 5:
					timeInserted =  "14:00:00";
					break;
				case 6:
					timeInserted =  "15:00:00";
					break;
				case 7:
					timeInserted =  "16:00:00";
					break;
				case 8:
					timeInserted =  "17:00:00";
					break;
				case 9:
					timeInserted =  "18:00:00";
					break;
				}
				
				String courseID = x.courseID;
				String moduleID = x.ModuleID;
				String moduleName = x.ModuleName;
				String lecturer = x.Lecturer;
				String room = x.roomNo;
				String time = timeInserted;
				String day = dayInserted;
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("courseID",courseID));
				nameValuePairs.add(new BasicNameValuePair("moduleID", moduleID));
				nameValuePairs.add(new BasicNameValuePair("moduleName", moduleName));
				nameValuePairs.add(new BasicNameValuePair("lecturer",lecturer));
				nameValuePairs.add(new BasicNameValuePair("room", room));
				nameValuePairs.add(new BasicNameValuePair("time", time));
				nameValuePairs.add(new BasicNameValuePair("day", day));
				nameValuePairs.add(new BasicNameValuePair("username", "N/A"));


				try {
					DefaultHttpClient httpclient1 = new DefaultHttpClient();
					HttpPost httppost = new HttpPost("http://garageserver.herobo.com/insertTime.php");

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
				return true;
			}
		});

		table_1.setRowHeight(60);

		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 9;
		gbc_table_1.gridheight = 3;
		gbc_table_1.insets = new Insets(0, 0, 5, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 2;
		gbc_table_1.gridy = 3;
		contentPane.add(table_1, gbc_table_1);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 4;
		contentPane.add(btnBack, gbc_btnBack);
		btnBack.addActionListener(this);
		
		add(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object src = evt.getSource();

		
	}

}
