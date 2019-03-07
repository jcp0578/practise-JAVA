package FindtwoArray;

/*
 * 二维数组中的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * 
 * AC but not good
 * 
 * 
 */
public class solution {
	static int [][] find_array;
	static int find_target;
    public static boolean Find(int target, int [][] array) {
    	int len_row=array.length;
    	if(len_row<=0)
    		return false;
    	int len_line=array[0].length;
    	if(len_row<=0)
    		return false;
    	
    	find_array=array;
    	find_target=target;
    	
    	return Find_sub(0,0,len_row-1,len_line-1);
    	
    	
    }
    
	private static boolean Find_sub(int start_i, int start_j, int end_i, int end_j) {
		if(start_i>end_i || start_j>end_j)
		{
			return false;
		}
		try 
		{
			int start=find_array[start_i][start_j];
			if(find_target<start)
				return false;
			else if(find_target==start)
				return true;
			
			int end=find_array[end_i][end_j];
			if(find_target>end)
				return false;
			else if(find_target==end)
				return true;
			int mid_i=(start_i+end_i)/2;
			int mid_j=(start_j+end_j)/2;
			int mid=find_array[mid_i][mid_j];
			if(find_target==mid)
				return true;
			else if(find_target>mid)
				return (Find_sub(start_i,mid_j+1,mid_i,end_j)||Find_sub(mid_i+1,start_j,end_i,end_j));
			else
				return (Find_sub(start_i,start_j,end_i,mid_j-1) || Find_sub(start_i,mid_j,mid_i-1,end_j));
		}
		catch(Exception e) 
		{
			return false;
		}
	}

	public static void main(String[] args) {
		int [][] in= {{1,2,3},{2,3,5}};
		int target_in = 4;
		System.out.println(Find(target_in,in));

	}

}

/* 
 * 思路
 * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
 * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
 * 要查找数字比左下角数字小时，上移
 */

