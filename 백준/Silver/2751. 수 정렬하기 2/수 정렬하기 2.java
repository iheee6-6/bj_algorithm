import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr.get(i)+"\n");
		}
		System.out.println(sb);
	}

}