import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (q.isEmpty()) {
					System.out.println(0);
					continue;
				}
				if (!q2.isEmpty()) {
					if (q.peek() == Math.abs(q2.peek())) {
						q.poll();
						System.out.println(q2.poll());
					} else
						System.out.println(q.poll());
				} else
					System.out.println(q.poll());
			} else {
				q.add(Math.abs(num));
				if (num < 0)
					q2.add(num);
			}
		}
	}

}
