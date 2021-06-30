package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610 {
	private static int[][] drc = {
			{0,-1}, {-1,-1}, {-1,0}, {-1,1},
			{0,1}, {1,1}, {1,0}, {1,-1}
	};
	private static ArrayList<int[]> cloud = new ArrayList<int[]>();
	private static Queue<int[]> waterCopyQ = new LinkedList<int[]>();
	private static int N;
	private static int[][] map;
	private static boolean[][] isExistCloud;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int[][] moveDS = new int[M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			moveDS[i][0] = Integer.parseInt(st.nextToken())-1;
			moveDS[i][1] = Integer.parseInt(st.nextToken());
		}
		
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		
		for (int i = 0; i < M; i++) {
			moveCloud(moveDS[i][0], moveDS[i][1]);
			waterCopy();
			createCloud();
			//print();
		}
		
		System.out.println(sumWater());
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==============");
	}

	private static int sumWater() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	private static void createCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>=2 && !isExistCloud[i][j]) {
					map[i][j] -= 2;
					cloud.add(new int[] {i,j});
				}
			}
		}
	}

	private static void waterCopy() {
		while(!waterCopyQ.isEmpty()) {
			int[] current = waterCopyQ.poll();
			int count = 0;
			for (int i = 1; i < 8; i+=2) {
				int nr = current[0] + drc[i][0];
				int nc = current[1] + drc[i][1];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(map[nr][nc]!=0) count++;
			}
			map[current[0]][current[1]] += count;
		}
	}

	private static void moveCloud(int d, int s) {
		isExistCloud = new boolean[N][N];
		for (int[] is : cloud) {
			int nr = (is[0] + drc[d][0]*s + 30*N)%N;
			int nc = (is[1] + drc[d][1]*s + 30*N)%N;
			waterCopyQ.add(new int[] {nr,nc});
			map[nr][nc]++;
			isExistCloud[nr][nc] = true;
			
		}
		cloud.clear();
	}

}
