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
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());
		Set<String> noli = new HashSet<>();
		Set<String> resultSet = new HashSet<>();
		for(int i=0;i<N;i++) {
			noli.add(br.readLine());
		}
		for(int j=0;j<M;j++) {
			String str=br.readLine();
			if(noli.contains(str))
					resultSet.add(str);
		}
		ArrayList<String> resultarr = new ArrayList<>(resultSet);
		Collections.sort(resultarr);
		System.out.println(resultarr.size());
		for(int y=0;y<resultarr.size();y++) {
			System.out.println(resultarr.get(y));
		}
	}
}
