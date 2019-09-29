package numPrimeArrangements;

/*
 * titel: 1175. 质数排列
 * url:https://leetcode-cn.com/problems/prime-arrangements/submissions/
 * time:1ms - 98.97%
 * memory: 32.7MB - 100%
 * AC
 * 
 */

public class Solution {
	final int[] PrimeTable= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
	final int mod = 1000000000+7;
	
	boolean isPrime(int n) {
		for(int i=0;i<PrimeTable.length;i++) {
			if(PrimeTable[i] == n)
				return true;
			else if(PrimeTable[i] > n)
				return false;
			else 
				continue;
		}
		return false;
	}
    public int numPrimeArrangements(int n) {
        if(n <= 2)
        	return 1;
        long sum_t = 1;
        int primeNum = 1;
    	for(int i =3;i<=n;i++) {
    		if(isPrime(i)) {
    			sum_t *=(++primeNum);
    		} else {
    			sum_t *=(i-primeNum);
    		}
    		if(sum_t >= mod) {
    			sum_t %= mod;
    		}
    	}
    	return (int)sum_t;
    }
	public static void main(String[] args) {
		int test_in = 100;
		Solution test = new Solution();
		System.out.println(test.numPrimeArrangements(test_in));

	}

}
