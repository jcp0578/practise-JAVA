package maxProfitAssignment;

//https://leetcode-cn.com/problems/most-profit-assigning-work/
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int t:difficulty) {
        	Integer temp = map.getOrDefault(t, 0);
        	if(temp < t)
        		map.put(t, temp);
        }
        int len = map.size();
        int[] dp = new int[len];
        int i = 0;
        //TODO sort and set dp 
		return 0;
        
    }
	public static void main(String[] args) {
		int[] test_in1 = { 1, 3, 0, 2, 4 };
		int[] test_in2 = { 1, 3, 0, 2, 4 };
		int[] test_in3 = { 1, 3, 0, 2, 4 };
		Solution test = new Solution();
		System.out.println(test.maxProfitAssignment(test_in1, test_in2, test_in3));

	}

}
