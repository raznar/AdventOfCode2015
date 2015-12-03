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
		
		while (con.hasNextLine()) {
			String dim = con.nextLine();
			String[] ar = dim.split("x");
			
			int l = Integer.parseInt(ar[0]);
			int w = Integer.parseInt(ar[1]);
			int h = Integer.parseInt(ar[2]);
			
			int lw = l*w;
			int lh = l*h;
			int wh = w*h;
			
			int padding = Math.min(Math.min(lw, lh), wh);
			
			surfaceArea += 2*(lw+lh+wh) + padding;
		}
		
		System.out.println(surfaceArea);
		con.close();
		
	}
	
	public static void partTwo() throws FileNotFoundException {
		Scanner con = new Scanner(new File("two_day_input.txt"));
		
		int feet = 0;
		
		while (con.hasNextLine()) {
			String dim = con.nextLine();
			String[] ar = dim.split("x");
			
			Integer[] list = new Integer[3];
			
			list[0] = Integer.parseInt(ar[0]);
			list[1] = Integer.parseInt(ar[1]);
			list[2] = Integer.parseInt(ar[2]);
			
			List<Integer> intList = Arrays.asList(list);
			intList.sort(null);
			
			/*
			
			int min1Dim = Math.min(list[0], list[1]);
			min1Dim = Math.min(min1Dim, list[2]);
			
			int max = Math.max(list[0], list[1]);
			max = Math.max(max, list[2]);
			
			int min2Dim = min1Dim;
			for (int i = 0; i < list.length ; i++) {
				if (list[i] != min1Dim && list[i] != max) {
					min2Dim = list[i];
				}
				if (list[i] == min1Dim && list[i] != max) {
					min2Dim = list[i];
				}
			}
			*/
			
			
			
			
			feet += (2*intList.get(0)) + (2*intList.get(1)) + (list[0]*list[1]*list[2]); 

		}
		
		System.out.println(feet);
		con.close();
	}
}
