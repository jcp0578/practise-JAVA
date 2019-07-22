package frequencySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/*
 * 根据字符出现频率排序
 * 
 * AC but too slow
 * 89ms - 32.93%
 * 
 */
public class Solution {
	public String frequencySort(String s) {
		if (s == null)
			return s;
		int len = s.length();

		HashMap<Character, Integer> count = new HashMap<>();

		for (int i = 0; i < len; i++) {
			count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
		}

		/**
		 * 通过List进行排序
		 */
		List<Entry<Character, Integer>> entry = new ArrayList<Entry<Character, Integer>>(count.entrySet());
		Collections.sort(entry, (a, b) -> (b.getValue() - a.getValue()));

		StringBuffer out = new StringBuffer();
		for (Entry<Character, Integer> entrys : entry) {
			char temp=entrys.getKey();
			for (int i = 0; i < entrys.getValue(); i++)
				out.append(temp);
		}
		return out.toString();

	}

	public static void main(String[] args) {
		String test_in = "Aabb";
		Solution test = new Solution();
		System.out.println(test.frequencySort(test_in));
	}

}
