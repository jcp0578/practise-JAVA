package test2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = 0, y = 0, k = 0;
			x = sc.nextInt();
			y = sc.nextInt();
			k = sc.nextInt();
			int x_abs = Math.abs(x);
			int y_abs = Math.abs(y);
			int min_t = Math.min(x_abs, y_abs);
			int xy_diff = Math.abs(x_abs - y_abs);
			if (k < (min_t + xy_diff))
				System.out.println(-1);
			else {
				if (xy_diff % 2 == 0) {
					if ((k - min_t) % 2 == 1)
						System.out.println(k - 2);
					else
						System.out.println(k);
				} else {
					System.out.println(k - 1);
				}
			}
		}
	}
}
