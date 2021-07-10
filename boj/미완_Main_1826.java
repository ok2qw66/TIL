package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class ¹Ì¿Ï_Main_1826 {

	static class GasStation implements Comparable<GasStation>{
		int distance;
		int fuel;
		
		public GasStation(int distance, int fuel) {
			super();
			this.distance = distance;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(GasStation o) {
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "GasStation [distance=" + distance + ", fuel=" + fuel + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<GasStation> pq = new PriorityQueue<GasStation>(new Comparator<GasStation>() {

			@Override
			public int compare(GasStation o1, GasStation o2) {
				if(o1.distance == o2.distance)
					return o2.fuel - o1.fuel;
				return o1.distance - o2.distance;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int distance = Integer.parseInt(st.nextToken());
			int fuel = Integer.parseInt(st.nextToken());
			pq.add(new GasStation(distance, fuel));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		pq.add(new GasStation(L, 0));
		int count = -1;
		int current = 0;
		
		
		while(current < L) {
			GasStation gs = new GasStation(current, -1);
			while(!pq.isEmpty()) {
				GasStation temp = pq.poll();
				
				if(temp.distance > P + current) {
					pq.add(temp);
					break;
				}else {
					if(temp.fuel > gs.fuel)
						gs = temp;
				}
			}
			
			if(gs.fuel == -1) {
				count = -1;
				break;
			}else {
				P += -gs.distance + current + gs.fuel;
				current = gs.distance;
				count++;
			}
		}
		System.out.println(count);
	}

}
