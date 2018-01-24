
class Bicycle {
	//fields
    int cadence = 0;
    int gear = 1;
    double inchestomile = 0.00095;
    
    //constructor
    Bicycle(int cad, int g){
    		cadence = cad;
    		gear = g; 
    }
    

    //methods
    void changeCadence(int newValue) {
         cadence = newValue;       	 
    }
    
    double mySpeed() {
    		return (gear * cadence) * inchestomile; //speed in inches per minute
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence  + " gear:" + gear);
    }
}