package Quizzle;


import java.io.Serializable;

class Student implements Serializable{
  private String school;
  private String yeargroup;
  private int score;
  private String quizname;

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
  public int getScore(){
      return score;
  }
  public String getQuizName(){
      return quizname;
  }
  public void setScore(int inScore){
    score = inScore;
      }
  public void setQuizName(String inQuizname){
    quizname = inQuizname;
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

    public boolean equals( Student s ) {
        return username.equals( s.username ) && password.equals( s.password );
    }
}
