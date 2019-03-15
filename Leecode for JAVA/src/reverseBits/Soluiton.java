package reverseBits;
/*
   *  颠倒二进制位
 *  
 * AC but too slow 
 */
public class Soluiton {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	if(n==1)
    	{
    		return Integer.MIN_VALUE;
    	}
        StringBuilder out_t=new StringBuilder(Integer.toBinaryString(n));
        out_t.reverse();
        for(int i=out_t.length();i<32;i++)
        	out_t.append('0');
        if(out_t.length()==32 && out_t.charAt(0)=='1')
        {
        	out_t.setCharAt(0, '-');
        }
        Integer out=Integer.valueOf(out_t.toString(),2);
        if(out<0)
        	out=-2147483648-out;
        return out;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_in1 = -1;
		Soluiton test = new Soluiton();
		System.out.println(test.reverseBits(num_in1));
	}

}
