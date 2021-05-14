package Package;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction
{ 
	private int [] list;
	
	public MergeSortTask (int[] list)
	{
		this.list = list;
	}
	
	@Override
	protected void compute() 
	{
		// TODO Auto-generated method stub
		int THRESHOLD = 10;
		if (list.length <= THRESHOLD) 			
		{ 		
		    bubbleSort(list);	
		}
		else
		{		
		int mid = list.length / 2;
		
		//the merge sort part
		int [] leftsub = Arrays.copyOfRange(list, 0 ,mid);
		mergesort(leftsub);
		int [] rightsub = Arrays.copyOfRange(list, mid, list.length);
		mergesort(rightsub);
		MergeSortTask Ltask = new MergeSortTask (leftsub);	
		MergeSortTask Rtask = new MergeSortTask (rightsub);
		mergesort(list);
		merge(list, leftsub,rightsub);
		return;
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

