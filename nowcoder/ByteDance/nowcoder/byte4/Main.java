package nowcoder.byte4;

/*
 * 时间复杂度过高
 * 40%
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<ArrayList<Integer>> save = new ArrayList<ArrayList<Integer>>();
		save.add(new ArrayList<Integer>());
		int zero_nums = 0;
		for (int i = 0; i < n; i++) {
			if (sc.nextInt() == 0) {
				zero_nums++;
				if (save.get(save.size() - 1).size() != 0)
					save.add(new ArrayList<Integer>());
				if (i != n - 1)
					save.add(new ArrayList<Integer>());

			} else {
				save.get(save.size() - 1).add(1);
			}
		}
		if (zero_nums <= k)
			System.out.println(n);
		else {
			int max_t = 0;
			int len = save.size();
			for (int i = 0; i < len; i++) {
				int change = k;
				int j = i;
				int temp = 0;
				while (j < len && change >= 0) {
					if (save.get(j).size() == 0) {
						change--;
						j++;
						if (change >= 0)
							temp++;
					} else {
						temp += save.get(j).size();
						j++;
					}
				}
				if (temp > max_t)
					max_t = temp;
				if (change > 0)
					break;
			}
			System.out.println(max_t);
		}

	}

}


/*
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<ArrayList<Integer>> save = new ArrayList<ArrayList<Integer>>();
		save.add(new ArrayList<Integer>());
		for (int i = 0; i < n; i++) {
			if (sc.nextInt() == 0) {
				if(save.get(save.size()-1).size() != 0)
					save.add(new ArrayList<Integer>());
				if(i!=n-1)
					save.add(new ArrayList<Integer>());
				
			} else {
				save.get(save.size()-1).add(1);
			}
		}
		int max_t = 0;
		int len = save.size();
		for (int i = 0; i < len; i++) {
			int change = k;
			int j = i;
			int temp = 0;
			while (j < len && change >= 0) {
				if (save.get(j).size() == 0) {
					change--;
					j++;
					if(change>=0)
						temp++;
				} else {
					temp += save.get(j).size();
					j++;
				}
			}
			if (temp > max_t)
				max_t = temp;
			if (change > 0)
				break;
		}
		System.out.println(max_t);

	}

}
*/