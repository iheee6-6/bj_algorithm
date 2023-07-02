import java.util.*;

class Solution {
    static Map<String,List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        for(int i=0;i<info.length;i++){
            String[] arr = info[i].split(" ");
            addMap(arr,"",0);
        }
        
        for (String key : map.keySet())
            Collections.sort(map.get(key));
        
        for(int i=0;i<query.length;i++){
            query[i]=query[i].replaceAll(" and ","");
            String[] q = query[i].split(" ");
           answer[i]=map.containsKey(q[0])?binarySearch(q):0;
        }
        return answer;
    }
    
    public static int binarySearch(String[] q){
        List<Integer> list = map.get(q[0]);
        int left=0;
        int right=list.size()-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            if(list.get(mid)>=Integer.parseInt(q[1])){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return list.size()-left;
    } 
    
    public static void addMap(String[] arr,String str,int count){
        if(count==4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str,list);
            }
            map.get(str).add(Integer.parseInt(arr[4]));
            return;
        }
        addMap(arr,str+"-",count+1);
        addMap(arr,str+arr[count],count+1);
    }
}