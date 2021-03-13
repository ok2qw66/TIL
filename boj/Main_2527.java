package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2527 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 4; i++) {
			String answer = "";
			st = new StringTokenizer(br.readLine(), " ");
			int[] firSq = new int[4];
			int[] secSq = new int[4];
			
			for (int j = 0; j < 4; j++) {
				firSq[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				secSq[j] = Integer.parseInt(st.nextToken());				
			}
			
			int firWidth = firSq[2] - firSq[0];
			int firHeight = firSq[3] - firSq[1];
			int secWidth = secSq[2] - secSq[0];
			int secHeight = secSq[3] - secSq[1];
			
			int distanceX = firSq[0] - secSq[0];
			int distanceY = secSq[3] - firSq[3];
					
			if(distanceX > secWidth || -distanceX > firWidth ) {
				answer = "d";
			}else if(distanceX == secWidth || -distanceX == firWidth) {
				if(distanceY > secHeight || -distanceY > firHeight) {
					answer = "d";
				}else if(distanceY == secHeight || -distanceY == firHeight) {
					answer = "c";
				}else {
					answer = "b";
				}
			}else {
				if(distanceY > secHeight || -distanceY > firHeight) {
					answer = "d";
				}else if(distanceY == secHeight || -distanceY == firHeight) {
					answer = "b";
				}else{
					answer = "a";
				}
			}
			System.out.println(answer);
			
		}
	}

}
