package replaceSpace;

/*
 * 替换空格
 * 
 * AC 19 ms
 */
public class Solution {
    public static String replaceSpace(StringBuffer str) {
    	for(int i=0;i<str.length();i++)
    	{
    		if(str.charAt(i)==' ')
    		{
    			str.insert(i, "%20");
    			i+=3;
    			str.deleteCharAt(i);
    			i-=1;
    		}	
    	}
    	return str.toString();
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		StringBuffer num_in=new StringBuffer("We Are  Happy.");
		System.out.println(replaceSpace(num_in));

	}

}
