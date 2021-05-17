package Package;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class QuickSortTask extends RecursiveAction
{
	private int [] list;
	
	public QuickSortTask(int[] list)
	{
		this.list = list;
	}
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		int THRESHOLD = 50;
		if (list.length >= THRESHOLD) 			
		{ 
			bubbleSort(list);
			return;
		}
		else
		{
		int mid = list.length / 2;
		
		int [] leftsub = Arrays.copyOfRange(list, 0 ,mid);
		int [] rightsub = Arrays.copyOfRange(list, mid , list.length);
		
		QuickSortTask Ltask = new QuickSortTask (leftsub);
		QuickSortTask Rtask = new QuickSortTask (rightsub);		
		invokeAll(Ltask,Rtask);
		quickSort(list, 0, list.length-1);
	}
	}
	public static void quickSort(int list[], int low, int hi)
    {
        if (low < hi){
                    
            int pivotIndex = partition (list,low,hi);
  
            quickSort(list,low,pivotIndex-1);
            quickSort(list,pivotIndex+1, hi);
        }
    }
	
	public static int partition (int a[], int i, int j)
	{ //define pivot and empty arrays
	       int p = a[i];
	       int m = i;
	       
	       //goes through the unprocessed numbers
	       for (int k = i+1; k<=j; k++){
	           if (a[k] < p)
	           {
	               m++;
	            //swap(a[k], a[m]);
	               int temp;
	               temp = a[k];
	               a[k] = a[m];
	               a[m] = temp;
	           }
	           
	       }
	            //swap (a[i], a[m]);
	               int temp2;
	               temp2 = a[i];
	               a[i] = a[m];
	               a[m] = temp2;
	           return m;
	 }
	
	
	public static void bubbleSort (int list[])
	{
		 int n = list.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (list[j] > list[j+1])
	                {
	                   
	                    int temp = list[j];
	                    list[j] = list[j+1];
	                    list[j+1] = temp;
	                }
	}
	
}