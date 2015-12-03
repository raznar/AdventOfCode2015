import java.util.*;
import java.io.*;

public class OneDay
{
	
	public static void main (String[] args) throws FileNotFoundException {
		partOne();
		partTwo();
	}
	
	public static void partOne() throws FileNotFoundException {
		Scanner console = new Scanner(new File("one_day_input.txt"));
		String in = console.nextLine();
		
		//Gets the count of closed parentheses
		int countClosed = in.length() - in.replaceAll("\\)", "").length();
		//Gets the count of open parentheses
		int countOpen = in.length() - in.replaceAll("\\(", "").length();

		System.out.println(countClosed - countOpen);
		console.close();
	}
	
	public static void partTwo() throws FileNotFoundException {
		Scanner console = new Scanner(new File("one_day_input.txt"));
		String in = console.nextLine();
		
		int length = in.length();
		int floor = 0;
		for (int i = 0; i < length; i++) {
			if (in.charAt(i) == '(') floor++;
			if (in.charAt(i) == ')') floor--;
			if (floor == -1) {
				System.out.println("The position is " + i);
				break;
			}
		}
		console.close();
	}
}
