package FianlProject;

public class MergeSort<T extends Comparable>
{
	
	private final T[] items, aux;

    public MergeSort(T[] items)
    {
        this.items = items;

        /* We have to make aux a distinct array from items */
        this.aux = (T[]) new Comparable[items.length];
    }

    public void sort()
    {
        this.sort(0, this.items.length - 1);
    }

    private void sort(int low, int high)
    {
        if (low >= high)
        {
           //Were done sorting this section, do nothing 
            return;
        }

       
        int mid = low + ((high - low) / 2);
        this.sort(low, mid);
        this.sort(mid + 1, high);
        this.merge(low, mid, high);
    }

    /**
     * Merge the values from low - high into the main array
     *
     * @param low  The starting point of the merge
     * @param mid  The dividing index to divide the arrays by
     * @param high The ending point of the merge
     */
    private void merge(int low, int mid, int high)
    {
        int i = low;        // Index value in main array

        int j = low;        // Index to the first half of the aux array
        int k = mid + 1;    // Index to the second half of the aux array

        /* Update the aux Array */
        for (int x = low; x <= high; x++)
        {
            this.aux[x] = this.items[x];
        }

        while (j <= mid || k <= high)
        {
            if (j > mid)
            {
                /* The first half is already finished, lets just go through the second half */
                this.items[i] = this.aux[k++];
            }
            else if (k > high)
            {
                /* The second half is already finished, lets just go through the first half */
                this.items[i] = this.aux[j++];
            }
            else if (this.aux[j].compareTo(this.aux[k]) > 0)
            {
                /* If aux[j] is > aux[k] */
                this.items[i] = this.aux[k++];
            }
            else
            {
                /* If aux[j] is <= aux[k] */
                this.items[i] = this.aux[j++];
            }

            i++;    // Increment the position we're at in the main array
        }
    }

    public T[] getSortedItems()
    {
        return this.items;
    }

}
