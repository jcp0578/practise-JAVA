package tencent3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] power=new int[n];
		int[] money=new int[n];
		for(int i=0;i<n;i++)
		{
			power[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			money[i]=sc.nextInt();
		}
		int sum_money=0;
		int now_power=0;
		
		PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->(b-a));
		for(int i=0;i<n;i++)
		{
			max.add(power[i]);
		}
		for(int i=0;i<n;i++)
		{
			if(now_power<power[i])
			{
				sum_money+=money[i];
				now_power+=power[i];
			}
			else
			{
				int max_t=max.peek();
				if(now_power+power[i] >max_t)
				{
					sum_money+=money[i];
					now_power+=power[i];					
				}
			}
			max.remove(power[i]);
		}
		System.out.println(sum_money);
	}

}


/*
package tencent3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] power=new int[n];
		int[] money=new int[n];
		for(int i=0;i<n;i++)
		{
			power[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			money[i]=sc.nextInt();
		}
		int sum_money=0;
		int now_power=0;
//		int last_power=0;
//		for(int i=0;i<n;i++)
//		{
//			sum_power+=power[i];
//		}
//		last_power=sum_power;
		for(int i=0;i<n;i++)
		{
			if(now_power<power[i])
			{
				sum_money+=money[i];
				now_power+=power[i];
			}
		}
		System.out.println(sum_money);
	}

}
*/