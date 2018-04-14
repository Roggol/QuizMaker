package Quizzle;


import java.io.Serializable;

class Student implements Serializable{

    private String username;
    private String password;

    

    public Student( String inUsername, String inPassword) {
        username = inUsername;
        password = inPassword;    
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String toString( ) {
        return username + "," + password;
    }

    public boolean equals( Student s ) {
        return username.equals( s.username ) && password.equals( s.password );
    }
}

