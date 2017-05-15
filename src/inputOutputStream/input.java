package inputOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Classe per intercettare input da uno stream Socket
 * 
 * @author PN_UTE5
 *
 */
public class input {

	private InputStreamReader in;
	private Socket s;
	private BufferedReader buffer;

	/**
	 * Metodo in cui si passa la Socket di connessione di cui si vuole intercettare il flusso in Input
	 * @param s Socket da passare di cui si vuole intercettare il flusso
	 */
	public input(Socket s) { // costruttore
		this.s = s;
		try {
			this.in = new InputStreamReader(this.s.getInputStream());
			this.buffer = new BufferedReader(in);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return Restituisce la stringa ricevuta dal buffer
	 */
	public String readInput() { // metodo per leggere i dati dallo stream passato col costruttore
		String str = null;
		try {
			str = this.buffer.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return str;
	}

}
