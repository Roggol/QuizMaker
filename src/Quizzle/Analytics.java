<<<<<<< HEAD
package Quizzle;
import  java.util.ArrayList;
import java.util.*;

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


	public Analytics() {

		prepareGUI();

		

		
		ActionListener listener = new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource()==exit){
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

		printQuizTablesToScreen(panel, startCoordinate);



		/*
		
		
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
		
		*/
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

	public void printQuizTablesToScreen(JPanel panel, int[] startCoordinate){

		

		String[] students = new String[2];
		ArrayList<String> years = new ArrayList<String>();
		ArrayList<String> schools = new ArrayList<String>();

		schools.add("Quiz 1");
		schools.add("Quiz 2"); 
		years.add("DMS");
		years.add("THS");
		years.add("CU");


		int [][][] schoolsYears = new int[schools.size()][years.size()][students.length];

		java.util.Collections.sort(schools);
		java.util.Collections.sort(years);
		System.out.println(schools);
		System.out.println(years);

		for (int i = 0; i < 1; i++){

			String currentSchool = "Quiz 1";

			String currentYear = "CU";

			int currentScore = 75;

			//puts score into array
			for (int z = 0; z < students.length; z++){
				System.out.println(z);
				System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
				if (schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] == 0){
					schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] = currentScore;
					System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
					break;
				}
				System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);


			}

		}

		for (int x = 0; x < schools.size(); x++){
			System.out.println(schools.get(x));
			for (int y = 0; y < years.size(); y++){
				for (int z = 0; z < students.length; z++){
					System.out.print(" " + schoolsYears[x][y][z]);
					
				}
				
				System.out.print(" " + years.get(y));
				System.out.println();
			}
		}

		

		System.out.println("\nConverting Tables: \n");

		for (int i = 0; i < schools.size(); i++){

			String[] headers = new String [students.length+2];
			headers[0] = "School";

			headers[1] = "Scores";

			headers[students.length+1] = "Average";
			String [][] rows = new String [years.size()][students.length+2];

			String title = schools.get(i);

			System.out.println("\n");	

			System.out.println("Title: " + title);
			

				for (int y = 0; y < years.size(); y++){
					rows[y][0] = years.get(y);
					for (int z = 0; z < students.length; z++){
						System.out.print(" " + schoolsYears[i][y][z]);
						rows[y][z+1] = Integer.toString(schoolsYears[i][y][z]);
						
					}
					rows[y][students.length+1] =Integer.toString(getAverage(schoolsYears[i][y]));
					
					System.out.print(" " + years.get(y));
					System.out.println();

				}

			System.out.println(rows.length);
			System.out.println(Arrays.toString(headers));
			for (int x = 0; x < rows.length; x++){

				System.out.println(Arrays.toString(rows[x]));

			}
			createTable(title, headers,content,175, 25,startCoordinate,panel);
		}

	}


	public static int search2d(String[][] list, String key){

		for (int i = 0 ; i < list.length; i++){
    		for(int j = 0 ; j < list[i].length ; j++){
         		if ( list[i][j] == key){
         			return i;
         		}
    		}
		}

	return -1;
}

	
	public static int getAverage(int[] list){

		ArrayList<Integer> toReturn = new ArrayList<Integer>();
		int sum = 0;
		int n = 0;
		for (int i = 0 ; i < list.length; i++){
			if ((list[i]) > 0){
				n += 1;
				sum += (list[i]);
				toReturn.add((list[i]));

			}
		} 


		if (n != 0) {

			return sum/n;

		} else {

			return 0;

		}
		
	
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
=======
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
>>>>>>> a214cf9a684c98c5985eaac07d3e54c52120f3b6
}