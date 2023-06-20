import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int w, cost;

		Node(int w, int cost) {
			this.cost = cost;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		Node[] list = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(list, (a, b) -> {
			if (b.cost == a.cost)
				return b.w - a.w;
			else
				return a.cost - b.cost;
		});

		  int totalPrice = -1;
    int totalGram = 0;
    int answer = Integer.MAX_VALUE;
    boolean isPossible = false;

    for (int i = 0; i < N; i++) {
      totalGram += list[i].w;

      if (i > 0 && list[i - 1].cost == list[i].cost) {
        totalPrice += list[i].cost;
      } else {
        totalPrice = list[i].cost;
      }

      if (totalGram >= M) {
        isPossible = true;
        answer = Math.min(answer, totalPrice);
      }
    }

    bw.write(isPossible ? answer + "\n" : -1 + "\n");
    bw.flush();
    bw.close();
	}

}