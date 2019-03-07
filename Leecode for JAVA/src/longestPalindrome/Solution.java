package longestPalindrome;

import java.util.List;


/*
 * 马拉车算法
 */
public class Solution {
    public static String longestPalindrome(String s) {
    	if(s=="")
    	{
    		return "";
    	}
    	List<Character> s_t=new java.util.ArrayList<Character>();
    	s_t.add('$');
    	s_t.add('#');
    	for(int i=0;i<s.length();i++)
    	{
        	s_t.add(s.charAt(i));
        	s_t.add('#');
    	}
    	s_t.add('%');
    	int id=0,mx=0;
    	int s_t_len=s_t.size()-1;
    	int p[] = new int[s_t_len];
    	int p_max=0;
    	
    	for(int i=1;i<s_t_len;i++)
    	{
    		if (i < mx)
    			if(p[2 * id - i] > (mx - i))
    			{
    				p[i]=(mx - i);
    				continue;
    			}
    			else if(p[2 * id - i] < (mx - i))
    			{
    				p[i]=p[2 * id - i];
    				continue;
    			}
    			else
    			{
    				p[i]=p[2 * id - i];
    			}
            else
                p[i] = 1;
    		while (s_t.get(i - p[i]) == s_t.get(i + p[i]))  // 不需边界判断，因为左有'$',右有'%'
                p[i]++;
            if (mx < i + p[i])
            {
                id = i;
                mx = i + p[i];
            }
    		if(p[i]>p[p_max])
    		{
    			p_max=i;
    		}
    	}
    	String out_t=new String(s.substring((p_max-p[p_max])/2,(p_max+p[p_max]-1)/2));
		return out_t;
    }
	public static void main(String[] args) {
		String String_in="a"; 
		System.out.println(longestPalindrome(String_in));
	}
}
