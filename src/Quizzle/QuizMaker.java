package Quizzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class QuizMaker extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	JButton next;

	JButton back;
	JButton save;
	JButton finish;
	JTextField questionTitle;
	JTextField AnswerA;
	JTextField AnswerB;
	JTextField AnswerC;
	JTextField AnswerD;
	JTextField Answer;
	JTextField Explanation;
	
	private int questionNumber = 0;


	public QuizMaker(final String quizName, QuestionBank q, boolean admin) {

		prepareGUI();
		next = new JButton("next -->");
		//Labelled save with an arrow to make it more clear that's what the button does
		back = new JButton("<-- back");
		save = new JButton("Save");
		finish = new JButton("Finish!");
		questionTitle = new JTextField("Question 1");
		AnswerA = new JTextField ("A: ");
		AnswerB = new JTextField ("B: ");
		AnswerC = new JTextField ("C: ");
		AnswerD = new JTextField ("D: ");
		Answer = new JTextField ("Correct Answer (A,B,C or D)");
		Explanation = new JTextField("Explanation");
		
		if (!(questionNumber >= q.numberOfEntries())){
			//if the question already exists in the file, print what is saved for that question
			//splits line by commas
			questionTitle.setText(q.getTitle(questionNumber));
			AnswerA.setText(q.getAnswerA(questionNumber));
			AnswerB.setText(q.getAnswerB(questionNumber));
			AnswerC.setText(q.getAnswerC(questionNumber));
			AnswerD.setText(q.getAnswerD(questionNumber));
			Answer.setText(q.getAnswer(questionNumber));
			Explanation.setText(q.getExplanation(questionNumber));
			//sets the text to contain the relevant text from the file
		}

		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == next) {
					next(q);
				}
				if(event.getSource() == back){
					back(q);
					
				}
				if (event.getSource()==save){
					save(q, quizName, admin, false);
				}if(event.getSource()==finish){
					save(q, quizName, admin, true);
					frame.dispose();
				}

			}

		};
		next.addActionListener(listener);
		next.setFocusable(false);
		next.setBackground(Color.GRAY);
		next.setSize(100, 50);
		next.setLocation(600, 480);
		
		back.addActionListener(listener);
		back.setFocusable(false);
		back.setBackground(Color.GRAY);
		back.setSize(100, 50);
		back.setLocation(400, 480);
		back.setVisible(false);
		
		save.addActionListener(listener);
		save.setFocusable(false);
		save.setBackground(Color.GRAY);
		save.setSize(100, 50);
		save.setLocation(400, 580);
		save.setVisible(true);
		
		finish.addActionListener(listener);
		finish.setFocusable(false);
		finish.setBackground(Color.GRAY);
		finish.setSize(100, 50);
		finish.setLocation(600, 580);
		finish.setVisible(false);
		
		questionTitle.setSize (600, 50);
		questionTitle.setLocation(1000, 100);		
		AnswerA.setSize (600, 50);
		AnswerA.setLocation(1000, 200);		
		AnswerB.setSize (600, 50);
		AnswerB.setLocation(1000, 300);		
		AnswerC.setSize (600, 50);
		AnswerC.setLocation(1000, 400);		
		AnswerD.setSize (600, 50);
		AnswerD.setLocation(1000, 500);	
		Answer.setSize (600, 50);
		Answer.setLocation(1000, 600);	
		Explanation.setSize(1000,50);
		Explanation.setLocation(1000,700);
		
		panel.setLayout(null);
		panel.add(next);
		panel.add(back);
		panel.add(save);
		panel.add(finish);
		panel.add(questionTitle);
		panel.add(AnswerA);
		panel.add(AnswerB);
		panel.add(AnswerC);
		panel.add(AnswerD);
		panel.add(Answer);
		
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	protected void finish(String quizName, QuestionBank q, boolean admin, boolean finishBool) {
		new Startup(quizName, q, admin);
		
	}

	protected void save(QuestionBank q, String quizName, boolean admin, boolean finishBool) {
		boolean validated = true;
		for(int i=0; i<q.numberOfEntries(); i++) {
			if(!((q.getAnswer(i).equals("A"))||q.getAnswer(i).equals("B")||q.getAnswer(i).equals("B")||q.getAnswer(i).equals("B"))){
				int qOut = i+1;
				JOptionPane.showMessageDialog(null, qOut + " does not have a valid answer");
				validated = false;
			}
		}
		if(validated){
			try {
		
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(quizName + "//questions.dat") );
				out.writeObject(q);
				out.close();
				System.out.println("saved");
				if(finishBool == true) {
					finish(quizName, q, admin, finishBool);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	protected void back(QuestionBank q) {
		if(questionNumber>=q.numberOfEntries()) {
			q.add(questionTitle.getText(), AnswerA.getText(), AnswerB.getText(), AnswerC.getText(), AnswerD.getText(), Answer.getText(), Explanation.getText());
		}else {
			q.replace(questionNumber,questionTitle.getText(), AnswerA.getText(), AnswerB.getText(), AnswerC.getText(), AnswerD.getText(), Answer.getText(), Explanation.getText());
		}
		if(questionNumber == 1){
			back.setVisible(false);
			//to make it so you can't reach negative question numbers
		}
		questionNumber --;
		
		questionTitle.setText(q.getTitle(questionNumber));
		AnswerA.setText(q.getAnswerA(questionNumber));
		AnswerB.setText(q.getAnswerB(questionNumber));
		AnswerC.setText(q.getAnswerC(questionNumber));
		AnswerD.setText(q.getAnswerD(questionNumber));
		Answer.setText(q.getAnswer(questionNumber));
		Explanation.setText(q.getExplanation(questionNumber));
		
	}

	protected void next(QuestionBank q) {
		
		if(!(Answer.getText().equals("A")||Answer.getText().equals("B")||Answer.getText().equals("C")||Answer.getText().equals("D"))){
			JOptionPane.showMessageDialog(null, "Not a valid Answer");
		}else{
			if(questionNumber>=q.numberOfEntries()) {
				q.add(questionTitle.getText(), AnswerA.getText(), AnswerB.getText(), AnswerC.getText(), AnswerD.getText(), Answer.getText(), Explanation.getText());
			}else {
				q.replace(questionNumber,questionTitle.getText(), AnswerA.getText(), AnswerB.getText(), AnswerC.getText(), AnswerD.getText(), Answer.getText(), Explanation.getText());
			}
			
			questionNumber++;
			System.out.println(""+questionNumber);
			if (!(questionNumber >= q.numberOfEntries())){
				//if the question already exists in the file, print what is saved for that question
				//splits line by commas
				questionTitle.setText(q.getTitle(questionNumber));
				AnswerA.setText(q.getAnswerA(questionNumber));
				AnswerB.setText(q.getAnswerB(questionNumber));
				AnswerC.setText(q.getAnswerC(questionNumber));
				AnswerD.setText(q.getAnswerD(questionNumber));
				Answer.setText(q.getAnswer(questionNumber));
				Explanation.setText(q.getExplanation(questionNumber));
				//sets the text to contain the relevant text from the file
				back.setVisible(true);
			}else {
				refresh(10);
			}
		}
	}
		

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void refresh( int numberOfQuestions){
		if(questionNumber > 0){
			back.setVisible(true);
		}
		next.setText("next -->");
		int questionInt = questionNumber+1;
		if(questionInt > numberOfQuestions){
			finish.setVisible(true);
		}
		back.setText("<-- back");
		AnswerA.setText("A: ");
		AnswerB.setText("B: ");
		AnswerC.setText("C: ");
		AnswerD.setText("D: ");
		Answer.setText("Correct Answer");

		questionTitle.setText("Question " + questionInt);			
				
		
	}
	private void prepareGUI() {
		//prepares GUI
		frame = new JFrame("Quizzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
	}

}