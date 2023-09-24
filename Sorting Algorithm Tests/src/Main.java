import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
public class Main 
{

	public static void main(String[] args) throws IOException
	{
		//declaring variables
		BubbleSort bs = new BubbleSort();
		HeapSort hs = new HeapSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		SelectionSort ss = new SelectionSort();
		final int SIZE = 1000;
		
		//creates a file
		FileWriter fw = new FileWriter("src\\output.txt");
		
		//cumulative time for each algorithm for each run
		long bTime = 0;
		long hTime = 0;
		long iTime = 0;
		long mTime = 0;
		long sTime = 0;
		
		//cumulative count for each algorithm
		long bCount = 0;
		long hCount = 0;
		long iCount = 0;
		long mCount = 0;
		long sCount = 0;
		
		//writing heading to the txt file, this is to properly import the data into a spreadsheet and make it easier to graph it
		//bubble sort outputs
		fw.write("Bubble sort time (ns): \t");
		fw.write("Bubble sort critical operations: \t");
		fw.write("Bubble sort mean time: \t");
		fw.write("Bubble sort SD time: \t");
		fw.write("Bubble sort average # of critical operations: \t");
		fw.write("Bubble sort SD # of critical operations: \t");
		
		//heap sort outputs
		fw.write("Heap sort time (ns): \t");
		fw.write("Heap sort critical operations: \t");
		fw.write("Heap sort mean time: \t");
		fw.write("Heap sort SD time: \t");
		fw.write("Heap sort average # of critical operations: \t");
		fw.write("Heap sort SD # of critical operations: \t");
		
		//insertion sort outputs
		fw.write("Insertion sort time (ns): \t");
		fw.write("Insertion sort critical operations: \t");
		fw.write("Insertion sort mean time: \t");
		fw.write("Insertion sort SD time: \t");
		fw.write("Insertion sort average # of critical operations: \t");
		fw.write("Insertion sort SD # of critical operations: \t");
		
		//merge sort outputs
		fw.write("Merge sort time (ns): \t");
		fw.write("Merge sort critical operations: \t");
		fw.write("Merge sort mean time: \t");
		fw.write("Merge sort SD time: \t");
		fw.write("Merge sort average # of critical operations: \t");
		fw.write("Merge sort SD # of critical operations: \t");
		
		//selection sort outputs
		fw.write("Selection sort time (ns): \t");
		fw.write("Selection sort critical operations: \t");
		fw.write("Selection sort mean time: \t");
		fw.write("Selection sort SD time: \t");
		fw.write("Selection sort average # of critical operations: \t");
		fw.write("Selection sort SD # of critical operations: \t");
		
		//where the random numbers are generated, using ThreadLocalRandom
		int num = 0;
		int run = 0;
		int modifier = 0;

		//initializing mean and standard deviations for the sorting algorithms
		long bAvgTime;
		long bSDTime;
		long bOPCountAvg;
		long bOPCountSD;
		
		long hAvgTime;
		long hSDTime;
		long hOPCountAvg;
		long hOPCountSD;
		
		long iAvgTime;
		long iSDTime;
		long iOPCountAvg;
		long iOPCountSD;
		
		long mAvgTime;
		long mSDTime;
		long mOPCountAvg;
		long mOPCountSD;
		
		long sAvgTime;
		long sSDTime;
		long sOPCountAvg;
		long sOPCountSD;
		
		while(num < 50)
		{
			System.out.println("num = " + num);
			//the 50 runs for each data size
			if(num % 10 == 0)
			{
				modifier += 500;
			}
			//modifier += 200;//100;
			while(run < 50)
			{
				int[] arr = new int[SIZE + modifier];
				System.out.println("run = " + run);
				
				long start = 0;
				long end = 0;
				
				//creates the data set using a random number generator
				for(int i = 0; i < SIZE + modifier; i++)
				{
					arr[i] = ThreadLocalRandom.current().nextInt();
				}
				int[] temp = arr.clone();
				
				//start of bubble sort calculations
				start = System.nanoTime();
				bs.sort(arr, arr.length);
				end = System.nanoTime();
				bTime += end - start;
				bCount += bs.getCount();
				
				//sets the array back to being unsorted, this will be used after every sort operation
				arr = temp;
				
				//heap sort calculations and operations
				start = System.nanoTime();
				hs.sort(arr, arr.length);
				end = System.nanoTime();
				hTime += end - start;
				hCount += hs.getCount();

				arr = temp;
				
				//insertion sort calculations and operations
				start = System.nanoTime();
				is.sort(arr, arr.length);
				end = System.nanoTime();
				iTime += end - start;
				iCount += is.getCount();
				
				arr = temp;
				
				//merge sort calculations and operations
				start = System.nanoTime();
				ms.sort(arr, 0, arr.length - 1);
				end = System.nanoTime();
				mTime += end - start;
				mCount += ms.getCount();

				arr = temp;
				
				//selection sort stuff
				start = System.nanoTime();
				ss.sort(arr, arr.length);
				end = System.nanoTime();
				sTime += end - start;
				sCount += ss.getCount();

				run++;
			}
			fw.write(System.lineSeparator());
			
			//bubble sort mean and s.d., then writes to output file, lastly resets critical operation counter and time for the run
			bAvgTime = (long) (bTime / 50);
			bSDTime = (long) Math.sqrt(bAvgTime);
			bOPCountAvg = (long) (bCount / 50);
			bOPCountSD = (long) Math.sqrt(bOPCountAvg);
			
			fw.write(bTime + "\t");
			fw.write(bCount + "\t");
			fw.write(bAvgTime + "\t");
			fw.write(bSDTime + "\t");
			fw.write(bOPCountAvg + "\t");
			fw.write(bOPCountSD + "\t");
			bTime = 0;
			bs.setCount(0);
			
			//heap sort mean and s.d., then writes to output file, lastly resets critical operation counter and time for the run
			hAvgTime = (long) (hTime / 50);
			hSDTime = (long) Math.sqrt(hAvgTime);
			hOPCountAvg = (long) (hCount / 50);
			hOPCountSD = (long) Math.sqrt(hOPCountAvg);
			
			fw.write(hTime + "\t");
			fw.write(hCount + "\t");
			fw.write(hAvgTime + "\t");
			fw.write(hSDTime + "\t");
			fw.write(hOPCountAvg + "\t");
			fw.write(hOPCountSD + "\t");
			hTime = 0;
			hs.setCount(0);
			
			//heap sort mean and s.d., then writes to output file, lastly resets critical operation counter and time for the run
			iAvgTime = (long) (iTime / 50);
			iSDTime = (long) Math.sqrt(iAvgTime);
			iOPCountAvg = (long) (iCount / 50);
			iOPCountSD = (long) Math.sqrt(iOPCountAvg);
			
			fw.write(iTime + "\t");
			fw.write(iCount + "\t");
			fw.write(iAvgTime + "\t");
			fw.write(iSDTime + "\t");
			fw.write(iOPCountAvg + "\t");
			fw.write(iOPCountSD + "\t");
			iTime = 0;
			is.setCount(0);
			
			//merge sort mean and s.d., then writes to output file, lastly resets critical operation counter and time for the run
			mAvgTime = (long) (mTime / 50);
			mSDTime = (long) Math.sqrt(mAvgTime);
			mOPCountAvg = (long) (mCount / 50);
			mOPCountSD = (long) Math.sqrt(mOPCountAvg);
			
			fw.write(mTime + "\t");
			fw.write(mCount + "\t");
			fw.write(mAvgTime + "\t");
			fw.write(mSDTime + "\t");
			fw.write(mOPCountAvg + "\t");
			fw.write(mOPCountSD + "\t");
			mTime = 0;
			ms.setCount(0);
			
			//selection sort mean and s.d., then writes to output file, lastly resets critical operation counter and time for the run
			sAvgTime = (long) (sTime / 50);
			sSDTime = (long) Math.sqrt(sAvgTime);
			sOPCountAvg = (long) (sCount / 50);
			sOPCountSD = (long) Math.sqrt(sOPCountAvg);
			
			fw.write(sTime + "\t");
			fw.write(sCount + "\t");
			fw.write(sAvgTime + "\t");
			fw.write(sSDTime + "\t");
			fw.write(sOPCountAvg + "\t");
			fw.write(sOPCountSD + "\t");
			sTime = 0;
			ss.setCount(0);
			
			run = 0;
			num++;
		}
		fw.close();
	}
}
