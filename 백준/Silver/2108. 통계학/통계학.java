import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		long sum = 0;
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);
		// System.out.println(String.format("%.1d",sum/t)); 틀림
		System.out.println((int) Math.round((double) sum / t));
		System.out.println(arr[t / 2]);
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			// 숫자가 한번 나올 때마다 1이 추가됨.
			map.put(num, map.getOrDefault(num, 0) + 1);
			max = Math.max(max, map.get(num));
		}
		ArrayList<Integer> arr2 = new ArrayList<>();
		int temp = 0;
		for (int key : map.keySet()) {
			if (max == map.get(key)) {
				arr2.add(key);
			}
		}

		Collections.sort(arr2);
		if (arr2.size() > 1) {
			System.out.println(arr2.get(1));
		} else {
			System.out.println(arr2.get(0));
		}

		System.out.println(arr[t - 1] - arr[0]);

	}

}
