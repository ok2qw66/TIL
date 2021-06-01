package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	private static int N;
	private static int time = 0;
	private static int[][] space;
	private static int[] babyshark = new int[4];
	private static int[] fish = new int[6];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j]==9) {
					space[i][j] = 0;
					babyshark = new int[]{i,j,2,0};
				}else if(space[i][j]!=0){
					fish[space[i][j]-1]++;				
				}
			}
		}
		
		while(isPossible()) {
			int count = eatPrey();
			if(count<0) {
				break;
			}
			time += count;
			//System.out.println("count="+count+", time="+time);
			checkSharkStatus();
		}
		System.out.println(time);

	}
	
	private static void checkSharkStatus() {
		if(babyshark[3]==babyshark[2]) {
			babyshark[2]++;
			babyshark[3] = 0;
		}
//		System.out.println("checkSharkStatus = "+Arrays.toString(babyshark));
	}

	private static int eatPrey() {
		boolean[][] isVisited = new boolean[N][N];
		isVisited[babyshark[0]][babyshark[1]] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(babyshark);
		ArrayList<int[]> possibleList = new ArrayList<>();
		int count = 0;
		while(!queue.isEmpty()) {
			count++;
			int size = queue.size();
			while(size-->0) {
				int[] current = queue.poll();
				int[] dx = {0,1,0,-1};
				int[] dy = {1,0,-1,0};
				
				for (int d = 0; d < 4; d++) {
					int nx = current[0] + dx[d];
					int ny = current[1] + dy[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					if(!isVisited[nx][ny] && space[nx][ny]!=0 && space[nx][ny]< babyshark[2]) {
						isVisited[nx][ny] = true;
						possibleList.add(new int[] {nx, ny});
					}else if(!isVisited[nx][ny] && (space[nx][ny]==babyshark[2] || space[nx][ny]==0)) {
						isVisited[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
			
			if(possibleList.size()!=0) {
				Collections.sort(possibleList, new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						if(o1[0]==o2[0]) 
							return o1[1] - o2[1];
						return o1[0] - o2[0];
					}
				});
				
				int[] deletePrey = possibleList.get(0);
//				System.out.println("eatPrey = "+Arrays.toString(deletePrey));
				fish[space[deletePrey[0]][deletePrey[1]]-1]--;
				space[deletePrey[0]][deletePrey[1]] = 0;
				babyshark[0] = deletePrey[0];
				babyshark[1] = deletePrey[1];
				babyshark[3]++;
				return count;
			}
		}
		
		return -1;
	}
	
	private static boolean isPossible() {
		int prey = 0;
		int limit = Math.min(babyshark[2]-1, 6);
		for (int i = 0; i < limit; i++) {
			prey += fish[i];
		}
		
//		System.out.println("isPossible = "+prey);
		
		if(prey>0)
			return true;
		return false;
	}

}
