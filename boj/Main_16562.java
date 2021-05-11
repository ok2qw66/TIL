package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16562 {

	private static int[][] relations;
	private static int N,M,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		relations = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			relations[i][0] = i;
			relations[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			int firTarget = findSmallest(first);
			int secTarget = findSmallest(second);
			
			setSmallest(firTarget,secTarget);
		}
		int answer = findAnswer();
		System.out.println(answer>K? "Oh no":answer);
	}

	

	private static int findAnswer() {
		int answer = 0;
		boolean[] visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(relations[i][0]==i) answer += relations[i][1];
			}
		}
		return answer;
	}



	private static void setSmallest(int firTarget, int secTarget) {
		if(relations[firTarget][1] < relations[secTarget][1]) {
			relations[secTarget][0] = firTarget;
		}else {
			relations[firTarget][0] = secTarget;
		}
	}



	private static int findSmallest(int second) {
		int current = second;
		int target = relations[current][0];
		while(target != current) {
			current = target;
			target = relations[current][0];
		}
		return target;
	}

}
