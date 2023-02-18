import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arrlist = new ArrayList<>();
		for(int i=1;i<n+1;i++) {
			arrlist.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx=0;
		while(!arrlist.isEmpty()) {
			int i=idx+k-1;
			while(i>=n)
				i-=n;
			sb.append(arrlist.get(i));
			arrlist.remove(i);
			n-=1;
			if(!arrlist.isEmpty()) sb.append(", ");
			idx=i;
		}
		sb.append(">");
		System.out.println(sb);
	}

}
