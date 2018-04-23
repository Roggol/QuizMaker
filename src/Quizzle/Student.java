package Quizzle;


import java.io.Serializable;

class Student implements Serializable{
  private String school;
  private String yeargroup;


  public Student( String inSchool, String inYeargroup) {
      school = inSchool;
      yeargroup = inYeargroup;
  }

  public String getSchool() {
      return school;
  }
  public String getYeargroup() {
      return yeargroup;
  }

  public String toString( ) {
      return school + "," + yeargroup;
  }

    /*
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
    }*/

}
