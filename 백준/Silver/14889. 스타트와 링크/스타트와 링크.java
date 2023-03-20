import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] check;
	static int min=Integer.MAX_VALUE;
	static int t;
	static int[][] arr ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		t = Integer.parseInt(br.readLine());
		arr = new int[t][t];
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < t; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[t];
		check(0,0);
		System.out.println(min);
	}
	
	static void check(int idx,int count) {
		if(count==t/2) {
			cul();
			return;
		}
		for(int i=idx;i<t;i++) {
			if(!check[i]) {
				check[i]=true;
				check(i+1,count+1);
				check[i]=false;
			}
		}
	}
	
	static void cul() {
		int team_start=0;
		int team_link=0;
		
		for(int j=0;j<t-1;j++) {
			for(int z=j+1;z<t;z++) {
				if(check[j]==true&&check[z]==true) {
					team_start+=arr[j][z];
					team_start+=arr[z][j];
				}
				else if(check[j]==false&&check[z]==false) {
					team_link+=arr[j][z];
					team_link+=arr[z][j];
				}
			}
		}

		int diff = Math.abs(team_start-team_link);
		if(diff==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, diff);
		
	}

}
