package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062 {
	static int N,K;
    static int max = 0;
    static boolean visit[] = new boolean[26];
    static String[] stArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stArr = new String[N];
        //남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다.  a n t i c
        if(K<5) {
            System.out.println(0);
            return;
        }else if(K==26) { 
            System.out.println(N);
            return;
        }else {
            for(int n=0; n<N; n++) {
                String str = br.readLine();
                stArr[n] = str.substring(4, str.length()-4);
            }
            K-=5;
            visit['a'-97]=true;
            visit['n'-97]=true;
            visit['t'-97]=true;
            visit['i'-97]=true;
            visit['c'-97]=true;
            dfs(0, 0);
            System.out.println(max);
        }
        
    }
    private static void dfs(int start, int count) {
        // TODO Auto-generated method stub
        if(count == K) {
            int rs = 0;
            for(int i=0; i<N; i++) {
                boolean isTrue = true;
                for(int j=0; j<stArr[i].length(); j++) {
                    if(!visit[stArr[i].charAt(j)-97]) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    rs++;
                }
            }
            max = Math.max(max, rs);
            return;
        }
        
        for(int i=start; i<26; i++) {
            if(!visit[i]) {
                visit[i]=true;
                dfs(i, count+1);
                visit[i]=false;
            }
        }
    }
}
