import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int mincount=Integer.MAX_VALUE;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][m]; // w=1,b=0
		for (int i = 0; i < n; i++) {
			String[] strarr = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				String str = strarr[j];
				if (str.equals("W"))
					arr[i][j] = 1;
				else
					arr[i][j] = 0;
			}
		}

		for (int i = 0; i < n-7; i++) {
			for (int j = 0; j < m-7; j++) {
				find(i,j);
			}
		}
		System.out.println(mincount);
	}
	
	static void find(int i,int j) {
		int check=arr[i][j]==1?0:1;
		int count=0;
		for(int k=i;k<i+8;k++) {
			for(int z=j;z<j+8;z++) {
				if(arr[k][z]!=check) count++;
				 check=(check==1)?0:1;
			} 
			check=(check==1)?0:1;
		}
		count =Math.min(count, 64-count);
		if(mincount>count) mincount=count;
	}
}
