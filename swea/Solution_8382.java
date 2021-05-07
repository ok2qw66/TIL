package com.ssafy.subclass.preview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Solution_8382 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int answer;
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			int diffX = Math.abs(sx - ex);
			int diffY = Math.abs(sy - ey);
			
			if(Math.abs(diffX - diffY) == 0) {
				answer = diffX + diffY;
			}else {
				int diff = Math.abs(diffY - diffX);
				answer = Math.min(diffY, diffX)*2;
				if(diff%2 == 1) {
					answer += diff*2 - 1;
				}else {
					answer += diff*2;
				}
			}
			String line = "#"+testCase+" "+answer;
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
