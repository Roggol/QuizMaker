package Quizzle;


import java.util.Vector;
import java.io.Serializable;

public class Students implements Serializable{

	private Vector<Student> entries;

    public Students( ) {
        entries = new Vector<Student>();
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
	public void setQuizName( int index, int quizname){
		entries.get(index).setQuizName(quizname);
	}
    public void delete(int index) {
    	entries.remove(index);
    }
    public int numberOfEntries(){
    	int entryNum=entries.size();
    	return entryNum;
    }
    public String passwordFor( String name ) {
        for (int i = 0; i < entries.size(); ++i) {
            if ( entries.get(i).getUsername().equals(name) ) {
                return entries.get(i).getPassword();
            }
        }
        return "Student not found.";
    }
    public String toString( ) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < entries.size(); ++i) {
            temp.append( entries.get(i).toString() + "\n" );
        }
        return temp.toString();
    }
    public boolean foundUser(String username, String password) {
    	boolean found= false;
    	for(int i = 0; i< entries.size(); ++i) {
    		if((entries.get(i).getUsername().equalsIgnoreCase(username))&&(entries.get(i).getPassword().equalsIgnoreCase(password))) {
    			found=true;
    		}
    	}
    	return found;
    }

}
