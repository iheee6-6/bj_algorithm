import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static class dot {
		int x;
		int y;

		dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dot[] arr = new dot[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new dot(a, b);
		}
		
		Arrays.sort(arr, new Comparator<dot>() {
			public int compare(dot d1, dot d2) {
				if(d1.x==d2.x) {
					return d1.y-d2.y;
				}
				return d1.x - d2.x;
			}
		});
		
		for (int i = 0; i < n; i++)
			System.out.println(arr[i].x+" "+arr[i].y);
	}

}
