package reverseBits;
/*
   *  颠倒二进制位
 *  
 * AC 
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=Integer.reverse(n);
        return res;
    }
    
//    public int reverseBits(int n) {
//        int res=0;
//        for(int i=0;i<32;i++){
//            res<<=1;
//            res|=(n&1);     //注意顺序，不然把最高位给左移出去了
//            n>>>=1;
//        }
//        return res;
//    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_in1 = 1;
		Solution test = new Solution();
		System.out.println(test.reverseBits(num_in1));
	}

}
