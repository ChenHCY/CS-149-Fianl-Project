package Package;

public class QuickSort {
	
	
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
