class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero=0;
        int right=0;
        
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0) zero++;
            else {
                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j]){
                        right++;
                    }
                }
            }
        }
        
        answer[0]=7-(right+zero)==7?6:7-(right+zero);
        answer[1]=7-right==7?6:7-right;
        
        return answer;
    }
}