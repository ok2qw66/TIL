package com.boj.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_20366 {

    private static class Alpha{
        int alpha;
        int count;

        public Alpha(int alpha, int count) {
            this.alpha = alpha;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        int[] count = new int[26]; // 선택된알파벳 횟수
        ArrayList<Alpha> alphaList = new ArrayList<>();
        int answer = 0;

        int prev = -1;
        int tempCnt = 0;
        for (int i=0;i<=line.length;i++){
            if(i==line.length){
                alphaList.add(new Alpha(prev,tempCnt));
                answer = Math.max(answer, tempCnt);
            }else if(prev==-1 || prev==line[i]-'a'){
                prev = line[i]-'a';
                tempCnt++;
            }else{
                alphaList.add(new Alpha(prev,tempCnt));
                answer = Math.max(answer, tempCnt);
                prev = line[i]-'a';
                tempCnt = 1;
            }
        }

        if(N==1)
            System.out.println(answer);
        else if(N==26)
            System.out.println(line.length);
        else{
            int pointer1 = 0;
            int pointer2 = 0;
            int tempAlphaCnt = 1; //선택된 알파벳의 갯수
            count[alphaList.get(pointer1).alpha] = 1;
            tempCnt = alphaList.get(pointer1).count; //길이

            for(;pointer1<alphaList.size();){
                while(tempAlphaCnt<=N){
                    answer = Math.max(answer, tempCnt);
                    if(pointer2==alphaList.size()-1) break;
                    pointer2++;
                    tempCnt += alphaList.get(pointer2).count;
                    if(count[alphaList.get(pointer2).alpha]==0){
                        tempAlphaCnt++;
                    }
                    count[alphaList.get(pointer2).alpha]++;
                }
                //System.out.println(pointer1+"->"+pointer2+" "+tempAlphaCnt+" "+tempCnt+" ("+answer+")");

                tempCnt -= alphaList.get(pointer1).count;
                if(count[alphaList.get(pointer1).alpha]==1){
                    tempAlphaCnt--;
                }
                count[alphaList.get(pointer1).alpha]--;
                pointer1++;
            }
            System.out.println(answer);
        }

    }
}
