
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Door[] doors = new Door[3];
		doors[0] = new Door();
	    doors[0].setName("Side");
	    doors[0].open();
	    
	    doors[1] = new Door();
	    doors[1].setName("Front");
	    doors[1].close();
	    
	    doors[2] = new Door();
	    doors[2].setName("Back");
	    doors[2].close();
	    
	    for(Door d: doors) {
	    	d.output();
	    }
	    
	    for(int i=0;i<doors.length;i++) {
	    	if(doors[i].isOpen()) {
	    		doors[i].close();
	    	}else {
	    		doors[i].open();
	    	}
	    }
	    
	    for(Door d: doors) {
	    	d.output();
	    }
	}

}
