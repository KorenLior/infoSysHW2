package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BdrAppWindow {

	private JFrame frame;

	/**
	 * Launch the application. Test
	 */
	public static void main(String[] args) {Testfdfg
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrAppWindow window = new BdrAppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BdrAppWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}