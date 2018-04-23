package Quizzle;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class Login {
		GUImanager g = new GUImanager();

		private JFrame frame;
		private JPanel panel;
		JButton start;
		JTextField username;
		JTextField password;
		JTextField school;
		JTextField yeargroup;
		String usernameCheck;
		String passwordCheck;
		String year = "";
		String schools = "";
		JButton Login;
		JButton admin;

		//Initialise buttons, strings, integers and Labels

		public Login(boolean firstLaunch) {

			prepareGUI();//sets up GUI

			start = new JButton("Play as Student");
			Login = new JButton("Login as Admin");
			username = new JTextField("UserName");
			password = new JTextField("Password");
			school = new JTextField("School");
			yeargroup = new JTextField("Yeargroup");
			admin = new JButton("Create Admin");
			//sets up buttons and Text fields
			ActionListener listener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					if (event.getSource() == start) {
						//if the start button is pressed
						goToMenu();
					}
					if (event.getSource() == Login){
						signup();
					}
					if(event.getSource()==admin) {
						createAdmin();
					}

				}
			};

			//objects setup
			start.addActionListener(listener);
			start.setFocusable(false);
			start.setBackground(Color.GRAY);
			start.setSize(400, 50);
			start.setLocation(1000, 480);

			Login.addActionListener(listener);
			Login.setFocusable(false);
			Login.setBackground(Color.GRAY);
			Login.setSize(400, 50);
			Login.setLocation(1000, 530);

			admin.addActionListener(listener);
			admin.setFocusable(false);
			admin.setBackground(Color.GRAY);
			admin.setSize(400, 50);
			admin.setLocation(1000, 530);


			username.setSize(100, 50);
			password.setSize(100, 50);
			username.setLocation(800, 530);
			password.setLocation(900, 530);
			school.setSize(100, 50);
			yeargroup.setSize(100, 50);
			school.setLocation(800,480);
			yeargroup.setLocation(900,480);
			panel.setLayout(null);
			panel.add(start);
			panel.add(username);
			panel.add(password);
			panel.add(school);
			panel.add(yeargroup);
			if(firstLaunch==true) {
				panel.add(admin);
			}else {
				panel.add(Login);
			}
			frame.add(panel);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);

		}

		protected void createAdmin() {
			usernameCheck = username.getText();
			passwordCheck = password.getText();
			//gets string from text fields
			Admins a = new Admins();
			a.add(usernameCheck, passwordCheck);
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Admins.dat") );
				out.writeObject(a);
				out.close();
				System.out.println("saved");
			}catch(IOException e) {
				e.printStackTrace();
			}
			frame.dispose();
			Students s = new Students();
			s.load();
			new QuizChoose(true, s, schools, year);


		}

		protected void signup() {
			boolean found = false;
			usernameCheck = username.getText();
			passwordCheck = password.getText();
			//get Text from box
			Admins a = new Admins();
			try {
					ObjectInputStream ois = new ObjectInputStream
		                ( new FileInputStream( "Admins.dat" ) );
		            a = (Admins)ois.readObject();
		            ois.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			Students s = new Students();
			s.load();

			if(passwordCheck.equals(a.PasswordFor(usernameCheck))) {
				frame.dispose();
				new QuizChoose(true, s, schools, year);

			}else {
				JOptionPane.showMessageDialog(null, "Username or password does not match" );

			}

		}


		protected void goToMenu() {
			Admins a = new Admins();
			try {
					ObjectInputStream ois = new ObjectInputStream
		                ( new FileInputStream( "Admins.dat" ) );
		            a = (Admins)ois.readObject();
		            ois.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			schools = school.getText();
			year = yeargroup.getText();
			Students s = new Students();
			s.load();
			frame.dispose();
			new QuizChoose(false, s, schools, year);
		}


		private void prepareGUI() {
			//sets up GUI
			frame = new JFrame("Quizzle");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new JPanel();
			frame.add(panel);
			frame.setVisible(true);
		}

}
