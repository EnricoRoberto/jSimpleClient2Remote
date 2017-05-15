package clientLive;

import java.awt.Color;
import java.net.Socket;
import java.util.TimerTask;

import client.ObjectStoreClass2;

public class LiveTimer  extends TimerTask{

	Socket s;
	public boolean liveblink;
	public boolean live;
	public boolean flipflop;
	clientLive.ObservableClass obx = new clientLive.ObservableClass(); // classe da osservare
	clientLive.ObserverClass1 ob1 = new clientLive.ObserverClass1();   // primo osservatore
	
	public LiveTimer(Socket s){
	this.s=s;	
	 obx.addObserver(ob1); // sottoscrizione ad ascoltatore ob1
	}
	
	@Override
	public void run() {
		
		
		if(s.isConnected()){
			live=true;
				if(!liveblink){
					liveblink = true;
					obx.startProcess("" + liveblink);
				}
				else{
					liveblink = false;
					obx.startProcess("" + liveblink);
				}
				
		}
		
		else{
			liveblink = false;
			live = false;
			}
		
		LiveStoreClass.live = live;
		LiveStoreClass.liveblink= liveblink;
		
		if(LiveStoreClass.liveblink){
			ObjectStoreClass2.txts[1].setBackground(Color.yellow);
		}
		if(!LiveStoreClass.liveblink){
			ObjectStoreClass2.txts[1].setBackground(Color.green);
		}
		
		
	}
	
	
	
	
	

}
