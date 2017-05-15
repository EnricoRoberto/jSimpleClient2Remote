

package client;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 /**
 * @author PN_UTE5
 *
 */
public class ObjectStoreClass2 {

	
	static JButton[] btns = new JButton[10];
	static JLabel[] label = new JLabel[10];
	static JFrame[] jframe = new JFrame[10];
	static boolean serverReCall = false;
	static boolean serverFirstCall = false;
	static boolean event = false;
	static String path = "";
	static String inputLine = "";
	
	/**
	 * JCheckBox , array di 50 JCheckBox da poter usare 
	 */
	public static JCheckBox[] checkbox = new JCheckBox[50];
	/**
	 * JTextField , array di 50 JTextField da poter usare
	 */
	public static JTextField[] txts = new JTextField[50];
	/**
 * JTextArea , array di 50 JTextArea da poter usare 
	 */
	public static JTextArea[] txta = new JTextArea[50];	
	/**
	 * Stringa, valore letto dalla tastiera su console
	 */
	public static String keyread = "";
	/**
	 * Bool Evento da tastiera avvenuto
	 */
	public static boolean keyevent = false;
	
	
	
}
