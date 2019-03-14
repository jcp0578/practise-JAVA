package test3;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] a=new Integer[n];
		Integer[] b=new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i]=sc.nextInt();
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer t1,Integer t2)
			{
				if(t1>t2)
					return -1;
				else if(t1==t2)
					return 0;
				else
					return 1;
			}
		};
		Arrays.sort(a, comparator);
		Arrays.sort(b, comparator);
		int sum_a=0;
		int sum_b=0;
		int index_a=0,index_b=0;
		for(int i=0;i<n;i++)
		{
			if(index_a>=n && index_b>=n)
				break;
			
			if(index_a>=n)
			{
				index_b++;
			}
			else if(index_b>=n || a[index_a]>=b[index_b])
			{
				sum_a+=a[index_a];
				index_a++;
			}
			else
			{
				index_b++;
			}
			
			
			if(index_b>=n)
			{
				index_a++;
			}
			else if(index_a>=n || a[index_a]<=b[index_b])
			{
				sum_b+=b[index_b];
				index_b++;
			}
			else
			{
				index_a++;
			}
		}
		System.out.println(sum_a-sum_b);
	}
}
