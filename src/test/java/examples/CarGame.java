package examples;

import org.testng.annotations.Test;

/**
 * Created by Daniel on 21/07/2017.
 */
public class CarGame {

    @Test
    public void startGame(){
        Auto auto1 = new Auto();
        auto1.setColor("Rood");
        System.out.println("The color of the car: " + auto1.getColor());

        Auto auto2 = new Auto();
        auto2.setColor("Paars");
        System.out.println("The color of the car: " + auto2.color);

        Auto auto3 = new Auto();
        System.out.println("Torque: " + auto3.calculateTorque(10,5252));

    }
}
