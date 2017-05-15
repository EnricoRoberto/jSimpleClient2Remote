package clientLive;

import java.util.Observable;

public class ObservableClass  extends Observable{
	
		public String value;
		String txt;
			
		public void startProcess(String txt) { // questo metodo deve essere chiamato dalla condizione da controllare
			
			this.setChanged(); // evento di cambiamento
			this.notifyObservers();  // notifica generale agli ascoltatori
			
		}
		
		
}
