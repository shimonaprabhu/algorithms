import java.util.*;

class MergeSort
{
	int a[]=new int[1000000];

	void merge_sort(int low,int high)
	{
	 	int mid;
	 	if(low<high)
	 	{
	 		mid=(low+high)/2;
	  		merge_sort(low,mid);
  			merge_sort(mid+1,high);
  			merge(low,mid,high);
 		}
	}

	void merge(int low,int mid,int high)
	{
	 	int h,i,j,k;
	 	int b[]=new int[1000000];
	 	h=low;
	 	i=low;
	 	j=mid+1;

	 	while((h<=mid)&&(j<=high))
	 	{
	 		if(a[h]<=a[j])
	  		{
	   			b[i]=a[h];
	   			h++;
	  		}
	  		else
	  		{
	   			b[i]=a[j];
	   			j++;
	  		}
	  	i++;
	 	}
	 	if(h>mid)
	 	{
	 	 	for(k=j;k<=high;k++)
	  		{
	   			b[i]=a[k];
	   			i++;
	  		}
	 	}
	 	else
	 	{
	  		for(k=h;k<=mid;k++)
	  		{
	   			b[i]=a[k];
	   			i++;
	  		}
	 	}
 	for(k=low;k<=high;k++) 
		a[k]=b[k];
	}


	public static void main(String args[])
	{
	 	int num,i;
		long startTime,endTime,lapse;
		Scanner br=new Scanner(System.in);
		System.out.println("Enter the number of elements > 5000");
	 	num=br.nextInt();
		Random ab=new Random();
	 	MergeSort obj=new MergeSort();
		for(i=1;i<=num;i++)
	 	{
	  		obj.a[i]=ab.nextInt(10000);
	 	}
		startTime=System.nanoTime();
	 	obj.merge_sort(1,num);
	        endTime=System.nanoTime();
		lapse=endTime-startTime;
		System.out.println("The sort took "+lapse+" nanoseconds:\n");
	
	}
}
