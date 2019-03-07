package findMedianSortedArrays;
/*
 * 二分法检索
 * o(log(m+n))
 * 68 ms 75.8 MB
 */
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num_t1,num_t2;    
        int len1,len2; 
        if(nums1.length > nums2.length )
        {
            len1=nums2.length;
            len2=nums1.length;
        	num_t1=nums2;
        	num_t2=nums1;
        }
        else
        {
            len1=nums1.length;
            len2=nums2.length;
        	num_t1=nums1;
        	num_t2=nums2;
        }
        if(len2==0)
        	return 0.0;
        int i=0,j=0;
        int imin=0,imax=len1;;
        int halfLen=(len1+len2+1)/2;
        
        while(imin<=imax)
        {
            i=(imax+imin)/2;
            j=halfLen-i;
            if(i>imin && num_t1[i-1] > num_t2[j])
            {
            	imax=i-1;
            }
            else if(i<imax && num_t1[i] < num_t2[j-1])
            {
            	imin=i+1;
            }
            else
            {
            	int maxLeft=0;
            	if(i==0)
            	{
            		maxLeft=num_t2[j-1];
            	}
            	else if(j==0)
            	{
            		maxLeft=num_t1[i-1];
            	}
            	else
            	{
            		maxLeft=Math.max(num_t1[i-1], num_t2[j-1]);
            	}
            	if((len1+len2)%2==1)
            		return maxLeft;
            	else
            	{
            		int minRight=0;
                	if(i==len1)
                	{
                		minRight=num_t2[j];
                	}
                	else if(j==len2)
                	{
                		minRight=num_t1[i];
                	}
                	else
                	{
                		minRight=Math.min(num_t1[i], num_t2[j]);
                	}
            		return (maxLeft+minRight)/2.0;
            	}
            }
        }
        return 0.0;
    }
	public static void main(String[] args) {
		int[] num_in = {0,9};
		int[] num_in2 ={1,2,3};
		System.out.println(findMedianSortedArrays(num_in, num_in2));
	}

}