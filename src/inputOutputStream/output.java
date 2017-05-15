package inputOutputStream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Classe per scrivere in output su uno stream di un Socket
 * 
 * @author PN_UTE5
 *
 */
public class output {

	private Socket s;
	private OutputStreamWriter outputstream;
	private BufferedWriter bufferedwriter;
	private PrintWriter outwriter;

	/**
	 * Metodo in cui si passa la Socket di connessione nel cui stream di uscita si vogliono scrivere dati
	 * @param s Socket da passare nel cui flusso si vuole scrivere dei dati.
	 */
	public output(Socket s) {

		this.s = s;
		try {
			this.outputstream = new OutputStreamWriter(this.s.getOutputStream());
			this.bufferedwriter = new BufferedWriter(this.outputstream);
			this.outwriter = new PrintWriter(this.bufferedwriter, true);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @param str Stringa che si vuole trasmettere nel flusso
	 */
	public void writeoutput(String str) {

		this.outwriter.println(str);
	}

}