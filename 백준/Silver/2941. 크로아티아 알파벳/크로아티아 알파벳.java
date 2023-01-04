import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int cnt =0;
		for(int i=0;i<arr.length;i++) {
			int idx = str.indexOf(arr[i]);
			if(idx>-1) {
				str= str.replace(arr[i],"0");
			}
		}
		System.out.println(str.length());
	}
}
