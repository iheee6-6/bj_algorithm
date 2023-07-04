class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int size=number.length()-k;
        String[] arr = number.split("");
        int start=0;
        StringBuilder sb = new StringBuilder();
        for(int i=size;i>=1;i--){
            int max=0;
            for(int j=start;j<=number.length()-i;j++){
                int num=Integer.parseInt(arr[j]);
                if(max<num){
                    max=num;
                    start=j+1;
                    if(num==9) break;
                }
            }
            sb.append(String.valueOf(max));
        }
        answer =sb.toString();
        return answer;
    }
}