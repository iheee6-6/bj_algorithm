import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int[] arr2 = new int[num];
		int[] arr3 = new int[num];
		int check = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (arr2[i] == arr[j]) {
					arr3[j] = i;
					arr[j]=-1;
					break;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			System.out.print(arr3[i]+" ");
		}
	}

}