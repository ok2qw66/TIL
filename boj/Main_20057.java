package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057 {

	private static int[][] board;
	private static int[] dx= {0,1,0,-1};
	private static int[] dy= {-1,0,1,0};
	
	private static double[] sandPercent = {0.05, 0.1, 0.1, 0.02, 0.02, 0.07, 0.07, 0.01, 0.01};
	private static int[][] sandMoveRight = {{0,3},{-1,2},{1,2},{-2,1},{2,1},{-1,1},{1,1},{1,0},{-1,0}};
	private static int[][] sandMoveDown = {{3,0},{2,-1},{2,1},{1,-2},{1,2},{1,-1},{1,1},{0,1},{0,-1}};
	
	private static int N;
	private static int answer=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(N/2,N/2);
		System.out.println("answer="+answer);
	}
	
	private static void move(int x, int y) {
		int[] next = new int[] {x,y};
		
		for (int i = 0,cnt=0; ; i=(++i)%4) {
			if(i%2==0)	cnt++;
			for (int j = cnt; j >0; j--) {
				if(next[0]>0||next[1]>0)
					next = moveSand(next[0],next[1],i);	
					
				if(next[0]==0 && next[1]==0)
					return;
			}		
		}
		
	}
	

	private static int[] moveSand(int x, int y, int direction) {
		int nX = x+dx[direction];
		int nY = y+dy[direction];
		int sand=0;
		int alpha=0;
		int temp;
		int tx,ty;
		
		System.out.println(x+","+y+"-> "+nX+", "+nY+" d="+direction+", answer = "+answer);
		
//		if(nX==0 && nY==0)
//			return new int[] {nX, nY};
//		
		sand = board[nX][nY];
		board[nX][nY] = 0;
		
		if(direction%2==0) {
			for (int i = 0; i < sandPercent.length; i++) {
				
				if(direction==0) {
					tx = x-sandMoveRight[i][0];
					ty = y-sandMoveRight[i][1];
				}else {
					tx = x+sandMoveRight[i][0];
					ty = y+sandMoveRight[i][1];
				}
				
				System.out.println("1>> "+tx+" "+ty);
	 			if( tx <0 || tx >= N || ty <0 || ty >= N ) {
	 				temp = (int) (sand * sandPercent[i]);
	 				answer += temp;
	 				alpha += temp;
	 			}
	 			else {
	 				temp = (int) (sand * sandPercent[i]);			
	 				board[tx][ty] += temp;
	 				alpha += temp;
	 			}
			}
		}else {
			for (int i = 0; i < sandPercent.length; i++) {
				
				if(direction==1) {
					tx = x+sandMoveDown[i][0];
					ty = y+sandMoveDown[i][1];
				}else {
					tx = x-sandMoveDown[i][0];
					ty = y-sandMoveDown[i][1];
				}
				
				System.out.println("2>> "+tx+" "+ty);
				if( tx <0 || tx >= N || ty <0 || ty >= N ) {
	 				temp = (int) (sand * sandPercent[i]);
	 				answer += temp;
	 				alpha += temp;
	 			}
	 			else {
	 				temp = (int) (sand * sandPercent[i]);			
	 				board[tx][ty] += temp;
	 				alpha += temp;
	 			}
			}
		}
		
		System.out.println(">>>>>>>>>>>>>> result : "+answer+" "+sand+" "+alpha);
		
		if( nX+dx[direction] <0 || nX+dx[direction] >= N || nY+dy[direction] <0 || nY+dy[direction] >= N )
			answer+= sand - alpha;
		else
			board[nX+dx[direction]][nY+dy[direction]] += sand - alpha;
 		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
		return new int[]{nX,nY};
	}

}
