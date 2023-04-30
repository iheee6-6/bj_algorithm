import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n, num;
	static int[] arr;
	static List<Integer> res;
	static boolean[] c;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        c = new boolean[n];
        arr = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = Integer.parseInt(br.readLine())-1;
        }
        
        res = new LinkedList<Integer>(); 
        
        for (int i=0;i<n;i++) {
        	c[i] = true;
        	num = i;
        	dfs(i);
        	c[i] = false;
        }
        
        Collections.sort(res);
        System.out.println(res.size());
        for(Integer x:res) {
        	System.out.println(x+1);
        }
    }
    
    public static void dfs(int i) {
    	if(arr[i]==num) res.add(num);
    	
    	if(!c[arr[i]]) {
    		c[arr[i]] = true;
    		dfs(arr[i]);
    		c[arr[i]]=false;
    	}
    }
}