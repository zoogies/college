public class proj2 {
    public static void main(String[] args) {
    	// make simple hash table
        ht table = new ht(11);

        // Insert keys and display the table content
        int[] keys = {34, 29, 53, 44, 120, 39, 45, 40};
        for (int i = 0; i<keys.length; i++) {
            if(table.insert(keys[i])) {
            	System.out.println("Inserted "+keys[i]);
            } else {
            	System.out.println("Failed inserting "+keys[i]);
            }
            
            table.display();
        }

        // Delete key 120 and display
        table.delete(120); table.display();

        // Search for key 40 and display
        int result = table.search(40);
        System.out.print("Search result for 40: ");
        if(result != -1) {
        	System.out.println("Found at slot " + result);
        }
        else {
        	System.out.println("not found.");
        }
        table.display();

        // Insert key 46 and display
        table.insert(46); table.display();
        
        ////////////////////
        // linear probing //
        ////////////////////
        
        System.out.println("\nLinear Probing:\n");
        
        // create linear probing hash table
        lpht LPT = new lpht(11);
        
        // insert all our keys again
        for (int i = 0; i<keys.length; i++) {
        	if(LPT.insert(keys[i])) {
            	System.out.println("Inserted "+keys[i]);
            } else {
            	System.out.println("Failed inserting "+keys[i]);
            }
        	LPT.display();
        }

        // Delete key 120 and display
        LPT.delete(120); LPT.display();

        // Search for key 40 and display
        result = LPT.search(40);
        System.out.print("Search result for 40: ");
        if(result != -1) {
        	System.out.println("Found at slot " + result);
        }
        else {
        	System.out.println("not found.");
        }
        LPT.display();

        // Insert key 46 and display
        LPT.insert(46);	LPT.display();
    }
}