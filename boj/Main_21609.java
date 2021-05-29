package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_21609 {

	private static int N,M;
	private static int answer = 0;
	private static BigBlock bigBlock = new BigBlock();
	private static BigBlock compareBlock = new BigBlock();
	private static int[][] gameBoard;	
	private static boolean[][] isCheck;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		gameBoard = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				gameBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findBigBlock(); 
		while(bigBlock.cnt>1) {
			removeBigBlock();
			goDown();
			revolve();
			goDown();
			bigBlock = new BigBlock();
			findBigBlock();
		}
		
		System.out.println(answer);

	}
	
	// gameBoard ���� ��� �Լ�
	private static void print() {
		System.out.println("============print===========================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(gameBoard[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=======================================");
	}

	// �ݽð� �������� 90�� ȸ��
	private static void revolve() {
		int[][] copyBoard = new int[N][N];
		
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				copyBoard[row][col] = gameBoard[row][col];
			}
		}
		
		for (int col = 0; col < N; col++) { // 90�� ȸ���� ����
			for (int row = 0; row < N; row++) {
				gameBoard[N-1-col][row] = copyBoard[row][col];
			}
		}
	}
	
	// �߷� �ۿ�
	private static void goDown() {
		for (int col = 0; col < N; col++) {
			Stack<Integer> prev = new Stack<Integer>();
			int curLoc;
			for (int row = 0; row < N; row++) {
				if(gameBoard[row][col]==-1) { // ������ block ���� => �������� ��ôblock �ױ�
					curLoc = row;
					while(!prev.isEmpty()) {
						int current = prev.pop();
						gameBoard[--curLoc][col] = current;
					}
				}else if(gameBoard[row][col]!=100) { // ��ĭ�ƴҶ��� stack�� �ֱ�
					prev.add(gameBoard[row][col]);
					gameBoard[row][col] = 100;
				}
			}
			curLoc = N;
			while(!prev.isEmpty()) { //������ block ���ʷ� �ױ�
				int current = prev.pop();
				gameBoard[--curLoc][col] = current;
			}
			
		}
		
	}
	
	// bigBlock �����ϱ� + ���� ȹ��
	private static void removeBigBlock() {
		for (int[] block : bigBlock.blockList) {
			gameBoard[block[0]][block[1]] = 100;
		}
		
		answer += bigBlock.cnt * bigBlock.cnt;
	}
	
	// bigBlock ã��
	private static void findBigBlock() {
		isCheck = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(gameBoard[i][j] > 0 && gameBoard[i][j]<100 && !isCheck[i][j]) { // ���غ��ã��
					getBigBlock(i,j);
					if(compareTo()>0) { // ����켱���� block�� �� bigBlock �ٲٱ�
						bigBlock.cnt = compareBlock.cnt;
						bigBlock.rainbowCnt = compareBlock.rainbowCnt;
						bigBlock.root[0] = compareBlock.root[0];
						bigBlock.root[1] = compareBlock.root[1];
						bigBlock.blockList.clear();
						for (int[] b: compareBlock.blockList) {
							bigBlock.blockList.add(b);
						}
					}
				}
			}
		}
	}

	// block �켱���� ��
	private static int compareTo() {
		if(bigBlock.cnt == compareBlock.cnt) {
			if(bigBlock.rainbowCnt==compareBlock.rainbowCnt) {
				if(compareBlock.root[0]==bigBlock.root[0]) {
					return compareBlock.root[1] - bigBlock.root[1];
				}
				return compareBlock.root[0] - bigBlock.root[0];
			}
			return compareBlock.rainbowCnt - bigBlock.rainbowCnt;
		}
		return compareBlock.cnt - bigBlock.cnt;
	}
	
	// block ã��
	private static void getBigBlock(int i, int j) {
		boolean[][] isVisited = new boolean[N][N];
		compareBlock.blockList.clear();
		compareBlock.blockList.add(new int[] {i,j});
		compareBlock.cnt = 0;
		compareBlock.rainbowCnt = 0;
		compareBlock.root = new int[] {i,j};
		int targetNum = gameBoard[i][j];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1, 0};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i,j});
		isVisited[i][j] = true;
		isCheck[i][j] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			compareBlock.cnt++;
			compareBlock.blockList.add(current);
			
			for (int d = 0; d < 4; d++) {
				int nx = current[0] + dx[d];
				int ny = current[1] + dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || isVisited[nx][ny]) continue;
				if(gameBoard[nx][ny]== targetNum) { //������ block
					isVisited[nx][ny] = true;
					isCheck[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					// ���� block �������� Ȯ��
					if(nx < compareBlock.root[0]) {  
						compareBlock.root[0] = nx;
						compareBlock.root[1] = ny;
					}else if(nx == compareBlock.root[0] && ny < compareBlock.root[1]) {
						compareBlock.root[1] = ny;
					}
				}else if(gameBoard[nx][ny]== 0) { // ������ block
					isVisited[nx][ny] = true;
					compareBlock.rainbowCnt++;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
	}

	// compareBlock�� bigBlock Ȯ��
	private static void compareBigAndCompare() {
		System.out.println("=================");
		System.out.println(compareBlock.toString());
		System.out.println(bigBlock.toString());
		System.out.println("=================");
	}

}



class BigBlock {
	public int cnt = 0; // block ����
	public int rainbowCnt = 0; // 0�� ����
	public int[] root = new int[2]; // ���� block
	public ArrayList<int[]> blockList = new ArrayList<>();; // ����� block�� ����
	
	@Override
	public String toString() {
		return "BigBlock [cnt=" + cnt + ", rainbowCnt=" +rainbowCnt +" , root="+ root[0]+","+root[1] + "]";
	}

	
}