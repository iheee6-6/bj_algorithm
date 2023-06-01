import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, result = Integer.MAX_VALUE;
	static int[][] arr;
	static ArrayList<Node> virusList;

	static Node[] activeVirusList;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int emptySpace=0;
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		virusList = new ArrayList<>();

		activeVirusList = new Node[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int input = Integer.parseInt(st.nextToken());
				arr[i][j] -= input;
				if (arr[i][j] == -2)
					virusList.add(new Node(i, j));
				else if(arr[i][j]==0)
					emptySpace++;
			}
		}
        if (emptySpace == 0) { // 빈 칸이 없는 경우
            System.out.println(0);
            return;
        }

		//simulation2();
		simulation(0,0);
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	static void simulation(int depth,int start) {
		if(depth==m) {
			spread(emptySpace);
			return;
		}
		for (int i = start; i < virusList.size(); i++) {
			activeVirusList[depth]=virusList.get(i);
			simulation(depth+1,i+1);
		}
	}


	static void spread(int emptySpace) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		for(Node node :activeVirusList) {
			q.add(node);
			visit[node.x][node.y]=true;
		}
		int time=0;
		while(!q.isEmpty()) {
			int size= q.size();
			for(int i=0;i<size;i++) {
				Node node = q.poll();
				
				for(int j=0;j<4;j++) {
					int xx = node.x + dx[j];
					int yy = node.y + dy[j];
					if (xx < 0 || yy < 0 || xx >= n || yy >= n || visit[xx][yy]||arr[xx][yy]==-1)
						continue;
					if(arr[xx][yy]==0) {
						emptySpace--;
					} 
					
					q.add(new Node(xx,yy));
					visit[xx][yy]=true;
				}
				
			}
			
			time++;
			if(time>=result) return;
			if(emptySpace==0) {
				result=Math.min(time,result);
			}

		}
		
	}
	
	
	static void simulation2() {
		for (int i = 0; i < virusList.size(); i++) {
			//tempArr = arr.clone();

			visited = new boolean[n][n];
			//spread(virusList.get(i), 0);
			
			result=Math.min(check(),result);
		}
	}

	
	static void spread2(Node node, int count) {
		visited[node.x][node.y]=true;
		//tempArr[node.x][node.y]=count;
		for (int j = 0; j < 4; j++) {
			int xx = node.x + dx[j];
			int yy = node.y + dy[j];
			if (xx < 0 || yy < 0 || xx >= n || yy >= n || visited[xx][yy])
				continue;
			if(arr[xx][yy]==0) {
				spread2(new Node(xx,yy), count + 1);
			}
		}
	}
	
	static int check() {
		
		int c=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			//	c=Math.max(c,tempArr[i][j]);
			}
		}
		return c;
	}
}
