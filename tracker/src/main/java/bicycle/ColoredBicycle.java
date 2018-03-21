package bicycle;

public class ColoredBicycle extends Bicycle {

	ColoredBicycle(int cad) {
		super(cad);
	}
	Color color = null;
	//Color color = Color.BLUE;
	
	  public static void main(String[] args) {

	   		
	   		
	    		ColoredBicycle bike1  = new ColoredBicycle(80);
	    		bike1.color = Color.BLUE;
	    		System.out.println(bike1.toString());

	    		
	   		
	  }

	@Override
	public String toString() {
		return "ColoredBicycle [color=" + color + ", cadence=" + cadence + ", gear=" + gear + "]";
	}
	
	
}
