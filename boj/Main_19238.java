package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238 {
	private static int N,M,F;
	private static int[] taxi;
	private static boolean[] finishPassenger;
	private static int[][] map;
	private static int[][] passenger;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		passenger = new int[M+1][4];
		finishPassenger = new boolean[M];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		taxi = new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			passenger[i][0] = Integer.parseInt(st.nextToken())-1;
			passenger[i][1] = Integer.parseInt(st.nextToken())-1;
			passenger[i][2] = Integer.parseInt(st.nextToken())-1;
			passenger[i][3] = Integer.parseInt(st.nextToken())-1;
		}
		passenger[M][0] = passenger[M][1] = N;
		
		goTaxi();
		System.out.println(F<0 ? -1: F);
	}
	
	private static void goTaxi() {
		onTaxi(findPassenger());
		if(F<=0) return;
	}
	// 택시 ~ 손님
	private static void onTaxi(int[] nextPassen) {
		//System.out.println("ONTAXI == "+Arrays.toString(nextPassen));
		//System.out.println("ONTAXI == "+Arrays.toString(taxi)+" "+F);
		if(nextPassen[0]==M) return; // 모든 손님 이동시킴
		// 손님 태움
		F -= nextPassen[1];
		if(F<0) return;
		taxi[0] = passenger[nextPassen[0]][0];
		taxi[1] = passenger[nextPassen[0]][1];
		// 손님 내림
		int tempFuel= fromtaxiTo(passenger[nextPassen[0]][2], passenger[nextPassen[0]][3]);
		F -= tempFuel;
		if(F<0) return;
		F += tempFuel*2;
		finishPassenger[nextPassen[0]] = true;
		taxi[0] = passenger[nextPassen[0]][2];
		taxi[1] = passenger[nextPassen[0]][3];
		//System.out.println("OFFTAXI == "+Arrays.toString(taxi)+" "+F);
		goTaxi();
	}

	// 다음 passenger 찾기
	private static int[] findPassenger() {
		int next = M;
		int fuel = 600000;
		for (int i = 0; i < M; i++) {
			if(finishPassenger[i]) continue;
			int tempFuel = fromtaxiTo(passenger[i][0], passenger[i][1]);
			if(tempFuel< fuel) {
				next = i;
				fuel = tempFuel;
			}else if(tempFuel == fuel){
				if(passenger[next][0]> passenger[i][0] || (passenger[next][0]== passenger[i][0] && passenger[next][1]> passenger[i][1])) {
					next = i;
				}
			}
		}
		//System.out.println("FIND PASSENGER!! >> "+next+" "+fuel);
		return new int[] {next,fuel};
	}
	// 현재택시 ~ (r,c)까지 걸리는 연료 측정
	private static int fromtaxiTo(int r, int c) {
		if(taxi[0]==r && taxi[1]==c) return 0;
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {taxi[0], taxi[1]});
		visited[taxi[0]][taxi[1]] = true;
		int count = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			int size = q.size();
			count++;
			while(size-->0) {
				int[] current = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = current[0] + dx[i];
					int nc = current[1] + dy[i];
					if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
					if(nr==r && nc==c) return count;
					if(!visited[nr][nc] && map[nr][nc]==0) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		return 600000;
	}

}
