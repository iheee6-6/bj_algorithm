import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int result = 0;

	static ArrayList<Integer>[] womenArr;
	static ArrayList<Integer>[] menArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		menArr = new ArrayList[2];
		womenArr = new ArrayList[2];

		menArr[0] = new ArrayList<>();
		menArr[1] = new ArrayList<>();
		womenArr[0] = new ArrayList<>();
		womenArr[1] = new ArrayList<>();

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (val < 0) {
				menArr[0].add(val * -1);
			} else
				menArr[1].add(val);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (val > 0) {
				womenArr[0].add(val);
			} else
				womenArr[1].add(val * -1);
		}

		Collections.sort(womenArr[0]);
		Collections.sort(womenArr[1]);
		Collections.sort(menArr[0]);
		Collections.sort(menArr[1]);

		find(0);
		find(1);
		System.out.println(result);
	}

	static void find(int idx) {
		for (int i = 0, j = 0; i < menArr[idx].size() && j < womenArr[idx].size();) {
			int big, small;
			if (idx == 1) {
				big = womenArr[idx].get(j);
				small = menArr[idx].get(i);
			} else {
				big = menArr[idx].get(i);
				small = womenArr[idx].get(j);
			}

			if (big <= small) {
				if (idx == 1)
					j++;
				else
					i++;
				continue;
			}

			result++;
			i++;
			j++;
		}
	}
}
