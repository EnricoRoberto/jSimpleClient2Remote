package client;

import java.util.TimerTask;

/**
 * @author PN_UTE5
 *
 */
public class TimerClass extends TimerTask{


	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	public void run() {
		
		if (!ObjectStoreClass2.serverFirstCall & ObjectStoreClass2.serverReCall) {
			RunnableCall call = new RunnableCall(ObjectStoreClass2.txts[1].getText(),
			Integer.parseInt(ObjectStoreClass2.txts[2].getText()), ObjectStoreClass2.txta[1]);
			System.out.println(TimerClass.this.toString());
		}
		
	}
	
	
}
