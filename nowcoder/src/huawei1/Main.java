package huawei1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int N = in.nextInt();
			String str = in.next();
			for (int i = 0; i < N; i++) {
				int flag = (int) str.charAt(i * 9);
				char[] out = new char[8];
				for (int j = 0; j < 8; j++)
					out[j] = str.charAt(i * 9 + j + 1);
				if (flag == '0') {
					for (int j = 7; j >= 0; j--)
						System.out.print(out[j]);
				} else {
					for (int j = 0; j < 8; j++)
						System.out.print(out[j]);
				}
				if (i != N - 1)
					System.out.print(' ');
			}
		}
		in.close();

	}

}
