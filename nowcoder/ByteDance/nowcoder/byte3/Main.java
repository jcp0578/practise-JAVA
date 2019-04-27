package nowcoder.byte3;

/*
 * 80%
 * 
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int[] place=new int[n];
		for(int i=0;i<n;i++)
		{
			place[i]=sc.nextInt();
		}
		int out=0;
		for(int i=0;i<n;i++)
		{
			int j=i+1;
			//改为二分查找
			int l=i+1,r=n-1;
			while(l<=r)
			{
				int mid=(r-l)/2+l;
				if(place[mid]<=(place[i]+d))
				{
					l=mid+1;
				}
				else
					r=mid-1;
			}
			out+=(l-i-1)*(l-i-2)/2;
			if(out>=99997867)
				out%=99997867;
		}
		System.out.println(out);
	}

}
