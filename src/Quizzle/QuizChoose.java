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
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizChoose extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	JButton analytics;
	JButton newQuiz;
	JButton oldQuiz;
	JButton back;
	JTextField quizMaker;
	String quizName;
	//initialise objects

	public QuizChoose(boolean admin, Students s) {
		prepareGUI();//setup GUI
		analytics = new JButton("Analytics");
		newQuiz = new JButton("New Category");
		oldQuiz = new JButton("Choose Category");
		quizMaker = new JTextField("Enter Category Here");
		//setup objects
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource() == newQuiz) {
					create(admin, s);
					
				}
				
				if (event.getSource() == analytics) {
					System.out.println("Jheex");
					viewStats(admin);
				}
				
				if(event.getSource() == oldQuiz){
					// use existing quiz
					quizName = quizMaker.getText();
					if (Files.isDirectory(Paths.get(quizName))) {
						QuestionBank q = new QuestionBank();
						try {
				            ObjectInputStream ois = new ObjectInputStream
				                ( new FileInputStream( quizName+"//questions.dat" ) );
				            q = (QuestionBank)ois.readObject();
				            ois.close();
				        }
				        catch (Exception e) {
				            e.printStackTrace();
				        }
						//checks to see if directory exists
						new Startup(quizName,q,admin, s);
						//launches main menu
						frame.setVisible(false);
						frame.dispose();
						//deletes frame
						
					}else{
						JOptionPane.showMessageDialog(null, "Invalid Category");
					}
						
				}
				if(event.getSource() == back){
					new Login(false);
					//returns to login screen
					frame.setVisible(false);
					frame.dispose();
					
				}

			}

		};
		
		analytics.addActionListener(listener);
		analytics.setFocusable(false);
		analytics.setBackground(Color.GRAY);
		analytics.setSize(200, 50);
		analytics.setLocation(100, 100);
		
		
		newQuiz.addActionListener(listener);
		newQuiz.setFocusable(false);
		newQuiz.setBackground(Color.GRAY);
		newQuiz.setSize(200, 50);
		newQuiz.setLocation(840, 480);
		oldQuiz.addActionListener(listener);
		oldQuiz.setFocusable(false);
		oldQuiz.setBackground(Color.GRAY);
		oldQuiz.setSize(200, 50);
		oldQuiz.setLocation(840, 530);

		quizMaker.setSize (200, 50);
		quizMaker.setLocation(840, 580);
		
		back = new JButton("Log out");
		back.addActionListener(listener);
		back.setFocusable(false);
		back.setBackground(Color.GRAY);
		back.setSize(200, 50);
		back.setLocation(840, 630);
		
		panel.setLayout(null);
		if(admin==true) {
			panel.add(newQuiz);
		}
		panel.add(analytics);
		panel.add(oldQuiz);
		panel.add(quizMaker);
		panel.add(back);
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}

	protected void create(boolean admin, Students s) {
		//create quiz
		quizName = quizMaker.getText();
		File directory = new File(quizName);
		directory.mkdir();
		//Create new directory of quiz name

		try{
			ObjectOutputStream out = new ObjectOutputStream
	                ( new FileOutputStream(quizName + "//questions.dat" ) );
	            out.close();
			//creates binary file
	        System.out.println("Questions File created");
		}catch(IOException e) {
			e.printStackTrace();
		}
		QuestionBank q = new QuestionBank();
		frame.dispose();
		new QuizMaker(quizName,q, admin, s);
	}
	
	protected void viewStats(boolean admin) {
		//create quiz
		if (admin == true){
			frame.dispose();
			//new Analytics(s, quizName, admin, null);
		}
	}
		

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	private void prepareGUI() {
		frame = new JFrame("Quizzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

}
