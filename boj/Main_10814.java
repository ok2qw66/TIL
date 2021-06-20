package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_10814 {

	static class Member{
		int idx;
		int age;
		String name;
		
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Member[] memberList = new Member[N];
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			memberList[i] = new Member(age, name);
			memberList[i].idx = i;
		}
		
		Arrays.sort(memberList, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age == o2.age)
					return o1.idx - o2.idx;
				return o1.age - o2.age;
			}
		});
		
		for (Member member : memberList) {
			System.out.println(member.age+" "+member.name);
		}
	}

}
