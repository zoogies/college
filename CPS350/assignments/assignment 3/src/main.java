// imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// product impl
class Product {
	// data for the product
	long ID;
	String name;
	double originalPrice;
	double currentPrice;
	
	// next item (LL)
	Product next;
	
	// create product from its fields
	Product(long ID, String name, double originalPrice, double currentPrice){
		this.ID=ID; this.name=name; this.originalPrice=originalPrice; this.currentPrice=currentPrice;
		this.next = null;
	}
	
	// create product by reference
	Product(Product p){
		this.ID=p.ID; this.name=p.name; this.originalPrice=p.originalPrice; this.currentPrice=p.currentPrice;
		this.next = null;
	}
	
	// return the discount for this product
	double getDiscount() {
		return (this.originalPrice - this.currentPrice) / this.originalPrice;
	}
}

// ProductList impl
class ProductList {
	Product head;
	ProductList(){
		this.head = null;
	}
	
	// create a prodcut list from another product list
	ProductList(ProductList pl){
		if(pl.head == null) {return;}
		this.head = new Product(pl.head);
		
		Product cur = pl.head.next;
		Product itr = this.head;
		while(cur != null) {
			itr.next = new Product(cur);
			cur = cur.next;
			itr = itr.next;
		}
	}
	
	// create a product list from a file
	ProductList(File f) {
		// attempt to open a scanner
	    Scanner s;
	    try {
	        s = new Scanner(f);
	    } catch (FileNotFoundException e) {
	        System.out.println("The file could not be opened.");
	        return;
	    }

	    Product itr = this.head;
	    // iterate over the file and create Products to add to list
	    while (s.hasNextLine()) {
	        Product staged;
	        String line;

	        // ID
	        line = s.nextLine().trim();
	        if(line.isEmpty()) {
	        	continue;
	        }
	        long ID = Long.parseLong(line);

	        // name
	        line = s.nextLine().trim();
	        if(line.isEmpty()) {
	        	continue;
	        }
	        String name = line;

	        // original price
	        line = s.nextLine().trim();
	        if(line.isEmpty()) {
	        	continue;
	        }
	        double og_price = Double.parseDouble(line);

	        // current price
	        line = s.nextLine().trim();
	        if(line.isEmpty()) {
	        	continue;
	        }
	        double cur_price = Double.parseDouble(line);

	        // create the product
	        staged = new Product(ID, name, og_price, cur_price);

	        // add to list
	        if (itr == null) {
	            this.head = staged;
	            itr = this.head;
	        } else {
	            itr.next = staged;
	            itr = itr.next;
	        }
	    }

	    s.close();
	}

	// print the list out with some separators
	void printList() {
		System.out.println("List contents:");
		Product cur = this.head;
		while(cur.next != null) {
			System.out.println("---------------");
			System.out.println("ID: "+cur.ID);
			System.out.println("name: "+cur.name);
			System.out.println("original price: "+cur.originalPrice);
			System.out.println("current price: "+cur.currentPrice);
			cur = cur.next;
		}
		System.out.println("---------------\n");
	}
	
	// bubble sort the ProductList
	void sortList() {
	    boolean swapped = true;

	    while (swapped) {
	        swapped = false;
	        Product current = head; Product previous = null;

	        while (current.next != null) {
	            if (current.getDiscount() > current.next.getDiscount()) {
	                // Swap
	                Product temp = current;
	                current = current.next;
	                temp.next = current.next;
	                current.next = temp;

	                if (previous != null) {
	                    previous.next = current;
	                } else {
	                    head = current;
	                }

	                swapped = true;
	            }

	            previous = current;
	            current = current.next;
	        }
	    }
	}
}

public class main {
	// test cases
	public static void main(String[] args) {
		System.out.println("Notice: I tried to put the text file in the package so I can use relative pathing,\nand so that it hopefully runs for you with no error.\nIf this does not work please replace \"products.txt\" with an absolute path.\n");
		File products_file = new File("products.txt");
		ProductList pl = new ProductList(products_file);
		ProductList pl_d = new ProductList(pl);
		pl.printList();
		System.out.println("Duplicate product list:");
		pl_d.printList();
		pl.sortList();
		System.out.println("Sorted product list:");
		pl.printList();
	}
}
