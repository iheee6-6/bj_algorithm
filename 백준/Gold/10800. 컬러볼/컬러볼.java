import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int idx, color, size;

		Node(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			arr[i] = new Node(i, c, s);
		}

		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.sort(arr, (a1, a2) -> (a1.size - a2.size));

		int sum = 0;
		int check_idx = 0;
		int[] result = new int[n];
		int[] color = new int[n + 1];
		for (int i = 0; i < n; i++) {
			Node nd = arr[i];
			while (arr[check_idx].size < nd.size) {
				Node nd2 = arr[check_idx];
				sum += nd2.size;
				color[nd2.color] += nd2.size;
				check_idx++;
			}
			result[nd.idx] = sum - color[nd.color];
		}

		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
