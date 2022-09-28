import java.util.Scanner;
public class twofour {

	public static void main(String[] args) {
		// setup scanner
		Scanner sc = new Scanner(System.in);
		
		// get inputs
		System.out.print("Enter number 1: ");
		int o = sc.nextInt();
		System.out.print("Enter number 2: ");
		int t = sc.nextInt();
		
		// output answers
		System.out.println("Sum: \t"+(o+t));
		System.out.println("Diff: \t"+(o-t));
		System.out.println("prod: \t"+(o*t));
		System.out.println("avg: \t"+((o+t)/2.0));
		System.out.println("dis: \t"+Math.abs(o-t));
		System.out.println("max: \t"+Math.max(o,t));
		System.out.println("min: \t"+Math.min(o,t));
	}

}
