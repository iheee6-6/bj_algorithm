import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int result=Integer.MAX_VALUE;
	static int N, M;

	static class Dot {
		int x;
		int y;
		int num;

		Dot(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		ArrayList<Dot> cctvList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0 && arr[i][j] != 6) {
					cctvList.add(new Dot(i, j, arr[i][j]));
				}
			}
		}

		check(0, arr, cctvList);
		System.out.println(result);

	}

	static void check(int cnt, int[][] arr, ArrayList<Dot> cctvList) {
		if (cnt == cctvList.size()) {
			result = Math.min(result, CountZero(arr));
			return;
		}
		
		int cctvNum = cctvList.get(cnt).num;
		int x = cctvList.get(cnt).x;
		int y = cctvList.get(cnt).y;
		
		int[][] tmp;
		if(cctvNum==1) {
			tmp=copyMap(arr);
			checkLeft(tmp,x,y);
			check(cnt+1,tmp,cctvList);
			
			tmp = copyMap(arr);
			checkRight(tmp,x,y);
			check(cnt+1,tmp,cctvList);
			
			tmp = copyMap(arr);
			checkDown(tmp,x,y);
			check(cnt+1,tmp,cctvList);
			
			tmp = copyMap(arr);
			checkUp(tmp,x,y);
			check(cnt+1,tmp,cctvList);
			
		}else if(cctvNum==2) {
			tmp=copyMap(arr);
			checkLeft(tmp,x,y);
			checkRight(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkDown(tmp,x,y);
			check(cnt+1,tmp,cctvList);
		}else if(cctvNum==3) {
			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkRight(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkDown(tmp,x,y);
			checkRight(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkDown(tmp,x,y);
			checkLeft(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkLeft(tmp,x,y);
			check(cnt+1,tmp,cctvList);
		}else if(cctvNum==4) {
			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkRight(tmp,x,y);
			checkLeft(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkRight(tmp,x,y);
			checkDown(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkDown(tmp,x,y);
			checkLeft(tmp,x,y);
			checkRight(tmp,x,y);
			check(cnt+1,tmp,cctvList);

			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkLeft(tmp,x,y);
			checkDown(tmp,x,y);
			check(cnt+1,tmp,cctvList);
		} 
		else {
			tmp=copyMap(arr);
			checkUp(tmp,x,y);
			checkLeft(tmp,x,y);
			checkRight(tmp,x,y);
			checkDown(tmp,x,y);
			check(cnt+1,tmp,cctvList);
		}
	}

	static void checkLeft(int[][] arr, int x,int y) {
		for(int i=y-1;i>=0;i--) {
			if(arr[x][i]==6) return;
			if(arr[x][i]!=0) continue;
			arr[x][i]=-1;
		}
	}
	

	static void checkRight(int[][] arr, int x,int y) {
		for(int i=y+1;i<M;i++) {
			if(arr[x][i]==6) return;
			if(arr[x][i]!=0) continue;
			arr[x][i]=-1;
		}
	}
	
	static void checkUp(int[][] arr, int x,int y) {
		for(int i=x-1;i>=0;i--) {
			if(arr[i][y]==6) return;
			if(arr[i][y]!=0) continue;
			arr[i][y]=-1;
		}
	}
	
	static void checkDown(int[][] arr, int x,int y) {
		for(int i=x+1;i<N;i++) {
			if(arr[i][y]==6) return;
			if(arr[i][y]!=0) continue;
			arr[i][y]=-1;
		}
	}
	
	static int CountZero(int[][] arr) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	static int[][] copyMap(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}

}
