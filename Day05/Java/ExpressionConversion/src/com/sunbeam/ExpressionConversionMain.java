package com.sunbeam;

import java.util.Stack;

public class ExpressionConversionMain {
	
	public static int priority(char opr) {
		switch(opr) {
		case '$': return 10;
		case '*': return 9;
		case '/': return 9;
		case '%': return 9;
		case '+': return 8;
		case '-': return 8;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		//1. create stack to push operators
		Stack<Character> st = new Stack<Character>();
		//1. create empty string to store postfix expression
		StringBuilder postfix = new StringBuilder();
		//2. check infiix expression from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			//3. extract element of ith index
			char ele = infix.charAt(i);
			//4. check if element is operand
			if(Character.isDigit(ele))
				postfix.append(ele);
			//5. check if element is '('
			else if(ele == '(')
				st.push(ele);
			//6. check if element is ')'
			else if(ele == ')') {
				while((st.peek()) != '(') {
					postfix.append(st.pop());
				}
				st.pop(); // to discard  '(' 
			}
			//7. check if element is operator
			else {
				//7.1 check priority of topmost element with current element
				while(!st.isEmpty() && priority(st.peek()) >= priority(ele)) {
					// pop operator from stack and append into postfix expression
					postfix.append(st.pop());
				}
				//7.2 push current operator on stack
				st.push(ele);
			}
		}
		//8. pop remaining operators of stack and append into postfix
		while(!st.isEmpty()) {
			postfix.append(st.pop());
		}
		//9. return postfix expression
		return postfix.toString();
	}
	
	public static String infixToPrefix(String infix) {
		//1. create stack to push operators
		Stack<Character> st = new Stack<Character>();
		//1. create empty string to store prefix expression
		StringBuilder prefix = new StringBuilder();
		//2. check infiix expression from right to left
		for(int i = infix.length() -1 ; i >= 0 ; i--) {
			//3. extract element of ith index
			char ele = infix.charAt(i);
			//4. check if element is operand
			if(Character.isDigit(ele))
				prefix.append(ele);
			//5. check if element is ')'
			else if(ele == ')')
				st.push(ele);
			//6. check if element is '('
			else if(ele == '(') {
				while((st.peek()) != ')') {
					prefix.append(st.pop());
				}
				st.pop(); // to discard  '(' 
			}
			//7. check if element is operator
			else {
				//7.1 check priority of topmost element with current element
				while(!st.isEmpty() && priority(st.peek()) > priority(ele)) {
					// pop operator from stack and append into prefix expression
					prefix.append(st.pop());
				}
				//7.2 push current operator on stack
				st.push(ele);
			}
		}
		//8. pop remaining operators of stack and append into postfix
		while(!st.isEmpty()) {
			prefix.append(st.pop());
		}
		//9. reverse prefix expression
		prefix.reverse();
		//10. return postfix expression
		return prefix.toString();
	}
	
	
	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		System.out.println("Infix : " + infix);
		
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix : " + prefix);

	}

}














