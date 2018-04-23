package Quizzle;


import java.io.Serializable;
//do not edit
class Question implements Serializable{

    private String questionTitle;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private String explanation;
    private String picString;
    

    public Question( String title, String AnswerA, String AnswerB, String AnswerC, String AnswerD, String answer, String explanationQ, String picStringQ ) {
        questionTitle = title;
        answerA = AnswerA;
        answerB = AnswerB;
        answerC = AnswerC;
        answerD = AnswerD;
        correctAnswer = answer;
        explanation = explanationQ;
        picString = picStringQ;
    }

    public String getTitle() {
        return questionTitle;
    }
    public String getA() {
        return answerA;
    }
    public String getB() {
    	return answerB;
    }
    public String getC() {
    	return answerD;
    }
    public String getD() {
        return answerC;
    }
    public String getAnswer() {
        return correctAnswer;
    }
    public void setTitle(String inTitle) {
    	questionTitle=inTitle;
    }
    public void setA(String inA) {
    	answerA=inA;
    }
    public void setB(String inB) {
    	answerB=inB;
    }
    public void setC(String inC) {
    	answerC=inC;
    }
    public void setD(String inD) {
    	answerD=inD;
    }
    public void setAnswer(String inAnswer) {
    	correctAnswer=inAnswer;
    }
    public void setExplanation(String inExplanation) {
    	explanation=inExplanation;
    }
    public String getExplanation() {
    	return explanation;
    }
    public void setPicString(String pic_String) {		//added
    	picString = pic_String;		
    }
    public String getPicString() {						//added
    	return picString;
    }
    public String toString( ) {
        return questionTitle + "," + answerA + "," + answerB + "," + answerC + ","+ answerD + "," + correctAnswer;
    }

    public boolean equals( Question s ) {
        return questionTitle.equals( s.questionTitle );
    }
    
    public boolean correct(String answer) {
		return (answer.equals(correctAnswer));   	
    }
}
