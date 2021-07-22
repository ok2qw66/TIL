package com.boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main_10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for (int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; cnt<N;i++){
            cnt += count[i];
            while(count[i]-->0) {
                sb.append(i).append("\n");
            }
        }

        sb.setLength(sb.length());
        System.out.println(sb);
    }
}
