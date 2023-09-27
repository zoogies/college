public class RealBuff
{
	int max_size = 100; // the default maximum size of the buffer
	double[] content; // the content of the buffer
	int current_size; // the number of valid elements

	RealBuff() // initializing an empty buffer of the default maximum size
	{
		content = new double[100];
		current_size = 0;
	}
	// initializing an empty buffer of the maximum size given by n
	RealBuff(final int n)
	{
		content = new double[n];
		current_size = 0;
		max_size = n;
	}
	// initializing a buff which is a copy of buff
	RealBuff(final RealBuff buff)
	{
		content = buff.content;
		current_size = buff.current_size;
	}

	public boolean append(double value) {
		if(current_size >= max_size) { // if we are full disallow
			return false;
		} // else add a new val to the end and increase size
		content[current_size] = value;
		current_size++;
		return true;
	}

	public boolean insert(double value, int index) {
		if(index > current_size || index < 0) { // if our index is invalid error
			return false;
		}
		else {
			// new modified array
			double[] newArr = new double[content.length+1];
			
			// iterate through our old array and copy important items to new array
			for (int i=0; i< newArr.length; i++){
				if (i<index){
					newArr[i] = content[i];
				}else if (i == index){
					newArr[i] = value; // add our new index specifically to the new array
				}else{
					newArr[i] = content[i-1];
				}
			}
			current_size++;
			content = newArr;
			return true; // increase size, set array and return
		}
	}

	public boolean delete(int index) {
		if(index > current_size || current_size == 0 || index < 0) { // check for invalid cases
			return false;
		}
		else {
			// create new staged array
			double[] newArr = new double[content.length-1];
			
			// iterate through and copy only the items we want to keep to the new array
			for (int i=0; i< newArr.length; i++){
				if (i<index){
					newArr[i] = content[i];
				}else if (i == index){
					newArr[i] = content[i+1]; // skip the index we dont want to add to the new array
				}else{
					newArr[i] = content[i+1];
				}
			}
			current_size--;
			content = newArr; // decrease size, save array and return
			return true;
		}
	}
	
	// display the contents of our array
	public void display() {
		for(int i = 0; i < current_size; i++) {
			System.out.println(i+": "+content[i]);
		}
	}
	
	// insertion sort the array
	public void insertionSort() {
		// start on second elem and work up array
		for(int j = 1; j < current_size; j++) {
			double key = content[j]; // current item
			int i = j - 1; // item behind current
			
			// while valid and last item is greater than current
			while(i >= 0 && content[i] > key) {
				content[i+1] = content[i]; // swap
				i = i - 1; // step last item back
			}
			content[i + 1] = key; // key goes one ahead of current's final location
		}
	}

	// quick sort the array
	public void quickSort(int low, int high) {
		if(high >= current_size) { // check if invalid
			System.out.println("Upper bound for quicksort exceeds the buffer size");
			return;
		}
	    if (low < high) {
	        int part = partition(low, high);
	        quickSort(low, part - 1);
	        quickSort(part + 1, high); // sort our two partitions
	    }
	}

	private int partition(int low, int high) {
	    double pivot = content[high]; // choose pivot
	    int i = (low - 1);

	    // sort items in our partition
	    for (int j = low; j < high; j++) {
	        if (content[j] <= pivot) { // if index is less than pivot
	            i++;
	            // swap
	            double temp = content[i];
	            content[i] = content[j];
	            content[j] = temp;
	        }
	    }

	    // swap
	    double temp = content[i + 1];
	    content[i + 1] = content[high];
	    content[high] = temp;

	    return i + 1;
	}
	
	// merge sort 
	public void mergeSort(int low, int high) {
		if(high >= current_size) { // check if invalid
			System.out.println("Upper bound for quicksort exceeds the buffer size");
			return;
		}
	    if (low < high) {
	        int middle = (low + high) / 2;
	        mergeSort(low, middle);
	        mergeSort(middle + 1, high);
	        merge(low, middle, high); // sort two halves and then merge them
	    }
	}

	private void merge(int low, int middle, int high) {
	    // create temporary arrays of appropriate size
	    int n1 = middle - low + 1;
	    int n2 = high - middle;
	    double[] leftArray = new double[n1];
	    double[] rightArray = new double[n2];

	    // Copy data to temporary arrays
	    for (int i = 0; i < n1; i++) {
	        leftArray[i] = content[low + i];
	    }
	    for (int j = 0; j < n2; j++) {
	        rightArray[j] = content[middle + 1 + j];
	    }

	    // Merge the arrays back
	    int i = 0, j = 0, k = low;
	    while (i < n1 && j < n2) {
	        if (leftArray[i] <= rightArray[j]) {
	            content[k] = leftArray[i];
	            i++;
	        } else {
	            content[k] = rightArray[j];
	            j++;
	        }
	        k++;
	    }

	    // Copy potential remaining elements
	    while (i < n1) {
	        content[k] = leftArray[i];
	        i++;
	        k++;
	    }
	    while (j < n2) {
	        content[k] = rightArray[j];
	        j++;
	        k++;
	    }
	}
}