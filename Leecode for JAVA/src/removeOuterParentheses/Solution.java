package removeOuterParentheses;

public class Solution {
    public String removeOuterParentheses(String S) {
        if(S==null ||S.length()<=1)
        	return S;
        int len=S.length();
        StringBuffer out=new StringBuffer();
        int temp=0;
        int i=0;
        int start=0;
        while(start <len)
        {
        	try
	        {
	        	do
	        	{
		        	if(S.charAt(i)=='(')
		        	{
		        		temp++;
		        		i++;
		        	}
		        	else
		        	{
		        		temp--;
		        		i++;
		        	}
	        	}while(temp!=0);
	        	out.append(S.substring(start+1, i-1));
	        	start=i;
        	}
        	catch(Exception e)
        	{
        		break;
        	}
        }
        return out.toString();
    }
	public static void main(String[] args) {
		String test_in="()";
		Solution test=new Solution();
		System.out.println(test.removeOuterParentheses(test_in));

	}

}
