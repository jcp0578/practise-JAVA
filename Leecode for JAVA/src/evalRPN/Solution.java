package evalRPN;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 逆波兰表达式求值
 * AC but too slow
 * 49ms - 7.75%
 * 
 */
public class Solution {
    public int evalRPN(String[] tokens) {
    	Deque<Integer> operands = new ArrayDeque<>();
        for(String str:tokens)
        {
        	str=str.trim();
        	try {
        		operands.push(Integer.valueOf(str));
        	}
        	catch(NumberFormatException e)
        	{
    			int temp2=operands.pop();
    			int temp1=operands.pop();
    			switch(str)
    			{
    				case "+":operands.push(temp1+temp2);break;
    				case "-":operands.push(temp1-temp2);break;
    				case "*":operands.push(temp1*temp2);break;
    				case "/":operands.push(temp1/temp2);break;
    				default:break;
    			}        		
        	}
        }
        return operands.peek();
    }
	public static void main(String[] args) {
		String[] test_in = {"10", "6", " 9     ", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		Solution test = new Solution();
		System.out.println(test.evalRPN(test_in));

	}

}
