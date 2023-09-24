//code from GeeksforGeeks
public class SelectionSort 
{
	private long count = 0;
	
	public void sort(int arr[], int num)
	{
		for(int i = 0; i < num - 1; i++)
		{
			count++;
			int min = i;
			for(int j = i + 1; j < num; j++)
			{
				if(arr[j] < arr[min])
				{
					count++;
					min = j;
				}
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	/*//returns min index
	public int minIndex(int arr[], int i, int j)
	{
		count++;
		if(i == j)
		{
			return i;
		}
		
		//finds min. of remaining elements
		int k = minIndex(arr, i + 1, j);
		
		//returns min. of current and remaining index(?)
		return (arr[i] < arr[k]) ? i : k;
	}
	
	//recursive selection sort
	public void sort(int arr[], int num, int index)
	{
		count++;
		//returns when starting index and size are the same
		if(index == num)
		{
			return;
		}
		
		//calls for min. index
		int k = minIndex(arr, index, num - 1);
		
		//TODO: if statement being called once for the entire test, do I need to fix this?
		//swaps when index and min index aren't the same
		if(k != index)
		{
			System.out.println("selection sort k != index works");
			int temp = arr[k];
			arr[k] = arr[index];
			arr[index] = temp;
		}
		
		//recursively calls sort function
		sort(arr, num, index + 1);
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
