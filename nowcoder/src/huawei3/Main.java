package huawei3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int N = in.nextInt();
			boolean[][] axis = new boolean[50][40];

			for (int i = 0; i < N; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				axis[y][x] = true;
			}
			int out = 0;
			while (true) {
				int cut = find(axis);
				if (cut == 0)
					break;
				else
					out++;
			}
			System.out.println(out);
		}
	}

	private static int find(boolean[][] axis) {
		// y
		int max_cut = 0;
		int cut_way = 0;// 0-y 1-x 2-45 3-135
		int cut_index = 0;
		int cut_num = 0;
		for (int i = 0; i < 40; i++) {
			cut_num = 0;
			for (int j = 0; j < 50; j++) {
				if (axis[j][i])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 0;
				cut_index = i;
			}
		}
		// x
		for (int i = 0; i < 50; i++) {
			cut_num = 0;
			for (int j = 0; j < 40; j++) {
				if (axis[i][j])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 1;
				cut_index = i;
			}
		}
		// 2
		for (int i = 0; i < 50; i++) {
			cut_num = 0;
			int j = 0;
			int k = i;
			while (k >= 0 && k < 50 && j >= 0 && j < 40) {
				if (axis[k--][j++])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 2;
				cut_index = i;
			}
		}
		// 2
		for (int j = 1; j < 40; j++) {
			cut_num = 0;
			int i = 49;
			int k = j;
			while (i >= 0 && i < 50 && k >= 0 && k < 40) {
				if (axis[i--][k++])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 2;
				cut_index = 50 + j;
			}
		}

		// 3
		for (int i = 0; i < 50; i++) {
			cut_num = 0;
			int j = 0;
			int k = i;
			while (k >= 0 && k < 50 && j >= 0 && j < 40) {
				if (axis[k++][j++])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 3;
				cut_index = i;
			}
		}
		// 3
		for (int j = 1; j < 40; j++) {
			cut_num = 0;
			int i = 0;
			int k = j;
			while (i >= 0 && i < 50 && k >= 0 && k < 40) {
				if (axis[i++][k++])
					cut_num++;
			}
			if (cut_num > max_cut) {
				max_cut = cut_num;
				cut_way = 3;
				cut_index = 50 + j;
			}
		}
		if (max_cut == 0)
			return 0;

		if (cut_way == 0) {
			for (int i = 0; i < 50; i++)
				axis[i][cut_index] = false;
		} else if (cut_way == 1) {
			for (int i = 0; i < 40; i++)
				axis[cut_index][i] = false;
		} else if (cut_way == 2) {
			if (cut_index < 50) {
				int i = cut_index;
				int j = 0;
				while (i >= 0 && i < 50 && j >= 0 && j < 40) {
					axis[i--][j++] = false;
				}
			} else {
				int j = cut_index - 50;
				int i = 49;
				while (i >= 0 && i < 50 && j >= 0 && j < 40) {
					axis[i--][j++] = false;
				}
			}
		} else if (cut_way == 3) {
			if (cut_index < 50) {
				int i = cut_index;
				int j = 0;
				while (i >= 0 && i < 50 && j >= 0 && j < 40) {
					axis[i++][j++] = false;
				}
			} else {
				int j = cut_index - 50;
				int i = 0;
				while (i >= 0 && i < 50 && j >= 0 && j < 40) {
					axis[i++][j++] = false;
				}
			}
		}

		return max_cut;
	}

}
