import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Apply {
		int a;
		int b;

		Apply(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}

	static int n, p;
	static ArrayList<Apply> arr;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			for (int j = 0; j < p; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.add(new Apply(a, b));
			}
			Collections.sort(arr, (a1, a2) -> (a1.b == a2.b ? a1.a - a2.a : a1.b - a2.b));

			int count = 0;
			check = new boolean[n+1];
			for (int j = 0; j < p; j++) {
				Apply a1 = arr.get(j);
				for (int z = a1.a; z <= a1.b; z++) {
					if (!check[z]) {
						check[z] = true;
						count++;
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(count).append("\n");
			bw.write(sb.toString());

		}
		bw.flush();
		bw.close();
		br.close();
	}

}
