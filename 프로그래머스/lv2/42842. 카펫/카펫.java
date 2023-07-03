class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum=brown+yellow;
        
        int outline=(brown+4)/2;
        //2x + 2y=outline
        for(int i=3;i<outline-2;i++){
            int x=outline-i;
            int y=i;
            if(yellow==((x-2)*(y-2))) {
                answer[0]=x;
                answer[1]=y;
                break;
            }
        }
        
        return answer;
    }
}