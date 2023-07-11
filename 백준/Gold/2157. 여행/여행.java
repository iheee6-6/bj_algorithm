import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k;
	static int result=0;
	
	static class Node{
		int idx;
		int point;
		Node(int idx,int point){
			this.idx=idx;
			this.point=point;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] map= new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			map[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(e<s) continue;
			map[s].add(new Node(e,p));
		}

		int[][] dp = new int[m+1][n+1];
		//go(1, 0,0);
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int count=1;
		while(!q.isEmpty()&&count<m) {
			int size = q.size();
			for(int z=0;z<size;z++) {
				int idx=q.poll();
				for(Node node:map[idx]) {
					if(dp[count][idx]+node.point<=dp[count+1][node.idx]) continue;
					dp[count+1][node.idx]=dp[count][idx]+node.point;
					q.add(node.idx);
				}
			}
			
			count++;
		}
		
		
		for(int i=2;i<=m;i++) {
			result=Math.max(result, dp[i][n]);
		}
		
		System.out.println(result);
	}
	
}
