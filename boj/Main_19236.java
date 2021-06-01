package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19236 {
	private static int fishMax = 0;
	private static int answer = 0;
	private static int[] sharkLoc = new int[3];
	private static int[][] fishLoc = new int[17][3];
	private static int[][] d = {
			{-1,0},
			{-1,-1},
			{0,-1},
			{1,-1},
			{1,0},
			{1,1},
			{0,1},
			{-1,1}
	};
	private static int[][] space;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		space = new int[4][4];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int fishNum = Integer.parseInt(st.nextToken());
				if(i==0 && j==0) {
					// 상어 0,0위치에 놓기
					sharkLoc[2] = Integer.parseInt(st.nextToken())-1;
					fishMax += fishNum;
					fishLoc[fishNum][0] = -1; // 물고기없음
					continue;
				}
				space[i][j] = fishNum;
				fishLoc[fishNum][0] = i;
				fishLoc[fishNum][1] = j;
				fishLoc[fishNum][2] = Integer.parseInt(st.nextToken())-1;
			}
		}
		
		move();
		System.out.println(answer);
		
	}
	private static void move() {
		int[][] clone = new int[4][4];
		int[][] cloneFish = new int[17][3];
		answer = Math.max(fishMax, answer);
		//System.out.println("fishMax = "+fishMax+", answer = "+answer);
		moveFish();
		cloneSpace(clone, cloneFish);
		moveShark(clone, cloneFish);
	}
	private static void cloneSpace(int[][] clone, int[][] cloneFish) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				clone[i][j] = space[i][j];
			}
		}
		
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 3; j++) {
				cloneFish[i][j] = fishLoc[i][j];
			}
		}
	}
	private static void moveShark(int[][] clone, int[][] cloneFish) {
		int[] tempShark = sharkLoc.clone();
		for (int i = 1; i <= 3; i++) {
			int nx = sharkLoc[0]+ d[sharkLoc[2]][0]*i;
			int ny = sharkLoc[1]+ d[sharkLoc[2]][1]*i;
			
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			if(space[nx][ny]==0) continue;
			int prayFish = space[nx][ny];
			fishLoc[prayFish][0] = -1;
			fishMax += prayFish;
			sharkLoc[0] = nx;
			sharkLoc[1] = ny;
			sharkLoc[2] = fishLoc[prayFish][2];
			space[nx][ny] = 0;
			
			move();
			fishLoc[prayFish][0] = nx;
			fishMax -= prayFish;
			fishLoc[prayFish][1] = ny;
			sharkLoc = tempShark.clone();
			reverseSpace(clone, cloneFish);
		}
		
	}
	private static void reverseSpace(int[][] clone, int[][] cloneFish) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				space[i][j] = clone[i][j];
			}
		}
		
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 3; j++) {
				fishLoc[i][j] = cloneFish[i][j];
			}
		}
		
	}
	private static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			if(fishLoc[i][0]==-1) continue;
			searchSwitchSpace(fishLoc[i]);
		}
		
	}
	
	private static void searchSwitchSpace(int[] fish) {
		int x = fish[0];
		int y = fish[1]; 
		
		for (int i = 0; i < 8; i++) {
			int dir = (fish[2]+i)%8;
			int nx = fish[0]+ d[dir][0];
			int ny = fish[1]+ d[dir][1];
			
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			if(nx==sharkLoc[0] && ny==sharkLoc[1]) continue;
			int switchFish = space[nx][ny];
			int targetFish = space[fish[0]][fish[1]];
			
			fishLoc[switchFish][0] = x;
			fishLoc[targetFish][0] = nx;
			fishLoc[switchFish][1] = y;
			fishLoc[targetFish][1] = ny;
			int temp = fishLoc[switchFish][2];
			fishLoc[targetFish][2] = dir;
			space[nx][ny] = targetFish;
			space[x][y] = switchFish;	
			
			//System.out.println(space[x][y]+": "+Arrays.toString(fishLoc[space[x][y]]));
			//System.out.println(space[nx][ny]+": "+Arrays.toString(fishLoc[space[nx][ny]]));
			
			return;
			
		}
		
	}

}
