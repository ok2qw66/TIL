package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2109 {

	static class Lecture implements Comparable<Lecture>{
		int p;
		int d;
		
		public Lecture(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Lecture o) {
			return o.d - this.d;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int maxD = 0;
		List<Lecture> lectures = new ArrayList<Lecture>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			maxD = maxD < d? d: maxD;
			lectures.add(new Lecture(p, d));
		}
		
		Collections.sort(lectures);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int maxP = 0;
		int idx = 0;
		while(maxD>0) {
			while(idx<N) {
				Lecture lec = lectures.get(idx);
				if(lec.d<maxD) {
					break;
				}else {
					pq.add(lec.p);
					idx++;
				}
			}
			
			if(!pq.isEmpty())	maxP += pq.poll();
			maxD--;
		}
		
		System.out.println(maxP);
	}

}
