package getSum;

public class Solution {

    public static int getSum(int a, int b) {
    	int add_t,carry_t;
    	add_t=a^b;
    	carry_t=(a&b)<<1;
    	while(carry_t!=0)
    	{
    		int a_t=add_t,c_t=carry_t;
    		add_t=a_t^c_t;
    		carry_t=(a_t&c_t)<<1;
    	}
    	return add_t;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_a=-100;
		int num_b=0;
		System.out.println(getSum(num_a,num_b));
	}

}
