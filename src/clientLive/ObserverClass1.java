package clientLive;

import java.util.Observable;
import java.util.Observer;

public class ObserverClass1  extends LiveStoreClass implements Observer{
	
	
	ObserverClass1(String txt){
		liveEvent = false;
	}
	
	ObserverClass1(){
		
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("---- se funziona lo vedo qui CLIENT-------  " );
		liveEvent = true;
		
		
     }
	
		
	

}
