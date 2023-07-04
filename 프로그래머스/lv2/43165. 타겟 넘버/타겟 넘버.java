class Solution {
    static int[] numbers;
    static int target;
    static boolean[] visited;
    static int answer=0;
    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;
        visited=new boolean[numbers.length];
        
        dfs(0,0);
        
        return answer;
    }
    
    static void dfs(int idx,int sum){
        if(idx==numbers.length){
            if(sum==target) answer++;
            return;
        }
        visited[idx]=true;
        dfs(idx+1,sum+numbers[idx]);
        dfs(idx+1,sum-numbers[idx]);
    }
}