import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		Set<String> arr = new HashSet<>();
		for(int i=0;i<n;i++) {
			arr.add(br.readLine());
		}
		int count=0;
		for(int i=0;i<m;i++) {
			String str = br.readLine();
			if(arr.contains(str)) count++;
		}
		System.out.println(count);
	}

}
