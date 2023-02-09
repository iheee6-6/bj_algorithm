import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<>();
		String[] arr = new String[n+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1 ; i++) {
			String str = br.readLine();
			arr[i]=str;
			map.put(str, i);
		}
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			int num = n + 1;
			try {
				num = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				
			}
			if (num == n + 1) {
				sb.append(map.get(str)+"\n");
			} else {
				sb.append(arr[num]+"\n");
			}
		}

		System.out.println(sb);
	}

}