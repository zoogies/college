
public class VendingMachineTester {

	public static void main(String[] args) {
		VendingMachine v = new VendingMachine();
		v.fillUp(10);
		System.out.println(v.canCount());
		System.out.println(v.tokenCount());
		v.insertToken();
		System.out.println(v.canCount());
		System.out.println(v.tokenCount());
	}

}
