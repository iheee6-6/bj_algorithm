import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)  throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st ;
		for(int i=0;i<num;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<num;j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
		}
		arr.sort(Collections.reverseOrder());
		System.out.println(arr.get(num-1));
	}
}