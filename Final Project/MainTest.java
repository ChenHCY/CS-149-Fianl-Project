// This file is for support test Compare the Execution time with different array size in the Merge sort and Quicksort

package FinalProject;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MainTest {

	public static void main(String[] args) throws InterruptedException
	{
		//the part for create Random List============================================
		int[] list = new int[50000];                                                                       
		System.out.println("Random Array of Integers: ");
		for (int i=0 ; i < list.length; i++)
		{
			list[i] = new Random().nextInt(10);
			System.out.print(list[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		// the merge sort part============================================================
		long Mstart = System.currentTimeMillis(); // for the merge sort
		for (int i = 0; i <5; i++) {
				Thread.sleep(60);
		}
		
		int[] mergeSortResult = list;
		
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
		
		//the  Execution Time part:
	    long Mend = System.currentTimeMillis();
	    System.out.println("The Execution Time of Merge Sort Used is: ");
        float sec = (Mend - Mstart) / 1000F; System.out.println(sec + " seconds");
	 
	 
        //the quick sort out put part================================================
		long Qstart = System.currentTimeMillis(); // for the merge sort
		for (int i = 0; i <5; i++) {
			 Thread.sleep(60);
		}
		
		int[] quickSortResult = list;
		
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
		
	     
	     //the  Execution Time part:
	     long Qend = System.currentTimeMillis();
	     System.out.println("The Execution Time of Quick Sort used is: ");
         float Qsec = (Qend - Qstart) / 1000F; System.out.println(Qsec + " seconds");
	}
}
