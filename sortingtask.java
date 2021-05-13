package Package;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class sortingtask  {

	private void merge(int[] leftArr, int[] rightArr, int[]Arr)
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
			if (list.length <= 10) 
			{
				mergesort(list);
				return;
			}
			
			int mid = list.length / 2;
			
			int [] leftsub = Arrays.copyOfRange(list, 0 ,mid);
			int [] rightsub = Arrays.copyOfRange(list, mid , list.length);
			
			MergeSortTask Ltask = new MergeSortTask (leftsub);
			MergeSortTask Rtask = new MergeSortTask (rightsub);
			invokeAll(Ltask,Rtask);
			merge(leftsub, rightsub, list);
 		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = new int[10];                                                                       
		System.out.println("Random Array of Integers: ");
		
		for (int i=0 ; i < list.length; i++)
		{
			list[i] = new Random().nextInt(100);
			System.out.print(list[i]);
			System.out.print(" ");
		}
		
		ForkJoinPool pool = new ForkJoinPool (Runtime.getRuntime().availableProcessors());
		MergeSortTask sortingtask = new MergeSortTask(list);
		pool.invoke(sortingtask);
		
		for(int i= 0; i<list.length; i++) {
			System.out.println(list[i] + " ");
		}
	}

}
