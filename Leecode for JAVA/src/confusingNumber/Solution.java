package confusingNumber;

/*
 * 1. 易混淆数
 * AC
 * 
 */
public class Solution {
    public boolean confusingNumber(int N) {
        int out=0;
        int flag=1;
        int[] cov= {0,1,-1,-1,-1,-1,9,-1,8,6};
        for(;flag<=N;flag*=10)
        {
        	int temp=N/flag%10;
        	if(cov[temp]==-1)
        		return false;
        	else
        		out=out*10+cov[temp];
        }
        if(out==N)
        	return false;
        else
        	return true;
        			
    }
	public static void main(String[] args) {
		int test_in=1;
		Solution test=new Solution();
		System.out.println(test.confusingNumber(test_in));

	}

}
