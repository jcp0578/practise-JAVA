package huawei2;

import java.util.Scanner;

public class Main {
	static int _out;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			Node[] node=new Node[5];
			for(int i=0;i<5;i++)
			{
				int x=in.nextInt();
				int y=in.nextInt();
				node[i]=new Node(x,y);
			}
			_out=Integer.MAX_VALUE;
			Node node_o=new Node(0,0);
			double dis_t=0;
			boolean[] visit=new boolean[5];
			
			DSF(visit,node,dis_t,node_o);
			
			System.out.println(_out);
		}

	}
	private static void DSF(boolean[] visit, Node[] node, double dis_t,Node last) {
		
		boolean end_flag=true;
		for(int i=0;i<5;i++)
		{
			if(visit[i])
				continue;
			end_flag=false;
			visit[i]=true;
			double dis_temp=dis_t;
			dis_temp+=dis(node[i],last);  //¼ÓÉÏ´Ë¶Î¾àÀë
			DSF(visit,node,dis_temp,node[i]);
			visit[i]=false;
		}
		if(end_flag)
		{
			double dis_temp=dis_t;
			dis_temp+=dis(last,new Node(0,0));
			_out=Math.min(_out, (int)dis_temp);
		}
		return ;
	}
	static double dis(Node o1,Node o2)
	{
		return  Math.sqrt((o1.x-o2.x)*(o1.x-o2.x)+(o1.y-o2.y)*(o1.y-o2.y));
		
	}

}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}