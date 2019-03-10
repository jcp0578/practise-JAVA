package SecondMax;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] max = new int[2];
		Arrays.fill(max, Integer.MIN_VALUE);
		for (int i = 0; i < len; i++) {
			if (sc.hasNextInt()) {
				int temp = sc.nextInt();
				if (temp > max[0]) {
					max[1] = max[0];
					max[0] = temp;
				} else if (temp > max[1]) {
					max[1] = temp;
				} else {
				}
			}

		}
		if (max[1] != Integer.MIN_VALUE) {
			System.out.println(max[1]);
		} else {
			System.out.println();
		}

	}

}
