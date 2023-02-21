import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			map.put(str[0],str[1].equals("enter")?1:-1 );
		}
		ArrayList<String> arr = new ArrayList<>(map.keySet());
		Collections.sort(arr,Collections.reverseOrder());
		
		for(String a:arr) {
			if(map.get(a)==1) System.out.println(a);
		}
	}

}