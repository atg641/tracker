class BicycleDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Bicycle bike1  = new Bicycle(80, 100);
        Bicycle bike2 = new Bicycle(100, 95);
        


        // Invoke methods on 
        // those objects
        bike1.changeCadence(50);
        bike1.cadence = 32;
        int speedNow = bike1.mySpeed();
        
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();

        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();

    }
}
