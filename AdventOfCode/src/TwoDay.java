import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TwoDay {
		
	public static void main(String[] args) throws FileNotFoundException{
		partOne();
		partTwo();
	}
	
	public static void partOne() throws FileNotFoundException {
		Scanner con = new Scanner(new File("two_day_input.txt"));
		
		int surfaceArea = 0;
		
		//Iterate over the file line by line
		while (con.hasNextLine()) {
			
			//Store dimensions
			String dim = con.nextLine();
			
			//Split the dimensions delimited by the 'x'
			String[] ar = dim.split("x");
			
			//Assign variables to the dimensions
			int l = Integer.parseInt(ar[0]);
			int w = Integer.parseInt(ar[1]);
			int h = Integer.parseInt(ar[2]);
			
			//Calculate side areas
			int lw = l*w;
			int lh = l*h;
			int wh = w*h;
			
			//Calculates the minimum amount of padding
			int padding = Math.min(Math.min(lw, lh), wh);
			
			//Add on the area
			surfaceArea += 2*(lw+lh+wh) + padding;
		}
		
		System.out.println(surfaceArea);
		con.close();
		
	}
	
	public static void partTwo() throws FileNotFoundException {
		Scanner con = new Scanner(new File("two_day_input.txt"));
		
		int feet = 0;
		
		//Iterate over the file line by line
		while (con.hasNextLine()) {
			
			//Store dimensions
			String dim = con.nextLine();
			
			//Split dimensions delimited by 'x'
			String[] ar = dim.split("x");
			
			//Create object Integer list
			Integer[] list = new Integer[3];
			
			list[0] = Integer.parseInt(ar[0]);
			list[1] = Integer.parseInt(ar[1]);
			list[2] = Integer.parseInt(ar[2]);
			
			//Sort the array from biggest to smallest
			//Smallest is always position 0, Second smallest is position 1, and Biggest is position 2
			List<Integer> intList = Arrays.asList(list);
			intList.sort(null);
			
			feet += (2*intList.get(0)) + (2*intList.get(1)) + (list[0]*list[1]*list[2]); 
		}
		
		System.out.println(feet);
		con.close();
	}
}
