import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] costList = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				costList[i][j] = Math.min(costList[i-1][(j+1)%3],costList[i-1][(j+2)%3]) + rgb[i-1][j];
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(answer > costList[N][i]) {
				answer = costList[N][i];
			}
		}
		System.out.println(answer);
	}

}
