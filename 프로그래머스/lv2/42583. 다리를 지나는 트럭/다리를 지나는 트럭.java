import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int answer=0;
        int now =0;
        for(int i=0;i<truck_weights.length;i++){
            while(true){
                if(q.isEmpty()){
                    q.add(truck_weights[i]);
                    now+=truck_weights[i];
                    answer++;
                    break;
                }
                else {
                    if(q.size()==bridge_length){
                        now-=q.poll();
                    }else if(now+truck_weights[i]>weight){
                        q.add(0);
                        answer++;
                    }else{
                        q.add(truck_weights[i]);
                        now+=truck_weights[i];
                        answer++;
                        break;
                    }
                    
                }
            }
            
        }
        return answer+bridge_length;
    }
}