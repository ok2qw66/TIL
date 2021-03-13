package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_3190 {

	private static Stack<int[]> snake;
	private static String[][] moveList;
	private static int[][] board;
	private static int[] dx= {0,1,0,-1};
	private static int[] dy= {1,0,-1,0};
	private static int N;
	private static int cnt=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		int apple = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < apple; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			board[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
		}
		
		int move = Integer.parseInt(br.readLine());
		moveList = new String[move][move];
		
		snake = new Stack();
		snake.add(new int[]{0,0});
		
		for (int i = 0; i < move; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			moveList[i][0] = st.nextToken();
			moveList[i][1] = st.nextToken();
		}
		board[0][0] = -1;
		snakeMove();
		System.out.println(cnt);
	}

	private static void snakeMove() {
		int direction = 0;
		int moveIdx = 0;
		int[] head,tail;
		
		while(true) {
			cnt++;
			
			head = snake.firstElement();
			tail = snake.peek();
			int x = head[0]+dx[direction];
			int y = head[1]+dy[direction];
			
			if(x<0 || x>=N || y<0 || y>=N || board[x][y]== -1) {
				return;
			}else {
				if(board[x][y]!= 1) {
					snake.pop();
					board[tail[0]][tail[1]] = 0;
				}
				snake.add(0,new int[] {x,y});
				board[x][y] = -1;
			}
			
			if(moveIdx<moveList.length && cnt == Integer.parseInt(moveList[moveIdx][0])) {
				String d = moveList[moveIdx][1];
				if(d.equals("D")) {
					direction = (direction+1)%4;
				}else {
					direction = direction-1 <0? direction-1+4 : (direction-1)%4;					
				}
				moveIdx++;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println(direction+ " "+ moveIdx+" cnt:"+cnt);
		}
		
	}

}
