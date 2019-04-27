package nowcoder.byte2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] save = new int[9];
		for (int i = 0; i < 13; i++)
			save[sc.nextInt() - 1]++;
		Set<Integer> out = new TreeSet<>();
		Deal(save, false, 13, out);
		if (out.size() == 0)
			System.out.println(0);
		else {
			Iterator<Integer> iterator = out.iterator();
			for (int i = 0; i < out.size(); i++) {
				int temp = iterator.next();
				if (save[temp] != 4) {
					System.out.print(temp + 1);
					if (i != out.size() - 1)
						System.out.print(' ');
					else
						System.out.println();
				}
			}
		}

	}

	private static void Deal(int[] save, boolean flag, int len, Set<Integer> out) {
		if (len == 0)
			return;
		else if (len == 1) {
			if (flag == false) {
				for (int i = 0; i < 9; i++) {
					if (save[i] != 0) {
						out.add(i);
						break;
					}
				}
			} else
				return;
		} else if (len == 2) {
			if (flag == true) {
				int[] temp = new int[2];
				int j = 0;
				for (int i = 0; i < 9; i++) {
					if (save[i] == 1) {
						temp[j++] = i;
					} else if (save[i] == 2) {
						temp[0] = i;
						temp[1] = i;
						break;
					}
				}
				if (temp[0] == temp[1])
					out.add(temp[0]);
				else if (temp[1] - temp[0] == 1) {
					if (temp[0] > 0)
						out.add(temp[0] - 1);
					if (temp[1] < 8)
						out.add(temp[1] + 1);
				} else if (temp[1] - temp[0] == 2) {
					out.add(temp[0] + 1);
				}
				return;
			} else
				return;
		} else {
			for (int i = 0; i < 9; i++) {
				if (save[i] != 0) {
					if (save[i] >= 2 && flag == false) {
						save[i] -= 2;
						Deal(save, true, len - 2, out);
						save[i] += 2;
					}
					if (save[i] >= 3) {
						save[i] -= 3;
						Deal(save, flag, len - 3, out);
						save[i] += 3;
					}
					if (i <= 6) {
						if (save[i + 1] != 0 && save[i + 2] != 0) {
							save[i]--;
							save[i + 1]--;
							save[i + 2]--;
							Deal(save, flag, len - 3, out);
							save[i]++;
							save[i + 1]++;
							save[i + 2]++;
						}
					}
				}
			}
		}
	}

}
