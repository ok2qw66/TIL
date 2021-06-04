package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058 {
	private static int I;
	private static int[][] iceBoard;
	private static boolean[][] isVisited;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] L = new int[Q];
		I = (int) Math.pow(2, N);
		iceBoard = new int[I][I];
		isVisited = new boolean[I][I];
		for (int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < I; j++) {
				iceBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < Q; i++) {
			divideSubBoard((int)Math.pow(2, L[i]));
			//print();
			decreaseIce();
		}
		int[] answer = findSumAndGroup();
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
	private static void print() {
		for (int x = 0; x < I; x++) {
			for (int y = 0; y < I; y++) {
				System.out.print(iceBoard[x][y]+" ");
			}
			System.out.println();
		}
		
	}
	///////////////q번 반복 for문 안에 실행 함수///////////////
	// subBoard 나누기
	private static void divideSubBoard(int length) {
		if(length==1) return;
		int[][] clone = cloneBoard();
		for (int i = 0; i < I; i+=length) {
			for (int j = 0; j < I; j+=length) {
				for (int k = 0; k < length; k++) {
					for (int l = 0; l < length; l++) {
						iceBoard[i+l][j+length-1-k] = clone[i+k][j+l];
					}
				}
			}
		}
	}
	//얼음이 있는칸 3칸과 인접x -> 얼음-1
	private static void decreaseIce() {
		int[][] clone = cloneBoard();
		for (int x = 0; x < I; x++) {
			for (int y = 0; y < I; y++) {
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if(nx<0 || nx>=I || ny<0 || ny>=I) continue;
					if(clone[nx][ny]>0) count++;
				}
				if(count<3) iceBoard[x][y]--;
			}
		}
	}
	// iceBoard 복사
	private static int[][] cloneBoard() {
		int[][] clone = new int[I][I];
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < I; j++) {
				clone[i][j] = iceBoard[i][j];
			}
		}
		return clone;
	}
	
	///////////////answer 만들기 함수///////////////
	// 한 그룹에 몇개의 ice가 있는지 체크
	private static int[] findGroup(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		isVisited[i][j] = true;
		int sum = iceBoard[i][j];
		int count = 1;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = current[0] + dx[k];
				int ny = current[1] + dy[k];
				
				if(nx<0 || nx>=I || ny<0 || ny>=I) continue;
				if(iceBoard[nx][ny]>0 && !isVisited[nx][ny]) {
					sum += iceBoard[nx][ny];
					count++;
					isVisited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		return new int[] {sum, count};
	}
	// ice의 합, 가장큰 그룹의 개수 리턴
	private static int[] findSumAndGroup() {
		int sum = 0;
		int groupCnt = 0;
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < I; j++) {
				if(iceBoard[i][j]>0 && !isVisited[i][j]) {
					int[] sc = findGroup(i,j);
					sum += sc[0];
					groupCnt = Math.max(groupCnt, sc[1]);
				}
			}
		}
		return new int[] {sum, groupCnt};
	}
	
}
