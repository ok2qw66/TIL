package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14503 {
	private static int cleanRoomCnt = 0, N,M;
	private static boolean isContinue = true;
	private static int[] robotCleaner;
	private static int[][] cleanArea;
	private static boolean[][] isCleaned;
	private static int[][] d = {
			{-1,0},{0,1},{1,0},{0,-1}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		robotCleaner = new int[] 
				{Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken())};
		cleanArea = new int[N][M];
		isCleaned = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				cleanArea[i][j] = temp;
				if(temp==1)
					isCleaned[i][j] = true;
			}
		}
		
		startClean();
		
		System.out.println(cleanRoomCnt);
	}
	
	private static void startClean() {
		if(!isCleaned[robotCleaner[0]][robotCleaner[1]]) {
			isCleaned[robotCleaner[0]][robotCleaner[1]] = true;
			cleanRoomCnt++;
		}
		
		for (int i = 1; i <= 4; i++) {
			robotCleaner[2] = (robotCleaner[2]+3)%4;
			int nx = robotCleaner[0] + d[robotCleaner[2]][0];
			int ny = robotCleaner[1] + d[robotCleaner[2]][1];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(!isCleaned[nx][ny]) {
				robotCleaner[0] = nx;
				robotCleaner[1] = ny; 
				startClean();
				return;
			}
		}
		int nx = robotCleaner[0] - d[robotCleaner[2]][0];
		int ny = robotCleaner[1] - d[robotCleaner[2]][1];
		if(cleanArea[nx][ny]!=1) {
			robotCleaner[0] = nx;
			robotCleaner[1] = ny; 
			startClean();
		}
	}

}
