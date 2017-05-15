package client;

import java.io.IOException;

import javax.swing.JTextArea;

public class MainClient {

	JTextArea ja;
	JTextArea[] txta = new JTextArea[4];	
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//***	client.WindowCreator winn = new client.WindowCreator();
		
		try {
			ProvaForm window = new ProvaForm();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//***		JTextField[] txtsa = winn.MyMainFrame(1000,400,Color.ORANGE);	
//		JTextArea[] txtas = client.ObjectStoreClass.txta;
		
		
		
	}
	
	
	

}
