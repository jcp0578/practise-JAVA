package shipWithinDays;

/***
 * 
 * OK
 * @author JCP
 *
 */

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int len=weights.length;
        int start=1;
        int end=0;
        for(int i=0;i<len;i++)
        {
        	start=Math.max(start, weights[i]);
        	end+=weights[i];
        }
        int out=end;
        while(start<=end)
        {
        	int mid=(start+end)>>1;
        	int res=find(weights,mid,D);
        	if(res==1)
        	{
        		start=mid+1;
        	}
        	else
        	{
        		out=Math.min(out, mid);
        		end=mid-1;
        	}
        }
        return out;
        
    }
	private int find(int[] weights, int n, int D) {
		int len=weights.length;
		int time=1;
		int sum=0;
		for(int i=0;i<len;i++)
		{
			if((weights[i]+sum)<=n)
				sum+=weights[i];
			else
			{
				if(weights[i]>n)
					return 1;
				time++;
				sum=weights[i];
			}
			if(time>D)
				return 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {1,2,3,1,1};
		int D=4;
		Solution test=new Solution();
		System.out.println(test.shipWithinDays(num_in,D));
	}

}
