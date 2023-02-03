import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[][] narr;
	static int[] karr;

	static class Jewel {
		int g;
		int price;

		Jewel(int g, int price) {
			this.g = g;
			this.price = price;
		}

		int getG() {
			return g;
		}

		int getPrice() {
			return price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Jewel[] jewel = new Jewel[n];
		karr = new int[k];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewel[i] = new Jewel(g, price);
		}
		for (int i = 0; i < k; i++) {
			karr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewel, new Comparator<Jewel>() {
			public int compare(Jewel j1, Jewel j2) {
				if (j1.getG() == j2.getG()) // j1.g()-j2.get();
					return j1.getPrice() - j2.getPrice();
				return j1.getG() - j2.getG();
			}
		});

		Arrays.sort(karr);

		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

		long result = 0;
		int idx = 0;
		for (int i = 0; i < k; i++) {
			while (idx < n && jewel[idx].g <= karr[i]) {
				pq.add(jewel[idx++].price);
			}

			if (!pq.isEmpty())
				result += pq.poll();
		}

		System.out.println(result);
	}

}