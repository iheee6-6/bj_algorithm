import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> qp = new PriorityQueue<>();
		PriorityQueue<Integer> maxqp = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (qp.size() == maxqp.size()) {
				maxqp.add(Integer.parseInt(br.readLine()));
			} else {
				qp.add(Integer.parseInt(br.readLine()));
			}

			if (!qp.isEmpty()&&maxqp.peek() > qp.peek()) {
				qp.add(maxqp.poll());
				maxqp.add(qp.poll());
			}
			sb.append(maxqp.peek()).append("\n");
		}System.out.println(sb);

	}

}