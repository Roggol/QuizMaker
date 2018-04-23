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
	public void setQuizName( int index, String quizname){
		entries.get(index).setQuizName(quizname);
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
