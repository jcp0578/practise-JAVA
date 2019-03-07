package multiply;
/*
 * 30ms 45.8 MB
 * AC but use too much Memory
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        if(len1==0 || len2==0)
        {
        	return "0";
        }
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0')
        {
        	return "0";
        }
        int i,j;
        int[] mult_t=new int[len1+len2-1];
        for(i=len1-1;i>=0;i--)
        {
        	for(j=len2-1;j>=0;j--)
        	{
        		mult_t[len1+len2-i-j-2]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        	}
        }
        int carry=0;
        StringBuilder out_t=new StringBuilder();
        for(int num:mult_t)
        {
        	num+=carry;
        	carry=num/10;
        	out_t.append((char) ('0'+(num%10)));
        }
        while(carry!=0)
        {
        	out_t.append((char) ('0'+(carry%10))); 
        	carry/=10;
        }
		return out_t.reverse().toString();
    }
	public static void main(String[] args) {
		String num_in = "10";
		String num_in2 ="123";
		System.out.println(multiply(num_in, num_in2));
	}
}
