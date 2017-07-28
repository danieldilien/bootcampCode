package examples;

/**
 * Created by Daniel on 21/07/2017.
 */
public class AutoAdvanced {
    public String brand;
    public double torque;

    public AutoAdvanced(String brand){
        this.brand = brand;
        System.out.println("Car is ready to drive");
    }
    public AutoAdvanced(String brand, int force, int engine){
        this.brand = brand;
        System.out.println("Car is ready to drive");
        calculateTorque(force,engine);
    }

    public void calculateTorque(int force, int engine){
        this.torque = ((force * 5252) / engine);
    }
    public void printTorque(){
        System.out.println("Torque of the car is " + torque);
    }
    public void printBrand(){
        System.out.println("Brand of the car is " + brand);
    }
}
