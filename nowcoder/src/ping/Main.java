package ping;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int out = 0;
			while (n > 1) {
				if (n == 2) {
					out += 1;
					n = 0;
				}
				out += n / 3;
				n = n / 3 + n % 3;
			}
			System.out.println(out);
		}
		in.close();
	}
}
