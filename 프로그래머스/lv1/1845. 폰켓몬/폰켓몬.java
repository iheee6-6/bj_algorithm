import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Integer[] arr = Arrays.stream(nums).boxed().toArray( Integer[]::new );
        int n = nums.length/2;
        Set<Integer> set =new HashSet(Arrays.asList(arr));
        if(set.size()>=n) answer =n;
        else answer = set.size();
        return answer;
    }
}