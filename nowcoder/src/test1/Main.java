package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int find_n;
	static int flag=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int k = in.nextInt();
            find_n=n;
            flag=0;
            ArrayList<Integer> out_t=new ArrayList<>();
            find(0,k,0,out_t);
        }
    }

	private static void find(int last_sum, int step, int last, ArrayList<Integer> out_t) {
		if(flag==0)
		{
			if(step==0)
			{
				if(last_sum==find_n)
				{
					flag=1;
					for(Integer temp:out_t)
					{
						if(temp>0)
						{
							System.out.print(temp);
							System.out.print(" ");
							System.out.println("+");
						}
						else
						{
							System.out.print(-temp);
							System.out.print(" ");
							System.out.println("-");
						}
					}
				}
				return ;
			}
			else
			{
	            
	            int temp=2*last;
	            last_sum+=temp;
	            out_t.add(temp);
	            find(last_sum,step-1,temp,out_t);
	            out_t.remove(out_t.size()-1);
	            last_sum-=temp;
	            
	            temp=-2*last;
	            last_sum+=temp;
	            out_t.add(temp);
	            find(last_sum,step-1,temp,out_t);
	            out_t.remove(out_t.size()-1);
	            last_sum-=temp;
	            
	            temp=2*last+1;
	            last_sum+=temp;
	            out_t.add(temp);
	            find(last_sum,step-1,temp,out_t);
	            out_t.remove(out_t.size()-1);
	            last_sum-=temp;
	            
	            temp=-(2*last+1);
	            last_sum+=temp;
	            out_t.add(temp);
	            find(last_sum,step-1,temp,out_t);
	            out_t.remove(out_t.size()-1);
	            last_sum-=temp;
			}
			
		}

		
	}

}
