class BicycleDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Bicycle bike1  = new Bicycle();
        Bicycle bike2 = new Bicycle();
        


        // Invoke methods on 
        // those objects
        bike1.changeCadence(50);
        bike1.cadence = 32;
        double speedNow = bike1.mySpeed();
        
       
        bike1.gear.changeGear(42, 34);
        bike1.printStates();

        bike2.changeCadence(50);
        
        bike2.gear.changeGear(53, 22);
        bike2.changeCadence(40);
        
        bike2.gear.changeGear(53, 21);
        bike2.printStates();

    }
}
