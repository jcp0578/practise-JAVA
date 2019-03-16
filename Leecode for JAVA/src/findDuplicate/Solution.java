package findDuplicate;

/*
   *  寻找重复数
   *  快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
   *  注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
   *  因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素, 
   *  即按照寻找链表环入口的思路来做
 *  
 * AC 
   *  时间复杂度O(N)
 */
public class Solution {
    public int findDuplicate(int[] nums) {
    	int len=nums.length;
    	if(len<2)
    		return -1;
    	if(len==2)
    		return nums[0];
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num_in= {1,2,4,2,2};
		Solution test=new Solution();
		System.out.println(test.findDuplicate(num_in));
	}

}
