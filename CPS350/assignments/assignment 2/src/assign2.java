import java.util.Random;

public class assign1 {

	public static void main(String[] args) {
		RealBuff buff1 = new RealBuff(); // empty max size buffer
		Random rand = new Random(); // create random obj
		
		// append items iteratively
		for(int i = 0; i < 10; i++) {
			buff1.append(rand.nextDouble(100));
		}
		
		
		// output buff1 and 2 values
		System.out.println("Buff 1:");
		buff1.display();

		// sort
		buff1.insertionSort();
		
		// output buff1 and 2 values
		System.out.println("\nSORTED Buff 1:");
		buff1.display();
	}

}
