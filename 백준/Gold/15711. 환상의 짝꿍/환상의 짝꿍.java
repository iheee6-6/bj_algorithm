import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] isPrime = new boolean[2000001];
    public static List<Integer> list = new ArrayList<>();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		eratosthenes();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			String result = "NO";
			long sum = a + b;
			if (sum < 4) {
				sb.append("NO").append("\n");
			} else if (sum % 2 == 0) {
				sb.append("YES").append("\n");
			} else {
				if (check(sum - 2)) {
					sb.append("NO").append("\n");
				} else {
					sb.append("YES").append("\n");
				}
			}

		}
		System.out.println(sb);
	}

	static boolean check(long num) {
		if(num<=2000000) return isPrime[(int)num];
		
		for(int i=0;i<list.size();i++) {
			if(num%list.get(i)==0) {
				return true;
			}
		}
		return false;
	}
	
	static void eratosthenes() {
		isPrime[0]= isPrime[1]=true;
		for(int i=2;i<=2000000;i++) {
			if(!isPrime[i]) {
				list.add(i);
				for(int j=i*2;j<=2000000;j+=i) {
					isPrime[j]=true;
				}
			}
		}
	}
}
