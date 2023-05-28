import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int K = Integer.parseInt(st.nextToken());
	        int N = Integer.parseInt(st.nextToken());

	        String[] arr = new String[K];
	        int max = 0;

	        for (int i = 0; i < K; i++) {
	            arr[i] = br.readLine();
	            max = Math.max(max, Integer.parseInt(arr[i]));
	        }

	        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

	        boolean flag = true;

	        StringBuilder answer = new StringBuilder();
	        for (String t : arr) {
	            answer.append(t);
	            if (max == Integer.parseInt(t) && flag) {
	                for (int i = K; i < N; i++) {
	                    answer.append(t);
	                    flag = false;
	                }
	            }
	        }

	        System.out.println(answer);
	}

	
}
