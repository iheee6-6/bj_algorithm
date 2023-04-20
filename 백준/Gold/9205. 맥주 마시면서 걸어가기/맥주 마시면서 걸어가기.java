import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int conv = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sangX = Integer.parseInt(st.nextToken());
			int sangY = Integer.parseInt(st.nextToken());

			int[][] convArr = new int[conv][2];
			for (int j = 0; j < conv; j++) {
				st = new StringTokenizer(br.readLine());
				convArr[j][0] = Integer.parseInt(st.nextToken());
				convArr[j][1] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int festivalX = Integer.parseInt(st.nextToken());
			int festivalY = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[conv];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { sangX, sangY });
			boolean result = false;
			while (!q.isEmpty()) {
				int[] temp = q.poll();
				if (Math.abs(festivalX - temp[0]) + Math.abs(festivalY - temp[1]) <= 1000) {
					result=true;
				}

				
				for (int j = 0; j < conv; j++) {
					if (Math.abs(convArr[j][0] - temp[0]) + Math.abs(convArr[j][1] - temp[1]) <= 1000&&!visited[j]) {
						q.add(new int[] {convArr[j][0],convArr[j][1]});
						visited[j]=true;
					}
				}
			}

			if(!result)
				System.out.println("sad");
			else 
				System.out.println("happy");

		}

	}

}
