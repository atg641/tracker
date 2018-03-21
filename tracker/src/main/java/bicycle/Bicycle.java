package bicycle;

class Bicycle {
	//fields
    int cadence = 0;
	Gear gear;
    final static double inchestomile = 0.00095;
    
    //constructor
    Bicycle(int cad, Gear g){
    		cadence = cad;
    		gear = g; 
    }
    
    Bicycle(int cad){
		cadence = cad;
		gear =  new Gear(); 
}
    

    //methods
    void changeCadence(int newValue) {
         cadence = newValue;       	 
    }
    
    double mySpeed() {
    		return (gear.computeGearInches() * cadence) * inchestomile; //speed in inches per minute
    }

    void changeGear(int crt, int st) {
         gear.changeGear(crt, st);
    }

    void printStates() {
        System.out.println("cadence:" +
            cadence + " speed:" + 
            mySpeed() + " gear:" + gear);
   }

    @Override
	public String toString() {
		return "Bicycle [cadence=" + cadence + ", gear=" + gear + "]";

	
	}
    public static void main(String[] args) {
   		Gear gear1 = new Gear();
   		Gear gear2 = new Gear();
    		Bicycle bike1  = new Bicycle(80, gear1);
    		Bicycle bike2  = new Bicycle(60, gear2);
    		
    	
    		bike1.changeCadence(63);
    		bike2.changeCadence(93);
    		bike1.changeGear(39, 28);
    		bike2.changeGear(53, 15);
    		bike1.mySpeed();
    		bike2.mySpeed();
    		bike1.toString(); //Not sure how to use the string
    		bike2.toString();
    		bike1.printStates();
    		bike2.printStates();
    		}
    }
    

	//define a toString method for Bicycle
	//compute speed of each object and print 
	//change gears and /or cadence and print speed and toString 