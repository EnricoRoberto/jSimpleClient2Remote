package fileOperations;

import java.util.Scanner;

import client.ObjectStoreClass2;

public class KeyRead extends ObjectStoreClass2 implements Runnable{

	public KeyRead() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner	input=	new	Scanner(System.in);
		while (true) {
			
			String s = input.nextLine();
			System.out.println("Ho letto:" + s);
			keyread = s;
			keyevent = true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
