import java.util.*;
import java.lang.Math;


public class averagemark {
	public static void main ( String args[]) {

		Random r = new Random();
		int[] marks = {r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11), r.nextInt(11)};
		
		System.out.println(averageMark(marks));
		System.out.println(totalMarks(marks));

	}

	
	public static int averageMark(int[] array) {

		float total = 0;

		for(int i=0; i<array.length; i++) {
			total += array[i];
		}

		int averageMark = Math.round(total / array.length);
		return averageMark;
	}

	public static int totalMarks(int[] array) {

		int total = 0;

		for(int i=0; i<array.length; i++) {
			total += array[i];
		}

		return total;

	}
	

}