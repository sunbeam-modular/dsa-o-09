package com.sunbeam;

import java.util.Stack;

public class ParenthesisBalancingMain {
	
	public static boolean isParenthesisBalanced(String expression) {
		String opening = "([{";
		String closing = ")]}";
		//1. create stack to push opening parenthesis
		Stack<Character> st = new Stack<Character>();
		//2. traverse expression from start to end
		for(int i = 0 ; i < expression.length() ; i++) {
			//3. extract character of ith indexx from expression
			char ele = expression.charAt(i);
			//4. if element is opening parenthesis then push it on stack
			if(opening.indexOf(ele) != -1)
				st.push(ele);
			//5. if element is closing parenthesis then check it with topmost element of stack
			else {
				int closingIndex = closing.indexOf(ele);
				if(closingIndex != -1) {
					if(st.isEmpty())
						return false;
					char open = st.pop();
					int openingIndex = opening.indexOf(open);
					if(openingIndex != closingIndex)
						return false;
				}
			}
		}
		if(!st.isEmpty())
			return false;
		//6. parenthesis are balanced
		return true;		
	}

	public static void main(String[] args) {
		
		String expression = "5+([9-4]*8-{6/2}))";
		
		boolean result = isParenthesisBalanced(expression);
		if(result)
			System.out.println("Parenthesis are balanced");
		else
			System.out.println("Parenthesis are not balanced");

	}

}
