class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        if(arr.length!=4&&arr.length!=6) return false;
        for(char c : arr){
            if(c>=65&&c<=90||c>=97&&c<=122) {
                answer=false;
                break;
            };
        }
        return answer;
    }
}