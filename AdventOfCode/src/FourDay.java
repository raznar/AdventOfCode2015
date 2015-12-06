import java.security.*;

import javax.xml.bind.DatatypeConverter;

public class FourDay {
	
	public static final String INPUT = "ckczppom";

	public static void main(String[] args) throws Exception {
		partOne();
		partTwo();
	}
	
	public static void partOne() throws Exception {
		long number = 0;

		
		MessageDigest m = MessageDigest.getInstance("MD5");
		
		while(true) {
			String key = String.format("%s%d", INPUT, number);
			number++;
			byte[] message = m.digest(key.getBytes());
			if (DatatypeConverter.printHexBinary(message).startsWith("00000")) {
				System.out.println(DatatypeConverter.printHexBinary(message));
				break;
			}
		}
		number--;
		System.out.println("The number is : " + number);
		
	}
	
	public static void partTwo() throws Exception {
		long number = 0;

		
		MessageDigest m = MessageDigest.getInstance("MD5");
		
		while(true) {
			String key = String.format("%s%d", INPUT, number);
			number++;
			byte[] message = m.digest(key.getBytes());
			if (DatatypeConverter.printHexBinary(message).startsWith("000000")) {
				System.out.println(DatatypeConverter.printHexBinary(message));
				break;
			}
		}
		number--;
		System.out.println("The number is : " + number);
		
	}

}
