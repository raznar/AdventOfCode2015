import java.io.*;
import java.util.*;

public class SixDay {

	public static void main(String[] args) throws Exception{
		partOne();
		partTwo();
	}
	
	public static void partOne() throws Exception {
		Scanner con = new Scanner(new File("six_day_input.txt"));
		boolean[][] lightArray = new boolean[1000][1000];
		
		while (con.hasNextLine()) {
			String line = con.nextLine();
			String[] input = line.split(" ");
			
			String[] start;
			String[] end;
			boolean tog = false;
			boolean change = false;
			
			if (input[0].equals("toggle")) {
				tog = true;
				start = input[1].split(",");
				end = input[3].split(",");
			} else {
				start = input[2].split(",");
				end = input[4].split(",");
				if (input[1].equals("on")) change = true;
			}

			for (int i = Integer.parseInt(start[0]); i <= Integer.parseInt(end[0]); i++) {
				for (int j = Integer.parseInt(start[1]); j <= Integer.parseInt(end[1]); j++) {
					if (tog) lightArray[i][j] = !lightArray[i][j];
					else lightArray[i][j] = change;
				}
			}
		}
		
		con.close();
		int lightsOn = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (lightArray[i][j]) lightsOn++;
			}
		}
		System.out.println("Number of Lights On: " + lightsOn);
	}
	
	public static void partTwo() throws Exception {
		Scanner con = new Scanner(new File("six_day_input.txt"));
		int[][] lightArray = new int[1000][1000];
		
		while (con.hasNextLine()) {
			String line = con.nextLine();
			String[] input = line.split(" ");
			
			String[] start;
			String[] end;
			boolean tog = false;
			
			int add = 0;
			
			if (input[0].equals("toggle")) {
				tog = true;
				start = input[1].split(",");
				end = input[3].split(",");
				add = 2;
			} else {
				start = input[2].split(",");
				end = input[4].split(",");
				if (input[1].equals("on")) add = 1;
				else add = -1;
			}

			for (int i = Integer.parseInt(start[0]); i <= Integer.parseInt(end[0]); i++) {
				for (int j = Integer.parseInt(start[1]); j <= Integer.parseInt(end[1]); j++) {
					if (tog) lightArray[i][j] += add;
					else {
						if (lightArray[i][j] > 0) {
							lightArray[i][j] += add;
						} else if (lightArray[i][j] == 0 && add != -1) {
							lightArray[i][j] += add;
						}
					}
				}
			}
		}
		
		con.close();
		int lightsOn = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				lightsOn += lightArray[i][j];
			}
		}
		System.out.println("Overall Brightness: " + lightsOn);
	}
}
