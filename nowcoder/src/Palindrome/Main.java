package Palindrome;

import java.util.Scanner;

/*
 * nowcoder - 华为专题
 * 密码截取
 * 本质为字符串中的最长回文串的长度
 * 
 * AC
 */
public class Main {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine())
		{
			String in=sc.nextLine();
			int len=in.length();
			if(len<=1)
				System.out.println(len);
			int max_len=0;
			for(int i=0;i<len;i++)
			{
				int l=i,r=i;
				while(l>0)
				{
					if(in.charAt(l-1)==in.charAt(l))
						l=l-1;
					else
						break;
				}
				while(r<len-1)
				{
					if(in.charAt(r+1)==in.charAt(r))
						r=r+1;
					else
						break;
				}
				while(l>0 && r<len-1)
				{
					if(in.charAt(r+1)==in.charAt(l-1))
					{
						l=l-1;
						r=r+1;
					}
					else
						break;
				}
				max_len=Math.max(max_len, r-l+1);
			}
			System.out.println(max_len);
		}
		sc.close();
	}
}
