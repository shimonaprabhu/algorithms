import java.util.*;
class Knapsack_greedy
{


public static void main(String args[])
{
        int W;
        int n;
        Knapsack_greedy obj=new Knapsack_greedy();
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
        double totalw=W,totalv=0,temp;int temp1;
        double ratio[]=new double[n+2];
        for(int i=1;i<=n;i++)
                ratio[i]=((double)v[i])/w[i];
	for(int i=1;i<=n;i++)
        {
                for(int j=1;j<=n-1;j++)
                {
                        if(ratio[j]<ratio[j+1])
                        {
                                temp=ratio[j];
                                ratio[j]=ratio[j+1];
                                ratio[j+1]=temp;
				temp1=v[j];
				v[j]=v[j+1];
				v[j+1]=temp1;
				temp1=w[j];
                                w[j]=w[j+1];
                                w[j+1]=temp1;
                        }
                }
        }
        for(int i=1;i<=n;i++)
        {
                if(totalw>=w[i])
                {
                        totalv=totalv+v[i];
                        totalw=totalw-w[i];
                        System.out.println("Item "+i+" was added completely with weight "+w[i]+" and value "+v[i]);
                }
                else
                {
                        totalv=totalv+(totalw*(ratio[i]));
                        System.out.println("Item "+i+" was added partially, i.e. "+totalw/w[i]+" times with weight "+w[i]+" and value "+totalw*(ratio[i]));
                        totalw=0;
                        break;
                }
        }
        System.out.println("Total amount is : "+totalv+"\nTotal weight left in knapsack : "+totalw);
        }
}
