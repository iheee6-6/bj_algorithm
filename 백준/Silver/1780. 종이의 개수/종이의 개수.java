import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static 	int[][] arr ;
	static int mo=0;
	static int z=0;
	static int one=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		check(0,0,n-1,n-1);

		System.out.println(mo);
		System.out.println(z);
		System.out.println(one);
	}

	static void check(int sx,int sy,int ex,int ey) {
		int value= arr[sx][sy];
		boolean same=true;
		for (int i = sx; i <= ex; i++) {
			for (int j = sy; j <= ey; j++) {
				if(value!=arr[i][j]) {
					int size=(ex-sx+1)/3;
					check(sx,sy,ex-size*2,ey-size*2);
					check(sx,sy+size,ex-size*2,ey-size);
					check(sx,sy+size*2,ex-size*2,ey);
					
					check(sx+size,sy,ex-size,ey-size*2);
					check(sx+size,sy+size,ex-size,ey-size);
					check(sx+size,sy+size*2,ex-size,ey);
					
					check(sx+size*2,sy,ex,ey-size*2);
					check(sx+size*2,sy+size,ex,ey-size);
					check(sx+size*2,sy+size*2,ex,ey);
					same=false;
					return;
				}
			}
		}
		if(same) {
			switch(value){
			case 0: z++; break;
			case 1: one++; break;
			case -1:mo++; break;
		}
		}
	}
}
