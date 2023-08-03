import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int v,e;
	static int[][] dist;
	static ArrayList<Node>[] map;
	static class Node implements Comparable<Node>{
		int idx,weight,food;
		int eat;
		Node(int idx,int weight,int food){
			this.idx=idx;
			this.weight=weight;
			this.food=food;
		}
		Node(int idx,int weight,int food,int eat){
			this.idx=idx;
			this.weight=weight;
			this.food=food;
			this.eat=eat;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		dist= new int[v+1][2];
		map= new ArrayList[v+1];
		for(int i=0;i<v+1;i++) {
			map[i]= new ArrayList<>();
			dist[i][0]=Integer.MAX_VALUE;
			dist[i][1]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<e;i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 int f = Integer.parseInt(st.nextToken());
			 map[x].add(new Node(y,w,f));
			 map[y].add(new Node(x,w,f));
		}
		
		dij(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<v+1;i++) {
			sb.append(Math.min(dist[i][0], dist[i][1])).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dij(int idx) {
		PriorityQueue<Node> p = new PriorityQueue<>();
		p.add(new Node(idx,0,0));
		dist[idx][0]=0;
		dist[idx][1]=0;
		
		while(!p.isEmpty()) {
			Node node = p.poll();
            
			if(dist[node.idx][node.eat]<node.weight) continue;
			for(int i=0;i<map[node.idx].size();i++) {
				Node temp = map[node.idx].get(i);
				
				if(node.eat==0) {
					if(dist[temp.idx][1]>node.weight+temp.weight-temp.food) {
						dist[temp.idx][1]=node.weight+temp.weight-temp.food;
						p.add(new Node(temp.idx,dist[temp.idx][1],0,1));
					}
				}
				
				if(dist[temp.idx][node.eat]>node.weight+temp.weight) {
					dist[temp.idx][node.eat]=node.weight+temp.weight;
					p.add(new Node(temp.idx,dist[temp.idx][node.eat],0,node.eat));
				}
			}
		}
	}
}
