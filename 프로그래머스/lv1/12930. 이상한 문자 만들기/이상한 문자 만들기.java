class Solution {
    public String solution(String s) {
        String answer = "";
        int count=0;
        String[] arr = s.split("");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(" ")){
                count=0;
                answer+=" ";
                continue;
            }
            if(count%2==0){
                answer+=arr[i].toUpperCase();    
            }else{
                answer+=arr[i].toLowerCase();
            }
            count++;
        }
        return answer;
    }
}