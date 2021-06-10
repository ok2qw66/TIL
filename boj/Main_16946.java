package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16946 {
		private static int N,M;
		private static int[][] map;
		private static int[][] countNumber;
		private static Queue<int[]> queue;
		private static int countIdx = 1;
		private static ArrayList<Integer> count;
		private static int[][] d = {
				{0,1}, {0,-1}, {1,0}, {-1,0}	
		};
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			countNumber = new int[N][M];
			
			queue = new LinkedList<int[]>();
			count = new ArrayList<Integer>();
			count.add(0);
			
			for (int i = 0; i < N; i++) {
				char[] row = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = row[j] - '0';
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0 && countNumber[i][j]==0) {
						findGroup(i,j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						findCount(i,j);
					}
				}
			}
			
	        for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map[i][j]);
				}
				if(i<N-1)
					sb.append("\n");
			}
			
			System.out.println(sb);
			
		}
		
		
		private static void findCount(int i, int j) {
			Set<Integer> set = new HashSet<>();
			for (int k = 0; k < 4; k++) {
				int r = i + d[k][0];
				int c = j + d[k][1];
				
				if(r<0 || r>=N || c<0 || c>=M) continue;
				int t = countNumber[r][c];
				if(map[r][c]==0 && !set.contains(t)) {
					map[i][j] += count.get(t);
					set.add(t);
				}
			}
			map[i][j] %= 10;
		}
		
		
		private static void findGroup(int i, int j) {
			queue.add(new int[] {i,j});
			int totalCnt = 1;
			countNumber[i][j] = countIdx;
			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				for (int k = 0; k < 4; k++) {
					int r = current[0] + d[k][0];
					int c = current[1] + d[k][1];
					
					if(r<0 || r>=N || c<0 || c>=M) continue;
					if(map[r][c]==0 && countNumber[r][c]==0) {
						totalCnt++;
						countNumber[r][c] = countIdx;
						queue.add(new int[] {r,c});
					}
				}
			}
			
			count.add(totalCnt);
			countIdx++;
		}

		
	}