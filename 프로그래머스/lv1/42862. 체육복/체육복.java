import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n+2];
        for(int i=0;i<lost.length;i++){
           arr[lost[i]]--;
        }
        for(int j=0;j<reserve.length;j++){
           arr[reserve[j]]++;
        } 
        
        for(int i=1;i<=n;i++){
           if(arr[i]<0){
               if(arr[i-1]>0){
                   arr[i-1]--;
                   arr[i]++;
               }else if(arr[i+1]>0){
                   arr[i+1]--;
                   arr[i]++;
               }
           }
            if(arr[i]>=0) answer++; 
        }
        
        
        return answer;
    }
}