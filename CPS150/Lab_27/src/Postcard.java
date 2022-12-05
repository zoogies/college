/*
	CPS 150
	Algorithms & Programming I
	
	Lab Project: Postcards to Friends
	
	name:Ryan Zmuda
 */

public class Postcard
{
   private String message;
   private String sender;
   private String recipient;

   public Postcard(String aSender, String aMessage)
   {
      message = aMessage;
      sender = aSender;
      recipient = "";
   } // end Postcard constructor
   
   // Your method for setting the recipient here
   public void changeRecip(String s) {
	   this.recipient = s;
   }
   // Your print method here
   public void print() {
	   System.out.println("Dear: "+this.recipient);
	   System.out.println(this.message);
	   System.out.println("Love,");
	   System.out.println(this.sender);
   }

} // end class Postcard