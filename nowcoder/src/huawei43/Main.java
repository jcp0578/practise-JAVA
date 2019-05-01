package huawei43;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<String> save=new ArrayList<>();
		String tt=sc.nextLine();
		while(sc.hasNextLine())
		{
			save.add(sc.nextLine());
		}
		sc.close();
		ArrayList<ArrayList<String>> temp=new ArrayList<>();
		int len=save.size();
		for(int i=0;i<len;i++)
		{
			ArrayList<String> add_t=new ArrayList<>();
			String[] temp1=save.get(i).split(",");
			for(String t:temp1)
			{
				add_t.add(t);
			}
			temp.add(add_t);
		}
		int[] index=new int[len];
		int count=len;
		ArrayList<String> out=new ArrayList<>();
		while(count>0)
		{
			for(int i=0;i<len;i++)
			{
				int now_len=temp.get(i).size();
				if(index[i]==now_len)
					continue;
				else if(index[i]+n>=(now_len))
				{
					for(int j=index[i];j<now_len;j++)
					{
						out.add(temp.get(i).get(j));
						out.add(",");
					}
					index[i]=now_len;
					count--;
				}
				else
				{
					for(int j=index[i];j<(index[i]+n);j++)
					{
						out.add(temp.get(i).get(j));
						out.add(",");
					}
					index[i]+=n;
				}
			}
		}
		StringBuffer outStr=new StringBuffer();
		for(String str:out)
		{
			outStr.append(str);
		}
		outStr.deleteCharAt(outStr.length()-1);
		System.out.println(outStr.toString());
	}

}
