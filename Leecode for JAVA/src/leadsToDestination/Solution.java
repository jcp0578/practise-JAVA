package leadsToDestination;

import java.util.ArrayList;

/*
 * 4. 从始点到终点的所有路径
 * DFS
 * AC
 */
public class Solution {
	boolean[] visit;
	ArrayList<ArrayList<Integer>> path;
	int des;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    	this.path=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
        	this.path.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++)
        {
        	this.path.get(edges[i][0]).add(edges[i][1]);
        }
        this.des=destination;
        this.visit =new boolean[n]; 
        return DFS(source);
    	
    }
	private boolean DFS(int node) {
		if(this.visit[node])
			return false;
		int len=this.path.get(node).size();
		if(len==0)
		{
			if(node==this.des)
				return true;
			else
				return false;
		}
		this.visit[node]=true;
		for(int i=0;i<len;i++)
		{
			int next_node=this.path.get(node).get(i);
			if(DFS(next_node))
				continue;
			else
				return false;
		}
		this.visit[node]=false;
		return true;
	}
	public static void main(String[] args) {
		int n=2;
		int[][] edges = {{0,1},{0,2}};
		int source=0;
		int destination=2;
		Solution test=new Solution();
		System.out.println(test.leadsToDestination(n,edges,source,destination));


	}

}
