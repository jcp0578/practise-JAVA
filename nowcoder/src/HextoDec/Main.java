package HextoDec;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String in_string = in.next();
			if(in_string.charAt(0)=='0' && in_string.charAt(1)=='x')
				in_string=in_string.substring(2);
			Integer temp=Integer.parseInt(in_string, 16);
			System.out.println(temp);
		}
		in.close();
	}
}
