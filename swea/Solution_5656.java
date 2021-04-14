package com.ssafy.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기_안예진 {

	private static int[][] board;
	private static int N,H,W;
	private static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			answer = W*H; //남는 블럭 수
			board = new int[H][W]; //블럭 입력 상태
			int[] topList = new int[W+1]; //맨위에 행번호 입력 리스트 & 마지막값:총블럭수
			Arrays.fill(topList, -1);
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]!=0) {
						topList[W]++; //블럭수+1
						if(topList[j]==-1) { //맨위에 행번호 세팅
							topList[j]=i; 
						}
					}
					
				}
			}
			dfs(0, board, topList); //수행횟수, 현보드상태, 맨위값리스트
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	private static int[][] clone;
	private static void dfs(int number, int[][] temp, int[] topList) {
		// topList에서 하나씩 선택
		// 선택값에 따라 없어질 값들 queue에 넣기
		// queue에 있는 값들 따라 없어질값들 넣기(0으로 만들기, queue에 r,c,val 넣기)
		// 남은 벽돌 밑으로 내리기
		
		if(number==N || topList[W]==0) {
			answer = Math.min(answer, topList[W]);
			return;
		}
		
		for (int i = 0; i < W; i++) { // topList에서 하나씩 선택
			int loc = topList[i]; //i번째 열에서 제일 첫번째 행번호
			if(loc>=H || loc<0) continue; //H이상 0미만이면 패스
			clone = new int[H][W];
			for (int j = 0; j < H; j++) { //temp 복사
				for (int k = 0; k < W; k++) {
					clone[j][k] = temp[j][k];
				}
			}
	
			int[] tempTopList = goBreak(i,loc); // col,row값으로 벽돌없애기
			dfs(number+1, clone, tempTopList);
			
		}
	}
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	
	private static int[] goBreak(int col, int row) {
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {row,col,clone[row][col]}); //현위치, 없앨수있는범위
		clone[row][col] = 0;
		visited[row][col] = true;
		while(!queue.isEmpty()) {
			int[] pick = queue.poll();
			for (int dir = 0; dir <4; dir++) {  //방향
				int t =0;
				while(++t<pick[2]) { //가능한 범위까지 queue에 넣기
					int nr = pick[0]+t*dx[dir];
					int nc = pick[1]+t*dy[dir];
					if(nr<0 || nr>=H || nc<0 || nc>=W) break;
					if(!visited[nr][nc] && clone[nr][nc]>0) {
						queue.add(new int[] {nr,nc,clone[nr][nc]});
						visited[nr][nc] = true;
						clone[nr][nc] = 0;
					}
				}
			}
		}
		return goArrange(); //남은 벽돌 밑으로 내리기
	}
	

	private static int[] goArrange() {
		int[] tempTopList = new int[W+1];
		int count = 0;
		for (int j = 0; j < W; j++) {
			int row = H-1;
			for (int i = H-1; i >=0; i--) {
				if(clone[i][j]!=0) {
					count++;
					if(row!=i) {
						clone[row][j] = clone[i][j];
						clone[i][j] = 0;
					}
					row--;
				}
			}
			tempTopList[j] = row+1;
		}
		
		tempTopList[W] = count;
		return tempTopList;
	}

}
