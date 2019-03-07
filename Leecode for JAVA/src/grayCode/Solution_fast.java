package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_fast {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		int count = 1 << n;
		for (int i = 0; i < count; i++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
	
    public List<Integer> grayCode2(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for(int i = 0; i < n; i++) {
            int flag = 1 << i;
            int index = ret.size() - 1;
            while(index >= 0) {
                int num = ret.get(index);
                num ^= flag;
                ret.add(num);
                index--;
            }
        }
        return ret;
     }
}
