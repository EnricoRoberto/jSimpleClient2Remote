package fileOperations;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 public class FileOperationStoreClass {
	
	public static String path = null;
	public static String inputLine = "";
	public static JTextField[] txts = new JTextField[50];
	static JTextArea[] txta = new JTextArea[50];	
	static JButton[] btns = new JButton[10];
	static JLabel[] label = new JLabel[10];
	static JCheckBox[] checkbox = new JCheckBox[50];
	static JFrame[] jframe = new JFrame[10];
	static boolean serverReCall = false;
	static boolean serverFirstCall = false;
	static boolean event = false;


	
}
