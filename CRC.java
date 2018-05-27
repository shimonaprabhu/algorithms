import java.util.*;
class CRC
    {
        int sender()
        {
            Scanner br=new Scanner(System.in);
            int gen[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1}, data[]=new int[32],datafunc[]=new int[32],datacheck[]=new int[32];
	System.out.println("CRC CCIT is:");
        for(int i=0;i<16;i++)
                System.out.print(gen[i]);
	System.out.println();
            System.out.println("Enter size of message");
            int n=br.nextInt();
            System.out.println("Enter the message from the sender side");
            for(int i=0;i<n;i++)
                data[i]=br.nextInt();
            for(int i=n;i<32;i++)
                data[i]=0;
            for(int c=0;c<32;c++)
                datafunc[c]=data[c];
            xor(datafunc,gen);
            
        System.out.println("Enter the message from the reciever side");
       
	
	return reciever(datafunc,datacheck,gen,n);

    }

    
    int reciever(int datafunc[],int data[],int gen[],int n)
    {
        Scanner br=new Scanner(System.in);
        for(int i=0;i<n;i++)
            data[i]=br.nextInt();
        for(int i=n;i<32;i++)
            data[i]=datafunc[i];
       
        for(int c=0;c<32;c++)
            datafunc[c]=data[c];
        xor(datafunc,gen);
        int count=0;
        for(int c=0;c<32;c++)
        {
            if(datafunc[c]==0)
                count++;
        }
        return count;
    }

    void xor(int datafunc[],int gen[])
    {
         int low=0,high=16,i=0;
        for(int a=0;a<16;a++)
        {
            if(datafunc[0]==0)
                {
                    while(datafunc[low]==0&&high<32)
            { 
                low++;
                high++;
                a++;
            }
            }
            for(int j=low;j<=high&&high<32;j++)
            {
                datafunc[j]= datafunc[j]^gen[i];
                i++;
            
            }
            low++;
            high++;
            i=0;
            if(high<32)
            {
                while(datafunc[low]==0&&high<32)
                { 
                    low++;
                    high++;
                    a++;
                }
                if(datafunc[low]==1)
                { 
                    continue;
                }
            }
        }
    }

    public static void main(String args[])
    {
       CRC obj=new CRC();
        int check= obj.sender();
        

	if(check==32)
            System.out.println("No error");
        else
            System.out.println("Error!!");
    }
}




