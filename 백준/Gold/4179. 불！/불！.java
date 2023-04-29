import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int a, b;
	static Node jh;
	static ArrayList<Node> fire = new ArrayList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	private static class Node {
		int x, y, count;
		String name;

		Node(int x, int y, String name, int count) {
			this.x = x;
			this.y = y;
			this.name = name;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		String[][] arr = new String[a][b];
		for (int i = 0; i < a; i++) {
			String[] strarr = br.readLine().split("");
			for (int j = 0; j < b; j++) {
				arr[i][j] = strarr[j];
				if (strarr[j].equals("J")) {
					if (i == a - 1 || j == b - 1 || i == 0 || j == 0) {
						System.out.println(1);
						return;
					}
					jh = new Node(i, j, "J", 1);
				}
				if (strarr[j].equals("F")) {
					fire.add(new Node(i, j, "F", 0));
				}
			}
		}

		int min = Integer.MAX_VALUE;
		boolean[][] visited= new boolean[a][b];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < fire.size(); i++) {
			q.add(fire.get(i));
			visited[fire.get(i).x][fire.get(i).y]=true;
		}
		q.add(jh);
		visited[jh.x][jh.y]=true;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			String name = node.name;
			
			for (int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];

				if (xx < 0 || yy < 0 || xx >= a || yy >= b||visited[xx][yy])
					continue;
				if (arr[xx][yy].equals("#") || arr[xx][yy].equals("F"))
					continue;
				if (name.equals("J")) {
					if (xx == a - 1 || yy == b - 1 || xx == 0 || yy == 0) {
						min = Math.min(min, node.count + 1);
						continue;
					}
				}
				arr[xx][yy] = name;
				visited[xx][yy]=true;
				q.add(new Node(xx, yy, name, node.count + 1));
			}

			if (name == "J") {
				arr[node.x][node.y] = ".";
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);

	}

}
