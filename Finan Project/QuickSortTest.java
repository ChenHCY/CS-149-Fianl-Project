package Package;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void test() {

			
		int [] list = {5,2,4,1,3,6};
		int [] checklist = {1,2,3,4,5,6};
		quickSort(list, 0 , list.length-1);
		assertArrayEquals(list, checklist);
		
		int[] quickSortResult = list;
		QuickSortTask quickSort = new QuickSortTask(quickSortResult);
		//the quick sort out put part
		quickSort(list, 0, list.length-1);
		System.out.println();
		System.out.print("After Quick Sort, the result is: ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(quickSortResult[i] + " ");
		}
		
	}



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
