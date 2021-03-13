package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205 {

	private static String answer;
	private static int[][] beerList;
	private static boolean[] beerVisit;
	private static int fesX, fesY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			answer = "sad";
			beerList = new int[N+2][2];
			beerVisit = new boolean[N+2];
			beerVisit[0] = true;
			fesX = 0; fesY = 0;
			
			for (int j = 0; j < N+2; j++) {
				st = new StringTokenizer(br.readLine()," ");
				
				fesX = Integer.parseInt(st.nextToken());
				fesY = Integer.parseInt(st.nextToken());
	
				beerList[j][0] = fesX;
				beerList[j][1] = fesY;
			}
			
			beerTour(beerList[0][0],beerList[0][1]);
			
			System.out.println(answer);
		}
	}

	private static void beerTour(int currX, int currY) {
		if(Math.abs(fesX - currX) + Math.abs(fesY - currY) <= 1000) {
			answer = "happy";
			return;
		}
		
		for (int j = 0; j < beerList.length && answer.equals("sad"); j++) {
			if(!beerVisit[j] && Math.abs(beerList[j][0] - currX) + Math.abs(beerList[j][1] - currY)<=1000) {
				beerVisit[j] = true;
				beerTour( beerList[j][0], beerList[j][1]);
			}
		}
		
	}

}
