import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int now = 100;
	static int result = Integer.MAX_VALUE;
	static PriorityQueue<Character> pq;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		if (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				pq.add(st.nextToken().charAt(0));
			}
		}

		int d = n - now;
		int count=0;
		for(int i=0;i<999999;i++) {
			String str = String.valueOf(i);
			boolean check=false;
			for(int j=0;j<str.length();j++) {
				if(pq.contains(str.charAt(j))) {
					check=true; break;
				}
			}
			
			if(check) continue;
			count=str.length()+Math.abs(n-i);
			result= Math.min(result, count);
			
		}

		System.out.println(Math.min(Math.abs(d), result));

	}

}
