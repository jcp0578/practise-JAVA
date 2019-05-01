package camelMatch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> ret=new ArrayList<>();
        satrt:
        for(String str:queries)
        {
        	int i=0;
        	int pattern_index=0;
        	for(i=0;i<str.length();i++)
        	{
        		char t=str.charAt(i);
        		if(pattern_index <pattern.length() && t==pattern.charAt(pattern_index))
        		{
        			pattern_index++;
        		}
        		else if(t >='a' && t <='z')
        		{
        			continue;
        		}
        		else
        		{
        			ret.add(false);
        			continue satrt;
        		}
        	}
        	if(pattern_index==pattern.length())
        		ret.add(true);
        	else
        		ret.add(false);
        }
        return ret;
    }
	public static void main(String[] args) {
		Solution test=new Solution();
		String[] test_in= {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
		String pattern ="FoBa";
		System.out.println(test.camelMatch(test_in, pattern));

	}

}
