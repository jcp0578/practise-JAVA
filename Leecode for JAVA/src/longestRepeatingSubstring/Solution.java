package longestRepeatingSubstring;

/*
 * 3. 最长重复子串
 * AC but slow
 * 
 */
public class Solution {
    public int longestRepeatingSubstring(String S) {
		if(S==null)
			return 0;
		int len=S.length();
		if(len<=1)
			return 0;
		int out=0;
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(S.charAt(i)==S.charAt(j))
				{
					int k=1;
					for(;j+k<len;k++)
					{
						if(S.charAt(i+k)==S.charAt(j+k))
						{
							continue;
						}
						else
							break;
					}
					if(k>out)
						out=k;
				}
			}
		}
        return out;
    }
	public static void main(String[] args) {
		String test_in = "aaaaa";
		
		
		Solution test = new Solution();
		System.out.println(test.longestRepeatingSubstring(test_in));

	}

}
