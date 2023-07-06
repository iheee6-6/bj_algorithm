import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i < 8; i++) {
            result.add(new HashSet<>());
        }

        for (int i = 0; i < 8; i++) {
            Set<Integer> currentResult = result.get(i);
            currentResult.add(Integer.parseInt(String.valueOf(N).repeat(i + 1)));

            for (int j = 0; j < i; j++) {
                for (int case1 : result.get(j)) {
                    for (int case2 : result.get(i - 1 - j)) {
                        currentResult.add(case1 + case2);
                        currentResult.add(case1 - case2);
                        currentResult.add(case1 * case2);
                        if (case2 != 0) {
                            currentResult.add(case1 / case2);
                        }
                    }
                }
            }

            if (currentResult.contains(number)) {
                return i + 1;
            }
        }

        return -1;
    }
}