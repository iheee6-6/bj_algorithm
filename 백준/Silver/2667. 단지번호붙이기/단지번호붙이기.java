import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    private static int dx[] = {0,0,1,-1};
    private static int dy[] = {1,-1,0,0};
	static int[][] arr;
	static int N;
	static int result;
	static boolean[][] check;
	static List<Integer> count = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.split("")[j]);
			}
		}
		int total=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !check[i][j]) {
					total++;
					result=0;
					dfs(i,j);
					count.add(result);
				}
			}
		}
		System.out.println(total);
		Collections.sort(count);
		for(int i=0;i<count.size();i++)
			System.out.println(count.get(i));

	}

	static void dfs(int x,int y) {
		check[x][y] = true;
		result++;
		for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny >=0 && nx < N && ny < N){
                if(arr[nx][ny] == 1 && !check[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
	}

}