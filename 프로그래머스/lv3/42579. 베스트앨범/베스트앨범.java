import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
		Map<String, Integer> map2 = new HashMap<>();
		Map<String, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				ArrayList<Integer> arrlist = map.get(genres[i]);
				arrlist.add(plays[i]);
				Collections.sort(arrlist,Collections.reverseOrder());
				map.remove(genres[i]);
				map.put(genres[i],arrlist);
				map2.put(genres[i], map2.get(genres[i]) + plays[i]);
			} else {
				ArrayList<Integer> temp= new ArrayList<>();
				temp.add(plays[i]);
				map.put(genres[i],temp);
				map2.put(genres[i], plays[i]);
			}
		}

		List<String> keySet = new ArrayList<>(map2.keySet());
boolean[] checked = new boolean[plays.length];
		keySet.sort((o1, o2) -> map2.get(o2).compareTo(map2.get(o1)));
		for (String key : keySet) {
			ArrayList<Integer> temp = map.get(key);
			int count=temp.size()>1?2:temp.size();
			for (int i = 0; i < count; i++) {
				for (int j = 0; j < plays.length; j++) {
					if (plays[j] == temp.get(i) && !checked[j]) {
						ans.add(j);
						checked[j]=true;
					}
				}
			}
		}
		
		answer=ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
	        
        return answer;
    }
}