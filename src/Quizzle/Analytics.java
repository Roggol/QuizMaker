package Quizzl;
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
	JLabel statLabel;
	JLabel[] yearGroups = new JLabel[10];
	String [][] content = new String[3][10];
	JButton exit;


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
		
		Students s = new Students ();
		System.out.println("Getting Students.");
		for (int i = 0; i < s.numberOfEntries(); i++) {
			
			System.out.println(s.getQuizName(i));
			System.out.println(s.getScore(i));
			System.out.println(s.getSchool(i));
			System.out.println(s.getScore(i));
			
		}
		
		System.out.println("All Students.");
		

		exit = new JButton("Exit");
		exit.setSize (100, 50);
		exit.addActionListener(listener);
		exit.setLocation(50, 750);
		panel.add(exit);
		
		int [] startCoordinate = {100,100};
		String[] headers = new String [10];

		//printQuizTablesToScreen(panel, startCoordinate); 		//this function takes the data from the student file and prints it onto the screen

		//as I was not able to get data from the file I went about creating demo templates
		content [0][0] = "Biology";
		content [0][1] = "44%";
		content [0][2] = "75%";
		content [0][3] = "75%";
		content [0][4] = "66%";
		
		content [1][0] = "Chemistry";
		content [1][1] = "30%";
		content [1][2] = "60%";
		content [1][3] = "90%";
		content [1][4] = "60%";
		
		content [2][0] = "Physics";
		content [2][1] = "90%";
		content [2][2] = "75%";
		content [2][3] = "60%";
		content [2][4] = "75%";
		
		headers [0] = "Quiz Name";
		headers [1] = "Year 9";
		headers [2] = "Year 10";
		headers [3] = "Year 11";
		headers [4] = "Average";
		
		createTable("Students Percentage Score Average",headers, content, 175, 25, startCoordinate, panel);
		
		
		
		startCoordinate[1] = 300;
		
		content [0][0] = "Biology";
		content [0][1] = "15";
		content [0][2] = "20";
		content [0][3] = "25";
		content [0][4] = "50";
		
		content [1][0] = "Chemistry";
		content [1][1] = "14";
		content [1][2] = "6";
		content [1][3] = "10";
		content [1][4] = "30";
		
		content [2][0] = "Physics";
		content [2][1] = "9";
		content [2][2] = "10";
		content [2][3] = "11";
		content [2][4] = "30";
		
	
		headers [0] = "School";
		headers [1] = "Year 9";
		headers [2] = "Year 10";
		headers [3] = "Year 11";
		headers [4] = "Sum";
		
		createTable("Amounts Of Students Who Partook In Each Quiz",headers, content, 175, 25, startCoordinate, panel);
		
		startCoordinate[1] = 500;
		content [0][0] = "Biology";
		content [0][1] = "44%";
		content [0][2] = "75%";
		content [0][3] = "75%";
		content [0][4] = "66%";
		
		content [1][0] = "Chemistry";
		content [1][1] = "30%";
		content [1][2] = "60%";
		content [1][3] = "90%";
		content [1][4] = "60%";
		
		content [2][0] = "Physics";
		content [2][1] = "90%";
		content [2][2] = "75%";
		content [2][3] = "60%";
		content [2][4] = "75%";
		
		headers [0] = "Quiz Name";
		headers [1] = "THS";
		headers [2] = "DMS";
		headers [3] = "Melbourne";
		headers [4] = "Average";

		

		createTable("Schools Average Score Per Quiz",headers, content, 175, 25, startCoordinate, panel);
		
		String[][] stats = new String [10][2];
		startCoordinate[0] = 1300;
		startCoordinate[1] = 100;
		
		stats[0][0] = "Total Students:";
		stats[0][1] = "125";
		stats[1][0] = "Quiz w/ Highest Average Score:";
		stats[1][1] = "Physics";
		stats[2][0] = "Quiz w/ Lowest Average Score:";
		stats[2][1] = "Biology";

		stats[3][0] = "Year w/ Highest Average Score:";
		stats[3][1] = "Year 11";
		stats[4][0] = "Year w/ Lowest Average Score:";
		stats[4][1] = "Year 9";
		
				
		
		writeStats("Statistics: ", stats, 200, 25, startCoordinate, panel);
		
		
		//the above code is example of what the analytics should look like
		
		panel.setLayout(null);

		
		frame.add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void writeStats (String title, String[][] rows ,int spaceBetweenColumns, int spaceBetweenRows, int [] startLocation, JPanel p){

		statLabel = new JLabel  (title);
		statLabel.setSize (1000, 100);	
		statLabel.setLocation(startLocation[0],startLocation[1] - spaceBetweenRows);
		p.add(statLabel);
		
			for (int i = 0; i < rows.length; i++) {
				
				statLabel = new JLabel  (rows[i][0]);
				statLabel.setSize (1000, 100);	
				statLabel.setLocation(startLocation[0],startLocation[1] + spaceBetweenRows*i);
				p.add(statLabel);
				
				statLabel = new JLabel  (rows[i][1]);
				statLabel.setSize (1000, 100);	
				statLabel.setLocation(startLocation[0] + spaceBetweenColumns,startLocation[1] + spaceBetweenRows*i);
				p.add(statLabel);
			}
		
	}
	
	
	public void createTable (String title,String[] headers, String[][] rows ,int spaceBetweenColumns, int spaceBetweenRows, int [] startLocation, JPanel p){
		//the above code creates a table od data with a title a header and the rows which fill that
		yearGroups[0] = new JLabel  (title); 			//adds a title
		yearGroups[0].setSize (1000, 100);				//sets size of the title
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

		int [][][] schoolsYears = new int[schools.size()][years.size()][students.length]; //holds each [school][year][grades]

		java.util.Collections.sort(schools); //sorts them
		java.util.Collections.sort(years); 

		System.out.println(schools);
		System.out.println(years);

		
		for (int i = 0; i < 1; i++){

				
			String currentSchool = "Quiz 1";	//this would be where get student quiz is called

			String currentYear = "CU"; 			//this would be where get student year is called

			int currentScore = 75;				//this would be where get student score is called

			//puts score into array
			for (int z = 0; z < students.length; z++){
				//System.out.println(z);
				//System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
				if (schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] == 0){
					schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] = currentScore;
					System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
					break;
				}
				//System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);


			}

		}

		/*for (int x = 0; x < schools.size(); x++){
			System.out.println(schools.get(x));
			for (int y = 0; y < years.size(); y++){
				for (int z = 0; z < students.length; z++){
					System.out.print(" " + schoolsYears[x][y][z]);
					
				}
				
				System.out.print(" " + years.get(y));
				System.out.println();
			}
		}*/

		

		System.out.println("\nConverting Tables: \n");
		//this is where the data is converted into a form where it can be put into table form

		for (int i = 0; i < schools.size(); i++){

			
			String[] headers = new String [students.length+2]; //adds extra room for average and name
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
			
			//puts the students into the tables
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
		//calculates the average score of the the students 
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

}
