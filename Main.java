package Package;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.List;

public class Main {

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
	
	 public static void mergeSort(int a[], int low, int hi){
	        if (low < hi) {
	            //Finding the mid of array
	            int mid = (low+hi)/2;
	            //Sorting left side of array
	            mergeSort (a,low,mid);
	            //Sorting right side of array
	            mergeSort(a,mid+1,hi);
	            //Going through the merge step
	            merge(a,low,mid,hi);
	        }
	    }
	
	 public static void merge(int a[], int low,int mid, int hi)
	    {
	        
	        int n = hi-low+1;
	        //Making a new  temp. array to store in
	        int [] b = new int[100]; 
	        
	        //Defining the left, right, and index of b
	        int left=low, right = mid+1, bIdx=0;
	        
	        
	        //Merges the array by checking the left and right side of each integer 
	        while (left <=mid && right <=hi)
	        {
	            if (a[left] <= a[right])
	                b[bIdx++] = a[left++];
	            else
	                b[bIdx++] = a[right++];
	        }
	        
	        while (left <=mid)
	            b[bIdx++] = a[left++];
	        while (right<=hi)
	            b[bIdx++] = a[right++];
	        
	         //Result is copied into a[]
	         for (int k=0; k < n; k++)
	             a[low+k] = b[k];
	         
	    }
	    
	 class MergeSortTask extends RecursiveAction 
	 {
	 static final int THRESHOLD = 10;
	 private int leftsub;
	 private int rightsub;
	 private int[] list;
	 
	 public MergeSortTask(int list [], int leftsub, int rightsub) {
	 this.list = list;
	 this.leftsub = leftsub;
	 this.rightsub = rightsub;
	 }
	 
	 @Override
	 protected void compute() {
		
	 if (list.length >= THRESHOLD)
	 {
		 int mid = (leftsub + rightsub) / 2;
		
		 MergeSortTask leftArr = new MergeSortTask(list, leftsub, mid);
		 
		 MergeSortTask rightArr = new MergeSortTask(list, mid+1, rightsub);
		 invokeAll(leftArr,rightArr);
		 
		// ForkJoinTask leftArr = new ForkJoinTask(leftArr);
		// quickSort(list,0,list.length-1);
		 
		// rightArr.fork();
		merge(list, leftsub, mid, rightsub);
		 
		 
	 }
	
	
	
	 }
	
	 }
	
	public static void main(String[] args) {
		
		int[] list = new int[10];                                                                       
		System.out.println("Random Array of Integers: ");
		
		for (int i=0 ; i < list.length; i++)
		{
			list[i] = new Random().nextInt(100);
			System.out.print(list[i]);
			System.out.print(" ");
		}
		
		System.out.println("\nLeft Subarray is: ");
		ForkJoinPool pool=new ForkJoinPool();
		// MergeSortTask quickSort = new MergeSortTask (list, 0, 0);
		
		System.out.println();
		
		//System.out.println(new ForkJoinPool().invoke(MergeSortTask));
		
	}

}
