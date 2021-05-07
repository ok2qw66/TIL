package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_1961 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NUM = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= NUM; testCase++) {
			int cnt = Integer.parseInt(br.readLine());
			int[][] matrix = new int[cnt][cnt];
			String[][] answer = new String[cnt][3];
			
			for (int i = 0; i < matrix.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().concat(" "));
				int index = 0;
				String third = "";
				while(st.hasMoreTokens()) {
					String temp = st.nextToken();
					matrix[i][index] = Integer.parseInt(temp);
					
					// first
					answer[index][0] = temp + answer[index][0];
					// second
					answer[cnt-index -1][2] += temp;
					//third
					third = temp + third;
					index++;
					
				}
				//third
				answer[cnt-i -1][1] = third;
			}
			System.out.println("#"+testCase);
			StringBuilder sb = new StringBuilder();
			for (String[] strings : answer) {
				for (String strings2 : strings) {
					strings2 = strings2.replace("null", " ");
					sb.append(strings2);
				}
				sb.append("\n");
			}
			System.out.print(sb);
						
		}

	}

}
