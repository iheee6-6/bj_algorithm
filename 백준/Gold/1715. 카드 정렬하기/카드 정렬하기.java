import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main { //우선순위 큐로 풀기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue();
		for (int i = 0; i < num; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		long result = 0;
		if (num != 1) {
			while (pq.size()>1) {
				long sum = pq.poll() + pq.poll();
				pq.add(sum);
				result += sum;
			}
		}
		System.out.println(result);
	}

}