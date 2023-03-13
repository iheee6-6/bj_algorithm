import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++)
			set.add(Integer.parseInt(st.nextToken()));
		
		ArrayList<Integer> arrlist = new ArrayList<>(set);
		Collections.sort(arrlist);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arrlist.size();i++) {
			sb.append(arrlist.get(i));
			if(i!=arrlist.size()-1)
				sb.append(" ");
		}
		System.out.println(sb);
	}

}
