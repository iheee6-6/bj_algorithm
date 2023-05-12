import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] a;
	static int b;
	static int result=-1;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] arr = st.nextToken().toCharArray();
		a= new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			a[i]=arr[i]-'0';
		}
		b = Integer.parseInt(st.nextToken());
		visited=new boolean[a.length];
		
		Arrays.sort(a);
		
		dfs(0,0);
		
		System.out.println(result);
		
	}
	
	static void dfs(int number,int fixcnt) {
		if(fixcnt==a.length) {
			result=Math.max(result, number);
			return;
		}
		
		for(int i=0;i<a.length;i++) {
			if(visited[i]||(fixcnt==0&&a[i]==0)) continue;
			if(number*10+a[i]>b) continue;
			
			visited[i]=true;
			dfs(number*10+a[i],fixcnt+1);
			visited[i]=false;
		}
		
	}

}
