import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n,count;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		arr=new int[n];
		backtracking(0);
		System.out.println(count);
	}
	static void backtracking(int depth) {
		if(depth==n) {
			count++;
			return;
		}
		else {
			for(int i=0;i<n;i++) { //열
				arr[depth]=i; //depth 행
					if(isGood(depth)) {
						backtracking(depth+1);
					}
				
			}
		}
	}
	static boolean isGood(int depth) {
		for(int i=0;i<depth;i++) {
			if(arr[depth]==arr[i]) {
				return false;
			}
			else if(Math.abs(depth-i) == Math.abs(arr[depth]-arr[i])){
				return false;
			}
		}
		return true;
	}
}