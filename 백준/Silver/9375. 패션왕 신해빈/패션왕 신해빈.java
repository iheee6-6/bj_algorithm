import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());

		for(int i=0;i<t;i++) {
			int c = Integer.parseInt(br.readLine());
			Map<String,Integer> map = new HashMap<>();
			for(int j=0;j<c;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String kind = st.nextToken();
				map.put(kind, map.get(kind)!=null? map.get(kind) +1:1);
			}
			int mul=1;
			for(String str :map.keySet()) {
				mul*=map.get(str)+1;
			}
			System.out.println(mul-1);
		}
	}

}
