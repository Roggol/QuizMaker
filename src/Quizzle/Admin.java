package Quizzle;

import java.io.Serializable;
//do not edit
public class Admin implements Serializable{
	private String Username;
    private String Password;
    

    public Admin( String inName, String inPassword ) {
        Username = inName;
        Password = inPassword;
   
    }

    public String getUsername() {
        return Username;
    }
    public String getPassword() {
    	return Password;
    }

    public String toString( ) {
        return Username + "," + Password;
    }

    public boolean equals( Admin a ) {
        return Username.equals( a.Username ) && Password.equals( a.Password );
    }

}
