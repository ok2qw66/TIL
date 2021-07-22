package com.boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pointer1 = 0;
        int pointer2 = 0;
        int count = 0;
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N;i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int sum = list[0];
        if(sum==M)
            count++;

        for(;pointer1!=N-1;){

            if(pointer2<N-1){
                pointer2++;
                sum += list[pointer2];
            }else if(sum<M){
                break;
            }
            //System.out.println(pointer1+"->"+pointer2+" "+sum);
            while(sum>=M && pointer1<N){
                if(sum==M)
                    count++;

                sum -= list[pointer1];
                pointer1++;
            }
        }

        System.out.println(count);
    }
}
