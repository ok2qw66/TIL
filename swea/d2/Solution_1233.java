package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1; testCase <= 10; testCase++) {
			int NUM = Integer.parseInt(br.readLine());
			String[] tree = new String[NUM+1];
			boolean[] check = new boolean[NUM+1];
			
			for (int i = 0; i < NUM; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int index = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				tree[index] = data;
			}
			int answer = dfs(1,tree,check);
			System.out.println("#"+testCase+" "+answer);
		}

	}

	private static int dfs(int target, String[] tree, boolean[] check) {
		String test = tree[target];
		// System.out.println("target="+target+" test="+test);
		int answer = 0;
		check[target] = true;
		
		if(target*2 <= tree.length -1) { // 리프노드가 아닌경우
			if(test.equals("-") || test.equals("+") || test.equals("/") || test.equals("*")) {
				int temp = dfs(target*2, tree, check);
				int temp2 = dfs(target*2+1, tree, check);
				answer = Math.min(temp, temp2);
			}else {
				return 0;
			}
		}else if(!test.equals("-") && !test.equals("+") & !test.equals("/") && !test.equals("*")) {// 리프노드인 경우
			answer = 1;
		}
		return answer;
	}

}
