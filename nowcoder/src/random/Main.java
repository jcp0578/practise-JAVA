package random;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNextInt())
		{
			int n=in.nextInt();
			byte[] flag=new byte[126];
			ArrayList<Integer> out=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int temp=in.nextInt();
				flag[temp>>3] |= (1<<((temp&7)));
			}
			for(int i=0;i<126;i++)
			{
				for(int j=0;j<8;j++)
				{
					if((flag[i]&(1<<j))!=0)
						out.add(i*8+j);
				}
			}
			for(int temp:out)
				System.out.println(temp);
		}
	}
}
