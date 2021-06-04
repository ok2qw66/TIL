package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20056 {
	
	private static class FireBall{
		int r; //��
		int c; //��
		int m; //����
		int d; //����
		int s; //�ӷ�
		
		public FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", d=" + d + ", s=" + s + "]";
		}
		
	}
	
	private static int N,M,K;
	private static int[][] space;
	private static ArrayList<FireBall> fireBallList = new ArrayList<FireBall>();
	private static int[][] d = {
			{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}	
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		space = new int[N][N]; // �ش� ĭ�� ��� fireball�� �ִ��� üũ
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			space[r][c]++;
			fireBallList.add(new FireBall(r,c,
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		
		while(K-->0) {
			moveFireBall();
			checkFireBall();
			print();
		}
		System.out.println(fireBallSum());
	}
	private static void print() {
		System.out.println("==============");
		for (FireBall fireBall : fireBallList) {
			System.out.println(fireBall.toString());
		}
		System.out.println("==============");
	}
	// ���̾ �̵�
	private static void moveFireBall() {
		for (FireBall fireBall : fireBallList) {
			space[fireBall.r][fireBall.c]--;
			int nr = fireBall.r + d[fireBall.d][0]*fireBall.s;
			int nc = fireBall.c + d[fireBall.d][1]*fireBall.s;
			nr = inRange(nr);
			nc = inRange(nc);
			fireBall.r = nr;
			fireBall.c = nc;
			space[nr][nc]++;
		}
	}
	// 0~ N-1 �������� r,c ���ϱ�
	private static int inRange(int x) {
		while(x<0 || x>=N) {
			if(x<0) x += N;
			else	x -= N;
		}
		return x;
	}
	// �ΰ� �̻� ���̾ �ִ� ĭ ó��
	private static void checkFireBall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(space[i][j]>1) {
					System.out.println("chekcFireBallCount = "+space[i][j]);
					divideFireBall(i,j);
				}
			}
		}
	}
	// 4���� fireball�� ������
	private static void divideFireBall(int r, int c) {
		int mSum = 0;
		int sSum = 0;
		int count = 0;
		boolean isOdd=false, isEven=false;
		
		print();
		for (int i=0;i<fireBallList.size();) {
			FireBall fireBall = fireBallList.get(i);
			if(fireBall.r==r && fireBall.c==c) {
				mSum += fireBall.m;
				sSum += fireBall.s;
				count++;
				if(fireBall.d%2==0) isEven = true;
				else isOdd = true;
				fireBallList.remove(i);
				
			}else {
				i++;
			}
		}
		print();
		
		if(mSum/5==0) {
			space[r][c] = 0;
			return;
		}
		if(isOdd ^ isEven) spread(r,c, 0, mSum/5, sSum/count);
		else spread(r,c,1, mSum/5, sSum/count);
		
	}
	// 4�� fireball ����Ʈ�� ���
	private static void spread(int r, int c, int i, int m, int s) {
		space[r][c] = 4;
		for (; i <= 7; i+=2) {
			fireBallList.add(new FireBall(r, c, m, s, i));
		}
	}
	// ���̾�� ������ �� ���ϱ�
	private static int fireBallSum() {
		int count = 0;
		for (FireBall fireBall : fireBallList) {
			count += fireBall.m;
		}
		return count;
	}

}