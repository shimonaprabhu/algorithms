import java.util.*;
class prim
{
    
public static void main(String args[])
        {
                int n;
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
				if(nodes[i][j]==0)
					nodes[i][j]=999;
                        }
                }
		prim p=new prim();
		p.primfind(n,nodes);
        }

	void primfind(int n, int nodes[][])
	{
		int visited[]=new int[n+2];
		int u=0,v=0,min,total=0;
		visited[1]=1;
		System.out.println("The minimum spanning tree is as follows:");
		for(int counter=1;counter<n;counter++)
		{
			min=999;
			for(int i=1;i<=n;i++)
			{
				if(visited[i]==1)
				{
					for(int j=1;j<=n;j++)
					{
						if(visited[j]!=1)
						{
							if(min>nodes[i][j])
							{
								min=nodes[i][j];
								u=i;
								v=j;
							}
						}
					}
				}
			}
			visited[v]=1;
			total=total+min;
			System.out.println("Path from "+u+" to "+v);
		}
		System.out.println("Minimum cost of the spanning tree: "+total);
	}
}







