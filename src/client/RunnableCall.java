package client;

import javax.swing.JTextArea;

/**
 * @author PN_UTE5
 *
 */
public class RunnableCall {
	
	String ip;
	int port;
	JTextArea ja;
		
	
	/**
	 * @param ip Stringa per passare il  numero ip "xxx.xxx.xxx.xxx"
	 * @param port Intero per passare la porta
	 * @param ja JTextArea da usare se server, non utilizzato attualmente
	 */
	public RunnableCall(String ip, int port, JTextArea ja){
		
		this.ip=ip;
		this.port=port;
		this.ja = ja;
		runnableGen(ip,port, ja);
	}
	
	/**
	 * @param ip Stringa per passare il  numero ip "xxx.xxx.xxx.xxx"
	 * @param port Intero per passare la porta
	 * @param ja JTextArea usato per passarlo al RunnableClassClient
	 */
	public void runnableGen(String ip,int port,JTextArea ja){
		RunnableClassClient rcl1 = new RunnableClassClient(ip, port,ja);  
		Thread t = new Thread (rcl1);
		t.start();
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
}
