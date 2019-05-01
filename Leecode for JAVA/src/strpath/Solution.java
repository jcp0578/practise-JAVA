package strpath;

public class Solution {
	
	public static void main(String[] args) {
		String test_s="xyz";
		String test_t="xzyxz";
		Solution test=new Solution();
		System.out.println(test.strpath(test_s,test_t));

	}

	public int strpath(String test_s, String test_t) {
		int len_s=test_s.length();
		int len_t=test_t.length();
		int count=0;
		int index_t=0;
		int index_s=0;
		int last_index_t=-1;
		while(index_t <len_t)
		{
			if(test_t.charAt(index_t)==test_s.charAt(index_s))
			{
				index_t++;
				index_s++;
			}
			else
			{
				index_s++;
			}
			if(index_s==len_s)
			{
				count++;
				index_s=0;
				if(index_t!=last_index_t)
					last_index_t=index_t;
				else
				{
					count=-1;
					break;
				}
			}
		}
		return count;
	}

}
