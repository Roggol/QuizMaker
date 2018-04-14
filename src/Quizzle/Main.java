package Quizzle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {//starts program
		boolean firstLaunch=false;
		File file = new File("Admins.dat");
		if(!(file.exists())) {
			firstLaunch=true;
			try{
				ObjectOutputStream out = new ObjectOutputStream
		                ( new FileOutputStream( "Admins.dat" ) );
		            out.close();
				//creates binary file
				System.out.println("Login file created");
			}catch(IOException e) {
				e.printStackTrace();
			}
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.dat") );
				out.close();
				System.out.println("Students File created");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		new Login(firstLaunch);//launches Login class
	}	
}
