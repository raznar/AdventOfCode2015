import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class ThreeDay {

	public static void main(String[] args) throws FileNotFoundException {
		partOne();
		partTwo();
	}


	public static void partOne() throws FileNotFoundException {
		Scanner con = new Scanner(new File("three_day_input.txt"));
		String input = con.nextLine();
		
		//Convert the whole input into a character array to be iterated over
		char[] array = input.toCharArray();

		con.close();
		
		//Create a HashMap to store the coordinates.
		//I really did not need to make a HashMap as an ArrayList or any Set would do
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//Inner class to determine the Coordinates
		class Coordinate {
			int x = 0;
			int y = 0;
			
			public void up() { y++; }
			public void right() { x++; }
			public void down() { y--; }
			public void left() { x--; }
			public String position(){ return x+" "+y; }
		}
		
		
		Coordinate pos = new Coordinate();
		
		//Iterate over the character array
		for (int i = 0; i < array.length; i++) {
			switch (array[i]) {
			case '^':
				pos.up();
				map.put(pos.position(), 0);
				break;
			case '>': 
				pos.right();
				map.put(pos.position(), 0);
				break;
			case 'v': 
				pos.down();
				map.put(pos.position(), 0);
				break;
			case '<': 
				pos.left();
				map.put(pos.position(), 0);
				break;
			default: 
				break;
			}
		}
		System.out.println("Santa delivered to " + map.size() + " houses");
	}

	public static void partTwo() throws FileNotFoundException {
		Scanner con = new Scanner(new File("three_day_input.txt"));
		String input = con.nextLine();

		char[] array = input.toCharArray();

		con.close();

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		class Coordinate {
			int x = 0;
			int y = 0;
			
			public void up() { y++; }
			public void right() { x++; }
			public void down() { y--; }
			public void left() { x--; }
			public String position(){ return x+" "+y; }
		}
		
		
		Coordinate santaPos = new Coordinate();
		Coordinate roboSantaPos = new Coordinate();

		for (int i = 0; i < array.length; i+=2) {
			switch (array[i]) {
			case '^':
				santaPos.up();
				map.put(santaPos.position(), 0);
				break;
			case '>': 
				santaPos.right();
				map.put(santaPos.position(), 0);
				break;
			case 'v': 
				santaPos.down();
				map.put(santaPos.position(), 0);
				break;
			case '<': 
				santaPos.left();
				map.put(santaPos.position(), 0);
				break;
			default: 
				break;
			}
		}
		
		for (int i = 1; i < array.length; i+=2) {
			switch (array[i]) {
			case '^':
				roboSantaPos.up();
				map.put(roboSantaPos.position(), 0);
				break;
			case '>': 
				roboSantaPos.right();
				map.put(roboSantaPos.position(), 0);
				break;
			case 'v': 
				roboSantaPos.down();
				map.put(roboSantaPos.position(), 0);
				break;
			case '<': 
				roboSantaPos.left();
				map.put(roboSantaPos.position(), 0);
				break;
			default: 
				break;
			}
		}
		System.out.println("Santa and RoboSanta delivered to " + map.size() + " houses");
	}
}
