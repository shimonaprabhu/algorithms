import java.util.*;

class Graph
{
	int i,j,w;
}

class tree
{
	int s,r,t;
}


class kruskal
{
	public static void main(String args[])
	{
		int n,m;
		Scanner br=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n=br.nextInt();
		System.out.println("Enter the number of edges");
		m=br.nextInt();
		Graph e[]=new Graph[m+1];
		System.out.println("Enter the nodes with their corresponding source, destination and weights");
		for(int a=0;a<m;a++)
		{
			e[a]=new Graph();
			e[a].i=br.nextInt();
			e[a].j=br.nextInt();
			e[a].w=br.nextInt();
		}
		kruskal k=new kruskal();
		k.display(e,m);
		k.kruskalinit(e,m,n);
	}


	void display(Graph e[],int m)
	{	System.out.println("\nThe graph is as follows:");
		for(int a=0;a<m;a++)
		{
			System.out.println("Edge going from "+e[a].i+" to "+e[a].j+" having weight "+e[a].w);
		}
	}



	void kruskalinit(Graph e[],int m,int n)
	{
		tree t[]=new tree[n+1];
		int count=0,k=0,sum=0;
		int pos,u,v,i,j;
		int parent[]=new int[n+1];
		for(int a=0;a<n;a++)
		parent[a]=a;
		
		while(count!=n-1)
		{
			pos=minedge(e,m);
			if(pos==-1)
			{
				break;
			}
			u=e[pos].i;
			v=e[pos].j;
			i=find(u,parent);
			j=find(v,parent);
			if(i!=j)
			{
				t[k]=new tree();
				t[k].s=u;	
				t[k].r=v;
				t[k].t=e[pos].w;
				k++;
				count++;
				sum=sum+e[pos].w;
				union(i,j,parent);
			}
			e[pos].w=999;
			}
			if(count==n-1)
			{	System.out.println("\nThe minimum spanning tree is as follows:");
				for(int a=0;a<k;a++)
					System.out.println("Edge going from "+t[a].s+" to "+t[a].r+" having weight "+t[a].t);
				System.out.println("\nThe weight of the spanning subgraph is : "+sum);
			}
			else
				System.out.println("Spanning subtree is not possible");
		
	}


	int minedge(Graph e[],int m)
	{
		
		int small=999;
		int pos=-1;
		for(int i=0;i<m-1;i++)
		{
			if(e[i].w<small)
			{
				small=e[i].w;
				pos=i;
			}
		}
		return pos;
	}



	int find(int v,int parent[])
	{
		while(parent[v]!=v)
			v=parent[v];
		return v;
	}


	void union(int i,int j, int parent[])
	{
		if(i<j)
			parent[j]=i;
		else
			parent[i]=j;
	}
}
