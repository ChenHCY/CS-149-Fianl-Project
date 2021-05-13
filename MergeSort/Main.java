package mergesortthread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

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
		
		System.out.println();
		System.out.print("After Merge Sort is: ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}


}
