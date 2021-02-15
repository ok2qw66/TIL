import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_안예진 {

	private static int[] s,b;
	private static int N, answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		b = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		check(0,0);
		System.out.println(answer);

	}
	
	private static void check(int cnt, int flag) {
		
		if(cnt==N) {
			if(flag !=0) {
				int mul=1, sum=0;
				for (int i = 0; i < N; i++) {
					if((flag & 1<<i)!=0) {
						mul *= s[i];
						sum += b[i];
					}
				}
				int temp = Math.abs(mul-sum);
				answer = answer> temp? temp: answer;
			}
			return;
		}
		
		check(cnt+1, flag | 1<<cnt);
		check(cnt+1, flag);
		
	}

}
