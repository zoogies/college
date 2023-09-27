import java.util.Random;

public class proj_1 {

	public static void main(String[] args) {
		RealBuff buff1 = new RealBuff(); // empty max size buffer
		Random rand = new Random(); // create random obj
		
		// append items iteratively
		for(int i = 0; i < 10; i++) {
			buff1.append(rand.nextDouble(100));
		}
		
		// output buff1 and 2 values
		System.out.println("Buffer 1:");
		buff1.display();

		// sort quicksort
		buff1.quickSort(0,buff1.current_size - 1);
		
		// output buff1 and 2 values
		System.out.println("\nQUICK SORT Buff 1:");
		buff1.display();
		
		RealBuff buff2 = new RealBuff();
		// append items iteratively
		for(int i = 0; i < 10; i++) {
			buff2.append(rand.nextDouble(100));
		}
		
		// output buff1 and 2 values
		System.out.println("\nBuffer 2:");
		buff2.display();
		
		// sort merge sort
		buff2.mergeSort(0,buff2.current_size - 1);
		
		System.out.println("\nMERGE SORT Buff 2:");
		buff2.display();
		
		RealBuff quick[] = new RealBuff[10];
		RealBuff merge[] = new RealBuff[10];
		
		int n = 500000; // length of buffer items
		
		// create 10 identical buffers (duplicate them) and fill them with n items between -100 and 100
		for(int i = 0; i<10;i++) {
			RealBuff b = new RealBuff(n);
			
			for(int j = 0; j<n; j++) {
				// add integer -100 to 100
				b.append((double)rand.nextInt(-100, 100));
			}
			
			quick[i] = b;
			merge[i] = b;
		}
		
		long quick_time = 0;
		long merge_time = 0;
		
		System.out.println("\nPerforming tests...\n");

		// quick sort quick[i] and display time
		for(int i = 0; i<10; i++) {
			long start = System.currentTimeMillis();
			
			quick[i].quickSort(0,quick[i].current_size - 1);
			
			quick_time += System.currentTimeMillis() - start;
		}
		
		System.out.println("Average time to quick sort a buffer of "+n+" items: "+quick_time/10+"ms");

		// merge sort merge[i] and display time
		for(int i = 0; i<10; i++) {
			long start = System.currentTimeMillis();
			
			merge[i].mergeSort(0,merge[i].current_size - 1);
			
			merge_time += System.currentTimeMillis() - start;
		}
		
		System.out.println("Average time to merge sort a buffer of "+n+" items: "+merge_time/10+"ms");
	}

}
