package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13904 {
	
	static class HomeWork implements Comparable<HomeWork>{
		int day;
		int score;
		
		public HomeWork(int day, int score) {
			super();
			this.day = day;
			this.score = score;
		}

		@Override
		public int compareTo(HomeWork o) {
			if(this.day == o.day)
				return this.score - o.score;
			return this.day - o.day;
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<HomeWork> list = new ArrayList<HomeWork>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			list.add(new HomeWork(day, score));
		}
		
		Collections.sort(list); //남은일수적은순 > 과제점수적은순
		
		ArrayList<Integer> getScoreList = new ArrayList<Integer>();
		int day = 0;
		for (HomeWork homeWork : list) {
			if(homeWork.day > day) {
				getScoreList.add(homeWork.score);
				day++;
			}else if(homeWork.day == day) {
				int minScore = getMinScore(getScoreList);
				getScoreList.remove((Object) minScore);
				getScoreList.add(homeWork.score);
			}
		}
		
		int totalSum = 0;
		for (Integer score : getScoreList) {
			totalSum += score;
		}
		System.out.println(totalSum);
	}
	private static int getMinScore(ArrayList<Integer> getScoreList) {
		int minScore = 100;
		for (Integer score : getScoreList) {
			if(minScore > score) {
				minScore = score;
			}
		}
		return minScore;
	}
	

}
