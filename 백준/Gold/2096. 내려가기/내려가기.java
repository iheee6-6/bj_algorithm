import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] maxdp, mindp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maxdp = new int[3];
		mindp = new int[3];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			if (i == 0) {
				maxdp[0] = z;
				maxdp[1] = o;
				maxdp[2] = t;

				mindp[0] = z;
				mindp[1] = o;
				mindp[2] = t;
			} else {
				int tempz = Math.max(z + maxdp[1], z + maxdp[0]);
				int tempo = Math.max(Math.max(o + maxdp[1], o + maxdp[0]), o + maxdp[2]);
				int tempt = Math.max(t + maxdp[1], t + maxdp[2]);
				maxdp[0] = tempz;
				maxdp[1] = tempo;
				maxdp[2] = tempt;
				tempz = Math.min(z + mindp[1], z + mindp[0]);
				tempo = Math.min(Math.min(o + mindp[1], o + mindp[0]), o + mindp[2]);
				tempt = Math.min(t + mindp[1], t + mindp[2]);
				mindp[0] = tempz;
				mindp[1] = tempo;
				mindp[2] = tempt;
			}
		}

		System.out.println(Math.max(Math.max(maxdp[0], maxdp[1]), maxdp[2]) + " "
				+ Math.min(Math.min(mindp[0], mindp[1]), mindp[2]));
	}

}