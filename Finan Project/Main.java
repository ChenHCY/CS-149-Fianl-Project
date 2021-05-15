package Package;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for (int i = 0; i <5; i++) {
			Thread.sleep(60);
		}

		int[] list = new int[50];                                                                       
		System.out.println("Random Array of Integers: ");
		
		for (int i=0 ; i < list.length; i++)
		{
			list[i] = new Random().nextInt(100);
			System.out.print(list[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		int[] mergeSortResult = list;
		int[] quickSortResult = list;
		
		ForkJoinPool pool = new ForkJoinPool (Runtime.getRuntime().availableProcessors());
		
		//the merge sort part
		MergeSort mergetSort = new MergeSort(mergeSortResult);
		pool.invoke(mergetSort);
		
		//the merge sort output part
		System.out.println();
		System.out.print("The Merge Sort result is:========================================= ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(mergeSortResult[i] + " ");
		}
		System.out.println();
		
		//================the check part for the merge sort===============================
		System.out.print("Used the for-loop to check the Merge sort correct or not:  ");
		for(int k = 0; k < mergeSortResult.length-1; k++)
		{ //used the for-loop to check the merge sort correct or not
	            if(mergeSortResult[k] > mergeSortResult[k+1])
	            {
	            	System.out.println("Merge Sort is Not correct");
	                return;
	            } 
	     }
	     System.out.println("Merge Sort is correct");
		

		//the quick sort out put part
		QuickSort quickSort = new QuickSort(quickSortResult);
	
		//the quick sort out put part
		System.out.println();
		System.out.print("The Quick Sort result is: ========================================");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(quickSortResult[i] + " ");
		}
		System.out.println();
		
		//================the check part for the quick sort  =================================
		System.out.print("Used the for-loop to check the Qicuk sort correct or not:  ");
		for(int k = 0; k < quickSortResult.length-1; k++)
		{ //used the for-loop to check the Quick sort correct or not
			if(quickSortResult[k] > quickSortResult[k+1])
	        { 
				System.out.println("Quick sort is Not correct");
				return;
	        } 
	 
	     }
	     System.out.println("Quick Sort is correct");
	     
	     //the  Execution Time part:
	     long end = System.currentTimeMillis();
	     System.out.println("\n\nExecution Time: ");
         float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
	}
}
