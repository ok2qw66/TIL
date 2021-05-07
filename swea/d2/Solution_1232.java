package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1232 {
	public static ArrayList<String[]> array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int num = Integer.parseInt(br.readLine());
			array = new ArrayList(num+1);
			String[] temp = new String[3];
			array.add(temp);
			for (int i = 0; i < num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				int cnt = 0;
				temp = new String[3];
				while(st.hasMoreTokens()) {
					temp[cnt++] = st.nextToken();					
				}
				array.add(temp);
			}
			
			int answer = (int)dfs(1);
			System.out.println("#"+testCase+" "+answer);
		}

	}
	
	public static float dfs(int target) {
		String[] calcul = array.get(target);
		float number = 0;
		float left, right;
		
		switch (calcul[0].charAt(0)) {
		case '+':
			left = dfs(Integer.parseInt(calcul[1]));
			right = dfs(Integer.parseInt(calcul[2]));
			number = left + right;
			break;
		case '-':
			left = dfs(Integer.parseInt(calcul[1]));
			right = dfs(Integer.parseInt(calcul[2]));
			number = left - right;
			break;
		case '*':
			left = dfs(Integer.parseInt(calcul[1]));
			right = dfs(Integer.parseInt(calcul[2]));
			number = left * right;
			break;
		case '/':
			left = dfs(Integer.parseInt(calcul[1]));
			right = dfs(Integer.parseInt(calcul[2]));
			number = left / right;
			break;
		default:
			number = Integer.parseInt(calcul[0]);
		}
		return number;
	}

}
