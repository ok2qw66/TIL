package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class Solution_1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int NUM = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= NUM; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int[] array = new int[num];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			System.out.print("#"+testCase);
			for(int x : array) {
				System.out.print(" "+x);
			}
			System.out.println();
		}
	}

}
