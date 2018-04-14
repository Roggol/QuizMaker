package Quizzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Startup extends JFrame implements ActionListener {

	GUImanager g = new GUImanager();

	private JFrame frame;
	private JPanel panel;
	JButton start;
	JButton back;
	JButton edit;
	public Startup(String quizName,QuestionBank q, boolean admin) {

		prepareGUI();

		start = new JButton("Start Quiz");
		edit = new JButton("Edit Quiz");
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == start) {
					//Start button pressed
					int questionNum = q.numberOfEntries();
					frame.dispose();
					new GUI(quizName,q,questionNum, admin);
					//launch quiz
				}
				if(event.getSource() == back){
					frame.dispose();
					new QuizChoose(admin);
					//launch choose quiz screen
					//delete frame
					
				}if (event.getSource() == edit) {
					
					new QuizMaker(quizName,q, admin);
					//launch quiz maker screen
					frame.setVisible(false);
					frame.dispose();
					//delete frame
				}

			}

		};
		start.addActionListener(listener);
		start.setFocusable(false);
		start.setBackground(Color.GRAY);
		start.setSize(100, 50);
		start.setLocation(840, 480);
		
		edit.addActionListener(listener);
		edit.setFocusable(false);
		edit.setBackground(Color.GRAY);
		edit.setSize(100, 50);
		edit.setLocation(840, 580);
		
		back = new JButton("Back");
		back.addActionListener(listener);
		back.setFocusable(false);
		back.setBackground(Color.GRAY);
		back.setSize(100, 50);
		back.setLocation(840, 630);
		
		panel.setLayout(null);
		panel.add(back);
		panel.add(start);
		if(admin) {
			panel.add(edit);
		}
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	private void prepareGUI() {
		frame = new JFrame("Quizzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
	}

}
