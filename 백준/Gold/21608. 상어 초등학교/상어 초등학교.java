import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static Queue<Student> q;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Student {
		int x;
		int y;
		int sNum;
		ArrayList<Integer> fList;

		Student(int sNum, ArrayList<Integer> fList) {
			this.sNum = sNum;
			this.fList = fList;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		arr = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n*n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			ArrayList<Integer> tempArr = new ArrayList<>();
			tempArr.add(Integer.parseInt(st.nextToken()));
			tempArr.add(Integer.parseInt(st.nextToken()));
			tempArr.add(Integer.parseInt(st.nextToken()));
			tempArr.add(Integer.parseInt(st.nextToken()));
			q.add(new Student(idx, tempArr));
		}

		for (Student s : q) {
			Find(s);
		}

		int result=0;
		for (Student s : q) {
			int fCount = 0;
			for (int k = 0; k < 4; k++) {
				int xx = s.x + dx[k];
				int yy = s.y + dy[k];
				if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
					if (s.fList.contains(arr[xx][yy]))
						fCount++;
				}
			}
			if(fCount==1) {
				result+=1;
			}else if(fCount>1) {
				result+=Math.pow(10, fCount-1);
			}
		}
		
		System.out.println(result);

	}

	static void Find(Student s) {
		ArrayList<Integer> arrlist = s.fList;
		int maxF = 0;
		int maxEmptyS = 0;
		int seatX = -1;
		int seatY = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != 0)
					continue;
				if(seatX==-1&&seatY==-1) {
					seatX=i;
					seatY=j;
				}
				int f = 0;
				int emptyS = 0;
				for (int k = 0; k < 4; k++) {
					int xx = i + dx[k];
					int yy = j + dy[k];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (arr[xx][yy] == 0)
							emptyS++;
						else if (arrlist.contains(arr[xx][yy]))
							f++;
					}
				}

				if (maxF < f) {
					seatX = i;
					seatY = j;
					maxF = f;
					maxEmptyS = emptyS;
				} else if (maxF == f && maxEmptyS < emptyS) {
					seatX = i;
					seatY = j;
					maxEmptyS = emptyS;
				} else if (maxF == f && maxEmptyS == emptyS && seatX > i) {
					seatX = i;
					seatY = j;
				}

			}
		}
		arr[seatX][seatY] = s.sNum;
		s.x = seatX;
		s.y = seatY;
	}

}
