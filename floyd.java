import java.util.*;
import java.io.*;
class floyd
{
	public static void main(String args[])
	{
		int n;
		floyd obj = new floyd();
		Scanner br=new Scanner(System.in);
		System.out.println("Enter the number of nodes");
		n=br.nextInt();
		int nodes[][]=new int[n+2][n+2];
		System.out.println("Enter the adjacency matrix");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				nodes[i][j]=br.nextInt();
			}
		}
		obj.floyd(nodes,n);
		
	}
	void floyd(int node[][],int n)
	{
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=n;j++)
				{
					if(node[i][j]>(node[i][k]+node[k][j]))
						node[i][j]=node[i][k]+node[k][j];
				}
			}
		}
		System.out.println("The shortest distance for the pairs of vertices are:");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(node[i][j]+" ");
			}
		System.out.println();
		}
	}
}

