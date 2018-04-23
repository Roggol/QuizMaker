package Quizzle;
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


	public Analytics(String quizName,QuestionBank q, boolean admin, Students s, String schools, String year) {

		prepareGUI();
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource()==exit){
					new Startup(quizName, q, admin, s, schools, year);
					frame.dispose();
					
				}


			}

		};
		
		//Students s = new Students ();

		

		exit = new JButton("Exit");
		exit.setSize (100, 50);
		exit.addActionListener(listener);
		exit.setLocation(50, 750);
		panel.add(exit);
		
		int [] startCoordinate = {100,100};
		String[] headers = new String [10];

		printQuizTablesToScreen(panel, startCoordinate, s); 		//this function takes the data from the student file and prints it onto the screen

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
		
		//createTable("Students Percentage Score Average",headers, content, 175, 25, startCoordinate, panel);
		
		
		
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
		
		//createTable("Amounts Of Students Who Partook In Each Quiz",headers, content, 175, 25, startCoordinate, panel);
		
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

		

		//createTable("Schools Average Score Per Quiz",headers, content, 175, 25, startCoordinate, panel);
		
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
		
				
		
		//writeStats("Statistics: ", stats, 200, 25, startCoordinate, panel);
		
		
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

	public void printQuizTablesToScreen(JPanel panel, int[] startCoordinate, Students s){

		String[] students = new String[2];
		ArrayList<String> years = new ArrayList<String>();
		ArrayList<String> schools = new ArrayList<String>();
		ArrayList<String> quizs = new ArrayList<String>();
		
		int studentAmount = s.numberOfEntries();
		
		System.out.println("Amount of Students: " + s.numberOfEntries());
		
		ArrayList allStudents = new ArrayList();
		String [] stu = new String [3];
		
		ArrayList<Integer> yearsCount = new ArrayList<Integer>();
		ArrayList<Integer> schoolsCount = new ArrayList<Integer>();
		ArrayList<Integer> quizCount = new ArrayList<Integer>();
		
		
		for (int i = 0; i < s.numberOfEntries(); i++) {
			stu[0] = s.getQuizName(i);
			System.out.println("Quiz Name:" + s.getQuizName(i));
			
			
			
			stu[1] = ""+s.getScore(i);
			System.out.println("Score :" + s.getScore(i));
			stu[2] = s.getSchool(i);
			
			String curQuiz = s.getQuizName(i);
			if (quizs . contains (curQuiz) == false && (curQuiz != null)){
				quizs.add(curQuiz);
				quizCount.add(1);
			} else {
				int indexInArray = quizs.indexOf(curQuiz);
				int toSet = quizCount.get(indexInArray) + 1;
				
				quizCount.set(indexInArray, toSet);
			}
			
			
			if (years . contains (s.getYear(i)) == false && (s.getYear(i) != null)){
				years.add(s.getYear(i));
				yearsCount.add(1);
			} else {
				int indexInArray = years.indexOf(s.getYear(i));
				int toSet = yearsCount.get(indexInArray) + 1;
				
				yearsCount.set(indexInArray, toSet);
			}
			System.out.println("Year:" + s.getYear(i));
			System.out.println("School:" + s.getSchool(i));
			if (schools . contains (s.getSchool(i)) == false && (s.getSchool(i) != null)){
				schools.add(s.getSchool(i));
				schoolsCount.add(1);
			} else {
				int indexInArray = schools.indexOf(s.getSchool(i));
				int toSet = schoolsCount.get(indexInArray) + 1;
				
				schoolsCount.set(indexInArray, toSet);
			}
			//schools.add(s.getSchool(i));
			allStudents.add(stu);
			
		}
		
		System.out.println("Years: " + years);
		System.out.println("Schools: " + schools);
		System.out.println("School Counts: " + schoolsCount);
		System.out.println("Years Count: " + yearsCount);
		
		System.out.println("Quizs: " + quizs);
		System.out.println("Quiz Counts: " + quizCount);
		
		
		
		
		System.out.println("All Students.");
		
		int [][] quizScores = new int [quizs.size()][Collections.max(quizCount)];
		int [] amountOfEntries = new int [quizs.size()];
		
		for (int i = 0; i < s.numberOfEntries(); i++) {
			String qName = s.getQuizName(i);
			int score = s.getScore(i);
			
			quizScores[quizs.indexOf(qName)][amountOfEntries[quizs.indexOf(qName)]] = score; 
			amountOfEntries[quizs.indexOf(qName)] += 1;
			
			
		}
		
		String[][] toPrint = new String [quizs.size()][2];
		String[][] toPrint2 = new String [quizs.size()][2];
		
		for (int i = 0; i < quizScores.length; i++) {
			
			System.out.println(Arrays.toString(quizScores[i]));
			//ArrayList<Integer> b = Arrays.asList(quizScores[i]);
			
			
			List<Integer> b = new ArrayList<Integer>();
			int sum = 0;
			for (int k : quizScores[i])
			{
			    b.add(k);
			    sum += k;
			}
			
			
			
			//int sum = Collections.sum(b);
			int topScore = Collections.max(b);
			int maxScore = topScore * amountOfEntries[i];
			
			int averageScore = 0; 
			
			if (topScore == 0){
				averageScore = 0;
			} else {
				System.out.println(sum/maxScore);
				
				float percent = (sum* 100/maxScore) ;
				averageScore = Math.round(percent) ;
			}
			
			System.out.println("Top Score: " + topScore);
			
			System.out.println("Average Grade: " + averageScore + "%");
			System.out.println("Sum: " + sum);
			System.out.println("Max Score: " + maxScore);
			
			System.out.println("Quiz: " + quizs.get(i) + " Average Score: " + averageScore + "%");
			
			toPrint[i][0] = quizs.get(i);
			toPrint[i][1] = averageScore + "%";
			
			toPrint2[i][0] = quizs.get(i);
			toPrint2[i][1] = amountOfEntries[i] + "";
			
			String[][] stats = new String [10][2];
			startCoordinate[0] = 1300;
			startCoordinate[1] = 100;
			
			stats[0][0] = "Total Students:";
			stats[0][1] = studentAmount+"";
			
			for (int j =0; j< schools.size(); j++) {
				System.out.println("J: " + j);
				stats[j+1][0] = "# of " + schools.get(j) + " students:";
				stats[j+1][1] = ""+schoolsCount.get(j);
				
			}
			
			startCoordinate[0] = 800;
			
					
			
			writeStats("Statistics: ", stats, 200, 25, startCoordinate, panel);
			
			
		}
		

		
		
		
		String[] ajheez = new String [2]; //adds extra room for average and name
		ajheez[0] = "Quiz";

		ajheez[1] = "Average Score";
		
		startCoordinate[0] = 100;
		startCoordinate[1] = 100;
		
		createTable("Students Percentage Score Average",ajheez, toPrint, 175, 25, startCoordinate, panel);
		
		startCoordinate[0] = 500;
		ajheez[1] = "Amount";
		createTable("Amount Of Students Who Entered Each Quiz",ajheez, toPrint2, 175, 25, startCoordinate, panel);
		
		System.out.println("^^ Quizs and Scores");

		int [][][] schoolsYears = new int[schools.size()][years.size()][s.numberOfEntries()]; //holds each [school][year][grades]
		
		System.out.println("School Years made.");

		java.util.Collections.sort(schools); //sorts them
		java.util.Collections.sort(years); 

		//System.out.println(schools);
		//System.out.println(years);
		
		System.out.println("Lists Sorted.");

		
		for (int i = 0; i < studentAmount; i++){

				
			String currentQuiz = s.getQuizName(i);	//this would be where get student quiz is called

			String currentSchool = (s.getSchool(i)); 			//this would be where get student year is called

			int currentScore = s.getScore(i);				//this would be where get student score is called
			
			ArrayList<ArrayList<Integer>> yearsScores = new ArrayList<ArrayList<Integer>>();
			
			for (int g = 0 ; g < years.size(); g++) {
				
				yearsScores.add(allStudents);
				
			}
			

			//puts score into array
			for (int z = 0; z < students.length; z++){
				//System.out.println(z);
				//System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
				//if (schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] == 0){
					//schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z] = currentScore;
					//System.out.println(schoolsYears[schools.indexOf(currentSchool)][years.indexOf(currentYear)][z]);
					//break;
				//}
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
			//createTable(title, headers,content,175, 25,startCoordinate,panel);
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
