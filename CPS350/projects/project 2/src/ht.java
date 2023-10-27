public class ht {
    private int[] table; // actual table data
    private int size; // table size

    // constructor, create a int array table of specified size
    public ht(int tableSize) {
        table = new int[tableSize];
        size = tableSize;
    }

    public int search(int key) {
        int index = key % size; // get index
        if (table[index] == key) { // check if table indexed value is key
            return index; // return index
        }
        return -1; // failed
    }

    public boolean insert(int key) {
        int index = key % size;
        if (table[index] == 0) { // empty
            table[index] = key; // copy key
            return true;
        }
        return false; // occupied, fail
    }

    public void delete(int key) {
        int index = search(key); // get the index of our key
        if (index != -1) { // if index exists
            table[index] = 0; // delete the data
        }
    }

    // print out each slot in our list
    public void display() {
    	System.out.println("-----------");
    	for (int i = 0; i < size; i++) {
            System.out.println("Slot " + i + ": " + table[i]);
        }
        System.out.println("-----------");
    }
}