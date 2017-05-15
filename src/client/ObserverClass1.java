package client;

import java.util.Observable;
import java.util.Observer;

/**
 * @author PN_UTE5
 *
 */
public class ObserverClass1  extends ObjectStoreClass2 implements Observer{
	
	String txt = new String();
	
	/**
	 * @param txt , costruttore
	 */
	ObserverClass1(String txt){
		this.txt = txt;
		event = false;
	}
	
	/**
	 * 
	 */
	ObserverClass1(){
		
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("---- se funziona lo vedo qui CLIENT-------  " + obs.getClass().getSimpleName());
		event = true;
		
		
     }
	
		
	

}
