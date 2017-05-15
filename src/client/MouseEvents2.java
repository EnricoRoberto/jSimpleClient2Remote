package client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fileOperations.BaseRead;

public class MouseEvents2 extends ObjectStoreClass2 implements MouseListener {

	private static final Frame Dialog = null;
	JTextField jt;

	public MouseEvents2(JTextField jt) {
		this.jt = jt;
	}

	public MouseEvents2() {

	}

	public void mouseClicked(MouseEvent e) {

		System.out.println("Click on: " + e.getComponent().getName() + " pos: (" + e.getX() + "," + e.getY() + ") ");
		Path currentRelativePath = Paths.get("");
		String spath = currentRelativePath.toAbsolutePath().toString();

		JFileChooser openFile = new JFileChooser(spath);
		openFile.setFileSelectionMode(2);
		openFile.showOpenDialog(Dialog);
		String filestring = openFile.getSelectedFile().getPath();
		ObjectStoreClass2.txta[1].setText(filestring);

		BaseRead read = new BaseRead(ObjectStoreClass2.txta[1], ObjectStoreClass2.txta[2]);

		// create gpio controller

//		try {
//			// ** GpioInputAllExample.ioGpio();
//			GpioOutputExamble.outGpio();
//			// } catch (PlatformAlreadyAssignedException e1) {
//			// // TODO Auto-generated catch block
//			// e1.printStackTrace();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		if (e.getComponent().getName() == "Connect to Server") {

			if (!serverFirstCall) {

				// ** new SimpleThread(e.getComponent().getName()).start();
				setConnectionState(Color.ORANGE);
				this.runnableGen(ObjectStoreClass2.txta[1]);
				setConnectionFrame();
				ObjectStoreClass2.serverReCall = true;
				ObjectStoreClass2.serverFirstCall = true;

			}

			else {
				// ** JOptionPane.showMessageDialog(null,"Premuto pulsante" +":
				// "+ e.getComponent().getName());
				JOptionPane.showMessageDialog(null, "Connessione già avviata");
			}

		}
		if (e.getComponent().getName() == "Button N°2") {
			new SimpleThread(e.getComponent().getName()).start();
			this.runnableGen(client.ObjectStoreClass2.txta[2]);
		}

		if (e.getComponent().getName() == "Button N°3") {
			new SimpleThread(e.getComponent().getName()).start();
			this.runnableGen(client.ObjectStoreClass2.txta[3]);
		}

		if (e.getComponent().getName() == "Button N°4") {
			new SimpleThread(e.getComponent().getName()).start();
			this.runnableGen(client.ObjectStoreClass2.txta[4]);
		}

		if (e.getComponent().getName() == "Button N°5") {
			new SimpleThread(e.getComponent().getName()).start();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entry in to: " + e.getComponent().getName() + " pos: (" + e.getX() + "," + e.getY() + ") ");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Exit from: " + e.getComponent().getName() + " pos: (" + e.getX() + "," + e.getY() + ")");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	public void runnableGen(JTextArea ja) {
		RunnableClassClient rcl1 = new RunnableClassClient(ObjectStoreClass2.txts[1].getText(),
				Integer.parseInt(ObjectStoreClass2.txts[2].getText()), ja);
		Thread t = new Thread(rcl1);
		t.start();
		try {
			Thread.currentThread();
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setConnectionState(Color color) {

		ObjectStoreClass2.btns[1].setBackground(color);

	}

	public void setConnectionFrame() {

		ObjectStoreClass2.jframe[1].setTitle("Client" + "  try:  " + ObjectStoreClass2.txts[1].getText() + "  port:  " + ObjectStoreClass2.txts[2].getText());

	}

}
