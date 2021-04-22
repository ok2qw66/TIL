package com.ssafy.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int first = Integer.parseInt(st.nextToken());
		int predict=0;
		
		if(first==1)
			predict = 1;
		else if(first==8)
			predict = -1;
		
		for (int i = 1; i < 8; i++) {
			int current = Integer.parseInt(st.nextToken());
			if(current==first+predict) {
				first = current;
			}else {
				predict = 0;
				break;
			}
		}	
		
		switch (predict) {
		case 1:
			System.out.println("ascending");
			break;
		case -1:
			System.out.println("descending");
			break;
		case 0:
			System.out.println("mixed");
			break;

		}
	}

}
