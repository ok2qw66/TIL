package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15685 {

	static class Dragon {
		int x; //시작점 x
		int y; //시작점 y
		int d; //방향
		
		public Dragon(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
	}
	
	private static int[][] dir = {
			{0,1},{-1,0},{0,-1},{1,0}
	};
	private static boolean[][] isVisited = new boolean[101][101];
	private static ArrayList<Dragon> dragonList = new ArrayList<Dragon>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			dragonList.clear();
			isVisited[x][y] = true;
			int[] current = {x+dir[d][0], y+dir[d][1]};
			dragonList.add(new Dragon(current[0], current[1], d));
			if(current[0]>=0 && current[0]<101 && current[1]>=0 && current[1]<101)
				isVisited[current[0]][current[1]] = true;
			while(g-->0) {
				current = makeCurve(current);
			}
			
		}
		
		
		
		System.out.println(checkSquare());
	}
	
	private static int checkSquare() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(isVisited[i][j]) {
					if(isVisited[i+1][j] && isVisited[i][j+1] && isVisited[i+1][j+1])
						count++;
				}
			}
		}
		return count;
	}
	
	private static int[] makeCurve(int[] current) {
		int size = dragonList.size();
		
		while(size-->0) {
			Dragon curDragon = dragonList.get(size);
			int d = (curDragon.d+1)%4;
			current[0] += dir[d][0];
			current[1] += dir[d][1];
			if(current[0]<0 || current[0]>=101 || current[1]<0 || current[1]>=101) continue;
			isVisited[current[0]][current[1]] = true;
			dragonList.add(new Dragon(current[0], current[1], d));
		}
		
		return current;
	}

}
