package fileOperations;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JTextArea;

public class BaseRead extends FileOperationStoreClass  {

	
	JTextArea commandArea, responseArea;
	DataInputStream is = null;
	//--------------------------------------------------
	public BaseRead(JTextArea txta, JTextArea txta2) {
	this.commandArea = txta;
	this.responseArea = txta2;
	try {
		
			is=new DataInputStream(new FileInputStream(txta.getText()));
			is.skipBytes(3);
			readFile();
		}
	catch (Exception e) {
			txta2.setText("Exception" + "\n" + e);
			}
	}
	//--------------------------------------------------
	@SuppressWarnings("deprecation")
	public void readFile() {
		String inputLine;
	try {
	
		while ((inputLine = is.readLine()) != null) {
		
		FileOperationStoreClass.inputLine = FileOperationStoreClass.inputLine + inputLine;
		
		responseArea.append(inputLine + "\n"); // con accapo
//		responseArea.append(inputLine); // senza accapo, tutto il flusso
		
	}
	
	} catch (IOException e) {
	responseArea.setText("IO Exception" + "\n");
	} 
	finally {
			try {
				is.close();
			} 
			catch (IOException e) {
				responseArea.setText("IO Exception" + "\n");
			}
		}
	}



}
