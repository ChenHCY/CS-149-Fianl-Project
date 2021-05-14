package Package;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction
{
	private int [] list;
	
	public MergeSortTask(int[] list)
	{
		this.list = list;
	}
	
	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		int THRESHOLD = 10;
		if (list.length <= THRESHOLD) 			
		{ 		
		mergesort(list);	
		
		}
		else
		{		
		int mid = list.length / 2;
		
		//the merge sort part
		//int [] leftsub = Arrays.copyOfRange(list, 0 ,mid);
		//mergesort(leftsub);
		//int [] rightsub = Arrays.copyOfRange(list, mid, list.length);
		//mergesort(rightsub);
		
        //MergeSortTask Ltask = new MergeSortTask (leftsub);	
		//MergeSortTask Rtask = new MergeSortTask (rightsub);
		//mergesort(list);
		//merge(list, leftsub,rightsub);
		
		//the quick sort part
		int [] leftQuick = Arrays.copyOfRange(list, 0 ,mid);
		int [] rightQuick = Arrays.copyOfRange(list, mid, list.length);
	
		
		MergeSortTask quickL = new MergeSortTask (leftQuick);
		MergeSortTask quickR = new MergeSortTask (rightQuick);

		quickSort(list, 0, list.length-1);
		
		return;
		
		//invokeAll(Ltask,Rtask);
		//mergesort(list);
		//merge(list, leftsub,rightsub);
		//return;
	}
	}
	
	
	private void merge(int [] Arr, int[] leftArr, int[] rightArr)
	{
	int a = 0;
	int b = 0;
	int c = 0;
	
	do  
	{
		if(leftArr[a] < rightArr[b])
		{
			Arr[c] = leftArr[a];
			c++; 
			a++;
		}
		else
		{
			Arr[c] = rightArr[b];
			c++; 
			b++;
		}
	} while (a < leftArr.length && b < rightArr.length);
	
	
	while (a < leftArr.length)
	{
		Arr[c] = leftArr[a];
		c++; 
		a++;
	}
	
	while (b < rightArr.length)
	{
		Arr[c] = rightArr[b];
		c++; 
		b++;
	}
	}
	
	
	private void mergesort(int[] list)
	{
		if (list.length <= 1)
		return;	
		int mid = list.length / 2;
		int[] leftArr = Arrays.copyOfRange(list, 0, mid);
		int[] rightArr = Arrays.copyOfRange(list, mid, list.length);
		
		mergesort(leftArr);
		mergesort(rightArr);
		
		merge(list, leftArr,rightArr);
		
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

