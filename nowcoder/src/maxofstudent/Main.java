package maxofstudent;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] score = new int[n + 1];
			for (int i = 1; i <= n; i++)
				score[i] = in.nextInt();
			for (int i = 0; i < m; i++) {
				String ch = in.next();
				int op1 = in.nextInt();
				int op2 = in.nextInt();
				if (ch.equals("Q")) {
					if(op1 >op2)
					{
						int t=op1;
						op1=op2;
						op2=t;
					}
					int max_t = score[op1];
					for (int j = op1 + 1; j <= op2; j++) {
						if (score[j] > max_t)
							max_t = score[j];
					}
					System.out.println(max_t);
				} else if (ch.equals("U")) {
					score[op1] = op2;
				}
			}
		}
		in.close();
	}
}
