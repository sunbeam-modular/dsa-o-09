package com.sunbeam;

import java.util.Stack;

public class ExpressionEvaluationMain {
	
	public static int calculate(int op1, char opr, int op2) {
		switch(opr) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '*': return op1 * op2;
		case '/': return op1 / op2;
		case '%': return op1 % op2;
		case '$': return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluate(String postfix) {
		//1. create stack to push operands of expression
		Stack<Integer> st = new Stack<Integer>();
		//2. check expression from left to right
		for(int i = 0 ; i < postfix.length() ; i++) {
			//3. extract element of ith index
			char ele = postfix.charAt(i);
			//4. check if element is operand
			if(Character.isDigit(ele))
				st.push(ele - '0');		// to convert ASCII value into integer
			//5. check if element is operator
			else {
				//6. pop two operands from stack
				int op2 = st.pop();	//first poped - > second operand
				int op1 = st.pop();	//second poped -> first operand
				//7. perform operation of op1 and op2
				int result = calculate(op1, ele, op2);
				//8. push result of operation on stack
				st.push(result);
			}
		}
		//9. pop result from stack and return it 
		return st.pop();
	}
	
	public static int prefixEvaluate(String prefix) {
		//1. create stack to push operands of expression
		Stack<Integer> st = new Stack<Integer>();
		//2. check expression from right to left
		for(int i = prefix.length()-1 ; i >= 0 ; i--) {
			//3. extract element of ith index
			char ele = prefix.charAt(i);
			//4. check if element is operand
			if(Character.isDigit(ele))
				st.push(ele - '0');		// to convert ASCII value into integer
			//5. check if element is operator
			else {
				//6. pop two operands from stack
				int op1 = st.pop();	//first poped -> first operand
				int op2 = st.pop();	//second poped - > second operand
				//7. perform operation of op1 and op2
				int result = calculate(op1, ele, op2);
				//8. push result of operation on stack
				st.push(result);
			}
		}
		//9. pop result from stack and return it 
		return st.pop();
	}

	public static void main(String[] args) {
		String postfix = "456*3/+9+7-";

		System.out.println("Postfix : " + postfix);
		int result = postfixEvaluate(postfix);
		System.out.println("Result : " + result);
		
		String prefix = "-++4/*56397";
		
		System.out.println("Prefix : " + prefix);
		result = prefixEvaluate(prefix);
		System.out.println("Result : " + result);
	}

}
