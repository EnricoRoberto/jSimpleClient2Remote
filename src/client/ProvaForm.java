package client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

/**
 * @author PN_UTE5
 *
 */
public class ProvaForm extends ObjectStoreClass2 {
	private final JLabel label1 = new JLabel("Data from server");
	private JTextField textField;
	private JTextField textField_1;
	Graphics2D graf;

	private JTextField textField_2;
	ObservableClass obx = new ObservableClass(); // classe da osservare
	ObserverClass1 ob1 = new ObserverClass1(); // primo osservatore

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ProvaForm window = new ProvaForm();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public ProvaForm() {
		initialize();

		// *** timer.schedule(task, 100,100);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Timer timer = new Timer();
		// TimerTask task = null;
		//
		// timer.schedule(task, 100,100);
		JFrame ClientFrame = new JFrame();
		ClientFrame.setTitle("Client");
		ClientFrame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ProvaForm.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		ClientFrame.getContentPane().setForeground(Color.WHITE);
		ClientFrame.getContentPane().setBackground(Color.WHITE);
		ClientFrame.setBounds(100, 100, 762, 558);
		ClientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setIcon(
				new ImageIcon(ProvaForm.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setBackground(new Color(0, 255, 0));
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btnConnectServer = new JButton("Connect to Server");
		btnConnectServer.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnConnectServer.addMouseListener(new client.MouseEvents2());
		btnConnectServer.setName("Connect to Server");
		btnConnectServer.setIcon(
				new ImageIcon(ProvaForm.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		btnConnectServer.setBackground(Color.ORANGE);

		JPanel panel = new JPanel();

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.ORANGE);
		separator_1.setBackground(Color.ORANGE);

		JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.LIGHT_GRAY);

		textField = new JTextField();
		textField.setText("2002");
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("192.168.2.70");
		textField_1.setColumns(10);

		JLabel lblInput = new JLabel("Input status: ");
		lblInput.setHorizontalAlignment(SwingConstants.LEFT);
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInput.setBackground(Color.GREEN);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_2.setColumns(10);

		JLabel lblClientStep = new JLabel("Client step:");
		lblClientStep.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientStep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClientStep.setBackground(Color.GREEN);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				obx.addObserver(ob1); // sottoscrizione ad ascoltatore ob1
				if (arg0.getKeyCode() == 10) {
					obx.startProcess(txta[2].getText());

				}
			}
		});
		textArea_1.setRows(3);
		textArea_1.setMargin(new Insets(5, 5, 5, 5));
		textArea_1.setLineWrap(true);
		textArea_1.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel = new JLabel("Data Toward Server");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		JTextArea textArea_2 = new JTextArea();
		textArea_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				System.out.println(KeyEvent.getExtendedKeyCodeForChar(arg0.getKeyChar()));
						

				if (KeyEvent.getExtendedKeyCodeForChar(arg0.getKeyChar()) == 10) {
					ObjectStoreClass2.keyevent = true;
					ObjectStoreClass2.keyread = ObjectStoreClass2.txta[3].getText();
				}

			}
		});
		textArea_2.setWrapStyleWord(true);
		textArea_2.setRows(3);
		textArea_2.setMargin(new Insets(5, 5, 5, 5));
		textArea_2.setLineWrap(true);
		textArea_2.setBackground(Color.LIGHT_GRAY);
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setWrapStyleWord(true);
		textArea_3.setRows(3);
		textArea_3.setMargin(new Insets(5, 5, 5, 5));
		textArea_3.setLineWrap(true);
		textArea_3.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblKeyboardText = new JLabel("Keyboard text :");
		lblKeyboardText.setHorizontalAlignment(SwingConstants.LEFT);
		lblKeyboardText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKeyboardText.setBackground(Color.GREEN);
		GroupLayout groupLayout = new GroupLayout(ClientFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientStep)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
							.addGap(406))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblKeyboardText, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(255))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textArea_2, Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(label1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
											.addComponent(textArea, 0, 0, Short.MAX_VALUE)))
									.addGap(11))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnConnectServer, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
											.addGap(51))
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
									.addGap(159))))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInput, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
					.addGap(7))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClientStep, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConnectServer))
							.addGap(0)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(label1)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblKeyboardText, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblInput))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
							.addGap(35))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setAutoCreateGaps(true);
		panel.setLayout(new GridLayout(1, 8, 10, 10));

		JCheckBox check1 = new JCheckBox("I 1");
		check1.setBackground(Color.ORANGE);
		panel.add(check1);

		JCheckBox check2 = new JCheckBox("I 2");
		check2.setBackground(Color.ORANGE);
		panel.add(check2);

		JCheckBox check3 = new JCheckBox("I 3");
		check3.setBackground(Color.ORANGE);
		panel.add(check3);

		JCheckBox check4 = new JCheckBox("I 4");
		check4.setBackground(Color.ORANGE);
		panel.add(check4);

		JCheckBox check5 = new JCheckBox("I 5");
		check5.setBackground(Color.ORANGE);
		panel.add(check5);

		JCheckBox check6 = new JCheckBox("I 6");
		check6.setBackground(Color.ORANGE);
		panel.add(check6);

		JCheckBox check7 = new JCheckBox("I 7");
		check7.setBackground(Color.ORANGE);
		panel.add(check7);
		ClientFrame.getContentPane().setLayout(groupLayout);

		ClientFrame.setVisible(true);

		store(btnConnectServer, 1);
		store(check1, 1);
		store(check1, 2);
		store(check1, 3);
		store(check1, 4);
		store(check1, 5);
		store(check1, 6);
		store(check1, 7);
		store(check1, 8);
		store(label1, 1);
		store(lblClientStep, 2);
		store(textArea, 1);
		store(textArea_1, 2);
		store(textArea_2, 3);
		store(textArea_3, 4);

		store(textField, 2);
		store(textField_2, 3);
		store(textField_1, 1);
		store(ClientFrame, 1);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void store(JLabel lbl, int n) {
		ObjectStoreClass2.label[n] = lbl;
	}

	private void store(JCheckBox chk, int n) {
		ObjectStoreClass2.checkbox[n] = chk;
	}

	private void store(JButton btn, int n) {
		ObjectStoreClass2.btns[n] = btn;
	}

	private void store(JTextArea textArea, int n) {
		ObjectStoreClass2.txta[n] = textArea;
	}

	private void store(JTextField textField, int n) {
		ObjectStoreClass2.txts[n] = textField;
	}

	private void store(JFrame jframe, int n) {
		ObjectStoreClass2.jframe[1] = jframe;
	}

	public void mpaint(Graphics2D g2) {

		Rectangle2D.Double r = new Rectangle2D.Double(50, 100, 200, 150); // costruzione
																			// di
																			// un
																			// rettangolo

		g2.draw(r); // disegno del rettangolo r
	}
}
