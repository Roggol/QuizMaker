package Quizzle;


import java.util.Vector;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Students implements Serializable{

	private Vector<Student> entries;

    public Students( ) {
        entries = new Vector<Student>();
    }
	public void load() {
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream("entries.dat"));
			entries = (Vector<Student>)in.readObject();
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void save() {
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream("entries.dat") );
			out.writeObject(entries);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    /*public void add( String username, String password){
		entries.add(new Student(username, password));
	}*/
	public void add( String school, String yeargroup){
	entries.add(new Student(school, yeargroup));
	}
	public void setScore( int index, int score){
		entries.get(index).setScore(score);
	}
	public void setQuizName( int index, String quizname){
		entries.get(index).setQuizName(quizname);
	}
	public int getScore(int index, int score){
		return entries.get(index).getScore(score);
	}
    public void delete(int index) {
    	entries.remove(index);
    }
    public int numberOfEntries(){
    	int entryNum=entries.size();
    	return entryNum;
    }

    public String toString( ) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < entries.size(); ++i) {
            temp.append( entries.get(i).toString() + "\n" );
        }
        return temp.toString();
    }


}
