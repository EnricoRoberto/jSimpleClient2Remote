package client;

/**
 * @author PN_UTE5
 *
 */
public class StepManager {

	public int startstep;
	public int actualstep; 
	public int increase=1;
	public int stop;
	
	/**
	 * @param startvalue , valore intero per step attuale
	 * @param increasvalue , valore intero da incrementare
	 * @param stopvalue , valore di step intero a cui finire e iniziare da 1 gli steps
	 */
	public StepManager(int startvalue, int increasvalue, int stopvalue){
		startstep=startvalue;
		actualstep=startvalue;
		increase=increasvalue;
		stop=stopvalue;
	}
		
	/**
	 * @return Object, ma non viene usato. Ritorna l'oggetto passato cosi' com'è
	 */
	public Object stepselector(){
		Object obj = null;
		
		switch (actualstep) {
		case 1:
		
			
			break;
		case 2:
		
			
			break;
		case 3:
	
	
			break;
		case 4:
	
	
			break;
		case 5:
	
			break;

		default:
			break;
		}
		return obj;
		
	}
	/**
	 * Incrementa gli step di 1 unità
	 */
	public void increase(){
		actualstep= actualstep+1;
			if(actualstep>=stop){
				actualstep = 1;
			}
	}
	
	/**
	 * Resetta gli steps al valore "startstep"
	 */
	public void reset(){
		actualstep= startstep;
	}
	
	
	
	
	
	
	
	
	
}
