package nowcoder.byte1;

/*
 * AC
 * 
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n<3)
			System.out.println(1);
		else
		{
			int out=1;
			int[] dp=new int[n];//表示第i年出生的
			dp[0]=1;
			dp[1]=0;
			for(int i=2;i<n;i++)
			{
				dp[i]=dp[i-1]+dp[i-2];
				if(i>=7)
					dp[i]-=dp[i-7];
				out+=dp[i];
				if(i>=10)
					out-=dp[i-10];
			}
			System.out.println(out);			
		}
		sc.close();

	}

}
