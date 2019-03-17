package bitwiseComplement;

public class Solution {
    public int bitwiseComplement(int N) {
        int out=0;
        int flag=1;
        do
        {
        	out+=((N&flag)==0?flag:0);
        	flag=flag<<1;
        }while(flag<N);
        return out;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num_in=2;
		Solution test=new Solution();
		System.out.println(test.bitwiseComplement(num_in));
	}

}
