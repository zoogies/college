public class lpht {
    private int[] table; // array that holds table data
    private int[] status; // status array, 0 for empty, 1 for marked, 2 for occupied
    private int size;

    public lpht(int tableSize) {
        table = new int[tableSize]; 
        status = new int[tableSize]; 
        size = tableSize;
    }

    public int search(int key) {
        int index = key % size; // hash index
        int i = 0;
        
        // check not empty indexes through whole table
        while (i < size && status[index] != 0) {
        	// if the slot is occupied and holds the key we are looking for
            if (status[index] == 2 && table[index] == key) { 
                return index; // return the index
            }
            index = (index + 1) % size; //  else, increment our index and repeat our search
            i++; // keep seperate iterator for when we have wrapped over whole table
        }
        return -1; // failed to find the key
    }

    public boolean insert(int key) {
        int index = key % size; // get index
        int i = 0;
        
        // check not empty indexes through the table
        while (i < size && status[index] != 0) { 
        	// if the index is occupied and its already the value we want to insert
            if (status[index] == 2 && table[index] == key) { 
                return false; // return, the key is already existent
            }
            index = (index + 1) % size; // check next index, wrapping table if needed
            i++; // seperate iterator
        }
        if (status[index] == 0 || status[index] == 1) { // if we found empty index
            table[index] = key; // set the key at index
            status[index] = 2; // update the status
            return true; // success
        }
        return false; // fail
    }

    public void delete(int key) {
        int index = search(key); // use existing search to check if key exists
        if (index != -1) {
            status[index] = 1; // mark as marked (do not zero the data)
        }
    }

    // display the table
    public void display() {
    	System.out.println("-----------");
    	for (int i = 0; i < size; i++) {
    		String _status; // string to represent status at index
    		if(status[i] == 0) {
    			_status = "\t (empty)";
    		}
    		else if(status[i] == 1) {
    			_status = "\t (marked)";
    		}
    		else {
    			_status = "\t (occupied)";
    		}
            System.out.println("Slot " + i + ": " + table[i] + _status);
        }
        System.out.println("-----------");
    }
}
