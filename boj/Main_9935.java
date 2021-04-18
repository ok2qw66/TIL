package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935 {

	private static char[] test;
	private static String bomb;
	private static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		test = br.readLine().toCharArray();
		bomb = br.readLine();
		
		stack = new Stack<Character>();
		int len = test.length;
		int last = bomb.charAt(bomb.length()-1);
		for (int i = 0; i < len;i++) {
			//System.out.println(stack.toString());
			stack.add(test[i]);
			if(test[i]==last) {
				isBomb(i);
				//System.out.println("isBomb!");
			}
		}
		System.out.println(makeAnswer());
	}

	private static String makeAnswer() {
		if(stack.size()==0) return "FRULA";
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}

	private static void isBomb(int i) {
		String substr = "";
		int bIdx=bomb.length()-1;
		for (; stack.size()!=0 && bIdx >=0 ; bIdx--) {
			char current = stack.pop();
			substr += current;
			if(current!=bomb.charAt(bIdx)) {
				break;
			}
		}
		if(bIdx>=0) {
			//System.out.println(substr+ "  .>>> "+stack.toString());
			for (int j = substr.length()-1; j>=0; j--) {
				stack.add(substr.charAt(j));
			}
		}
	}

}
