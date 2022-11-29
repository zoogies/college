
public class Door {
	private String name;
    private boolean state; // true for open, false for closed

     public void setName(String n)
    {
        name = n;
    } // end name setter

    public boolean isOpen()
    {
        return state;
    } // end state getter

    public void open()
    {
       state = true;
    } // end open method

    public void close()
    {
        state = false;
    } // end close method
    
    public void output()
    {
       System.out.print(name);
       System.out.print(": ");
       if (state)
       {
          System.out.println("open");
       }
       else
       {
          System.out.println("closed");
       }
    }
}
