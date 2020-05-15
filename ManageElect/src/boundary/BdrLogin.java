package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.CtrlLogin;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class BdrLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Action actionLogin = new SwingLoginAction();
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BdrLogin dialog = new BdrLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BdrLogin() {
		initGUI();
	}

	private void initGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btLogin = new JButton("Login");
				btLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btLogin.setAction(actionLogin);
				btLogin.setActionCommand("OK");
				buttonPane.add(btLogin);
				getRootPane().setDefaultButton(btLogin);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	private class SwingLoginAction extends AbstractAction {
		public SwingLoginAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		/**
		 * @requires txtBox contains integer
		 * @modifies 
		 * @effects initiates ctrlLogin(txtInBox). ctrlLogin will initiate the "MainMenu" JFrame
		 * in future can add password system here as well for secure login
		 * @return
		 */
		public void actionPerformed(ActionEvent ae) {
			String txtInBox = txtId.getText();
			try {
				int id = Integer.parseInt(txtInBox);
				new CtrlLogin(id);
			}
			catch(Exception e){
				System.out.print("txt in bdrLogin.txtBox: " + txtInBox);
			}
		}
	}
}
