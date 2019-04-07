package tencent1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String read_t=sc.next();
		int[] count=new int[2];
		count[0]=0;
		count[1]=0;
		for(int i=0;i<n;i++)
		{
			if(read_t.charAt(i)=='0')
			{
				count[0]++;
			}
			else if(read_t.charAt(i)=='1')
			{
				count[1]++;
			}
			else
			{
				
			}
		}
		System.out.println(Math.abs(count[0]-count[1]));
		sc.close();
	}

}
