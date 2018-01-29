
class Bicycle {
//fields
    int cadence = 0;
    Gear gear;
    final  double inchestomile = 0.00095;

    //constructor
    Bicycle(int cad, Gear  g){
    cadence = cad;
    gear = g;
    }

    //methods
    void changeCadence(int newValue) {
         cadence = newValue;
    }

    double mySpeed() {
    return (gear.computeGearInches() * cadence) * inchestomile; //speed in inches per minute
    }

    void changeGear(Gear  newValue) {
         gear = newValue;
    }

    void printStates() {
         System.out.println("cadence:" +
             cadence  + " gear:" + gear);
    }
    public static void main(String[] args) {
Gear gear1 = new Gear(43, 20);
    Bicycle bike1  = new Bicycle(80, gear1);

    }

}