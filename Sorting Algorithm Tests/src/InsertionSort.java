//code from GeeksforGeeks
public class InsertionSort 
{
	private long count = 0;
	
	//algorithm does work, just need to find out where the swaps are happening
	public void sort(int arr[], int num)
	{
		int key = 0;
		int j = 0;
		for(int i = 1; i < num - 1; i++)
		{
			key = arr[i];
			j = i - 1;

			//moves elements that are greater than the key, to one position ahead of their current position
			while(j > 0)// && arr[j] > key)
			{
				//count++;
				if(arr[j] > key)
				{
					arr[j + 1] = arr[j];
					count++;
				}
				j--;
			}
			count++;
			arr[j + 1] = key;
		}
	}
	
	//recursive version
	/*public void sort(int arr[], int num)
	{
		//base case
		if(num <= 1)
		{
			count++;
			return;
		}
		
		//recursively sorts the first n-1 elements
		sort(arr, num - 1);
		
		//inserts last element in correct position
		int last = arr[num - 1];
		int j = num - 2;
		
		//moves elements greater than the current element by one position forward
		while(j >= 0)//j >= 0 && arr[j] > last)
		{
			count++;
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = last;
	}*/
	
	public void setCount(long count)
	{
		this.count = count;
	}
	
	public long getCount()
	{
		return count;
	}
}
