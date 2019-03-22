package isAnagram;

/*
   * 有效的字母异位词
   * 统计比较
 * AC
 * 4ms 93.44%
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t))
        	return true;
        if(s.length()!=t.length())
        	return false;
        int[] count=new int[26];
        for(int i=0;i<s.length();i++) {
			count[s.charAt(i)-'a']++;
		}
        for(int i=0;i<t.length();i++) {
			count[t.charAt(i)-'a']--;
		}
        for(int i=0;i<26;i++)
        {
        	if(count[i]!=0)
        		return false;
        }
        return true;
    }
	public static void main(String[] args) {
		String test1="rac";
		String test2="car";
		Solution test =new Solution();
		System.out.println(test.isAnagram(test1, test2));
				
	}

}
