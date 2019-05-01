package judgePoint24;

import java.util.ArrayList;

/*
 * 24点游戏
 * AC but slow
 * 35ms 
 */
public class Solution {
	public boolean judgePoint24(int[] nums) {
		ArrayList<Double> nums_t=new ArrayList<>();
		for(int t:nums)
		{
			nums_t.add(new Double(t));
		}
		return deal(nums_t);

	}

	private boolean deal(ArrayList<Double> nums) {
		if(nums.size()==0)
			return false;
		if(nums.size()==1)
		{
			if(Math.abs(nums.get(0) - 24.0) < 1e-6)
				return true;
			else
				return false;
		}
		for(int i=0;i<nums.size();i++)
		{
			for(int j=0;j<nums.size();j++)
			{
				if(j==i)
					continue;
				ArrayList<Double> temp=new ArrayList<>();
				for(int k=0;k<nums.size();k++)
				{
					if(k==i || k==j)
						continue;
					temp.add(nums.get(k));
				}
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && j > i) continue;
                    if (k == 0) temp.add(nums.get(i) + nums.get(j));
                    if (k == 1) temp.add(nums.get(i) * nums.get(j));
                    if (k == 2) temp.add(nums.get(i) - nums.get(j));
                    if (k == 3) {
                        if (nums.get(j) != 0) {
                        	temp.add(nums.get(i) / nums.get(j));
                        } else {
                            continue;
                        }
                    }
                    if (deal(temp)) return true;
                    temp.remove(temp.size() - 1);
                }				
				
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] test_in = { 1, 9,1,2 };
		Solution test = new Solution();
		System.out.println(test.judgePoint24(test_in));

	}

}
