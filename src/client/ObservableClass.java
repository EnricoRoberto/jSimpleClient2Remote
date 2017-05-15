
package client;

import java.util.Observable;

/**
 * @author PN_UTE5
 *
 */

public class ObservableClass  extends Observable{
	
		public String value;
		String txt;
		
		/**
		 * @param txt , parametro non utilizzato attualmente
		 * Il metodo dev'esser richiamato dalla condizione da controllare
		 */
		public void startProcess(String txt) { // questo metodo deve essere chiamato dalla condizione da controllare
			
			this.setChanged(); // evento di cambiamento
			this.notifyObservers();  // notifica generale agli ascoltatori
			
		}
		/**
		 * @param txt , Stringa da passare per impostare semplicemente un valore di ritorno
		 * @return Valore di ritorno : value = txt
		 */
		public String returnValue(String txt){
			value=txt;
			return value;
		}
		
}
