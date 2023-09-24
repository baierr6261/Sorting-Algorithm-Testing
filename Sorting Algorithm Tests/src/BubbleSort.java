//code is based from GeeksforGeeks
public class BubbleSort
{
	private long count = 0;
	
	public void sort(int arr[], int num)
	{
		int temp = 0;
		for(int i = 0; i < num; i++)
		{
			for(int j = 1; j < num - i; j++)
			{
				if(arr[j - 1] > arr[j])
				{
					count++;
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//recursive version
	/*public void sort(int arr[], int num)
	{
		if(num == 0 || num == 1)
		{
			count++;
			return;
		}
		
		for(int i = 0; i < num - 1; i++)
		{
			count++;
			if(arr[i] > arr[i + 1])
			{
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		sort(arr, num - 1);
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
