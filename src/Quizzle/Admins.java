package Quizzle;

import java.util.Vector;
import java.io.Serializable;

public class Admins implements Serializable{

	private Vector<Admin> entries;

    public Admins( ) {
        entries = new Vector<Admin>();
    }

    public void add( String username, String password) {
		entries.add(new Admin(username, password));
    }
    public void delete(int index) {
    	entries.remove(index);
    }
    public int numberOfEntries(){
    	int entryNum=entries.size();
    	return entryNum;
    }
    public String PasswordFor( String name ) {
        for (int i = 0; i < entries.size(); ++i) {
            if ( entries.get(i).getUsername().equals(name) ) {
                return entries.get(i).getPassword();
            }
        }
        return "Admin not found.";
    }
    public String toString( ) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < entries.size(); ++i) {
            temp.append( entries.get(i).toString() + "\n" );
        }
        return temp.toString();
    }

}
