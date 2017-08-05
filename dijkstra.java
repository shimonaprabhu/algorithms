import java.util.*;

class dijkstra
{
	public static void main(String args[])
	{
		Scanner br=new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int n=br.nextInt();
		System.out.println("Enter the source vertex");
		int source=br.nextInt();
		int visit[]=new int[n+1];
		int p[]=new int[n+1];
		int d[]=new int[n+1];
		int k=0;
		System.out.println("Enter the adjacenecy matrix of the graph");
		int a[][]=new int[n+1][n+1];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=br.nextInt();
			}
		}

		dijkstra obj=new dijkstra();
		obj.dijkstrafind(a,n,source,visit,p,d);
		System.out.println();
		for(int i=0;i<n;i++)
		{
			if(d[i]==999)
				System.out.println("Node "+i+" is not reachable from "+source);
			else
			{
				k=i;
				System.out.print("The length of the shortest path is : "+d[k]+" from "+source);
				while(k!=source)
				{
					System.out.print("-->"+k);
					k=p[k];
				}
				System.out.println();
			}
		}
	}


	void dijkstrafind(int a[][],int n,int source,int visit[],int p[],int d[])
	{
		for(int i=0;i<n;i++)
		{
			visit[i]=0;
			d[i]=a[source][i];
			p[i]=source;
		}
		visit[source]=1;
		for(int i=1;i<n;i++)
		{
			int min=999,c=-1;
			for(int j=0;j<n;j++)
			{
				if(visit[j]!=1&&d[j]<min)
				{
					min=d[j];
					c=j;
				}
			}
			if(c==-1)
				return;
			visit[c]=1;
			for(int b=0;b<n;b++)
			{
				if(visit[b]!=1&&d[c]+a[c][b]<d[b])
					{
						d[b]=d[c]+a[c][b];
						p[b]=c;
					}
			}
		}
	}
}
