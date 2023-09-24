//code from GeeksforGeeks
public class MergeSort 
{
	private long count = 0;

	public void merge(int arr[], int l, int m, int r)
	{
		int num1 = m - l + 1;
		int num2 = r - m;
		
		int left[] = new int[num1];
		int right[] = new int[num2];
		
		for(int i = 0; i < num1; i++)
		{
			count++;
			left[i] = arr[l + i];
		}
		
		for(int i = 0; i < num2; i++)
		{
			count++;
			right[i] = arr[m + i + 1];
		}
		
		int i = 0, j = 0;
		int k = l;
		
		while(i < num1 && j < num2)
		{
			count++;
			if(left[i] <= right[j])
			{
				//count++;
				arr[k] = left[i];
				i++;
			}
			
			else 
			{
				//count++;
				arr[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while(i < num1)
		{
			count++;
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < num2)
		{
			count++;
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	public void sort(int arr[], int left, int right)
	{
		if(left < right)
		{
			int mid = left + (right - left) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
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
