package numPairsDivisibleBy60;


public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int len=time.length;
        if(len==0)
        	return 0;
        int out=0;
        for(int i=0;i<len;i++)
        {
        	for(int j=i+1;j<len;j++)
        	{
        		if((time[i]+time[j])%60==0)
        			out++;
        	}
        }
        return out;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {30,20,150,100,40};
		Solution test=new Solution();
		System.out.println(test.numPairsDivisibleBy60(num_in));
	}

}
