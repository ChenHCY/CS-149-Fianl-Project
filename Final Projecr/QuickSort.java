package FinalProject;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction
{
	private int [] list;
	
	public QuickSort(int[] list)
	{
		this.list = list;
	}
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		int THRESHOLD = 10;
		if (list.length <= THRESHOLD) 			
		{ 		
			quickSort(list, 0, list.length);	
		
		}
		else
		{		
			int mid = list.length / 2;
			//the quick sort part
			int [] leftQuick = Arrays.copyOfRange(list, 0 ,mid);
			int [] rightQuick = Arrays.copyOfRange(list, mid, list.length);
		
			QuickSort quickL = new QuickSort (leftQuick);
			QuickSort quickR = new QuickSort (rightQuick);

			quickSort(list, 0, list.length-1);
			
			return;
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

}
