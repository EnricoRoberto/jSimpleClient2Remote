package client;

/**
 * @author PN_UTE5
 *
 */
public class SimpleThread  extends Thread {
 
	   public SimpleThread(String str) {
		      super(str);
		      }
	      	
	   		/* (non-Javadoc)
	   		 * @see java.lang.Thread#run()
	   		 */
	   		public void run() {
		        for (int i = 1; i < 3; i++) {
		        		           System.out.println(i + " " + "Thread avviato da " +  getName());
		           }
		
		        System.out.println("DONE! " + getName());
		      }
   
}

		      
		      
		      