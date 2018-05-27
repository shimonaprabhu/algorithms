import java.util.*;
class bellmanford
{
    public static void main(String args[])
    {
        bellmanford obj=new bellmanford();
        Scanner br=new Scanner(System.in);
        System.out.println("Enter the no of nodes");
        int n=br.nextInt();
        System.out.println("Enter the source");
        int s=br.nextInt();
        int dist[]=new int[n+2];
        String str[]=new String[n+2];
        int a[][]=new int[n+2][n+2];
        
        System.out.println("Enter the adjacency matrix");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                a[i][j]=br.nextInt();
            }
        }
        
        for(int i=1;i<=n;i++)
        dist[i]=a[s][i];
        for(int i=1;i<=n;i++)
        str[i]="";
        for(int k=3;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
            {
                if(i!=s)
                {
                for(int j=1;j<=n;j++)
                {
                    if(dist[i]>dist[j]+a[j][i])
                    {
                        dist[i]=dist[j]+a[j][i];
                         obj.find(j,str,s,n,i);
                        }
                            
                            

                    }
                }
            }
        
        
    }
    obj.display(s,str,n,dist);
}

void find(int j,String str[], int s,int n,int i)
{
    for(int a=1;a<=n;a++)
    {
        if(str[i]=="")
        str[i]=Integer.toString(j);
       if(j==a)
        {
            
                         str[i]=str[a]+Integer.toString(j);
                        }              
                    }
                }
                void display(int s,String str[],int n,int dist[])
                {
                    System.out.println("The shortest path lengths are as follows");
                    
               for(int i=1;i<=n;i++)
               {
                   if(i!=s)
                   {
                       if(str[i]=="")
                       {
                           System.out.print(s+"-->"+i);
                           System.out.println("\tPath length is "+dist[i]);
                        }
                        else
                        {
                            System.out.print(s+"-->");
                            for(int a=0;a<str[i].length();a++)
                            System.out.print(str[i].charAt(a)+"-->");
                           System.out.print(i); 
                           System.out.println("\tPath length is "+dist[i]);
                        }
                    }
                    
}
}
}


