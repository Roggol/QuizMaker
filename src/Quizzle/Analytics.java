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

public class Analytics extends JFrame implements ActionListener {
	
	

	private JFrame frame;
	private JPanel panel;
	JButton next;

	JLabel  Header;
	JLabel Footer; 
	JLabel[] yearGroups = new JLabel[10];
	String [][] content = new String[2][10];
	JButton exit;

	
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


	public Analytics(Students s, String quiz, boolean Admin, QuestionBank q, String Schools, String year) {

		prepareGUI();

		

		
		ActionListener listener = new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource()==exit){
					new Startup(quiz, q, Admin, s, Schools, year);
					frame.dispose();
					
				}


			}

		};

		exit = new JButton("Exit");
		exit.setSize (100, 50);
		exit.addActionListener(listener);
		exit.setLocation(50, 750);
		panel.add(exit);
		
		
		Header = new JLabel  ("Analytics");
		Footer = new JLabel ("(500, 300)");
		
		Header.setSize (100, 100);
		Header.setLocation(500, 50);	
		
		Footer.setSize(100, 100);
		Footer.setLocation(500, 300);
		
		//AnswerB.setSize (600, 50);
		//AnswerB.setLocation(1000, 300);
		
		
		int [] startCoordinate = {100,100};
		String[] headers = new String [10];
		
		
		
		content [0][0] = "Marlwood";
		content [0][1] = "44%";
		content [0][2] = "75%";
		content [0][3] = "75%";
		content [0][4] = "66%";
		
		headers [0] = "School";
		headers [1] = "Year 9";
		headers [2] = "Year 10";
		headers [3] = "Year 11";
		headers [4] = "Average";
		
		createTable("Students Percentage Averages",headers, content, 175, 25, startCoordinate, panel);
		
		
		
		startCoordinate[1] = 300;
		
		content [0][0] = "Marlwood";
		content [0][1] = "75";
		content [0][2] = "43";
		content [0][3] = "200";
		content [0][4] = "318";
		
		headers [0] = "School";
		headers [1] = "Year 9";
		headers [2] = "Year 10";
		headers [3] = "Year 11";
		headers [4] = "Sum";
		
		createTable("Amounts Of Students",headers, content, 175, 25, startCoordinate, panel);
		
		startCoordinate[1] = 500;
		
		content [0][0] = "Marlwood";
		content [0][1] = "75%";
		content [0][2] = "30%";
		content [0][3] = "70%";
		content [0][4] = "JHEEZ%";
		
		headers [0] = "Question";
		headers [1] = "1";
		headers [2] = "2";
		headers [3] = "3";
		headers [4] = "4";
		
		createTable("Average Per Question",headers, content, 175, 25, startCoordinate, panel);
		
		
		
		
		
		/*for(int i=1; i<10; i++){
		
			yearGroups[i] = new JLabel  ("Year Group:\n/n " + i);
		
			yearGroups[i].setSize (100, 100);
			yearGroups[i].setLocation(500+ i*100, 300);
		
		
			panel.add(yearGroups[i]);
		
		}*/
		
		
		
		
		//panel.add(Header);
		//panel.add(Footer);
		
		panel.setLayout(null);

		
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	
	public void createTable (String title,String[] headers, String[][] rows ,int spaceBetweenColumns, int spaceBetweenRows, int [] startLocation, JPanel p){
		
		yearGroups[0] = new JLabel  (title);
		yearGroups[0].setSize (1000, 100);
		yearGroups[0].setLocation(startLocation[0],startLocation[1] - spaceBetweenRows);
		p.add(yearGroups[0]);
		
		for(int i=0; i<headers.length; i++){
			
			yearGroups[i] = new JLabel  (headers[i]);
		
			yearGroups[i].setSize (100, 100);
			yearGroups[i].setLocation(startLocation[0] + i*spaceBetweenColumns, startLocation[1]);
		
		
			p.add(yearGroups[i]);
		
		}
		
		for(int i=0; i<rows.length; i++){
			for(int j=0; j<rows[i].length; j++){
				System.out.println(rows[i][j]);
				yearGroups[j] = new JLabel  (rows[i][j]);
		
				yearGroups[j].setSize (100, 100);
				yearGroups[j].setLocation(startLocation[0] + (j)*spaceBetweenColumns, startLocation[1] + spaceBetweenRows*(i+1));
		
				p.add(yearGroups[j]);
				
			}
		
		}
		
		
		
		
	}
	
	private void prepareGUI() {
		//prepares GUI
		frame = new JFrame("Quizzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	JButton  Header;
	JLabel Footer; 
	
	//JTextField AnswerB;
	
	private JFrame frame;
	private JPanel panel;

	public Analytics (){
		//setLayout(null);
		System.out.println("AAAA");
		prepareGUI();//setup GUI
		//setLayout(null);
		Header = new JButton  ("(100, 100)");
		Footer = new JLabel ("(500, 300)");
		//AnswerB = new JTextField  ("aye");
		JLabel[] yearGroups = new JLabel[10];
		
		//AnswerA.setFont(new Font("Verdana",1,20));
		
		Header.setSize (1, 1);
		Header.setLocation(100, 100);	
		
		Footer.setSize(100, 100);
		Footer.setLocation(500, 300);
		
		Footer.setSize(100, 50);
		Footer.setLocation(400, 480);
		//AnswerB.setSize (600, 50);
		//AnswerB.setLocation(1000, 300);	
		
		panel.add(Header);
		panel.add(Footer);
		//frame.add(panel);
		//panel.add(AnswerB);
		//frame.add(panel);
		
		/*for(int i=1; i<10; i++){
			
			yearGroups[i] = new JLabel  ("Year Group:\n/n " + i);
			
			yearGroups[i].setSize (100, 50);
			yearGroups[i].setLocation(10+0*10, 1000);
			
			panel.add(yearGroups[i]);
			
			
			
		}
		
		
		
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		prepareGUI();//setup GUI
		// TODO Auto-generated method stub
		
	}
	
	
	private void prepareGUI() {
		
		//prepares GUI
		frame = new JFrame("Quizzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
	}
	*/
}