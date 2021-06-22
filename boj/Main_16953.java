package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int answer = -1;
		boolean[] visited = new boolean[B+1];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1,B});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			//System.out.println(current[0]+" "+current[1]);
			if(current[1]==A) {
				answer = current[0];
				break;
			}
			
			if(current[1]%10==1 && !visited[current[1]/10]) {
				visited[current[1]/10] = true;
				queue.add(new int[] {current[0]+1, current[1]/10});
			}
			if(current[1]%2==0 && !visited[current[1]/2]) {
				visited[current[1]/2] = true;
				queue.add(new int[] {current[0]+1, current[1]/2});				
			}
		}
		
		System.out.println(answer);
	}

}
