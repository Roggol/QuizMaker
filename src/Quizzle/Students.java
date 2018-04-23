package Quizzle;


import java.util.Vector;
import java.io.FileInputStream;
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
 /*   public boolean foundUser(String username, String password) {
    	boolean found= false;
    	for(int i = 0; i< entries.size(); ++i) {
    		if((entries.get(i).getUsername().equalsIgnoreCase(username))&&(entries.get(i).getPassword().equalsIgnoreCase(password))) {
    			found=true;
    		}
    	}
    	return found;
    }
*/
}
