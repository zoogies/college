/*
 * Defined the items we put in our MBH
 */
class item {
    double weight;
    double value;
    int ID;
    double priority;
    
    public item(int ID, double weight, double value, double priority) {
        this.weight = weight;
        this.value = value;
        this.ID = ID;
        this.priority = priority;
    }
}

/*
 * Heap definition
 */
class MBH {
    private item[] heap; 
    private int size;
    private int maxsize; 
    
    // initialize heap at a size
    public MBH(int size) {
        this.maxsize = size;
        this.size = 0;
        heap = new item[this.maxsize];
    }

    // accessor to get the parent of an index
    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    // accessor to get the left child of an index
    private int leftChild(int idx) {
        return (2 * idx) + 1;
    }

    // accessor to get the right child of an index
    private int rightChild(int idx) {
        return (2 * idx) + 2;
    }
    
    // swap two nodes
    private void swap(int x, int y) {
        item temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
    
    // percolate down recursively
    private void downHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;

        // find the largest child
        if (left < size && heap[left].priority > heap[pos].priority)
            largest = left;
        if (right < size && heap[right].priority > heap[largest].priority)
            largest = right;

        if (largest != pos) {
            swap(pos, largest);
            downHeapify(largest);
        }
    }
    
    // percolate up iteratively
    private void heapifyUp(int pos) {
        while (pos > 0 && heap[parent(pos)].priority < heap[pos].priority) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    // insert an item into heap
    public void insert(item element) {
        if (size < maxsize) {
            size++;
            int current = size - 1;
            heap[current] = element;
            heapifyUp(current);
        } else {
            System.out.println("Heap is full. Cannot insert.");
        }
    }

    // grab the max element off the top of the heap and adjust accordingly
    public item popMax() {
        // if heap is empty return null
    	if (size == 0) {
            // System.out.println("Heap is empty.");
            return null;
        }
    	
    	// resize and redistribute heap items
        item max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downHeapify(0);
        return max;
    }
}

public class main {
    public static void main(String[] args) {
        
    	/*
    	 * First case, highest value greedy algorithm
    	 */
    	System.out.println("Highest value:");
    	MBH items = new MBH(10);
        items.insert(new item(0,23,505,505));
		items.insert(new item(1,26,352,352));
		items.insert(new item(2,20,458,458));
		items.insert(new item(3,18,220,220));
		items.insert(new item(4,32,354,354));
		items.insert(new item(5,27,414,414));
		items.insert(new item(6,29,498,498));
		items.insert(new item(7,26,545,545));
		items.insert(new item(8,30,473,473));
		items.insert(new item(9,27,543,543));
        
        double limit = 67;
        double weight = 0;
        double value = 0;
        while(weight < limit) {
        	item i = items.popMax();
        	if(i == null) {
        		// System.out.println("Every item reached.");
        		break;
        	}
        	if(weight+i.weight > limit) {
        		continue;
        	}
        	weight += i.weight;
        	value += i.value;
        	System.out.println("Selected item ID="+i.ID+" weight="+i.weight+" value="+i.value+" priority="+i.priority);
        }
        System.out.println("Finished with weight: "+weight+"/"+limit);
        System.out.println("Bag value: "+value);
        
        /*
    	 * Second case, lowest weight greedy algorithm
    	 */
        System.out.println();
        System.out.println("Lowest weight:");
    	MBH weight_items = new MBH(10);
    	weight_items.insert(new item(0,23,505,-23));
    	weight_items.insert(new item(1,26,352,-26));
    	weight_items.insert(new item(2,20,458,-20));
    	weight_items.insert(new item(3,18,220,-18));
    	weight_items.insert(new item(4,32,354,-32));
    	weight_items.insert(new item(5,27,414,-27));
    	weight_items.insert(new item(6,29,498,-29));
    	weight_items.insert(new item(7,26,545,-26));
    	weight_items.insert(new item(8,30,473,-30));
    	weight_items.insert(new item(9,27,543,-27));
        
        limit = 67;
        weight = 0;
        value = 0;
        while(weight < limit) {
        	item i = weight_items.popMax();
        	if(i == null) {
        		// System.out.println("Every item reached.");
        		break;
        	}
        	if(weight+i.weight > limit) {
        		continue;
        	}
        	weight += i.weight;
        	value += i.value;
        	System.out.println("Selected item ID="+i.ID+" weight="+i.weight+" value="+i.value+" priority="+i.priority);
        }
        System.out.println("Finished with weight: "+weight+"/"+limit);
        System.out.println("Bag value: "+value);
        
        /*
    	 * Third case, ratio of value to weight
    	 */
        System.out.println();
        System.out.println("Value to weight ratio:");
    	MBH ratio_items = new MBH(10);
    	ratio_items.insert(new item(0,23,505,505/23));
    	ratio_items.insert(new item(1,26,352,352/26));
    	ratio_items.insert(new item(2,20,458,458/20));
    	ratio_items.insert(new item(3,18,220,220/18));
    	ratio_items.insert(new item(4,32,354,354/32));
    	ratio_items.insert(new item(5,27,414,414/27));
    	ratio_items.insert(new item(6,29,498,498/29));
    	ratio_items.insert(new item(7,26,545,545/26));
    	ratio_items.insert(new item(8,30,473,473/30));
    	ratio_items.insert(new item(9,27,543,543/27));
        
        limit = 67;
        weight = 0;
        value = 0;
        while(weight < limit) {
        	item i = ratio_items.popMax();
        	if(i == null) {
        		// System.out.println("Every item reached.");
        		break;
        	}
        	if(weight+i.weight > limit) {
        		continue;
        	}
        	weight += i.weight;
        	value += i.value;
        	System.out.println("Selected item ID="+i.ID+" weight="+i.weight+" value="+i.value+" priority="+i.priority);
        }
        System.out.println("Finished with weight: "+weight+"/"+limit);
        System.out.println("Bag value: "+value);
    }
}
