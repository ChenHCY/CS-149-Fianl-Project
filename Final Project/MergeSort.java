package Package;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSort
{	private void merge(int[] leftArr, int[] rightArr, int[]Arr)
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
		merge(leftArr,rightArr,list);
	}
}