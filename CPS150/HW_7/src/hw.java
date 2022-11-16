import java.util.Scanner;

public class hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5};
		int max = array[0];
		int min = array[0];

		for(int i = 0; i < array.length; i++) {
		  if(array[i] > max) {
		    max = array[i];
		  }
		  if(array[i] < min) {
		    min = array[i];
		  }
		}
		System.out.println("min: "+min+" max: "+max);
	
	
		String[] s = {"a","b","c"};
		for(String st: s) {
			System.out.print(st+" ");
		}
		int[] a = {1,2,3};
		int t = 0;
		for(int st: a) {
			t += st;
		}
		System.out.println("\nsum: "+t);
		
		t = 0;
		for(int st: a) {
			if(st <0) {
				t++;
			}
		}
		System.out.println("negative count: "+t);
		
		Double[] b = {1.0,2.0,3.0};
		Double tut = 0.0;
		for(int i=0;i<b.length;i++) {
			tut+=b[i];
		}
		
		Double target = 0.0;
		for(int ii=0;ii<b.length;ii++) {
			if(ii == target) {
				// return true;
			}
		}
		
		int iii = 0;
		for(int ii=0;ii<b.length;ii++) {
			b[ii] = 2* b[ii];
		}
		
		float total = 0;
		Float[] values = {1.0f,2.0f,3.0f};
		for (float value : values) {
		    total = total + value;
		}
		 total = 0;
		for (float value : values) {
		    total = total + value;
		}
		 total = 0;
		for (float value : values) {
		    if (value == target) {
		        // return value;
		    }
		}
		
		
		int n = 10; 
		  
        int[] arr = new int[n]; 
  
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter the elements of the array:"); 
  
        for (int i = 0; i < n; i++) 
        { 
            arr[i] = input.nextInt(); 
        } 
  
        System.out.println("The array in the reverse order is:"); 
  
        for (int i = n-1; i >= 0; i--) 
        { 
            System.out.print(arr[i] + "\n"); 
        } 
        
		//        trace 1:
		//        pos     found
		//       	0       false
		//       	1       false
		//        	2       true
        
        //        trace 2:
		//        pos     found
		//       	0       false
		//       	1       false
		//        	2       true
        
		//        pos    found
		//        2      100
		//        3      120
		//        4      80
		        
		//
		//public static void sort(int[] arr) 
		//
		//public static void printseperated(int[] arr, String delimiter) 
		//
		//public static int countLessThan(int[] arr, int value) 
		//
		//public static void removeLessThan(int[] arr, int value) 
		//
		//public static int[] extractLessThan(int[] arr, int value)
        
        //The method does not actually modify the array that is passed in as a parameter.
        

		//-Create a variable to store the sum of all quiz scores
		//-Iterate through each quiz score in the array
		//-find the index of the lowest score
        //-iterate again adding every score except the lowest
		//-Return the sum
        
        int[][] valuess = new int[2][2];
        
        for (int i = 0; i < valuess.length; i++) {
        	  for (int j = 0; j < valuess.length; j++) {
        	    valuess[i][j] = 0;
        	  }
        }
        

        for(int[] i:valuess) {
        	for(int o: i) {
        		System.out.print(o);
        	}
        	System.out.println();
        }
        
        for (int i = 0; i < valuess.length; i++) {
            for (int j = 0; j < valuess.length; j++) {
                if ((i + j) % 2 == 0) {
                    valuess[i][j] = 0;
                }
                else {
                    valuess[i][j] = 1;
                }
            }
        }
        for(int[] i:valuess) {
        	for(int o: i) {
        		System.out.print(o);
        	}
        	System.out.println();
        }
        
        for(int i=0; i < valuess.length; i++){
        	  for(int j=0; j < valuess[0].length; j++){
        	    if(i == 0 || i == valuess.length - 1){
        	      valuess[i][j] = 0;
        	    }
        	  }
        }
        for(int[] i:valuess) {
        	for(int o: i) {
        		System.out.print(o);
        	}
        	System.out.println();
        }
        
        int sum = 0;
        for (int i = 0; i < valuess.length; i++) {
            for (int j = 0; j < valuess[i].length; j++) {
                sum += valuess[i][j];
            }
        }
        System.out.println("sum: "+ sum);
        

		for(int[] row : valuess) {
		    for(int column : row) {
		        System.out.print(column + " ");
		    }
		    System.out.println();
		}

//		For each row in the 2-D array:
//			-Set the first element to -1
//			-Set the last element to -1
//
//			For each column in the 2-D array:
//			-Set the first element to -1
//			-Set the last element to -1
	}
}
