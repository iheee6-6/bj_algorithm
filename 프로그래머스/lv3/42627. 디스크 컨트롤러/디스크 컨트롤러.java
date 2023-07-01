import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
       
        int count=0;
        int end=0;
        int idx=0;
        while(count<jobs.length){
            
            while(idx<jobs.length&&end>=jobs[idx][0]){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                end=jobs[idx][0];
            }else{
                int[] temp= pq.poll();
                answer += temp[1]-temp[0]+end;
                end+=temp[1];
                count++;
            }
        }
        return (int)Math.floor(answer/jobs.length);
    }
}