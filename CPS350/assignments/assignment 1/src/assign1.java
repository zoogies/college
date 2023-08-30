public class assign1 {

	public static void main(String[] args) {
		RealBuff buff1 = new RealBuff(); // empty max size buffer
		
		// append items iteratively
		double[] items = {51, 7.2, 8.9, 10.6, 0, -18.1};
		for(int i = 0; i < items.length; i++) {
			buff1.append(items[i]);
		}
		
		// buff2 copies buffer 1
		RealBuff buff2 = new RealBuff(buff1);
		
		// output buff1 and 2 values
		System.out.println("Buff 1:");
		buff1.display();
		System.out.println("\nBuff 2:");
		buff2.display();
		
		buff1.delete(2); // delete buff1 index 2
		buff2.insert(-50,3); // insert -50 to index 3 buff2
		
		// output buff1 and 2 values
		System.out.println("\nNEW Buff 1:");
		buff1.display();
		System.out.println("\nNEW Buff 2:");
		buff2.display();
	}

}
