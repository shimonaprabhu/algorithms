import java.util.*;
class Knapsack_Dynamic
{


public static void main(String args[])
{
        int W;
        int n;
        Knapsack_Dynamic obj=new Knapsack_Dynamic();
        Scanner br=new Scanner(System.in);
        System.out.println("Enter the maximum capacity");
        W=br.nextInt();
        System.out.println("Enter the number of items");
        n=br.nextInt();
        System.out.println("Enter the weights of the ith elements");
        int w[]=new int[n+2];
        for(int i=1;i<=n;i++)
                w[i]=br.nextInt();
        System.out.println("Enter the values of the ith elements");
        int v[]=new int[n+2];
        for(int i=1;i<=n;i++)
        v[i]=br.nextInt();
        obj.knapsack(w,v,n,W);
}


void knapsack(int w[],int v[],int n,int W)
{
        int k[][]=new int[n+2][W+2];
        for(int i=0;i<=n;i++)
                k[i][0]=0;
        for(int i=0;i<=W;i++)
                k[0][i]=0;

        for(int i=1;i<=n;i++)
        {
                for(int j=1;j<=W;j++)
                {
                        if(w[i]<=j)
                        {
                                if(k[i-1][j]>(k[i-1][j-w[i]]+v[i]))
                                        k[i][j]=k[i-1][j];
                                else
                                        k[i][j]=k[i-1][j-w[i]]+v[i];
                        }
                        if(w[i]>j)
                                k[i][j]=k[i-1][j];
                }
        }
        System.out.println("The profit table is as follows:");
        for(int i=1;i<=n;i++)
        {
                for(int j=1;j<=W;j++)
                {
                        System.out.print(k[i][j]+"\t");
                }
                System.out.println("");
        }
        System.out.println("The maximum profit is: "+k[n][W]);
	int r=n,s=W;
	int x[]=new int[n+2];
	while(r!=0&&s!=0)
	{
		if(k[r][s]!=k[r-1][s])
		{
			x[r]=1;
			s=s-w[r];
		}
		r=r-1;
	}
	for(int i=1;i<=n;i++)
	{
		if(x[i]==1)
		System.out.println("Item "+i+" is present");
	}
}
}

