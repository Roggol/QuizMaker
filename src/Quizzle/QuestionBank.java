package Quizzle;

import java.util.Vector;
import java.io.Serializable;

public class QuestionBank implements Serializable{
//do not edit
	private Vector<Question> entries;

    public QuestionBank( ) {
        entries = new Vector<Question>();
    }

    public void add( String Title, String AnswerA, String AnswerB, String AnswerC,  String AnswerD, String correctAnswer, String explanation, String picString) {
		entries.add(new Question(Title, AnswerA, AnswerB, AnswerC, AnswerD, correctAnswer, explanation, picString));
    }
    public void replace(int index, String Title, String AnswerA, String AnswerB, String AnswerC,  String AnswerD, String correctAnswer, String explanation, String picString) {
    	entries.get(index).setTitle(Title);
    	entries.get(index).setA(AnswerA);
    	entries.get(index).setB(AnswerB);
    	entries.get(index).setC(AnswerC);
    	entries.get(index).setD(AnswerD);
    	entries.get(index).setAnswer(correctAnswer);
    	entries.get(index).setExplanation(explanation);
    	entries.get(index).setPicString(picString);				//added
    }
    public void delete(int index) {
    	entries.remove(index);
    }
    public int numberOfEntries(){
    	int entryNum=entries.size();
    	return entryNum;
    }
    public String getTitle(int index) {
    	return entries.get(index).getTitle();
    }
    public String getAnswerA(int index) {
    	return entries.get(index).getA();
    }
    public String getAnswerB(int index) {
    	return entries.get(index).getB();
    }
    public String getAnswerC(int index) {
    	return entries.get(index).getC();
    }
    public String getAnswerD(int index) {
    	return entries.get(index).getD();
    }
    public String getAnswer(int index) {
    	return entries.get(index).getAnswer();
    }
    public String getExplanation(int index) {
    	return entries.get(index).getExplanation();
    }
    public String getPicString(int index) {			//added
    	return entries.get(index).getPicString();
    }
    public String toString( ) {
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < entries.size(); ++i) {
            temp.append( entries.get(i).toString() + "\n" );
        }
        return temp.toString();
    }
    public boolean match(int i, String answer) {
		return entries.get(i).correct(answer);	
    }
    public String explantion(int i) {
    	return entries.get(i).getExplanation();
    }
    public String picString(int i) {				//added
    	return entries.get(i).getPicString();
    }
}
