package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13460 {
	static String[][] board;
	static String[][] tempList;
	static boolean[][][][] visited;
	static int N, M, count;
	static ArrayList<String[][]> queue = new ArrayList<>();
	static ArrayList<Integer> queueCount = new ArrayList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new String[N][M];
		visited = new boolean[N][M][N][M];
		int bx=0,by=0,rx=0,ry=0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				String val = String.valueOf(s.charAt(j));
				board[i][j] = val;
				if(val.equals("R"))	
					rx = i;ry = j;
				if(val.equals("B"))	
					bx = i;by = j;
			}
		}
		visited[bx][by][rx][ry] = true;
		verify();
	}
	
	private static void verify() {
		queue.add(board);
		queueCount.add(1);
		
		while(!queueCount.isEmpty()) {
			tempList = queue.get(0);
			queue.remove(0);
			count = queueCount.get(0);
			queueCount.remove(0);
			
			for (int i = 0; i < 4; i++) {
				int temp = move(i);
				if(temp > 0) {
					System.out.println(temp);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	private static int move(int order) {
		String[][] copy = new String[N][M];
		int[] blue = new int[2];
		int[] red = new int[2];
		int[] hole = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = tempList[i][j];
				if(tempList[i][j].equals("B")) {
					blue[0] = i;blue[1] = j;
				}
				else if(tempList[i][j].equals("R")) {
					red[0] = i;red[1] = j;
				}
				else if(tempList[i][j].equals("O")) {
					hole[0] = i;hole[1] = j;
				}
			}
		}
		
		boolean frontRed = false;
		int i = blue[0]+dx[order],j=blue[1]+dy[order];
		for (;i>0 && i<N-1 && j>0 && j<M-1 ; i+=dx[order],j+=dy[order]) {
			String check = copy[i][j];
			if(check.equals("#")) {
				break;
			}
			else if(check.equals("R")) {
				frontRed = true;
			}else if(check.equals("O")) {
				return -1;
			}
		}
		copy[blue[0]][blue[1]] = ".";
		if(frontRed) {
			i -= dx[order]*2;
			j -= dy[order]*2;
			copy[i][j] = "B";
		}
		else {
			i -= dx[order];
			j -= dy[order];
			copy[i][j] = "B";
		}
		
		int ii = red[0]+dx[order],jj=red[1]+dy[order];
		for (;ii>0 && ii<N-1 && jj>0 && jj<M-1; ii+=dx[order],jj+=dy[order]) {
			String check = copy[ii][jj];
			if(check.equals("#") || (check.equals("B") & !frontRed)) {
				break;
			}else if(check.equals("O")) {
				return count;
			}
		}
		copy[red[0]][red[1]] = ".";
		ii = ii-dx[order];jj = jj-dy[order];
		copy[ii][jj] = "R";
		copy[i][j] = "B";
		
		if(count <10 && !visited[i][j][ii][jj]) {
			visited[i][j][ii][jj] = true;
			queue.add(copy);
			queueCount.add(count+1);
		}
		
		return 0;
		
	}

}
