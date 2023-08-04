import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int p,m;
	static class Node{
		int level;
		String name;
		Node(int level,String name){
			this.level=level;
			this.name=name;
		}
	}
	static class Room{
		List<Node> users = new ArrayList<>();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ArrayList<Room> rooms  = new ArrayList<>();
		
		for(int i=0;i<p;i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n =st.nextToken();
			boolean flag=false;
			for(Room room : rooms) {
				if(room.users.size()>=m) {
					continue;
				}
				if(!room.users.isEmpty()&&room.users.get(0).level-10<=l&&room.users.get(0).level+10>=l) {
					flag=true;
					room.users.add(new Node(l,n));
					break;
				}
			}
			
			if(!flag) {
				Room room = new Room();
				room.users.add(new Node(l,n));
				rooms.add(room);
			}
		}
		
		for(Room room:rooms) {
			if(room.users.size()==m)
				System.out.println("Started!");
			else 
				System.out.println("Waiting!");
			Collections.sort(room.users,(a,b)->a.name.compareTo(b.name));
			for(Node node :room.users) {
				System.out.println(node.level+" "+node.name);
			}
		}
		
	}

}
