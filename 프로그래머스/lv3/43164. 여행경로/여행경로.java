import java.util.*;
class Solution {
    static String[][] arr;
    static boolean[] visited;
    static ArrayList<String> result= new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        arr= tickets;
        visited=new boolean[tickets.length];
        find("ICN","ICN",0);
        Collections.sort(result);
        
        answer = result.get(0).split(" ");
        return answer;
    }
    
    static void find(String res,String dist,int count){
        if(count==arr.length){
            result.add(res);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i][0].equals(dist)&&!visited[i]){
                visited[i]=true;
                find(res+" "+arr[i][1],arr[i][1],count+1);
                visited[i]=false;
            }
        }
    }
}