
class Bicycle {
	//fields
    int cadence = 0;
    int speed = 0;
    int gear = 1;  //inches
    
    //constructor
    Bicycle(int cad, int g){
    		cadence = cad;
    		gear = g; 
    }
    

    //methods
    void changeCadence(int newValue) {
         cadence = newValue;       	 
    }
    
    int mySpeed() {
    		return gear * cadence; //speed in inches per minute
    }

    void changeGear(int newValue) {
         gear = newValue;
    }

    void speedUp(int increment) {
         speed += increment;   
    }

    void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence + " speed:" + 
             speed + " gear:" + gear);
    }
}