package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406 {
	private static String line;
	private static int N;
	private static int M;
	private static Stack<Character> stack,temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		line = br.readLine();
		N = line.length();
		M = Integer.parseInt(br.readLine());		
		
		stack = new Stack<Character>();
		temp = new Stack<Character>();
		for (int i = 0; i < line.length(); i++) {
			stack.add(line.charAt(i));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String action = st.nextToken();
			
			switch (action) {
			case "P":
				stack.add(st.nextToken().charAt(0));
				break;
			case "L":
				if(stack.size()!=0)
					temp.add(stack.pop());
				break;
			case "D":
				if(temp.size()!=0)
					stack.add(temp.pop());
				break;
			case "B":
				if(stack.size()!=0)
					stack.pop();
				break;
			}
		}
		
		answer();
	}
	
	private static void answer() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(stack.size()!=0) {
			sb.append(String.valueOf(stack.pop()));
		}
		
		while(temp.size()!=0) {
			sb2.append(String.valueOf(temp.pop()));
		}
		
		System.out.print(sb.reverse());
		System.out.println(sb2);
	}

}
