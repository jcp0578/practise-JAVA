package minDominoRotations;

public class Solution {
    public static int minDominoRotations(int[] A, int[] B) {
        int len=A.length;
        if(len==0)
        	return -1;
        if(len!=B.length)
        	return -1;
        int[] count=new int[6];
        for(int i=0;i<len;i++)
        {
        	count[A[i]-1]++;
        	count[B[i]-1]++;
        }
        int max_t=1;
        for(int i=0;i<6;i++)
        {
        	if(count[i]>count[max_t])
        		max_t=i;
        }
        if(count[max_t]<len)
        	return -1;
        int A_notlen=0;
        int B_notlen=0;
        for(int i=0;i<len;i++)
        {
        	if(A[i]-1!=max_t && B[i]-1!=max_t)
        		return -1;
        	if(A[i]-1!=max_t)
        		A_notlen++;
        	if(B[i]-1!=max_t)
        		B_notlen++;
        }
        return Math.min(A_notlen, B_notlen);
        
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] in1= {3,5,1,2,3};
		int[] in2= {3,6,3,3,4};
		System.out.println(minDominoRotations(in1,in2));
	}

}
