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
        this.torque = calculateTorque(force,engine);

    }

    public double calculateTorque(int force, int engine){
        return ((force * 5252) / engine);

    }
    public void printTorque(){
        System.out.println(torque);
    }
    public void printBrand(){
        System.out.println("Brand of the car is " + brand);
    }
}
