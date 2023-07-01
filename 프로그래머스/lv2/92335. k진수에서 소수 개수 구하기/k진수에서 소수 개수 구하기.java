class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String temp = "";
        while(n>0){
            temp=(n%k)+temp;
            n/=k;
        }
        
        String[] arr = temp.split("0");
        for(String str:arr){
            if(str.equals("")) continue;
            if(isPrime(str)){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean isPrime(String s){
        Long x = Long.parseLong(s);
        
        if(x<2) return false;
        
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0)
                return false;
        }
        return true;
        
    }
}