package Package;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;



class MergeSortTest {
	@Test
	void test() throws InterruptedException {
		
		int [] list = {5,2,4,1,3,6};
		int [] checklist = {1,2,3,4,5,6};
		mergesort(list);
		assertArrayEquals(list, checklist);		
		
         
         
         
		int mid = list.length / 2;
		//the merge sort part
		int [] leftsub = Arrays.copyOfRange(list, 0 ,mid);
		mergesort(leftsub);
		int [] rightsub = Arrays.copyOfRange(list, mid, list.length);
		mergesort(rightsub);
	
        MergeSortTask Ltask = new MergeSortTask (leftsub);	
		MergeSortTask Rtask = new MergeSortTask (rightsub);
		mergesort(list);
		merge(list, leftsub,rightsub);
		
		
	
		
		int[] mergeSortResult = list;
		System.out.println();
		System.out.print("After Merge Sort, the result is: ");
		System.out.println();
		for(int i= 0; i<list.length; i++) {
			System.out.print(mergeSortResult[i] + " ");
		}

	}
	
         
private void merge(int [] Arr, int[] leftArr, int[] rightArr)
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
	
	merge(list, leftArr,rightArr);
	
}


}