package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11650 {

	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		list.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x==o2.x)
					return o1.y - o2.y;
				
				return o1.x - o2.x;
			}
		});

		for (Point point : list) {
			System.out.println(point.x+ " "+ point.y);
		}
	}

}
