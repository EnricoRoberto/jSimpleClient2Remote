package client;

/*Questa classe è una classe runnable che permettete, passata ad un 
*thread, di essere ciclata continuamente
*/

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientLive.LiveStoreClass;
import fileOperations.KeyRead;
import inputOutputStream.input;
import inputOutputStream.output;

/**
 * @author PN_UTE5
 *
 */
public class RunnableClassClient extends ObjectStoreClass2 implements Runnable {
	String ip = null;
	int port = 0;
	JTextField jt;
	JTextArea ja;
	String host;
	public Socket s;

	InputStreamReader isr;
	BufferedReader in;

	OutputStreamWriter osw;
	BufferedWriter bw;
	PrintWriter out;


	/**
	 * @param ip
	 * @param port
	 * @param ja
	 */
	RunnableClassClient(String ip, int port, JTextArea ja) {
		this.ip = ip;
		this.port = port;
		this.ja = ja;
	}
	
	/**
	 * @param ip numero di IP String
	 * @param port numero di porta intero
	 * @param ja JTextArea
	 * @param host nome host in formato String, in alternativa  a IP number. 
	 */
	RunnableClassClient(String ip, int port, JTextArea ja, String host) {
		this.ip = ip;
		this.port = port;
		this.ja = ja;
		this.host = host;
	}

	public void startclient() throws IOException {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		StepManager step = new StepManager(1, 1, 1000);
		boolean done = false;

		runnableKeyRead();

		try {

			s = new Socket(ip, port);
		
			s.setSoTimeout(1000);
			clientLive.CallLiveTimer live = new clientLive.CallLiveTimer(s);

		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			this.txta[1].setText(e1.toString());
			setConnectionState(Color.red);
			done = true;
			stopFirstStart();

		} catch (IOException e1) {
			e1.printStackTrace();
			this.txta[1].setText(e1.toString());
			setConnectionState(Color.red);
			stopFirstStart();
			done = true;
		}

		while (!done) {

			switch (step.actualstep) {
			case 1: // output and input stream creation

				this.txts[3].setText("Step n°: " + step.actualstep);
				try {

					Thread.sleep(1);
					input input = new inputOutputStream.input(s); /// FUNZIONA
					String inputString = null;

					output output = new inputOutputStream.output(s);

					if (ObjectStoreClass2.keyevent) {
						output.writeoutput("From:  " + s.hashCode() + "   Msg:  " + ObjectStoreClass2.keyread);
						keyevent = false;
						inputString = input.readInput(); /// FUNZIONA
					}

					if (inputString != null) {

						ObjectStoreClass2.txta[4].setText(inputString);

					}

				} catch (Exception e) {
					this.txta[1].setText(e.toString());
					setConnectionState(Color.red);
					stopFirstStart();
					done = true;
					step.reset();
				}

				// *** step.increase();
				break;

			case 2:
				this.txts[3].setText("Step n°: " + step.actualstep);
				// *** step.increase();
				break;

			case 3: // communication management
				this.txts[3].setText("Step n°: " + step.actualstep);

				try {
					// isr = new InputStreamReader(s.getInputStream());
					// in = new BufferedReader(isr);
					String str = in.readLine();

				
					writetxt("");
					writetxt("risposta da server:  " + str);
					this.btns[1].setBackground(Color.GREEN);

					step.increase();
					// **step.reset();
					// **done=true;
				} catch (Exception e) {
					this.txta[1].setText(e.toString());
					setConnectionState(Color.red);
					stopFirstStart();
					done = true;
					step.reset();
				}

				// *** done=true;

				break;

			case 4: // live signal to server
				this.txts[3].setText("Step n°: " + step.actualstep);

				try {

					Thread.sleep(10);
					if (clientLive.LiveStoreClass.liveEvent) {

						clientLive.LiveStoreClass.liveEvent = false;

						GregorianCalendar calendar = new GregorianCalendar();
						System.out.println("dati di vita trasmessi verso server");

						// osw = new OutputStreamWriter(s.getOutputStream());
						// bw = new BufferedWriter(osw);
						// out = new PrintWriter(bw, true);

						// out.println("LIVE STATUS : "+LiveStoreClass.liveblink
						// + " " + calendar.getTime()); // scrive nello stream
						// out.println("LIVE STATUS : "+LiveStoreClass.liveblink
						// + " --- " + FileOperationStoreClass.inputLine); //
						// scrive nello stream il file txt
						out.println(keyread);

						// writetoServer("" + LiveStoreClass.liveblink + " " +
						// calendar.getTime()); // fino a qui funziona
						writetoServer(LiveStoreClass.liveblink + ""); // fino a
																		// qui
																		// funziona

						// isr = new InputStreamReader(s.getInputStream());
						// in = new BufferedReader(isr);
						String str = in.readLine();
						// ***writetxt("");
						writetxt("risposta da server:  " + str);
						this.txta[1].setBackground(Color.white);
					}

					// ** step.increase();

				} catch (Exception e) {
					this.txta[1].setText(e.toString());
					setConnectionState(Color.red);
					stopFirstStart();
					done = true;
					step.reset();
					out.close();
				}

				break;

			case 5: // live signal from server
				this.txts[3].setText("Step n°: " + step.actualstep);
				try {
					isr = new InputStreamReader(s.getInputStream());
					in = new BufferedReader(isr);
					String str = in.readLine();
					writetxt("");
					writetxt("risposta da server:  " + str);

					if (str != "") {
						if (str == "" + LiveStoreClass.liveblink) {
							step.actualstep = 4;
						}
						// else {
						// step.reset();
						// done = true;
						// this.txts[3].setText("Step n°: " + step.actualstep);
						// }
					}

				} catch (Exception e) {
					this.txta[1].setText(e.toString());
					setConnectionState(Color.red);
					stopFirstStart();
					done = true;
					step.reset();
					this.txts[3].setText("Step n°: " + step.actualstep);
				}

				break;

			default:
				break;
			}

		}
	}

	/**
	 * @param txt, string passa il testo da stampare
	 * nella finestra JArea this.ja
	 */
	public void writetxt(String txt) {
		this.ja.setText(txt);
	}

	public void writetoServer(String txt) {
		txta[2].setText(txt);
	}

	public void setConnectionState(Color color) {

		this.btns[1].setBackground(color);

	}

	public void stopFirstStart() {
		ObjectStoreClass2.serverFirstCall = false;
		ObjectStoreClass2.serverReCall = false;
	}

	public static void runnableKeyRead() {
		KeyRead rcl4 = new KeyRead();
		Thread t5 = new Thread(rcl4);
		t5.start();
		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}// fine classe
