package Package;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main  {

	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 long start = System.currentTimeMillis();
	      for (int i = 0; i <5; i++) {
	         Thread.sleep(60);
	      }
	     
			int[] list = new int[8];                                                                       
			System.out.println("Random Array of Integers: ");
			
			for (int i=0 ; i < list.length; i++)
			{
				list[i] = new Random().nextInt(100);
				System.out.print(list[i]);
				System.out.print(" ");
			}
			
			int[] mergeSortResult = list;
			int[] quickSortResult = list;
			
			ForkJoinPool pool = new ForkJoinPool (Runtime.getRuntime().availableProcessors());
			
			//the merge sort part
			MergeSortTask mergetSort = new MergeSortTask(mergeSortResult);
			pool.invoke(mergetSort);
			
			//the merge sort output part
			System.out.println();
			System.out.print("After Merge Sort, the result is: ");
			System.out.println();
			for(int i= 0; i<list.length; i++) {
				System.out.print(mergeSortResult[i] + " ");
			}

		
			//the quick sort out put part
			QuickSortTask quickSort = new QuickSortTask(quickSortResult);
			//the quick sort out put part
			System.out.println();
			System.out.print("After Quick Sort, the result is: ");
			System.out.println();
			for(int i= 0; i<list.length; i++) {
				System.out.print(quickSortResult[i] + " ");
			}
			
			
			 long end = System.currentTimeMillis();
				
				System.out.println("\n\nExecution Time: ");
				float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
				
			//the check part
			
		}

}
