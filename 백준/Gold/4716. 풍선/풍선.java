import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int num, adis, bdis;

		Node(int num, int adis, int bdis) {
			this.num = num;
			this.adis = adis;
			this.bdis = bdis;
		}

		@Override
		public int compareTo(Node nd) {
			return Math.abs(nd.adis - nd.bdis) - Math.abs(this.adis - this.bdis);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int an = Integer.parseInt(st.nextToken());
			int bn = Integer.parseInt(st.nextToken());
			if (an == 0 && bn == 0 && n == 0)
				break;
			Node[] arr = new Node[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));

			}

			Arrays.sort(arr);
			int result = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i].adis < arr[i].bdis) {
					if (an >= arr[i].num) {
						an -= arr[i].num;
						result += arr[i].adis * arr[i].num;
					} else {
						result += arr[i].adis * an;
						result += arr[i].bdis * (arr[i].num - an);
						bn -= (arr[i].num - an);
						an = 0;
					}
				} else {
					if (bn >= arr[i].num) {
						bn -= arr[i].num;
						result += arr[i].bdis * arr[i].num;
					} else {
						result += arr[i].bdis * bn;
						result += arr[i].adis * (arr[i].num - bn);
						an -= (arr[i].num - bn);
						bn = 0;
					}

				}
			}

			System.out.println(result);
		}
	}

}
