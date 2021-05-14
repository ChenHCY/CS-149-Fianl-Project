package FinalProject;

public class SortBasic 
{
	//the basic merge sort part
	private void merge(int[] leftArr, int[] rightArr, int[]Arr)
	{
		int a = 0, b = 0, c = 0;
		
		do  
		{
			if(leftArr[a] < rightArr[b])
			{
			Arr[c] = leftArr[a];
			c++; 
			a++;
		} else {
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
	
	//the quick sort part
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
