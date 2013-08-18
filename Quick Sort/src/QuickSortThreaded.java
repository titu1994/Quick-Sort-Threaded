
public class QuickSortThreaded {
	
	private static int[] numbers;
	private static int number;
	
	private static int k = 0;
	private static int key;

	public static void sort(int[] values){
		// Check for empty or null array
		if (values ==null || values.length==0){
			return;
		}
		numbers = values;
		number = values.length;
		
		int TM = Runtime.getRuntime().availableProcessors();
		
		final int lArray[] = new int[TM];
		
		final int range = number/TM;
		
		for(int i = 1; i <= TM; i++){
			lArray[i-1] = range * i;
		}
		
		Thread tArr[] = new Thread[TM];
		key -= range;
		
		k = 0;
		
		
		for(int i = 0; i < TM; i++){
			key += range;
			
			if(key >= number){
				key = number - 1;
			}
			tArr[i] = new Thread(new Runnable() {
			
				@Override
				public void run() {
					// TODO Auto-generated method stub
				
					quicksort(key, lArray[k++]);
				}
			});
			
			
		}
		
		for(int i = 0; i < TM; i++){
			tArr[i].start();
			
			try {
				tArr[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
			
	}

	private static void quicksort(int low, int high) {
		int i = low, j = high;
		int temp;
		
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];
		
		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
		        i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
		        i++;
		        j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	

}
