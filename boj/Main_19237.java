package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19237 {
	private static int[][] d = {
			{-1,0},{1,0},{0,-1},{0,1}	
	};
	private static int time=0;
	private static int[][][] space;
	private static int[][] shark;
	private static int[][][] sharkPriority;
	private static int N,M,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		space = new int[N][N][2]; //��,��,(�����������ȣ,��ȿ�ð�)
		shark = new int[M+1][3]; // ����ȣ,(��� ��ġ ��,��,����)
		sharkPriority = new int[M+1][4][4]; // ����ȣ, ����������,(�켱����)
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int inputShark = Integer.parseInt(st.nextToken());
				if(inputShark!=0) {
					// ��� ��ġ ����
					shark[inputShark][0] = i;
					shark[inputShark][1] = j;
					// ��� ���� �����
					space[i][j][0] = inputShark;
					space[i][j][1] = K;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) { // ��� ���� ����
			shark[i][2] = Integer.parseInt(st.nextToken())-1;
		}
		
		for (int i = 1; i <= M; i++) { // �� ���� ���� �켱���� ����
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 4; k++) {
					sharkPriority[i][j][k] = Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		while(existNum()!=1 && time <= 1000) {
			//check();
			time++;
			decreaseScent(); //���� ��ȿ�ð� -1
			moveShark(); // ��� �̵�
		}
		System.out.println(time>1000? -1: time);
	}
	private static void check() {
		System.out.println("========shark========");
		for (int i = 1; i <= M; i++) {
			System.out.println(Arrays.toString(shark[i]));
		}
		System.out.println("========space========");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("["+space[i][j][0]+","+space[i][j][1]+"] ");
			}
			System.out.println();
		}
	}
	// ��� �̵�
	private static void moveShark() {
		for (int i = M; i > 0; i--) {
			int sharkX = shark[i][0];
			int sharkY = shark[i][1];
			int sharkD = shark[i][2];
			if(sharkX ==-1) continue;
			//System.out.println(i+"th shark >> "+sharkX+" "+sharkY);
			// ��ĭ���� Ž��
			int j = 0;
			for (; j < 4; j++) {
				int dd = sharkPriority[i][sharkD][j];
				int nx = sharkX + d[dd][0];
				int ny = sharkY + d[dd][1];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(space[nx][ny][0]==0) {
					//System.out.println(i+"th shark "+nx+" "+ny);
					// ��� ��ġ ����
					shark[i][0] = nx;
					shark[i][1] = ny;
					shark[i][2] = dd;
					// ��� ���� �����
					space[nx][ny][0] = i;
					space[nx][ny][1] = K;
					break;
				}else if(space[nx][ny][1]==K) {
					//System.out.println(i+"th shark "+nx+" "+ny);
					shark[space[nx][ny][0]][0] = -1; // ���� �� ��� �Ѱܳ�
					// ��� ��ġ ����
					shark[i][0] = nx;
					shark[i][1] = ny;
					shark[i][2] = dd;
					// ��� ���� �����
					space[nx][ny][0] = i;
					space[nx][ny][1] = K;
					break;
				}
			}
			if(j!=4) continue;
			// �ڽŰ� ���� �� ĭ ã��
			for (j = 0; j < 4; j++) {
				int dd = sharkPriority[i][sharkD][j];
				int nx = sharkX + d[dd][0];
				int ny = sharkY + d[dd][1];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(space[nx][ny][0]==i) {
					//System.out.println(i+"th same shark "+nx+" "+ny);
					// ��� ��ġ ����
					shark[i][0] = nx;
					shark[i][1] = ny;
					shark[i][2] = dd;
					// ��� ���� �����
					space[nx][ny][0] = i;
					space[nx][ny][1] += K; //������ �ִ� ���̶�� ǥ��
					break;
				}
			}
		}
	}
	// space�� �����ִ� ��� ������ 1�� �����ð� ����
	private static void decreaseScent() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(space[i][j][0]!=0) {
					if(space[i][j][1]>K) space[i][j][1] = K;
					if(--space[i][j][1]==-1) {
						space[i][j][0] = 0;
					}
				}
			}
		}
	}
	// �� ��� ���Ҵ��� üũ
	private static int existNum() {
		int count = 0;
		for (int i = 1; i <= M; i++) {
			if(shark[i][0]!=-1)
				count++;
		}
		return count;
	}

}
