import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static boolean[][] visited;
	static int[][] arr;
	static int n;
	static int min=Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n= Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
				min=Math.min(arr[i][j], min);
				max =Math.max(arr[i][j],max);
			}
		}
		for(int i=0;i<=max;i++) {
			visited=new boolean[n][n];
			int count=0;
			for(int j=0;j<n;j++) {
				for(int z=0;z<n;z++) {
					if(!visited[j][z]&&arr[j][z]>i)
						count+= dfs(j,z,i);
				}
			}
			 result=Math.max(result, count);
		}
		
		System.out.println(result);
	}

	static public int dfs(int x,int y,int size) {
		visited[x][y]=true;	
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy= y+dy[i];
			if(xx<0||yy<0||xx>=n||yy>=n||visited[xx][yy]) continue;
			if(arr[xx][yy]>size)dfs(xx,yy,size);
		}
		return 1;
	}
}
