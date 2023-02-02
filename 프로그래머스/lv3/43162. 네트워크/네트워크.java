class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[n];
        for(int i=0;i<n;i++){
            if(!checked[i]){
                dfs(i,n,computers,checked);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int x,int n,int[][] computers,boolean[] checked){
        for(int i=0;i<n;i++){
            if(i!=x&&computers[x][i]==1&&!checked[i]) {
                checked[i]=true;
                dfs(i,n,computers,checked);               
            }
        }
    }
}