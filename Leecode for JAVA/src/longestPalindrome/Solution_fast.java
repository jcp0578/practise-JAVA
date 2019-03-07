package longestPalindrome;

class Solution_fast {
	    public String longestPalindrome(String s) {
	        int n = s.length();

	        int [] range = new int[2];
	        for(int i = 0;i<n;i++){
	            i = helper(s, range, i);
	        }

	        return s.substring(range[0],range[1]);
	    }

	    public int helper(String s,int [] range, int i){
	        int lo = i; int hi=i;
	        while (hi<s.length()-1 && s.charAt(hi) == s.charAt(hi+1)){
	            hi++;
	        }

	        int ret = hi;
	        while (lo>0 && hi<s.length()-1 && s.charAt(lo-1)== s.charAt(hi+1)){
	            lo--;
	            hi++;
	        }

	        if(hi-lo +1 > range[1]-range[0]){
	            range[0] = lo;
	            range[1] = hi+1;
	        }

	        return ret;
	    }
	}
