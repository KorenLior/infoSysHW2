package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import control.CtrlContactElector;
import control.CtrlElector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Time;

import javax.swing.Action;

public class BdrContactElector {

	private JFrame frame;
	private final ButtonGroup rbgAnswer = new ButtonGroup();
	private final ButtonGroup rbgWillVote = new ButtonGroup();
	private final ButtonGroup rbgSupportParty = new ButtonGroup();
	private final ButtonGroup rbgIntrestedClass = new ButtonGroup();
	private final ButtonGroup rbgRide = new ButtonGroup();
	private JTextField txtRideFrom;
	private JTextField txtRideUntil;
	private final Action actionSubmit = new SwingSubmitAction();
	private boolean answer = false;
	private boolean needRide = false;
	private int planToVote = 3;
	private int supportParty = 3;
	private int intrestedInClass = 3;
	private Time pickupFrom, pickupTo;
	private int electorId, employeeId;
	private final Action actionAnswerY = new SwingAction();
	private final Action actionAnswerN = new SwingAction_1();
	private final Action actionVoteY = new SwingAction_2();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrContactElector window = new BdrContactElector(0,0);
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
	public BdrContactElector(int electorID, int employeeID) {
		initGUI(electorID, employeeID);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initGUI(int electorID, int employeeID) {
		CtrlElector ctrlEL = new CtrlElector(electorID);
		String name = ctrlEL.getElectorName();
		Integer phone = ctrlEL.getElectorPhone();
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rbAnswerY = new JRadioButton("yes");
		rbAnswerY.setAction(actionAnswerY);
		rbgAnswer.add(rbAnswerY);
		
		JRadioButton rbAnswerN = new JRadioButton("no");
		rbAnswerN.setAction(actionAnswerN);
		rbAnswerN.setSelected(true);
		rbgAnswer.add(rbAnswerN);
		
		JLabel lblAnswer = new JLabel("Answered:");
		
		JLabel lblVoting = new JLabel("will vote:");
		
		JRadioButton rbrbWillVoteN = new JRadioButton("no");
		rbgWillVote.add(rbrbWillVoteN);
		rbrbWillVoteN.setSelected(true);
		
		JRadioButton rbWillVoteY = new JRadioButton("yes");
		rbWillVoteY.setAction(actionVoteY);
		rbgWillVote.add(rbWillVoteY);
		
		JRadioButton rbrbWillVoteU = new JRadioButton("undecided");
		rbgWillVote.add(rbrbWillVoteU);
		rbrbWillVoteU.setSelected(true);
		
		JLabel lblSupportsParty = new JLabel("supports party:");
		
		JRadioButton rbSupportU = new JRadioButton("undecided");
		rbgSupportParty.add(rbSupportU);
		rbSupportU.setSelected(true);
		
		JRadioButton rbSupportY = new JRadioButton("yes");
		rbgSupportParty.add(rbSupportY);
		
		JRadioButton rbSupportN = new JRadioButton("no");
		rbgSupportParty.add(rbSupportN);
		
		JLabel lblNeedRide = new JLabel("need a ride?");
		
		JRadioButton rbRideY = new JRadioButton("yes");
		rbgRide.add(rbRideY);
		
		txtRideFrom = new JTextField();
		txtRideFrom.setColumns(10);
		
		txtRideUntil = new JTextField();
		txtRideUntil.setColumns(10);
		
		JLabel lblRideStart = new JLabel("From:");
		
		JLabel lblRideEnd = new JLabel("Until:");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setAction(actionSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		
		JRadioButton rbRideN = new JRadioButton("no");
		rbgRide.add(rbRideN);
		rbRideN.setSelected(true);
		
		JLabel lblElectorName = new JLabel(name);
		
		JLabel lblPhoneTxt = new JLabel("Phone Number:");
		
		JLabel lblPhoneNum = new JLabel(phone.toString());
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblAnswer))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(rbAnswerY)
							.addComponent(rbAnswerN, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblVoting))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblSupportsParty, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNeedRide, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(rbRideY)
							.addComponent(rbRideN, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblRideStart, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(txtRideFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblRideEnd, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(txtRideUntil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rbSupportY)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbSupportN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rbWillVoteY)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbrbWillVoteN)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rbSupportU)
								.addComponent(rbrbWillVoteU)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(240)
							.addComponent(btnSubmit)
							.addGap(6)
							.addComponent(btnCancel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblElectorName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPhoneTxt)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPhoneNum, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblElectorName)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneTxt)
						.addComponent(lblPhoneNum))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAnswer)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rbAnswerY)
						.addComponent(rbAnswerN))
					.addGap(3)
					.addComponent(lblVoting)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rbWillVoteY)
							.addGap(5)
							.addComponent(lblSupportsParty))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rbrbWillVoteN)
							.addComponent(rbrbWillVoteU)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rbSupportY)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rbSupportN)
							.addComponent(rbSupportU)))
					.addGap(3)
					.addComponent(lblNeedRide)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rbRideY)
						.addComponent(rbRideN))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRideStart))
						.addComponent(txtRideFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRideEnd))
						.addComponent(txtRideUntil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSubmit)
						.addComponent(btnCancel))
					.addGap(163))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private class SwingSubmitAction extends AbstractAction {
		public SwingSubmitAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent ae) {
			new CtrlContactElector();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "SwingAction_2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
