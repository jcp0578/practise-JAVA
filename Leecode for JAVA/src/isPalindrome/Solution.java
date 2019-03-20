package isPalindrome;

/**
 * 125. 验证回文串
 * 
 * @author JCP
 * AC but slow
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len<=1)
        	return true;
        int i=0,j=len-1;
        while(i<j)
        {
        	char temp_i='@';
        	for(;i<len;)
        	{
        		temp_i=s.charAt(i++);
        		if(Character.isDigit(temp_i) || Character.isLetter(temp_i))
    				break;
        		temp_i='@';
        	}
        	temp_i=Character.toLowerCase(temp_i);
        	char temp_j='@';
        	for(;j>=0;)
        	{
        		temp_j=s.charAt(j--);
        		if(Character.isDigit(temp_j) || Character.isLetter(temp_j))
    				break;
        		temp_j='@';
        	}
        	temp_j=Character.toLowerCase(temp_j);
    		if(temp_i!=temp_j)
    			return false;
        }
        return true;
    }
	public static void main(String[] args) {
		Solution test=new Solution();
		String test_str= ".,";
		System.out.println(test.isPalindrome(test_str));
	}

}
