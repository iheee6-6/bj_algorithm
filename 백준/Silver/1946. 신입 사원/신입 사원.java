import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<num;i++) {
			int per = Integer.parseInt(br.readLine());
			arr= new int[per][2];
			for(int j=0;j<per;j++) {
				st= new StringTokenizer(br.readLine());
				arr[j][0]=Integer.parseInt(st.nextToken());
				arr[j][1]=Integer.parseInt(st.nextToken());
			}
			/*Arrays.sort(arr,new Comparator<int[]>() {
				@Override
				public int compare(int[] arr1, int[] arr2) {
					return arr1[0]-arr2[0] ;
				}
			});*/
			sort(0);
			int zeroSecond= arr[0][1]; //서류 점수 1등자의 면접등수
			int count=0;
			for(int k=0;k<per;k++) {
				if(arr[k][1]<=zeroSecond) {
					zeroSecond=arr[k][1]; count++;
				}
			}
			System.out.println(count);
		}
	}
	static void sort(int n) {
		 Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return arr1[n]-arr2[n] ;
			}
		});
	}

}