package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] order = new int[6][2];
		int[] arrow = new int[5]; //1:->, 2:<- , 3: 👇, 4:☝☝
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			order[i][0] = direction;
			order[i][1] = length;
			arrow[direction]++;
		}
		int findVal = 0;
		if(arrow[1]+arrow[4]==2) {
			findVal = 1;
		}else if(arrow[2]+arrow[3]==2){
			findVal = 2;
		}else if(arrow[3]+arrow[1]==2) {
			findVal = 3;
		}else if(arrow[4]+arrow[2]==2) {
			findVal = 4;
		}
		int answer = 0;
		for (int i = 0; i < 6; i++) {
			if(order[i][0]==findVal) {
				answer = order[i][1]*order[(i+1)%6][1] - order[(i+3)%6][1]*order[(i+4)%6][1];
			}
		}
		System.out.println(answer*N);

	}

}
