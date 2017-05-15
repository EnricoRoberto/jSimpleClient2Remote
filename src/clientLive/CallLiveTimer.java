/**
 * 
 */
package clientLive;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class CallLiveTimer  {

	
	public CallLiveTimer(Socket s) {
		// TODO Auto-generated constructor stub
		
		
		Timer timer = new Timer();
		TimerTask livetask = new LiveTimer(s);
		timer.schedule(livetask, 0,1000);
	}


}
