
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean check = false;
			for (int j = 0; j <= q.size() / 2; j++) {
				if (num == q.get(j)) {
					check = true;
					break;
				}
			}
			if (check) {
				while (num != q.peek()) {
					q.offerLast(q.poll());
					count++;
				}
			} else {
				while (num != q.peek()) {
					q.offerFirst(q.pollLast());
					count++;
				}
			}
			q.poll();
		}
		sb.append(count);
		System.out.println(sb);
	}

}