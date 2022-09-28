import java.util.Scanner;
 
public class twoseven {
 
    public static void main(String[] args) {
    	//setup scanner
        Scanner sc = new Scanner(System.in);  
        //get inputs
        System.out.println("Type the radius: ");
        Double radius = sc.nextDouble();
        //output and calculate
        System.out.println("Area of the circle: " + (Math.PI*(radius*radius)));
        System.out.println("Circumference of the circle: " + (2*Math.PI*radius));
        System.out.println("Volume of the sphere: " + ((4.0/3.0)*Math.PI*(radius*radius*radius)));
        System.out.println("Surface area of the sphere: " + (4*Math.PI*(radius*radius)));
    }
}