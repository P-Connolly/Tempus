/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.Color;  
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

  

public class TableCellLongTextRenderer extends DefaultTableCellRenderer implements TableCellRenderer{  
  
    @Override  
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
        final JTextArea jtext = new JTextArea();  
        jtext.setText((String)value);  
        jtext.setWrapStyleWord(true);  
        jtext.setLineWrap(true);  
        if(isSelected){  
            jtext.setBackground((Color)UIManager.get("Table.selectionBackground"));  
        }  
        
      
        return jtext;  
    }  
  
    @Override  
    public void validate() {  
    }  
  
    @Override  
    public void revalidate() {  
    }  
  
    @Override  
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {  
    }  
  
     public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
  
}  