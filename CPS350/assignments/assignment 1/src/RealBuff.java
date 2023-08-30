public class RealBuff
{
	static final int max_size = 100; // the default maximum size of the buffer
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
}