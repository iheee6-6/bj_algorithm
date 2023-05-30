import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int end, w;

		Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node n) {
			return this.end - n.end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<Node>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e,w));
		}
		
		int result=0;
		ArrayList<Node> truck= new ArrayList<>();
		for(int i=1;i<=n;i++) {
			Collections.sort(list[i]);
			
			ArrayList<Node> temp= list[i];
			for(int j=0;j<truck.size();j++) {
				Node node = truck.get(j);
				if(node.end==i) {
					result+=node.w;
					truck.remove(node);
					c+=node.w;
				}
			}
			
			for(Node node:temp) {
				int ww= c-node.w>0?node.w:c;
				c-=ww;
				truck.add(new Node(node.end,ww));
			}
		}

		System.out.println(result);
	}

}
