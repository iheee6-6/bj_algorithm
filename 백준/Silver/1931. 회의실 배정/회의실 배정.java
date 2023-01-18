import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		arr= new int[num][2];
		dp= new int[num];
		StringTokenizer st;
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(arr,(arr1,arr2)->arr1[0]>arr2[0]? 1: -1); 이렇게 하면 arr[1]은 고려안하고 정렬됨
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if (arr1[1] == arr2[1]) {
					return arr1[0] - arr2[0];
				}
				return arr1[1] - arr2[1];
			}
		});

		int count = 0;
		int lastTime = 0;
		for (int i = 0; i < num; i++) {
			if (lastTime <= arr[i][0]) {
				count++;
				lastTime = arr[i][1];
			}
		}
		System.out.println(count);
	}
	
}
