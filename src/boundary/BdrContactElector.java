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

import control.CtrlElector;

import javax.swing.JTextField;
import javax.swing.JButton;

public class BdrContactElector {

	private JFrame frame;
	private final ButtonGroup rbgAnswer = new ButtonGroup();
	private final ButtonGroup rbgWillVote = new ButtonGroup();
	private final ButtonGroup rbgSupportParty = new ButtonGroup();
	private final ButtonGroup rbgIntrestedClass = new ButtonGroup();
	private final ButtonGroup rbgRide = new ButtonGroup();
	private JTextField txtRideFrom;
	private JTextField txtRideUntil;

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
		frame.setBounds(100, 100, 413, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rbAnswerY = new JRadioButton("yes");
		rbgAnswer.add(rbAnswerY);
		
		JRadioButton rbAnswerN = new JRadioButton("no");
		rbAnswerN.setSelected(true);
		rbgAnswer.add(rbAnswerN);
		
		JLabel lblAnswer = new JLabel("Answered:");
		
		JLabel lblVoting = new JLabel("will vote:");
		
		JRadioButton rbAnswerN_1 = new JRadioButton("no");
		rbgWillVote.add(rbAnswerN_1);
		rbAnswerN_1.setSelected(true);
		
		JRadioButton rbAnswerY_1 = new JRadioButton("yes");
		rbgWillVote.add(rbAnswerY_1);
		
		JRadioButton rbAnswerU_1 = new JRadioButton("undecided");
		rbgWillVote.add(rbAnswerU_1);
		rbAnswerU_1.setSelected(true);
		
		JLabel lblSupportsParty = new JLabel("supports party:");
		
		JRadioButton rbAnswerU_1_1 = new JRadioButton("undecided");
		rbgSupportParty.add(rbAnswerU_1_1);
		rbAnswerU_1_1.setSelected(true);
		
		JRadioButton rbAnswerY_1_1 = new JRadioButton("yes");
		rbgSupportParty.add(rbAnswerY_1_1);
		
		JRadioButton rbAnswerN_1_1 = new JRadioButton("no");
		rbgSupportParty.add(rbAnswerN_1_1);
		
		JLabel lblNeedRide = new JLabel("need a ride?");
		
		JRadioButton rbAnswerY_2 = new JRadioButton("yes");
		rbgRide.add(rbAnswerY_2);
		
		txtRideFrom = new JTextField();
		txtRideFrom.setColumns(10);
		
		txtRideUntil = new JTextField();
		txtRideUntil.setColumns(10);
		
		JLabel lblRideStart = new JLabel("From:");
		
		JLabel lblRideEnd = new JLabel("Until:");
		
		JButton btnSubmit = new JButton("Submit");
		
		JButton btnCancel = new JButton("Cancel");
		
		JRadioButton rbAnswerN_2 = new JRadioButton("no");
		rbgRide.add(rbAnswerN_2);
		rbAnswerN_2.setSelected(true);
		
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
							.addComponent(rbAnswerY_2)
							.addComponent(rbAnswerN_2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
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
									.addComponent(rbAnswerY_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbAnswerN_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rbAnswerY_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbAnswerN_1)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rbAnswerU_1_1)
								.addComponent(rbAnswerU_1)))
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
							.addComponent(rbAnswerY_1)
							.addGap(5)
							.addComponent(lblSupportsParty))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rbAnswerN_1)
							.addComponent(rbAnswerU_1)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rbAnswerY_1_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rbAnswerN_1_1)
							.addComponent(rbAnswerU_1_1)))
					.addGap(3)
					.addComponent(lblNeedRide)
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rbAnswerY_2)
						.addComponent(rbAnswerN_2))
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
}
