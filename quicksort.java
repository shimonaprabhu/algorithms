import java.util.*;

class QuickSort
{
        static int array[];
        static int num;



	void quickSort(int lowerIndex,int higherIndex)
	{
		int i=lowerIndex;
	        int j=higherIndex;
	        int pivot=array[lowerIndex+(higherIndex-lowerIndex)/2];
		while(i<=j)
        	{
                	while(array[i]<pivot)
                	{
                	        i++;
                	}
                	while(array[j]>pivot)
                	{
                	        j--;
                	}
                	if(i<=j)
                	{
                	        exchangeNumbers(i,j);
                	        i++;
               		        j--;
            		}
        	}
        	if(lowerIndex<j)
        	        quickSort(lowerIndex,j);
        	if(i<higherIndex)
        	    quickSort(i,higherIndex);
	}


	void exchangeNumbers(int i,int j)
	{
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	}



	public static void main(String args[])
	{
	        int i;
	        long startTime,endTime,lapse;
	        Scanner br=new Scanner(System.in);
	        System.out.println("Enter the number of elements > 5000");
	        num=br.nextInt();
	        Random ab=new Random();
	        array=new int[num+2];
	        for(i=0;i<num;i++)
	        {
	                array[i]=ab.nextInt(100);
	        }
	        QuickSort obj = new QuickSort();
	        startTime=System.nanoTime();
	        obj.quickSort(0,num-1);	
	        endTime=System.nanoTime();
	        lapse=endTime-startTime;
	        System.out.println("The sort took "+lapse+" nanoseconds:\n");
	}
}
