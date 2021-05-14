package FinalProject;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = new int[20];                                                                       
		System.out.println("Random Array of Integers: ");
		
		for (int i=0 ; i < list.length; i++)
		{
			list[i] = new Random().nextInt(100);
			System.out.print(list[i]);
			System.out.print(" ");
		}
		
		int[] mergeSortResut = list;
		int[] quickSortResut = list;
		
		ForkJoinPool pool = new ForkJoinPool (Runtime.getRuntime().availableProcessors());
		
		//the merge sort part
		MergeSort mergetSort = new MergeSort(mergeSortResut);
		pool.invoke(mergetSort);
		
		//the merge sort output part
		System.out.println();
		System.out.print("After Merge Sort, the result is: ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(mergeSortResut[i] + " ");
		}

		//the quick sort out put part
		QuickSort quickSort = new QuickSort(quickSortResut);
	
		//the quick sort out put part
		System.out.println();
		System.out.print("After Quick Sort, the result is: ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(quickSortResut[i] + " ");
		}
		
		//the check part
		
	}

}
