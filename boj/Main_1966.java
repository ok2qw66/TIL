package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main_1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringJoiner sb = new StringJoiner("\n");
		int TC = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Integer[]> printList = new LinkedList<Integer[]>(); 
			Integer[] priority = new Integer[N];
			st = new StringTokenizer(br.readLine()," ");
			
			for (int j = 0; j < N; j++) {
				int element = Integer.parseInt(st.nextToken());
				if(j== M)
					printList.add(new Integer[] {element,1});
				else
					printList.add(new Integer[] {element,0});
					
				priority[j] = element;
			}
			
			Arrays.sort(priority, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
			
			int answer = -1;
			int idx = 0;
			int cnt = 0;
			while(answer <0) {
				Integer[] present = printList.poll();
				
				if(priority[idx] == present[0] && present[1] == 1) {
					cnt++;
					answer = cnt;
					break;
				}else if(priority[idx] == present[0]){
					cnt++;
					idx++;
				}else {
					printList.add(present);
				}
			}
			sb.add(String.valueOf(answer));
		}
		System.out.println(sb.toString());
	}

}
