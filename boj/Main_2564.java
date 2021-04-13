package com.ssafy.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2564_2 {

	private static int[][] location;
	private static int[] minDistance;
	private static int M,N,T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); //가로 크기
		N = Integer.parseInt(st.nextToken()); //세로 크기
		
		
		T = Integer.parseInt(br.readLine());
		int direct,distance;
		minDistance = new int[T];
		//Arrays.fill(minDistance, Integer.MAX_VALUE);
		location = new int[T][2];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			direct = Integer.parseInt(st.nextToken())-1;
			distance = Integer.parseInt(st.nextToken());
			location[i][0] = direct;
			location[i][1] = distance;
		}
	
		//동근이의 위치
		st = new StringTokenizer(br.readLine(), " ");
		direct = Integer.parseInt(st.nextToken())-1;
		distance = Integer.parseInt(st.nextToken());
		
		findTravel(direct,distance);
		int answer = 0;
		for (int temp : minDistance) {
			answer += temp;
		}
		System.out.println(answer);
	}

	/** 동근이 위치에서 가능한 상점체크하기 : 시계방향*/
	private static void findTravel(int direct, int distance) {
		for (int i = 0; i < T; i++) {
			int[] current = location[i];
			
			if(current[0]==direct) { //같은 뱡향
				minDistance[i] = Math.abs(current[1]-distance);
			}else if(current[0]+direct==2) { // 북서
				minDistance[i] = current[1]+distance;
			}else if(current[0]+direct==4) { // 남동
				minDistance[i] = M+N-(current[1]+distance);
			}else if(current[0]+direct==3) { //direct합이 짝수 3이면 한번만 방향 꺾음
				switch (current[0]) {
				case 0:
					minDistance[i] = M-current[1] + distance; 
					break;
				case 1:
					minDistance[i] = current[1] + N - distance;
					break;
				case 2:
					minDistance[i] = N-current[1] + distance;
					break;
				case 3:
					minDistance[i] = current[1] + M - distance;
					break;
				}
			}else if(current[0]+direct==1) { //북남
				minDistance[i] = Math.min(distance+current[1], 2*M-(distance+current[1]))+N;
			}else { //서동
				minDistance[i] = Math.min(distance+current[1], 2*N-(distance+current[1]))+M;
			}
		}
	}

}
