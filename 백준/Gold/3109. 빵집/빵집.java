import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static char[][] map;

	static int result=0;
	static int[] dx= {-1,0,1}; //오른쪽위, 오른쪽, 오른쪽아래
	static int[] dy= {1,1,1};
	static boolean[][] visited;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited=new boolean[r][c];
		for (int i = 0; i < r; i++) {
			char[] arr= br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = arr[j];
			}
		}

		for (int i = 0; i < r; i++) {
			check=false; //길을 완성했는지 여부
			dfs(i, 0);
		}
		
		System.out.println(result);
	}

	static void dfs(int x, int y) {
		if(y==c-1) {
			result++;
			check=true;
			visited[x][y]=true;
			return;
		}
		
		for(int i=0;i<3;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<0||yy<0||xx>=r||yy>=c||visited[xx][yy]||map[xx][yy]!='.') continue;
			dfs(xx,yy);
			if(check) { //길 완성했으면 더 이상 움직이지 않아도 됨
				visited[xx][yy]=true;
				return;
			}else { //길 완성 못하면 이 길은 실패라는 표시
				visited[xx][yy]=true;
			}
		}
	}

}
