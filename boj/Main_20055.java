package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20055 {
	private static int N,K;
	private static int[] containerbelt;
	private static boolean[] isRobot;
	private static int current = 0;
	private static int answer = 0;
	private static int zeroCnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		containerbelt = new int[N*2];
		isRobot = new boolean[N*2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N*2; i++) {
			containerbelt[i] = Integer.parseInt(st.nextToken());
		}
		
		while(zeroCnt < K) {
			answer++;
			step1();
			step2();
			step3();
//			print();
		}
		System.out.println(answer);
	}
	
	private static void print() {
		System.out.println("===========================");
		System.out.println("current="+current);
		System.out.println("answer="+answer);
		System.out.println("zeroCnt="+zeroCnt);
		System.out.println(Arrays.toString(containerbelt));
		System.out.println(Arrays.toString(isRobot));
		System.out.println("===========================");
	}

	// �κ� �ø���
	private static void step3() {
		if(containerbelt[current] != 0) {
			isRobot[current] = true;
			if(--containerbelt[current]==0) {
				zeroCnt++;
			}
		}
		
	}

	// ���� �ö� �κ����� 1ĭ�� �̵�
	private static void step2() {
		int lastLoc = current+N-1+2*N;
		for (int i = 1; i < N; i++) {
			int curLoc = (lastLoc-i)%(2*N);
			int nextLoc = (lastLoc-i+1)%(2*N);
			if(isRobot[curLoc] && !isRobot[nextLoc] && containerbelt[nextLoc]>0) {
				isRobot[curLoc] = false;
				isRobot[nextLoc] = true;
				if(--containerbelt[nextLoc]==0) {
					zeroCnt++;
				}
			}
		}
	}

	// ��Ʈ ȸ�� + ������ ��ġ �κ� ������
	private static void step1() {
		int lastRobotLoc = (current+N-2+2*N)%(2*N);
		current = (current-1+2*N)%(2*N); // ��Ʈ ȸ�� -> �����ϴ� current��ġ-1
		if(isRobot[lastRobotLoc]) { // ������ ��ġ �κ� ������(falseó��)
			isRobot[lastRobotLoc] = false;
		}
		if(isRobot[(lastRobotLoc+1)%(2*N)]) { // �̹� ������ �κ� ������(falseó��)
			isRobot[(lastRobotLoc+1)%(2*N)] = false;
		}
	}

}
