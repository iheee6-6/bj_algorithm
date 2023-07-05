import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int n= (100-progresses[i])/speeds[i];
            n+=(100-progresses[i])%speeds[i]>0?1:0;
            q.add(n);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int num=1;
            int temp=q.poll();
            while(!q.isEmpty()&&temp>=q.peek()){
                num++;
                q.poll();
            }
            list.add(num);
        }
        
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}