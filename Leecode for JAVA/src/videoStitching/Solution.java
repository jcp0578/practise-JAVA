package videoStitching;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        ArrayList<int[]> save=new ArrayList<int[]>();
        for(int[] temp:clips)
        {
        	save.add(temp);
        }
        Collections.sort(save,(a,b)->((a[0]-b[0])==0)?(b[1]-a[1]):(a[0]-b[0]));
        ArrayList<int[]> out=new ArrayList<int[]>();
        int add_index=0;
        int pre=0;
        int last_pre=-1;
        while(add_index<save.size())
        {
        	int[] temp=save.get(add_index);
        	if(temp[0]<=pre)
        	{
        		if(temp[0]<=last_pre)
        			out.remove(out.size()-1);
        		out.add(temp);
        		if(temp[1]>=T)
        			break;
        		pre=temp[1];
        		if(out.size()>1)
        			last_pre=out.get(out.size()-2)[1];
        		else
        			last_pre=-1;
        		int i=add_index+1;
        		for(i=add_index+1;i<save.size();i++)
        		{
        			if(save.get(i)[1]>pre)
        			{
        				break;
        			}
        		}
        		add_index=i;
        	}
        	else
        	{
        		return -1;
        	}
        }
        if(out.get(out.size()-1)[1]>=T)
        	return out.size();
        else
        	return -1;
    }
	public static void main(String[] args) {
		Solution test=new Solution();
		int[][] test_in= {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
		int T=9;
		System.out.println(test.videoStitching(test_in, T));

	}

}
