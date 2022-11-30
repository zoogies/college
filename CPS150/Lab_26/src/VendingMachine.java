
public class VendingMachine {
	int cans;
	int tokens;
	public VendingMachine() {
		cans = 0;
		tokens = 0;
	}
	
	public void fillUp( int c ) { this.cans+=c; return; }
	
	public int canCount() { return this.cans; }
	
	public int tokenCount() { return this.tokens; }
	
	public void insertToken()
	{
	   this.tokens++;
	   this.cans--;
	}
}
