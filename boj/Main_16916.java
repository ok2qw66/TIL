package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16916 {

	private static char[] s;
	private static char[] p;
	private static int[] fail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		
		createFail();
		System.out.println(isSubStr());

	}
	// �κ� ���ڿ����� Ȯ�� �Լ�
	private static int isSubStr() {
		int j = 0;
		int len = 0;
		for (int i = 0; i < s.length;) {
			if(len == p.length) break;
			if(s[i]==p[j]) { // ��ġ�Ѵٸ�
				len++;
				i++;
				j++;
			}else if(j==0) { // ���ư� ���� ���ٸ�
				i++;
				len = 0;
			}else{ // ���ư���
				j = fail[j-1];
				len = j;
			}
		}
		return len==p.length? 1: 0;
	}
	
	// ���� �Լ� �����
	private static void createFail() {
		fail = new int[p.length];
		int j =  0;
		for (int i = 1; i < p.length;) {
			if(p[i]==p[j]) { //��ġ�Ѵٸ�
				fail[i++] = j+1;
				j++;
			}else if(j==0) { // ���ư� ���� ���ٸ�
				fail[i++] = 0;
			}
			else { //���ư���
				j = fail[j-1];
			}
		}
	}
	

}
