import java.util.*;
class Solution {
    
    static class G{
        String name;
        int play;
        G(String name,int play){
            this.name=name;
            this.play=play;
        }
    }
    
    static class Node implements Comparable<Node>{
        int idx;
        int play;
        
        Node(int idx,int play){
            this.idx=idx;
            this.play=play;
        }
        
        @Override
        public int compareTo(Node n){
            if(n.play==this.play){
                return this.idx-n.idx;
            }
            return n.play-this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String,Integer> map2= new HashMap<>();
		Map<String, ArrayList<Node>> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				ArrayList<Node> temp= map.get(genres[i]);
                temp.add(new Node(i,plays[i]));
                Collections.sort(temp);
                //map.remove(genres[i]);
                map.put(genres[i],temp);
			} else {
                ArrayList<Node> temp = new  ArrayList<>();
                temp.add(new Node(i,plays[i]));
				map.put(genres[i],temp);
			}
            map2.put(genres[i],map2.getOrDefault(genres[i],0)+plays[i]);
		}

        ArrayList<G> gList = new ArrayList<>();
        for(String k : map2.keySet()){
             gList.add(new G(k,map2.get(k)));
        }
        Collections.sort(gList,(g1,g2)->(g2.play-g1.play));
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
		for(int i=0;i<gList.size();i++){
            String name =gList.get(i).name;
            ArrayList<Node> temp = map.get(name);
            for(int j=0;j<temp.size();j++){
                if(j>=2) break;
                answerList.add(temp.get(j).idx);
            }
        }
        
        answer=new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i]=answerList.get(i);
        }
        return answer;
    }
}