import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		for (int i = 0; i < num; i++) {
			int a = Integer.parseInt(st.nextToken());
			boolean check=true;
			for(int j=2;j<a;j++) {
				if(a%j==0) {
					check=false;
					break;
				}
			}
			if(check&&a!=1) result++;
		}
		System.out.println(result);

	}

}
