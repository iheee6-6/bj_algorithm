import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int a, b;
	static ArrayList<Node>[] arr;

	static int[] dp;
	static class Node implements Comparable<Node>{
		int num, cost;

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new ArrayList[n+1];

		for (int i = 0; i < n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[x].add(new Node(y, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		a= Integer.parseInt(st.nextToken());
		b= Integer.parseInt(st.nextToken());
		
		dp= new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		boolean visited[]= new boolean[n+1];
		PriorityQueue<Node> q = new PriorityQueue<>(); 
		q.add(new Node(a,0));
		while(!q.isEmpty()) {
			Node node=q.poll();
			
			if(visited[node.num]) continue;
			visited[node.num]=true;
			for(int i=0;i<arr[node.num].size();i++) {
				if(!visited[arr[node.num].get(i).num]&&dp[arr[node.num].get(i).num]>=node.cost+arr[node.num].get(i).cost) {
					dp[arr[node.num].get(i).num]=node.cost+arr[node.num].get(i).cost;
				    q.add(new Node(arr[node.num].get(i).num,node.cost+arr[node.num].get(i).cost));
				}
			}
			
		}

		System.out.println(dp[b]);
	}

}
