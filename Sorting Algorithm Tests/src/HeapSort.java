//code from GeeksforGeeks
public class HeapSort 
{
	private long count = 0;
	
	public void sort(int arr[], int size)
	{
		//builds the heap
		for(int i = size / 2 - 1; i >= 0; i--)
		{
			//count++;
			heapify(arr, size, i);
		}
		
		//extracts each element from the heap
		for(int j = size - 1; j >= 0; j--)
		{
			count++;
			//moves the current root to the end
			int temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
			
			//calls the max heapify on the reduced heap
			heapify(arr, j, 0);
		}
	}
	
	//heapifies a subtree rooted w/ node i, which is an index in arr, n = size of heap
	public void heapify(int arr[], int size, int i)
	{
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		//if left child is larger than root
		if(left < size && arr[left] > arr[largest])
		{
			count++;
			largest = left;
		}
		
		//if right child is larger than root
		if(right < size && arr[right] > arr[largest])
		{
			count++;
			largest = right;
		}
		
		//if largest isn't root
		if(largest != i)
		{
			count++;
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			//recursively heapifies sub tree
			heapify(arr, size, largest);
		}
	}
	
	public void setCount(long count)
	{
		this.count = count;
	}
	
	public long getCount()
	{
		return count;
	}
}
