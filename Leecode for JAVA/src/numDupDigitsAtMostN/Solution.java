package numDupDigitsAtMostN;


/**
 * 
 * out time
 * @author JCP
 *
 */
public class Solution {
    public int numDupDigitsAtMostN(int N) {
        int out=0;
        for(int i=11;i<=N;i++)
        {
        	int[] count=new int[10];
        	int j=i;
        	while(j>0)
        	{
        		count[j%10]++;
        		if(count[j%10]==2)
        		{
        			out++;
        			break;
        		}
        		j/=10;
        	}
        }
        return out;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_in=1000;
		Solution test=new Solution();
		System.out.println(test.numDupDigitsAtMostN(num_in));
	}
}
