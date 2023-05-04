import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, X;

	static class pqFormat implements Comparable<pqFormat> {
		int idx, dist;

		pqFormat(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(pqFormat l) {
			return this.dist - l.dist;
		}
	}

	static class Load {
		int y, time;

		Load(int y, int time) {
			this.y = y;
			this.time = time;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		ArrayList<Load>[] line = new ArrayList[n + 1];
		ArrayList<Load>[] rline = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			line[i] = new ArrayList<>();
			rline[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			line[x].add(new Load(y, t));
			rline[y].add(new Load(x, t));
		}

		int[] dist1 = dijkstra(line);
		int[] dist2 = dijkstra(rline);

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dist1[i] + dist2[i]);
		}

		System.out.println(max);

	}

	static int[] dijkstra(ArrayList<Load>[] line) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		boolean[] visited = new boolean[n + 1];
		PriorityQueue<pqFormat> pq = new PriorityQueue<>();
		pq.add(new pqFormat(X, 0));

		while (!pq.isEmpty()) {
			pqFormat now = pq.poll();
			if (visited[now.idx] == true)
				continue;

			visited[now.idx] = true;
			for (Load l : line[now.idx]) {
				if (dist[l.y] > dist[now.idx] + l.time) {
					dist[l.y] = dist[now.idx] + l.time;
					pq.add(new pqFormat(l.y, dist[l.y]));
				}
			}
		}
		return dist;
	}
}
