package fizzBuzz;

import java.util.List;

public class Solution_fast {
	// 方式三：
	public List<String> fizzBuzz(int n) {
		return new java.util.AbstractList<String>() {
			@Override
			public String get(int index) {
				index++;

				if (index % 3 == 0) {
					if (index % 5 == 0) {
						return "FizzBuzz";
					}
					return "Fizz";
				}
				if (index % 5 == 0) {
					return "Buzz";
				}
				return index + "";
			}

			@Override
			public int size() {
				return n;
			}
		};

		// 方式二： 感觉数据比较多的时候，是否会快点
//	     public List<String> fizzBuzz(int n) {

//	         List<String> list = new ArrayList<>();

//	         String strT = "Fizz";
//	         String strF = "Buzz";
//	         String strTF = "FizzBuzz";

//	         for( int i = 1;i<= n ;i ++) {
//	             list.add(i+"");
//	         }

//	         for(int i= 2; i< n;i+=3) {
//	             list.set(i,strT);
//	         }

//	         for(int i = 4;i< n;i+= 5) {
//	             if(list.get(i) == strT) {
//	               list.set(i,strTF);    
//	             }else{
//	               list.set(i,strF);    
//	             }
//	         }
//	         return list;
//	     }

		// 方式一：
		// public List<String> fizzBuzz(int n) {
		// //
		// List<String> list = new ArrayList<>();
		// for(int i = 1;i<= n ;i++) {
		// if(i % 3 == 0) {
		// if(i % 5 == 0) {
		// list.add("FizzBuzz");
		// }else{
		// list.add("Fizz");
		// }
		// }else if(i % 5 == 0){
		// list.add("Buzz");
		// }else{
		// list.add(i+"");
		// }
		// }
		// return list;
		// }
	}
}
