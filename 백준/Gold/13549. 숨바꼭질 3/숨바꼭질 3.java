import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int x;
		int time;
		Node(int x, int time){
			this.x=x;
			this.time=time;
		}
	}
	static boolean[] visited= new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result=Integer.MAX_VALUE;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n,0));
		while(!q.isEmpty()) {
			Node node=q.poll();
			int x= node.x;
			int time=node.time;
			visited[x]=true;
			
			if(x==k) result= Math.min(result, time);
			
			if( x*2<=100000&&!visited[x*2])
				q.add(new Node(x*2,time));
			
			if( x+1<=100000&&!visited[x+1])
				q.add(new Node(x+1,time+1));
			
			if( x-1>=0&&!visited[x-1])
				q.add(new Node(x-1,time+1));
		}
		
		System.out.println(result);
	}
}
