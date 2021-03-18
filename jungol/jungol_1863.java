import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_안예진 {

	private static int[] students;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		students = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			students[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		}
		
		for (int i = 1; i <= N; i++) {
			int top = findSet(students[i]);
			if(!visited[top]) {
				answer++;
				visited[top] = true;
			}
		}
		System.out.println(answer);
	}

	private static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		
		if(x>y) {
			students[x] = y;
		}else if(x<y) {
			students[y] = x;
		}
	}

	private static int findSet(int p) {
		if(p == students[p]) return p;
		
		return students[p] = findSet(students[p]);
	}

}
