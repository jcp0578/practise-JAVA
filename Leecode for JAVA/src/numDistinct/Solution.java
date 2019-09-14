package numDistinct;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * title:不同的子序列
 * url:https://leetcode-cn.com/problems/distinct-subsequences/submissions/
 * 
 * TIME OUT
 * 
 */
public class Solution {
	public int numDistinct(String s, String t) {
		if(t == null)
			return 1;
		if(s == null)
			return 0;
		int lenOfS = s.length();
		int lenOfT = t.length();
		
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < lenOfS; i++) {
			Character temp = s.charAt(i);
			if (map.containsKey(temp)) {
				map.get(temp).add(i);
			} else {
				ArrayList<Integer> addList = new ArrayList<>();
				addList.add(i);
				map.put(temp, addList);
			}
		}
		return DFS(map, t, -1, 0);

	}

	private int DFS(HashMap<Character, ArrayList<Integer>> map, String t, int index, int k) {
		int len = t.length();
		if (k == len)
			return 1;
		int res = 0;
		ArrayList<Integer> listTemp = map.getOrDefault(t.charAt(k), null);
		if(listTemp == null)
			return 0;
		for (int i = 0; i < listTemp.size(); i++) {
			int curIndex = listTemp.get(i);
			if (curIndex <= index) {
				continue;
			} else {
				res += DFS(map, t, curIndex, k + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String str_in = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String str_in2 = "bcddceeeebecbc";
		Solution test = new Solution();
		System.out.println(test.numDistinct(str_in, str_in2));

	}

}
