package evalRPN;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * 逆波兰表达式求值
 * Integer.parseInt(str)花费时间较多
 * AC
 * 10ms - 75.83%
 * 
 */
public class Solution {
    public int evalRPN(String[] tokens) {
    	Deque<Integer> operands= new ArrayDeque<>();
        for(String str:tokens)
        {
        	if(str.length()==1 && str.charAt(0)<'0')
        	{
    			int temp2=operands.pop();
    			int temp1=operands.pop();
    			char t=str.charAt(0);
    			switch(t)
    			{
    				case '+':operands.push(temp1+temp2);break;
    				case '-':operands.push(temp1-temp2);break;
    				case '*':operands.push(temp1*temp2);break;
    				case '/':operands.push(temp1/temp2);break;
    				default:break;
    			}        		
        	}
        	else
        	{
        		operands.push(Integer.parseInt(str));//
        	}
        }
        return operands.peek();
    }
	public static void main(String[] args) {
		String[] test_in = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		Solution test = new Solution();
		System.out.println(test.evalRPN(test_in));

	}

}
