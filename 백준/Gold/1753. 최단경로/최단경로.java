import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int v,k,e;
	static ArrayList<Node>[] map;
	static int[] dist;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		k= Integer.parseInt(br.readLine());
		
		map= new ArrayList[v+1];
		for(int i=0;i<v+1;i++)
			map[i]=new ArrayList<>();
		dist=new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int u= Integer.parseInt(st.nextToken());
			int vv= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			map[u].add(new Node(vv,w));
		}
		
		find();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=v;i++) {
			sb.append(dist[i]==Integer.MAX_VALUE?"INF":dist[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	

	static void find() {
        PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(k,0));
		dist[k]=0;
	    boolean[] check = new boolean[v + 1];
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0;i<map[node.idx].size();i++) {
				Node temp = map[node.idx].get(i);
			
				if(dist[temp.idx]>dist[node.idx]+temp.weight) {
					dist[temp.idx]=dist[node.idx]+temp.weight;
					q.add(new Node(temp.idx,dist[temp.idx]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int weight;
		Node(int idx,int weight){
			this.idx=idx;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
}
