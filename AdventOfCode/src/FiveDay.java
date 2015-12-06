import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FiveDay {
	public static void main(String[] args) throws FileNotFoundException {
		partOne();
		partTwo();
	}

	private static void partOne() throws FileNotFoundException {
		Scanner con = new Scanner(new File("five_day_input.txt"));
		
		int nice = 0;
		
		while(con.hasNextLine()) {
			String input = con.nextLine();
			if(isNice(input)){
				nice++;
			}
		}
		
		con.close();
		
		System.out.println("Nice: " + nice);
		
	}

	public static boolean isNice(String input) {
		Pattern vowel = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");
		Pattern repeatedChar = Pattern.compile("(\\w)\\1");
		Pattern prohibited = Pattern.compile("(ab|cd|pq|xy)");
		
		Matcher m1 = vowel.matcher(input);
		Matcher m2 = repeatedChar.matcher(input);
		Matcher m3 = prohibited.matcher(input);
		
		if (m3.find()) return false;
		if (m1.find() && m2.find()) return true;
		
		return false;
	}

	private static void partTwo() throws FileNotFoundException {
		Scanner con = new Scanner(new File("five_day_input.txt"));
		
		int nice = 0;
		
		while(con.hasNextLine()) {
			String input = con.nextLine();
			if(isNice2(input)){
				nice++;
			}
		}
		
		con.close();
		
		System.out.println("Nice: " + nice);

	}
	
	public static boolean isNice2(String input) {
		Pattern pairOfLetters = Pattern.compile("(..).*\\1");
		Pattern repeatedChar = Pattern.compile("(.).\\1");
		
		Matcher m1 = pairOfLetters.matcher(input);
		Matcher m2 = repeatedChar.matcher(input);
		
		if (m1.find() && m2.find()) return true;
		
		return false;
	}
}
